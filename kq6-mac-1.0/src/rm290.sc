;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm290 0
)

(instance rm290 of KQ6Room
	(properties
		noun 5
		picture 290
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 142 120 98 120 79 133 27 133 7 159 106 159 119 172 119 184 184 184 183 161 309 161 248 128 224 128 208 118 157 118 157 1 319 1 319 189 0 189 0 1 142 1
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 164 138 182 132 203 141 184 146
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 120 127 137 136 118 145 102 137
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 142 150 142 140 161 140 161 150
					yourself:
				)
		)
		(super init: &rest)
		(Load rsVIEW 291)
		(gEgo init: reset: 2 posn: 151 119 setScale: 0)
		(gWalkHandler addToFront: self)
		(ferryman init:)
		(door init: cel: 5 setCycle: Beg door)
		(genericFeatures init:)
		(table init:)
		(if (== ((gInventory at: 34) owner:) gCurRoomNum) ; rabbitFoot
			(rabbitsFoot init:)
		)
		(gCurRoom setScript: enterScr)
		(gGlobalSound number: 290 loop: -1 play:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: leaveScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gGlobalSound fade:)
		(super dispose: &rest)
		(SetFlag 17)
	)

	(method (scriptCheck)
		(gMessager say: 0 0 34 0 0 899) ; "It wouldn't be polite to do that here! Perhaps Alexander should wait until he's not taking up the ferryman's time."
		(return 0)
	)
)

(instance enterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 17))
					(gGame givePoints: 2)
				)
				(ferryman setMotion: PolyPath 138 137 self)
			)
			(1
				(ferryman
					posn: 128 147
					view: 294
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(2
				(ferryman stopUpd:)
				(gEgo setSpeed: 6 setMotion: MoveTo 160 140 self)
			)
			(3
				(gEgo
					view: 291
					setLoop: 0
					posn: 176 144
					normal: 0
					cel: 0
					setCycle: End self
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(gEgo stopUpd:)
				(gMessager say: 1 0 (if (IsFlag 17) 9 else 8) 0 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gWalkHandler delete: gCurRoom)
				(ferryman hide:)
				(gEgo
					view: 291
					loop: 3
					posn: 178 144
					cel: 0
					normal: 0
					setCycle: CT 8 1 self
				)
			)
			(1
				(gMessager say: 6 5 (if (IsFlag 17) 13 else 12) 0 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(ferryman view: 291 loop: 4 cel: 0 posn: 134 145 show:)
				(gEgo reset: 7 posn: 167 142 ignoreActors: setScale: 0)
				(= cycles 2)
			)
			(5
				(gEgo setMotion: PolyPath 148 116 self)
			)
			(6
				(gEgo setHeading: 0 self)
			)
			(7
				(ferryman setCycle: End self)
				(door setCycle: End self)
				(gGlobalSound4 number: 901 loop: 1 play:)
			)
			(8 0)
			(9
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 136
		y 78
		noun 6
		sightAngle 180
		view 290
		loop 3
	)

	(method (cue)
		(self stopUpd:)
		(gGlobalSound4 number: 902 loop: 1 play:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: leaveScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ferrymanTalkScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< global158 5)
					(++ global158)
				)
				(switch global158
					(0 0)
					(1
						(= register 2)
						(ClearFlag 30)
						(SetFlag 29)
					)
					(2
						(= register 3)
					)
					(3
						(= register 4)
					)
					(4
						(= register 5)
					)
					(5
						(if (> (++ global166) 5)
							(= global166 1)
						)
						(= register
							(switch global166
								(0 0)
								(1 6)
								(2 14)
								(3 15)
								(4 16)
								(5 18)
								(6 19)
							)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(if (== global158 5)
					(gMessager say: 3 2 17 1 self) ; "What else can you tell me about the Land?"
				else
					(self cue:)
				)
			)
			(2
				(gMessager say: 3 2 register 0 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ferryman of Actor
	(properties
		x 150
		y 121
		noun 3
		sightAngle 180
		view 292
	)

	(method (init)
		(super init: &rest)
		(self
			setStep: (gEgo xStep:) (gEgo yStep:)
			setCycle: Walk
			signal: (| signal $1000)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gCurRoom setScript: ferrymanTalkScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance getRabbitsFoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame givePoints: 1)
				(gEgo get: 34) ; rabbitFoot
				(gMessager say: 4 5 0 0 self) ; "(CURIOUS) I see you have a rabbit's foot. Has it brought you much luck?"
			)
			(1
				(gEgo loop: 2 cel: 0 setPri: 11 setCycle: CT 3 1 self)
			)
			(2
				(rabbitsFoot dispose:)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo cel: 0)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rabbitsFoot of View
	(properties
		x 154
		y 174
		z 42
		noun 4
		sightAngle 180
		view 290
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: getRabbitsFoot)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self setPri: 11 stopUpd: ignoreActors:)
	)
)

(instance table of Feature
	(properties
		noun 18
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 5 1) ; Do, Look
			(gMessager
				say: noun theVerb (if (gCast contains: rabbitsFoot) 21 else 11)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance genericFeatures of Feature
	(properties)

	(method (onMe param1 &tmp temp0)
		(return
			(= noun
				(switch (= temp0 (OnControl CONTROL (param1 x:) (param1 y:)))
					(2 15)
					(8 7)
					(16 8)
					(32 10)
					(64 16)
					(128 9)
					(512 14)
					(1024 11)
					(else 0)
				)
			)
		)
	)
)

