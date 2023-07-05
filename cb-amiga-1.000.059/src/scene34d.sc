;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 303)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene34d 0
)

(local
	local0
	local1
	local2
	local3 = 1
	local4
)

(procedure (localproc_0 &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= local0 (+ (/ (StrLen @temp0) 2) 1))
)

(procedure (localproc_1 param1)
	(if (= local3 param1)
		(jeevEyes hide:)
		(jeevFace show:)
	else
		(jeevEyes show:)
		(jeevFace hide:)
	)
)

(procedure (localproc_2)
	(localproc_0 &rest)
	(fifiMouth setScript: cycleMouth)
	(Print &rest #at 20 120 #font 4 #width 140 #mode 1 #dispose)
)

(procedure (localproc_3)
	(localproc_0 &rest)
	(jeevMouth setScript: cycleMouth)
	(Print &rest #at 160 120 #font 4 #width 140 #mode 1 #dispose)
)

(instance scene34d of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(if (and (not (& gSpyFlags $0020)) (> [gCycleTimers 2] 1))
			(|= gSpyFlags $0020)
			(= [gCycleTimers 2] 1)
			(Fifi setPri: 3 cycleSpeed: 2 init:)
			(fifiMouth cycleSpeed: 1 setPri: 4 init: hide:)
			(jeevEyes setPri: 2 cycleSpeed: 2 init: hide:)
			(jeevMouth setPri: 2 init: hide:)
			(jeevFace setPri: 3 cycleSpeed: 1 init: hide:)
			(Jeeves setPri: 1 init:)
			(self setScript: speech34d)
		else
			(Jeeves setPri: 1 init:)
			(jeevEyes setPri: 2 cycleSpeed: 2 setScript: JeevEyes init:)
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

(instance speech34d of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(and
				(not (event claimed:))
				(== evKEYBOARD (event type:))
				(or (== (event message:) KEY_S) (== (event message:) KEY_s))
			)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (not local3) (<= (-- local4) 0))
			(= local4 (Random 10 30))
			(if (jeevEyes cycler:)
				(jeevEyes setCycle: 0 hide:)
			else
				(jeevEyes setCycle: Fwd show:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2
					(Display 303 0 dsCOORD 48 8 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0 dsSAVEPIXELS) ; "Press the 'S' key to skip this scene."
				)
				(Fifi setCycle: End self)
				(jeevFace show: setCycle: End)
			)
			(1
				(Fifi setCycle: Beg self)
				(jeevFace setCycle: Beg)
			)
			(2
				(localproc_1 0)
				(localproc_3 303 1) ; "You drive me wild, my little crepe suzette!"
				(= seconds 4)
			)
			(3
				(localproc_2 303 2) ; "Oh la la, mon amant! You do zee same for me!"
				(= seconds 4)
			)
			(4
				(Fifi setCycle: End self)
				(localproc_1 1)
				(jeevFace setCycle: End)
			)
			(5
				(Fifi setCycle: Beg self)
				(jeevFace setCycle: Beg)
			)
			(6
				(localproc_1 0)
				(localproc_3 303 3) ; "When do you want to meet, my love?"
				(= seconds 4)
			)
			(7
				(localproc_2 303 4) ; "Soon, bon ami. I will see you later een my room."
				(= seconds 4)
			)
			(8
				(localproc_2 303 5) ; "But first, I must go up and make myself pretty for you."
				(= seconds 4)
			)
			(9
				(localproc_3 303 6) ; "You couldn't be any prettier, cupcake."
				(= seconds 4)
			)
			(10
				(localproc_2 303 7) ; "(Giggle) You flatter me too much! Au revoir...until later!"
				(= seconds 4)
			)
			(11
				(Fifi setCycle: End self)
				(localproc_1 1)
				(jeevFace setCycle: End)
			)
			(12
				(cls)
				(Fifi setCycle: Beg self)
				(jeevFace setCycle: Beg)
			)
			(13
				(localproc_1 0)
				(Fifi
					setLoop: 5
					posn: (- (Fifi x:) 43) (Fifi y:)
					setCycle: Walk
					setMotion: MoveTo -2 (Fifi y:) self
				)
				(Jeeves stopUpd:)
			)
			(14
				(gCurRoom newRoom: gPrevRoomNum)
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

(instance JeevEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= state -1)
				(if (^= local3 $0001)
					(jeevEyes hide:)
					(= seconds (Random 2 3))
				else
					(jeevEyes cel: (/ (Random 1 29999) 10000) forceUpd: show:)
					(= cycles 3)
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
				(Print 303 8 #dispose) ; "It looks like Jeeves is continuing his chores."
				(= seconds 4)
			)
			(1
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance Jeeves of Prop
	(properties
		y 108
		x 192
		view 453
	)
)

(instance jeevFace of Prop
	(properties
		y 93
		x 188
		view 453
		loop 3
	)
)

(instance jeevMouth of Prop
	(properties
		y 93
		x 188
		view 453
		loop 1
	)
)

(instance jeevEyes of Prop
	(properties
		y 77
		x 188
		view 453
		loop 2
	)
)

(instance Fifi of Act
	(properties
		y 102
		x 172
		view 453
		loop 4
		illegalBits 0
	)
)

(instance fifiMouth of Prop
	(properties
		y 85
		x 162
		view 453
		loop 6
	)
)

(instance myMusic of Sound
	(properties)
)

