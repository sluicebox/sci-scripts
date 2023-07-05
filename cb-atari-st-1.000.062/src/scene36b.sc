;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 323)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene36b 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= local1 (+ (/ (StrLen @temp0) 3) 1))
)

(procedure (localproc_1)
	(puff cel: 0 setCycle: End show:)
	(localproc_0 &rest)
	(+= local1 (/ local1 4))
	(glorMouth setScript: cycleMouth)
	(Print &rest #at 140 115 #font 4 #width 140 #mode 1 #draw #dispose)
)

(procedure (localproc_2)
	(puff hide:)
	(localproc_0 &rest)
	(+= local1 (/ local1 2))
	(clarMouth setScript: cycleMouth)
	(Print &rest #at 10 115 #font 4 #width 140 #mode 1 #draw #dispose)
)

(procedure (localproc_3)
	(|= gSpyFlags $0001)
	(= [gCycleTimers 1] 0)
	(SetFlag 23)
)

(instance scene36b of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(glorSmoke setLoop: 4 setPri: 2 ignoreActors: 1 init: stopUpd: hide:)
		(glow init: stopUpd: hide:)
		(glorMouth setPri: 2 init:)
		(glorEye setPri: 2 init: stopUpd: setScript: GlorsEyes)
		(Gloria setPri: 1 ignoreActors: 1 init:)
		(puff setPri: 1 init: hide:)
		(glorHand
			setLoop: 1
			setCel: 0
			setPri: 3
			xStep: 5
			yStep: 5
			ignoreActors: 1
			init:
		)
		(if (== gClarenceWilburState 4)
			(Load rsFONT 41)
			(LoadMany rsMESSAGE 406)
			(Load rsVIEW 642)
			(LoadMany rsSOUND 29 94 95 96)
			(= gClarenceWilburState 5)
			(Clarence setPri: 1 init:)
			(clarMouth setPri: 2 init:)
			(clarEye setLoop: 8 setPri: 2 init: stopUpd: setScript: ClarsEye)
			(Hand setLoop: 0 setCel: 1 setPri: 1 yStep: 5 init:)
			(Smoke setPri: 2 init: hide:)
			(self setScript: speech36b)
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

(instance ClarsEye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clarEye cel: (^ (clarEye cel:) $0001) forceUpd:)
				(= state -1)
				(if (clarEye cel:)
					(= cycles 2)
				else
					(= seconds (Random 2 5))
				)
			)
		)
	)
)

(instance GlorsEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(glorEye stopUpd:)
				(= seconds (Random 2 5))
			)
			(1
				(glorEye startUpd: setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance speech36b of Script
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
			(if (not (& gSpyFlags $0001))
				(localproc_3)
			)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)

	(method (doit)
		(super doit:)
		(if (>= state 1)
			(if (and (== (mod state 2) 0) (!= state 8))
				(= local0 0)
				(glorMouth loop: 3 cycleSpeed: 0 setCycle: Fwd)
				(glorHand setMotion: MoveTo 167 111)
				(glow hide:)
				(if (and (== (glorHand x:) 167) (== (glorHand y:) 111))
					(glorSmoke posn: 148 89 show: setCycle: Fwd)
				)
				(clarMouth stopUpd:)
				(if (and (== (Hand x:) 122) (== (Hand y:) 135))
					(Smoke show: setCycle: End)
				)
				(Hand setMotion: MoveTo 122 135)
			else
				(clarMouth setCycle: Fwd)
				(Hand setMotion: MoveTo 140 190)
				(cond
					(
						(and
							(== (glorHand x:) 186)
							(== (glorHand y:) 111)
							(== local0 0)
						)
						(= local0 1)
						(glow show:)
						(glorMouth loop: 2 setCycle: Fwd cycleSpeed: 3)
						(glorSmoke hide:)
					)
					((not local0)
						(glorHand setMotion: MoveTo 186 111)
						(glorSmoke setMotion: MoveTo 169 89)
						(glorMouth setCycle: End)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(if (cycleMouth client:)
			(= local2 1)
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
					(= local3
						(Display 323 0 dsCOORD 48 8 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0 dsSAVEPIXELS) ; "Press the 'S' key to skip this scene."
					)
					(localproc_2 323 1) ; "You seem distant, babe. What's the matter?"
					(= seconds 10)
				)
				(2
					(localproc_1 323 2) ; "Well, dahling...this is very difficult."
					(= seconds 4)
				)
				(3
					(localproc_2 323 3) ; "What's difficult?!"
					(= seconds 7)
				)
				(4
					(localproc_1 323 4) ; "You and I...I want to end it."
					(= seconds 10)
				)
				(5
					(localproc_2 323 5) ; "Are you joking or something? That's ridiculous!"
					(= seconds 8)
				)
				(6
					(localproc_1 323 6) ; "No, dahling. I'm not joking. I have a new beau...he's a director."
					(= seconds 10)
				)
				(7
					(localproc_2 323 7) ; "Yeah, well...I have to think about this!"
					(= seconds 8)
				)
				(8
					(localproc_2 323 8) ; "See you around...sweetheart!"
					(= seconds 8)
				)
				(9
					(cls)
					(clarMouth hide:)
					(clarEye hide:)
					(glorMouth hide:)
					(Clarence
						setLoop: 7
						setStep: 5 5
						setMotion: MoveTo -40 (Clarence y:) self
					)
				)
				(10
					(gCurRoom newRoom: gPrevRoomNum)
				)
			)
		)
	)
)

(instance twice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(glorSmoke posn: 148 89 show: setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(Print 323 9 #dispose) ; "It's just Gloria listening to the Victrola."
				(= seconds 4)
			)
			(2
				(cls)
				(glorSmoke setMotion: MoveTo 169 89)
				(glorHand setMotion: MoveTo 186 111 self)
			)
			(3
				(gCurRoom newRoom: gPrevRoomNum)
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

(instance Gloria of Prop
	(properties
		y 110
		x 231
		view 367
	)
)

(instance glorMouth of Prop
	(properties
		y 96
		x 211
		view 367
		loop 3
	)
)

(instance clarEye of Prop
	(properties
		y 72
		x 118
		view 409
	)
)

(instance glorSmoke of Act
	(properties
		y 89
		x 148
		yStep 5
		view 367
		xStep 5
	)
)

(instance glorEye of Prop
	(properties
		y 76
		x 204
		view 367
		loop 7
	)
)

(instance glow of Prop
	(properties
		y 89
		x 170
		view 367
		loop 1
		cel 1
	)
)

(instance puff of Prop
	(properties
		y 88
		x 196
		view 367
		loop 8
		signal 16384
	)
)

(instance glorHand of Act
	(properties
		y 111
		x 167
		view 367
	)
)

(instance myMusic of Sound
	(properties)
)

