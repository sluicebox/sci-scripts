;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 305)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene34b 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= local1 (+ (/ (StrLen @temp0) 3) 1))
)

(procedure (localproc_1)
	(localproc_0 &rest)
	(+= local1 (/ local1 4))
	(wilbMouth setScript: cycleMouth)
	(Print &rest #at 140 115 #font 4 #width 140 #mode 1 #draw #dispose)
)

(procedure (localproc_2)
	(localproc_0 &rest)
	(+= local1 (/ local1 4))
	(clarMouth setScript: cycleMouth)
	(Print &rest #at 10 115 #font 4 #width 140 #mode 1 #draw #dispose)
)

(instance scene34b of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(SetFlag 16)
		(SetFlag 17)
		(SetFlag 18)
		(SetFlag 19)
		(Load rsFONT 4)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(= gClarenceWilburState 4)
		(Clarence setPri: 1 init:)
		(clarMouth setPri: 2 init:)
		(clarEye setPri: 2 init: setScript: eyeball2)
		(Hand setLoop: 0 setCel: 1 setPri: 1 yStep: 5 init:)
		(Smoke setPri: 2 init: hide:)
		(Wilbur setLoop: 0 setCel: 0 setPri: 1 yStep: 5 init:)
		(wilbMouth setPri: 2 init:)
		(wilbEye setPri: 2 init: setScript: eyeball)
		(self setScript: speech)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance eyeball of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wilbEye loop: (Random 2 4) cel: 1)
				(= seconds (Random 2 6))
			)
			(1
				(wilbEye loop: (Random 2 4) cel: 0)
				(= state -1)
				(= seconds (Random 2 6))
			)
		)
	)
)

(instance eyeball2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Beg)
				(= state -1)
				(= seconds (Random 4 6))
			)
		)
	)
)

(instance speech of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(and
				(not (event claimed:))
				(== evKEYBOARD (event type:))
				(or (== (event message:) KEY_S) (== (event message:) KEY_s))
			)
			(cls)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== (mod state 2) 1) (!= state 9))
			(if (and (== (Hand x:) 122) (== (Hand y:) 135))
				(Smoke show: setCycle: End)
			)
			(Hand setMotion: MoveTo 122 135)
		else
			(Hand setMotion: MoveTo 140 190)
		)
	)

	(method (changeState newState)
		(if (cycleMouth client:)
			(= local2 1)
			(= cycles 1)
		else
			(switch (= state newState)
				(0
					(= cycles 7)
				)
				(1
					(= local0
						(Display 305 0 dsCOORD 48 8 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0 dsSAVEPIXELS) ; "Press the 'S' key to skip this scene."
					)
					(localproc_1 305 1) ; "It's just not right! We've got to tell him about it!"
					(= seconds 10)
				)
				(2
					(localproc_2 305 2) ; "No! It'll work out, Wilbur. I've got some plans."
					(= seconds 4)
				)
				(3
					(localproc_1 305 3) ; "How are you going to replace that hundred grand we took from Henri? Where would YOU get that kind of money?!"
					(= seconds 7)
				)
				(4
					(localproc_2 305 4) ; "I know people. I can do it...trust me."
					(= seconds 10)
				)
				(5
					(localproc_1 305 5) ; "Why were we so stupid as to buy into a racehorse, anyway?! And to use Henri's money! We should've known better!"
					(= seconds 8)
				)
				(6
					(localproc_2 305 6) ; "It would've worked out, Wilbur. It wasn't our fault that &$#@*% horse broke his leg!"
					(= seconds 10)
				)
				(7
					(localproc_1 305 7) ; "All I can say, Clarence, is you'd better do something fast...because if you don't, I'm 'fessing up.'"
					(= seconds 8)
				)
				(8
					(localproc_2 305 8) ; "I'll handle it, Wilbur! Just don't be stupid and say something!"
					(= seconds 10)
				)
				(9
					(localproc_2 305 9) ; "I've gotta go...remember, don't say nothin'!"
					(= seconds 10)
				)
				(10
					(cls)
					(clarMouth hide:)
					(wilbEye hide:)
					(clarEye hide:)
					(wilbMouth hide:)
					(Clarence
						setLoop: 7
						setCycle: Walk
						setStep: 5 5
						setMotion: MoveTo -40 (Clarence y:) self
					)
				)
				(11
					(gCurRoom newRoom: gPrevRoomNum)
				)
			)
		)
	)
)

(instance cycleMouth of Script
	(properties)

	(method (doit)
		(super doit:)
		(if local2
			(= local2 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: Fwd show:)
				(= cycles local1)
			)
			(1
				(client setScript: 0 hide:)
				(self client: 0)
			)
		)
	)
)

(instance Wilbur of Act
	(properties
		y 106
		x 223
		view 431
	)
)

(instance Clarence of Act
	(properties
		y 115
		x 102
		view 409
	)
)

(instance clarMouth of Prop
	(properties
		y 94
		x 114
		view 409
		loop 2
	)
)

(instance clarEye of Prop
	(properties
		y 72
		x 119
		view 409
		loop 8
	)
)

(instance wilbEye of Prop
	(properties
		y 74
		x 221
		view 431
		loop 4
	)
)

(instance wilbMouth of Prop
	(properties
		y 94
		x 220
		view 431
		loop 1
	)
)

(instance Smoke of Prop
	(properties
		y 82
		x 116
		view 409
		loop 4
	)
)

(instance Hand of Act
	(properties
		y 190
		x 140
		view 409
	)
)

(instance myMusic of Sound
	(properties)
)

