package domain;

/**
 * 사용자의 계획(할 일)을 표현하는 Task 도메인 객체.
 * 최소한의 책임과 필드만을 가집니다.
 */
public class Task {
        // 고유 식별자 (자동 생성되거나, 시스템에 의해 할당됨)
        private final long id;

        // 할 일의 간단한 설명 또는 제목
        private String description;

        // 완료 여부
        private boolean isCompleted;

        /**
         * Task 객체를 생성합니다.
         * @param id 고유 식별자
         * @param description 할 일 설명
         */
        public Task(long id, String description) {
            this.id = id;
            this.description = description;
            this.isCompleted = false;
        }

        /**
         * 할 일의 설명 반환
         */
        public String getDescription() {
            return description;
        }

        /**
         * 할 일의 설명 수정
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * 완료 여부 반환
         */
        public boolean isCompleted() {
            return isCompleted;
        }

        /**
         * 할 일을 완료 처리
         */
        public void complete() {
            this.isCompleted = true;
        }

    /**
     * 고유 식별자 반환
     */
    public long getId() {
        return id;
    }
}
