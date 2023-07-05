;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 770)
(include sci.sh)
(use Main)
(use genetix)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm770 0
)

(local
	local0
	local1
)

(instance rm770 of Rm
	(properties
		noun 4
		picture 115
	)

	(method (doit)
		(= local0 (gEgo onControl:))
		(if (not (gCurRoom script:))
			(if (& $1000 local0)
				(gCurRoom setScript: (ScriptID 31 3) 0 7) ; sGenInNout
			)
			(if (& $0800 local0)
				(gCurRoom setScript: (ScriptID 31 3) 0 8) ; sGenInNout
			)
		)
		(super doit:)
	)

	(method (init)
		(LoadMany rsMESSAGE number)
		(gSq5Music2 stop:)
		(self setRegions: 31) ; genetix
		(= style -32668)
		(super init:)
		(plate init: setOnMeCheck: 1 (plate onMeCheck:))
		(NormalEgo 603)
		(gEgo
			view: 603
			init:
			scaleSignal: 0
			cycleSpeed: 3
			setStep: 3 3
			scaleX: 128
			scaleY: 128
			setCycle: Walk
		)
		(switch gPrevRoomNum
			(730
				(gCurRoom setScript: sFrom730)
			)
			(790
				(gCurRoom setScript: sFrom790)
			)
			(else
				(SetFlag 24)
				(SetFlag 25)
				(SetFlag 26)
				(SetFlag 22)
				(SetFlag 27)
				(gCurRoom setScript: sFrom790)
			)
		)
		(beam1 init:)
		(beam2 init:)
		(beam3 init:)
		(beam4 init:)
		(beam5 init:)
		(beam6 init:)
		(beam7 init:)
		(beam8 init:)
		(beam9 init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 107 96 186 130 215 117 256 133 256 104 146 71 106 81 106 94
					yourself:
				)
		)
		(tumbler1 init:)
		(tumbler2 init:)
		(tumbler3 init:)
		(tumbler4 init:)
		(gSq5Music1 number: 121 setLoop: -1 play:)
	)
)

(instance sFrom790 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 108 63 setMotion: MoveTo 140 83 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFrom730 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 281 126 setMotion: MoveTo 231 117 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(class Tumbler of Prop
	(properties
		noun 1
		view 615
		loop 1
		priority 3
		signal 16
	)

	(method (init)
		(super init:)
		(|= signal $0008)
	)

	(method (show)
		(super show:)
		(self cue:)
	)

	(method (hide)
		(super hide:)
		(self cue:)
	)

	(method (cue)
		(gSq5Music2 number: 611 setLoop: 1 play:)
	)

	(method (dispose)
		(|= signal $0008)
		(|= signal $8000)
	)
)

(instance tumbler1 of Tumbler
	(properties
		x 251
		y 80
	)
)

(instance tumbler2 of Tumbler
	(properties
		x 251
		y 71
	)
)

(instance tumbler3 of Tumbler
	(properties
		x 251
		y 62
	)
)

(instance tumbler4 of Tumbler
	(properties
		x 251
		y 53
	)
)

(class Beam of Prop
	(properties
		noun 2
		view 615
		signal 16
	)

	(method (doit)
		(cond
			((& onMeCheck local0)
				(if (not (& signal $0088))
					(self hide:)
				)
			)
			((& signal $0088)
				(self show:)
			)
		)
		(super doit:)
	)

	(method (show)
		(= local1 0)
		(super show:)
		(switch self
			(beam2
				(tumbler1 hide:)
			)
			(beam4
				(tumbler2 hide:)
			)
			(beam6
				(tumbler3 hide:)
			)
			(beam8
				(tumbler4 hide:)
			)
		)
	)

	(method (hide)
		(if (not local1)
			(= local1 1)
			(super hide:)
			(switch self
				(beam2
					(tumbler1 show:)
				)
				(beam4
					(tumbler2 show:)
				)
				(beam6
					(tumbler3 show:)
				)
				(beam8
					(tumbler4 show:)
				)
			)
		)
	)
)

(instance beam1 of Beam
	(properties
		x 142
		y 71
		onMeCheck 2
		cel 8
		priority 7
	)
)

(instance beam2 of Beam
	(properties
		x 162
		y 65
		onMeCheck 4
		cel 7
		priority 6
	)
)

(instance beam3 of Beam
	(properties
		x 180
		y 60
		onMeCheck 8
		cel 5
		priority 5
	)
)

(instance beam4 of Beam
	(properties
		x 164
		y 79
		onMeCheck 16
		cel 6
		priority 8
	)
)

(instance beam5 of Beam
	(properties
		x 184
		y 73
		onMeCheck 32
		cel 1
		priority 7
	)
)

(instance beam6 of Beam
	(properties
		x 203
		y 67
		onMeCheck 64
		cel 2
		priority 6
	)
)

(instance beam7 of Beam
	(properties
		x 189
		y 89
		onMeCheck 128
		cel 3
		priority 9
	)
)

(instance beam8 of Beam
	(properties
		x 210
		y 82
		onMeCheck 256
		cel 1
		priority 8
	)
)

(instance beam9 of Beam
	(properties
		x 228
		y 75
		onMeCheck 512
		priority 7
	)
)

(instance plate of Feature
	(properties
		x 271
		y 189
		noun 3
		onMeCheck 21502
	)
)

(instance cliffy of MyActor ; UNUSED
	(properties
		noun 1
		view 20
		signal 16384
	)
)

