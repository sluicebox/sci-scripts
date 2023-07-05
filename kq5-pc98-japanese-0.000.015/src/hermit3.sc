;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 112)
(include sci.sh)
(use Main)
(use DLetter)
(use KQ5Room)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(public
	hermit3 0
)

(instance hermit3 of KQ5Room
	(properties
		picture 88
		style 10
	)

	(method (init)
		(super init:)
		(Load rsSCRIPT 941)
		(if (!= (gGlobalSound number:) 820)
			(gGlobalSound number: 820 loop: -1 vol: 127 playBed:)
		)
		(if (== global361 46)
			(sailBoat
				init:
				y: (if (== gCurRoomNum 44) 153 else 173)
				stopUpd:
				ignoreActors:
			)
			(sail
				posn: (+ (sailBoat x:) 7) (sailBoat y:)
				setPri: (sailBoat priority:)
				init:
			)
		)
		(egoMouth init:)
		(hermitMouth init:)
		(hermit_eyes init:)
		(chimney init: setCycle: Fwd cycleSpeed: 3)
		(if (!= (gGame detailLevel:) 3)
			(chimney setCycle: 0)
		)
		(self setScript: cartoon setRegions: 763) ; cartoonRegion
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitMouth cycleSpeed: 2)
				(hermit_eyes cycleSpeed: 20 setCycle: RandCycle)
				(hermitMouth setCycle: RandCycle)
				(PrintDC 112 0 #at 30 10 #dispose) ; "Now, son. What was it you was tryin' to tell me before?"
				(= seconds 8)
			)
			(1
				(cls)
				(hermitMouth setCycle: 0)
				(egoMouth cycleSpeed: 2)
				(egoMouth setCycle: RandCycle)
				(PrintDC 112 1 #at 100 120 #dispose) ; "I was trying to find out where the wizard Mordack's island is. He kidnapped my family and is holding them hostage there. I MUST get to them before it's too late!"
				(= seconds 11)
			)
			(2
				(egoMouth setCycle: 0)
				(cls)
				(hermitMouth setCycle: RandCycle)
				(PrintDC 112 2 #at 30 10 #dispose) ; "Oh, I'm right sorry to hear about that. He's a nasty one, that Mordack. I wouldn't wanna tangle with him."
				(= seconds 11)
			)
			(3
				(hermitMouth setCycle: 0)
				(cls)
				(= seconds 3)
			)
			(4
				(hermitMouth setCycle: RandCycle)
				(PrintDC 112 3 #at 30 10 #dispose) ; "I'd try to talk you outta goin' there 'cept I can see that you cain't leave your poor defenseless family unaided."
				(= seconds 9)
			)
			(5
				(hermitMouth setCycle: 0)
				(cls)
				(= seconds 3)
			)
			(6
				(hermitMouth setCycle: RandCycle)
				(PrintDC 112 4 #at 30 10 #dispose) ; "I can enlist someone who can lead you straight to his island. Follow me outside."
				(= seconds 8)
			)
			(7
				(hermitMouth setCycle: 0)
				(if (IsFlag 55)
					(gGlobalSound fade:)
					(if (!= global361 46)
						(gCurRoom newRoom: 46)
					else
						(gCurRoom newRoom: 110) ; hermitRoom
					)
				else
					(gCurRoom newRoom: 111) ; hermit2
				)
			)
		)
	)
)

(instance egoMouth of Prop
	(properties
		x 183
		y 85
		view 827
	)
)

(instance hermitMouth of Prop
	(properties
		x 135
		y 104
		view 827
		loop 2
	)
)

(instance hermit_eyes of Prop
	(properties
		x 144
		y 83
		view 827
		loop 3
	)
)

(instance chimney of Prop
	(properties
		x 18
		y 70
		z 20
		view 625
		loop 2
	)
)

(instance sailBoat of Actor
	(properties
		x 280
		y 173
		view 618
		cel 1
		priority -1
		signal 16385
	)
)

(instance sail of Actor
	(properties
		z 15
		view 618
		loop 2
		signal 16385
	)
)

