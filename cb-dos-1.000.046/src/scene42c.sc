;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 353)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene42c 0
)

(local
	local0
)

(procedure (localproc_0)
	(if (not local0)
		(= local0 1)
		(DrawPic 62 6)
		(gCast eachElementDo: #hide)
		(Colonel view: 302 loop: 0 posn: 105 107 setPri: 1)
	)
)

(procedure (localproc_1)
	(if local0
		(= local0 0)
		(DrawPic 42)
		(DrawPic 162 7 0)
		(gAddToPics doit:)
		(gCast eachElementDo: #show)
		(if gDetailLevel
			(lamp1 setCycle: Fwd init:)
			(lamp2 setPri: 11 setCycle: Fwd init:)
			(logs setCycle: Fwd init:)
		else
			(logs init: stopUpd:)
			(lamp1 init: stopUpd:)
			(lamp2 setPri: 11 init: stopUpd:)
		)
		(Colonel view: 302 loop: 0 cel: 0 posn: 200 140 show:)
		(Chair posn: 177 140 hide:)
		(stand init:)
	)
)

(instance scene42c of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(HandsOff)
		(= global190 1)
		(SetFlag 34)
		(Load rsPIC 42 162)
		(Load rsVIEW 301)
		(Load rsVIEW 309)
		(Load rsVIEW 310)
		(= local0 1)
		(gAddToPics
			add:
				bed
				table1
				table2
				table3
				sofa
				mirror
				lift
				gate
				vase
				flower
				cannon
		)
		(stand view: 310 loop: 3 posn: 169 90)
		(Chair view: 142 loop: 1 cel: 9 ignoreActors: 1 init: hide:)
		(Colonel
			view: 302
			ignoreActors: 1
			posn: 105 107
			setPri: 1
			loop: 0
			cel: 0
			init:
		)
		(myMusic number: 27 loop: -1 play:)
		(|= gSpyFlags $0040)
		(self setScript: stoke)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(= global190 0)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance stoke of Script
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 7)
			)
			(1
				(Display 353 0 dsCOORD 48 8 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0 dsSAVEPIXELS) ; "Press the 'S' key to skip this scene."
				(Colonel cycleSpeed: 2 setCycle: End self)
			)
			(2
				(localproc_1)
				(Colonel
					view: 309
					loop: 0
					cel: 0
					setPri: -1
					cycleSpeed: 6
					setCycle: End self
				)
				(Chair show:)
			)
			(3
				(Colonel
					view: 301
					setStep: 2 2
					setCycle: Walk
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 233 117 self
				)
			)
			(4
				(Colonel setMotion: MoveTo 181 95 self)
			)
			(5
				(Colonel
					view: 310
					loop: 0
					cel: 0
					cycleSpeed: 0
					setCycle: End self
				)
				(stand loop: 2)
			)
			(6
				(Colonel loop: 1 setCycle: Fwd)
				(= cycles 21)
			)
			(7
				(Colonel
					loop: 0
					cel: (- (NumCels Colonel) 1)
					setCycle: Beg self
				)
			)
			(8
				(stand loop: 3)
				(Colonel
					view: 301
					setCycle: Walk
					setStep: 2 2
					setCycle: Walk
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 233 117 self
				)
			)
			(9
				(Colonel setMotion: MoveTo 200 140 self)
			)
			(10
				(Colonel
					view: 309
					loop: 0
					cel: 2
					setPri: -1
					cycleSpeed: 3
					setCycle: Beg self
				)
			)
			(11
				(Chair hide:)
				(localproc_0)
				(Colonel
					cel: (- (NumCels Colonel) 1)
					cycleSpeed: 2
					setCycle: Beg
					show:
				)
				(= seconds 3)
			)
			(12
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance bed of PV
	(properties
		y 167
		x 121
		view 142
		loop 1
		cel 2
	)
)

(instance table1 of PV
	(properties
		y 167
		x 148
		view 142
		loop 1
		cel 3
		priority 15
	)
)

(instance table2 of PV
	(properties
		y 167
		x 69
		view 142
		loop 1
		cel 3
		priority 15
	)
)

(instance sofa of PV
	(properties
		y 125
		x 158
		view 142
		loop 1
		priority 8
	)
)

(instance mirror of PV
	(properties
		y 141
		x 41
		view 142
		loop 1
		cel 1
	)
)

(instance table3 of PV
	(properties
		y 123
		x 202
		view 142
		loop 1
		cel 4
		priority 8
	)
)

(instance cannon of PV
	(properties
		y 52
		x 190
		view 142
		loop 1
		cel 5
	)
)

(instance lift of PV
	(properties
		y 126
		x 296
		view 242
	)
)

(instance gate of PV
	(properties
		y 126
		x 283
		view 242
		loop 2
	)
)

(instance vase of PV
	(properties
		y 52
		x 210
		view 142
		loop 1
		cel 7
	)
)

(instance flower of PV
	(properties
		y 52
		x 170
		view 142
		loop 1
		cel 8
	)
)

(instance lamp1 of Prop
	(properties
		y 44
		x 80
		view 142
	)
)

(instance lamp2 of Prop
	(properties
		y 76
		x 15
		view 142
		cel 1
	)
)

(instance logs of Prop
	(properties
		y 86
		x 189
		view 142
		loop 2
		priority 5
		cycleSpeed 1
	)
)

(instance Colonel of Act
	(properties)
)

(instance Chair of Act
	(properties)
)

(instance stand of Prop
	(properties)
)

(instance myMusic of Sound
	(properties)
)

