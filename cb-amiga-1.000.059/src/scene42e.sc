;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 354)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene42e 0
)

(local
	local0
	local1
	local2
	local3 = 1
)

(procedure (localproc_0 &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= local0 (+ (/ (StrLen @temp0) 3) 1))
)

(procedure (localproc_1)
	(localproc_0 &rest)
	(+= local0 (/ local0 4))
	(lillMouth setScript: cycleMouth)
	(Print &rest #at 160 115 #font 4 #width 140 #mode 1 #dispose)
)

(procedure (localproc_2)
	(localproc_0 &rest)
	(+= local0 (/ local0 2))
	(coloMouth loop: 5 setScript: cycleMouth)
	(Print &rest #at 20 115 #font 4 #width 140 #mode 1 #dispose)
)

(instance Hand of Act
	(properties)
)

(instance Smoke of Act
	(properties)
)

(instance Colonel of Prop
	(properties)
)

(instance coloFace of Prop
	(properties)
)

(instance coloMouth of Prop
	(properties)
)

(instance coloEyes of Prop
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance scene42e of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(Colonel
			view: 311
			posn: 101 105
			loop: 1
			cel: 0
			setPri: 1
			init:
			stopUpd:
		)
		(coloFace
			view: 311
			posn: 114 88
			loop: 0
			cel: 0
			setPri: 2
			init:
			stopUpd:
		)
		(coloEyes
			view: 311
			posn: 114 (- (coloFace y:) 15)
			loop: 2
			cel: 0
			setPri: 3
			setScript: ColoEyes
			init:
			stopUpd:
		)
		(coloMouth
			view: 311
			posn: 114 88
			loop: 4
			cel: 0
			setPri: 2
			cycleSpeed: 1
			init:
			hide:
		)
		(Hand
			view: 311
			posn: 128 136
			setLoop: 1
			setCel: 1
			setPri: 3
			moveSpeed: 1
			illegalBits: 0
			ignoreActors: 1
			init:
			hide:
		)
		(Smoke
			view: 311
			setLoop: 3
			setCycle: Walk
			setPri: 3
			illegalBits: 0
			ignoreActors: 1
			init:
			hide:
		)
		(if (and (not (& gSpyFlags $0040)) (!= [gCycleTimers 1] 1))
			(= [gCycleTimers 1] 1)
			(|= gSpyFlags $0040)
			(Load rsFONT 41)
			(LoadMany rsMESSAGE 406)
			(Load rsVIEW 642)
			(LoadMany rsSOUND 94 95 96 29)
			(Lillian setPri: 3 cycleSpeed: 2 init:)
			(lillMouth cycleSpeed: 1 setPri: 4 init: hide:)
			(lillEye setPri: 4 init: setScript: LillEyes)
			(SetFlag 38)
			(self setScript: speech42e)
		else
			(self setScript: twice)
		)
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

(instance speech42e of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(and
				(not (event claimed:))
				(not script)
				(== evKEYBOARD (event type:))
				(or (== (event message:) KEY_S) (== (event message:) KEY_s))
			)
			(cls)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(if (cycleMouth client:)
			(= local1 1)
			(= cycles 1)
		else
			(switch (= state newState)
				(0
					(cond
						((not global216)
							(= state -1)
						)
						((not (& gMustDos $0002))
							(|= gMustDos $0002)
							(self setScript: (ScriptID 406 0)) ; Clock
							(= state -1)
						)
						((self script:)
							(= state -1)
						)
					)
					(= cycles 1)
				)
				(1
					(= local2
						(Display 354 0 dsCOORD 48 8 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0 dsSAVEPIXELS) ; "Press the 'S' key to skip this scene."
					)
					(localproc_1 354 1) ; "Why are you treating me this way, Uncle Henri? Don't you care how I feel? Don't I matter to you anymore?"
					(= seconds 10)
				)
				(2
					(localproc_2 354 2) ; "You matter to me the same way everyone else does. No more...and no less."
					(= seconds 8)
				)
				(3
					(Colonel setScript: twice)
					(localproc_1 354 3) ; "But I don't understand it! I thought I was special! I thought you cared for me more than for Gloria, or Rudy...or any of the others!"
					(= seconds 10)
				)
				(4
					(if (Colonel script:)
						(= state 3)
						(= cycles 1)
					else
						(localproc_2 354 4) ; "You're right; YOU thought that. You were wrong."
						(= seconds 5)
					)
				)
				(5
					(localproc_1 354 5) ; "What about when I used to come and visit you? You were like a father to me! How can you be like this now?!"
					(= seconds 8)
				)
				(6
					(localproc_2 354 6) ; "I'm afraid you misunderstood a lot of things, Lillian. I was just trying to help my sister...that's all. To me you were just her insecure, whiny kid."
					(= seconds 10)
				)
				(7
					(Colonel setScript: twice)
					(localproc_1 354 7) ; "I won't hear any more of this!! You're lying to me, Uncle Henri! Somebody's behind this, I just know it! And I intend to find out who it is!!"
					(= seconds 10)
				)
				(8
					(if (Colonel script:)
						(= state 7)
						(= cycles 1)
					else
						(localproc_1 354 8) ; "Au revoir...Uncle Henri!"
						(= seconds 5)
					)
				)
				(9
					(Lillian
						setLoop: 4
						setCycle: Walk
						setMotion: MoveTo 300 (Lillian y:) self
					)
					(lillEye dispose:)
				)
				(10
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
		(if local1
			(= local1 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: Fwd show:)
				(= cycles local0)
			)
			(1
				(client setScript: 0 hide:)
				(self client: 0)
			)
		)
	)
)

(instance ColoEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 7)
			)
			(1
				(= state 0)
				(if (^= local3 $0001)
					(coloEyes hide:)
					(= seconds (Random 2 3))
				else
					(coloEyes cel: (/ (Random 1 29999) 10000) forceUpd: show:)
					(= cycles 3)
				)
			)
		)
	)
)

(instance LillEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 7)
			)
			(1
				(= state 0)
				(lillEye loop: (Random 2 3) cel: 0 setCycle: Beg)
				(= seconds (Random 3 8))
			)
		)
	)
)

(instance twice of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 3) (== (Smoke cel:) (- (NumCels Smoke) 1)))
			(Smoke hide:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client scene42e)
					(Print 354 9 #dispose) ; "You see the Colonel sitting in his room."
				)
				(coloFace cel: 0 forceUpd:)
				(coloEyes y: (- (coloFace y:) 15) forceUpd:)
				(Hand show: setMotion: MoveTo 116 116 self)
			)
			(1
				(Hand stopUpd:)
				(coloMouth show: loop: 4 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(coloMouth setCycle: End)
				(Hand setMotion: MoveTo 128 136 self)
			)
			(3
				(Hand hide:)
				(coloFace cel: 1 forceUpd:)
				(coloMouth hide:)
				(coloEyes y: (- (coloFace y:) 16) forceUpd:)
				(Smoke show: cel: 0 posn: 113 79 setMotion: MoveTo 128 101 self)
			)
			(4
				(if (== client scene42e)
					(gCurRoom newRoom: gPrevRoomNum)
				else
					(coloFace cel: 0 forceUpd:)
					(coloEyes y: (- (coloFace y:) 15) forceUpd:)
					(client setScript: 0)
					(self client: 0)
				)
			)
		)
	)
)

(instance Lillian of Act
	(properties
		y 107
		x 227
		view 504
	)
)

(instance lillMouth of Prop
	(properties
		y 85
		x 214
		view 504
		loop 1
	)
)

(instance lillEye of Prop
	(properties
		y 72
		x 207
		view 504
		loop 2
	)
)

