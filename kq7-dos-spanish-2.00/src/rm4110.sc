;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4110)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm4110 0
)

(instance rm4110 of KQRoom
	(properties
		picture 4110
	)

	(method (init)
		(if (not (IsFlag 223))
			(Load 140 4111) ; WAVE
			(Load rsVIEW 41101)
			(Load rsVIEW 41103)
			(Load rsVIEW 41103)
			(sarcophagus cel: 0)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 87 103 86 112 82 130 106 150 206 151 227 140 210 108 189 91 130 91 108 106 90 106
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 120 108 175 100 209 129 158 134
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 87 103 86 112 82 130 106 150 206 151 228 136 216 115 200 93 130 91 108 106 90 106
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 120 108 175 100 220 128 158 134
						yourself:
					)
			)
			(sarcophagus cel: 1)
			(if (not (IsFlag 222))
				(Load rsVIEW 41103)
			)
		)
		(SetFlag 192)
		(super init:)
		(gEgo posn: 87 106 init: normalize: 4 setScaler: Scaler 91 74 136 82)
		(gKqMusic1 number: 4110 setLoop: -1 play:)
		(sarcophagus init:)
		(exitDoor init:)
		(exitDoorFeature init:)
		(gCurRoom setScript: sWalkIn)
	)

	(method (dispose)
		(ClearFlag 192)
		(super dispose:)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(or
				(and
					(<= (gEgo y:) 108)
					(<= (gEgo x:) 165)
					(> (gEgo x:) 117)
				)
				(and (>= (gEgo x:) 165) (<= (gEgo y:) 128))
			)
			(gEgo setPri: 107)
		else
			(gEgo setPri: 135)
		)
	)
)

(instance sWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 101 112 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openSarcophagus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScaler: 0
					scaleX: 128
					scaleY: 128
					view: 41101
					setLoop: 0
					setCel: 0
					x: 135
					y: 131
					setPri: 140
					setCycle: CT 12 1 self
				)
			)
			(1
				(gEgo setCycle: End self)
				(sarcophagus setMotion: MoveTo 179 103 self)
				(soundEffect number: 4111 setLoop: 1 play:)
			)
			(2 0)
			(3
				(gEgo setLoop: 1 setCel: 0 x: 134 y: 130 setCycle: End self)
			)
			(4
				(gMessager say: 1 8 1 0 self) ; "(THINKS TO HERSELF WITH GREAT PITY)Oh...my...poor Count Tsepish."
			)
			(5
				(gEgo
					normalize: 6
					setScaler: Scaler 91 74 136 82
					posn: (sarcophagus approachX:) (sarcophagus approachY:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getHead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScaler: 0
					scaleX: 128
					scaleY: 128
					view: 41101
					setLoop: 2
					setCel: 0
					x: 138
					y: 130
					setPri: 140
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 41103
					setLoop: 0
					setCel: 0
					x: 144
					y: 129
					setCycle: End self
				)
			)
			(2
				(gEgo
					get: 75 ; Horseman_s_Head
					setPri: (+ (gEgo priority:) 10)
					setLoop: 1
					setCel: 0
					x: 145
					y: 128
					setCycle: End self
				)
			)
			(3
				(gEgo
					normalize: 6
					setScaler: Scaler 91 74 136 82
					posn: (sarcophagus approachX:) (sarcophagus approachY:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitDoorFeature of ExitFeature
	(properties
		nsLeft 48
		nsTop 48
		nsRight 95
		nsBottom 110
		approachX 87
		approachY 107
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
	)

	(method (doVerb)
		(gCurRoom newRoom: 4101)
	)
)

(instance exitDoor of Feature
	(properties
		approachX 87
		approachY 107
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 45 55 92 42 100 100 72 113
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (onMe)
		(return (exitDoor onMe: &rest))
	)
)

(instance sarcophagus of Actor
	(properties
		approachX 135
		approachY 131
		x 167
		y 107
		view 41100
	)

	(method (init)
		(if (IsFlag 223)
			(self posn: 179 103)
		)
		(super init:)
		(if (not (IsFlag 222))
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self
			setPri: 130
			ignoreActors:
			approachVerbs: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 136 109 132 82 150 65 160 65 171 74 181 74 190 93 201 98 182 127 161 130 137 109
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (not (IsFlag 223))
					(SetFlag 223)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 87 103 86 112 82 130 106 150 206 151 228 136 216 115 200 93 130 91 108 106 90 106
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 120 108 175 100 220 128 158 134
								yourself:
							)
					)
					(gCurRoom setScript: openSarcophagus)
				else
					(gCurRoom setScript: getHead)
					(SetFlag 222)
					(self setHotspot: 0)
				)
			)
		)
	)
)

(instance soundEffect of Sound
	(properties
		number 4111
	)
)

