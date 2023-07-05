;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use castle)
(use DLetter)
(use KQ5Room)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(public
	rm096 0
)

(local
	local0
)

(instance rm096 of KQ5Room
	(properties
		picture 96
	)

	(method (init)
		(super init:)
		(self setRegions: 550 763) ; castle, cartoonRegion
		(Load rsVIEW 860)
		(gEgo init: hide:)
		((gEgo head:) hide:)
		(hisEyes init: setCel: 0 setScript: boyBlinkScript)
		(cassimaEyes init:)
		(cassimaLips init:)
		(egoFace init:)
		(locket init: setScript: locketScript)
		(gCurRoom setScript: cartoon setRegions: 763) ; cartoonRegion
	)
)

(instance kingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoFace setCel: (Random 0 5))
				(= cycles (Random 1 4))
			)
			(1
				(self init:)
			)
		)
	)
)

(instance girlBlinkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cassimaEyes setLoop: 1 cycleSpeed: 0 setCycle: End self)
			)
			(1
				(= cycles (Random 1 4))
			)
			(2
				(cassimaEyes setCycle: Beg self)
			)
			(3
				(= seconds (Random 1 3))
			)
			(4
				(self init:)
			)
		)
	)
)

(instance boyBlinkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hisEyes setLoop: 5 cycleSpeed: 0 setCycle: End self)
			)
			(1
				(= cycles (Random 1 4))
			)
			(2
				(hisEyes setCycle: Beg self)
			)
			(3
				(= seconds (Random 3 9))
			)
			(4
				(self init:)
			)
		)
	)
)

(instance locketScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(locket
					setCycle: Fwd
					setLoop: (Random 3 4)
					cycleSpeed: (Random 1 3)
				)
				(= seconds (Random 1 3))
			)
			(1
				(locket setLoop: 4 setCel: 255)
				(= seconds (Random 2 6))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance cassimaEyes of Prop
	(properties
		x 117
		y 75
		view 860
		loop 1
	)
)

(instance hisEyes of Prop
	(properties
		x 201
		y 53
		view 860
		loop 5
	)
)

(instance cassimaLips of Prop
	(properties
		x 106
		y 93
		view 860
	)
)

(instance egoFace of Prop
	(properties
		x 216
		y 76
		view 860
		loop 2
	)
)

(instance locket of Prop
	(properties
		x 148
		y 89
		view 860
		loop 4
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc550_17)
				(= seconds 2)
			)
			(1
				(cassimaEyes
					setPri: (+ (cassimaLips priority:) 1)
					setScript: girlBlinkScript
				)
				(cassimaLips setLoop: 0 cycleSpeed: 2)
				(cassimaLips setCycle: RandCycle)
				(PrintDC 96 0 #at 18 130 #width 250 #dispose) ; "Wherever did you FIND my gold locket? I thought it was gone for good. I lost it on the island just after I was brought here by Mordack."
				(= seconds 10)
			)
			(2
				(cassimaLips setCycle: 0 setCel: 0)
				(egoFace setScript: kingScript)
				(PrintDC 96 1 #at 100 130 #dispose) ; "You wouldn't believe me if I told you. Tell me, who are you...and how did you come to be here?"
				(= seconds 10)
			)
			(3
				(egoFace setScript: 0 setCel: 0)
				(cassimaLips setCycle: RandCycle)
				(PrintDC 96 2 #at 18 120 #width 260 #dispose) ; "My name is Princess Cassima from the Kingdom of the Green Isles. My father, the King, employs a horrible Vizier who befriended Mordack. When Mordack saw me, he immediately wished to marry me and bring me here."
				(= seconds 15)
			)
			(4
				(cls)
				(= seconds 2)
				(cassimaLips setCycle: 0 setCel: 0)
			)
			(5
				(cassimaLips setCycle: RandCycle)
				(PrintDC 96 3 #at 18 130 #width 250 #dispose) ; "Naturally I refused and my father agreed with me. But our refusal angered him so much that he stole me here anyway, and put me to work as a scullery girl."
				(= seconds 13)
			)
			(6
				(cls)
				(= seconds 2)
				(cassimaLips setCycle: 0 setCel: 0)
			)
			(7
				(cassimaLips setCycle: RandCycle)
				(PrintDC 96 4 #at 18 115 #dispose) ; "He says he will never let me go...that a scullery girl I will remain until I agree to marry him. But the thought revolts me! What am I to do?!"
				(= seconds 12)
			)
			(8
				(cls)
				(cassimaLips setCycle: 0 setCel: 0)
				(= seconds 1)
			)
			(9
				(gCurRoom newRoom: 57)
			)
		)
	)
)

