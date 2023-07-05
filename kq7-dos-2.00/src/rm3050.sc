;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3050)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm3050 0
)

(local
	local0
)

(instance rm3050 of KQRoom
	(properties
		picture 3050
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 3050)
		(Load rsSOUND 3000)
		(SetFlag 21)
		(gEgo setScaler: Scaler 100 36 82 45 init:)
		(cond
			((or (== gPrevRoomNum 3250) (== gPrevRoomNum 3100)) 0)
			((and (== gPrevRoomNum 3300) (IsFlag 101)) 0)
			(else
				(gKqMusic1 number: 3000 setVol: 127 loop: -1 play:)
			)
		)
		(switch gPrevRoomNum
			(3100
				(SetFlag 106)
				(gEgo posn: 323 67 normalize: 1)
				(gCurRoom setScript: fromRockHead)
			)
			(3250
				(SetFlag 106)
				(gEgo posn: 255 200 normalize: 3)
				(gCurRoom setScript: oakFarBank)
			)
			(23 ; selectGameRoom
				(gEgo normalize:)
				(gGame handsOn:)
			)
			(else
				(SetFlag 106)
				(gEgo posn: -20 52 normalize: 0)
				(gCurRoom setScript: stepFarBank)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: -5 42 -5 53 69 54 143 67 222 82 230 99 203 120 230 137 284 137 246 83 311 63 319 61 318 55 245 60 211 64 145 58 111 53 77 49 50 45 16 43
					yourself:
				)
		)
		(if (IsFlag 102)
			(Load 140 894) ; WAVE
			(waterSound number: 894 loop: -1 play:)
			(river1 setCycle: Fwd init:)
			(river2 setCycle: Fwd init:)
		)
		(river init:)
		(myWestExit init:)
		(mySouthExit init:)
		(myEastExit init:)
	)
)

(instance oakFarBank of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 6)
				)
				(1
					(gEgo setMotion: PolyPath 254 136 self)
				)
				(2
					(gEgo setHeading: 315 self)
				)
				(3
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo loop: 7 posn: 254 136 normalize: 7)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance stepFarBank of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 1)
				)
				(1
					(gEgo setLoop: 0 1 setMotion: MoveTo 25 52 self)
				)
				(2
					(gEgo setHeading: 180 self)
				)
				(3
					(gEgo normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo loop: 2 normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance fromRockHead of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setMotion: MoveTo 303 67 self)
				)
				(1
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo loop: 1 posn: 303 67 normalize: 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance stickToeInFar of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(cond
						((== local0 0)
							(if (== gValOrRoz -3) ; Roz
								(Load rsVIEW 8491)
							else
								(Load rsVIEW 8131)
							)
						)
						((== gValOrRoz -3) ; Roz
							(Load rsVIEW 8381)
						)
						(else
							(Load rsVIEW 8021)
						)
					)
					(gEgo setHeading: 225 self)
				)
				(1
					(if (== local0 1)
						(if (!= gValOrRoz -3) ; Roz
							(gEgo setMotion: MoveTo 190 112 self)
						else
							(gEgo setMotion: MoveTo 195 116 self)
						)
					else
						(= cycles 1)
					)
				)
				(2
					(cond
						((== local0 0)
							(if (== gValOrRoz -3) ; Roz
								(gEgo
									view: 8491
									loop: 1
									cel: 0
									setCycle: Osc 2 self
								)
							else
								(gEgo
									view: 8131
									loop: 1
									cel: 0
									x: (+ (gEgo x:) 9)
									y: (+ (gEgo y:) 1)
									setCycle: Osc 2 self
								)
							)
						)
						((== gValOrRoz -3) ; Roz
							(gEgo
								view: 8381
								loop: 1
								cel: 0
								x: 198
								setCycle: End self
							)
						)
						(else
							(gEgo
								view: 8021
								loop: 1
								cel: 0
								setCycle: End self
							)
						)
					)
				)
				(3
					(switch (gEgo view:)
						(8131
							(gEgo
								x: (- (gEgo x:) 9)
								y: (- (gEgo y:) 1)
							)
						)
						(8021
							(gEgo x: 213 y: 113)
						)
						(8381
							(gEgo x: 220 y: 117)
						)
					)
					(gEgo normalize: 5)
					(= cycles 1)
				)
				(4
					(cond
						((IsFlag 102)
							(if (== gValOrRoz -3) ; Roz
								(river1 approachX: 206 approachY: 145)
								(river1 approachX: 206 approachY: 145)
								(river2 approachX: 206 approachY: 145)
							else
								(river1 approachX: 213 approachY: 121)
								(river1 approachX: 213 approachY: 121)
								(river2 approachX: 213 approachY: 121)
							)
						)
						((== gValOrRoz -3) ; Roz
							(river1 approachX: 195 approachY: 116)
							(river1 approachX: 195 approachY: 116)
							(river2 approachX: 195 approachY: 116)
						)
						(else
							(river1 approachX: 213 approachY: 121)
							(river1 approachX: 213 approachY: 121)
							(river2 approachX: 213 approachY: 121)
						)
					)
					(++ local0)
					(gEgo normalize: 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(++ local0)
					(ClearFlag 539)
					(gEgo normalize: 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance drownDeathFar of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsSOUND 3252)
					(if (== gValOrRoz -3) ; Roz
						(Load rsVIEW 8381)
					)
					(= cycles 6)
				)
				(1
					(if (IsFlag 102)
						(Load rsSOUND 907)
					else
						(Load rsSOUND 902)
					)
					(= cycles 1)
				)
				(2
					(gKqMusic1 stop:)
					(cond
						((IsFlag 102)
							(if (== gValOrRoz -3) ; Roz
								(gEgo
									view: 3053
									loop: 1
									cel: 0
									posn: 188 139
									setPri: 200
									setCycle: CT 9 1 self
								)
							else
								(waterSound number: 3252 loop: 1 play:)
								(gEgo
									view: 3054
									loop: 0
									cel: 0
									posn: 209 124
									setPri: 200
									setCycle: CT 10 1 self
								)
							)
						)
						((== gValOrRoz -3) ; Roz
							(gEgo
								view: 8381
								loop: 1
								cel: 0
								x: 198
								setCycle: End self
							)
						)
						(else
							(gEgo
								view: 3055
								loop: 0
								cel: 0
								posn: 209 124
								setPri: 200
								setCycle: CT 10 1 self
							)
						)
					)
				)
				(3
					(cond
						((IsFlag 102)
							(if (== gValOrRoz -3) ; Roz
								(gEgo
									loop: 1
									cel: 9
									posn: 188 139
									setCycle: End self
								)
							else
								(waterSound number: 3252 loop: 1 play:)
								(gEgo loop: 0 cel: 10 setCycle: CT 15 1 self)
							)
						)
						((== gValOrRoz -3) ; Roz
							(= cycles 1)
						)
						(else
							(gEgo loop: 0 cel: 10 setCycle: CT 15 1 self)
						)
					)
					(cond
						((IsFlag 102)
							(riverSound number: 907 loop: 1 play:)
						)
						((== gValOrRoz -3) ; Roz
							(waterSound number: 3252 loop: 1 play:)
						)
						(else
							(riverSound number: 902 loop: 1 play:)
						)
					)
				)
				(4
					(riverSound stop:)
					(cond
						((== gValOrRoz -3) ; Roz
							(if (IsFlag 102)
								(EgoDead 69 self)
							else
								(gEgo posn: 222 120 setPri: -1 normalize: 1)
								(gMessager say: 7 8 6 1 self 3250) ; "I don't think so! I'm not silly enough to slog through that. Besides, Mother always told me not to play in the mud."
							)
						)
						((IsFlag 102)
							(EgoDead 24 self)
						)
						(else
							(EgoDead 25 self)
						)
					)
				)
				(5
					(gKqMusic1 play:)
					(if (IsFlag 102)
						(waterSound number: 894 loop: -1 play:)
					)
					(if (== gValOrRoz -3) ; Roz
						(if (IsFlag 102)
							(gEgo posn: 213 121 setPri: -1 normalize: 5)
							(= local0 0)
						else
							(gEgo setPri: -1 normalize: 1)
						)
					else
						(gEgo posn: 213 121 setPri: -1 normalize: 5)
						(= local0 0)
					)
					(ClearFlag 5)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(if (== gValOrRoz -3) ; Roz
						(if (IsFlag 102)
							(gEgo posn: 213 121 setPri: -1 normalize: 5)
							(= local0 0)
						else
							(gEgo normalize: 5)
						)
					else
						(gEgo posn: 213 121 setPri: -1 normalize: 5)
						(= local0 0)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sExitWest of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setMotion: MoveTo -20 49 self)
				)
				(1
					(gGame handsOff:)
					(gCurRoom newRoom: 3300)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(ClearFlag 539)
					(gCurRoom newRoom: 3300)
				)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setMotion: MoveTo (gEgo x:) 200 self)
				)
				(1
					(gGame handsOff:)
					(gCurRoom newRoom: 3250)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(ClearFlag 539)
					(if (== (mySouthExit nsLeft:) 214)
						(gCurRoom newRoom: 3250)
					else
						(gCurRoom newRoom: 3200)
					)
				)
			)
		)
	)
)

(instance exitToEast of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setMotion: MoveTo 340 62 self)
				)
				(1
					(gGame handsOff:)
					(gCurRoom newRoom: 3100)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(ClearFlag 539)
					(gCurRoom newRoom: 3100)
				)
			)
		)
	)
)

(instance sMessage of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gMessager say: 1 8 1 0 self) ; "(THINKS TO HERSELF)I already have a stick. I don't really need another."
				)
				(1
					(riverStix setHotspot: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(riverStix setHotspot: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sGetStick of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(stickSound number: 3051 loop: 1 play:)
					(gEgo get: 3) ; Stick
					(gEgo view: 8071 loop: 1 cel: 0 setCycle: End self)
				)
				(1
					(gEgo normalize: setHeading: 180 self)
				)
				(2
					(riverStix setHotspot: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(riverStix setHotspot: 0)
					(gEgo normalize: 2)
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance river1 of Prop
	(properties
		x 93
		y 139
		priority 139
		fixPriority 1
		view 3050
		cel 4
		signal 16385
	)

	(method (init)
		(super init:)
		(self approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
		(= approachX 194)
		(= approachY 118)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (and (== gValOrRoz -3) (not (IsFlag 102))) ; Roz
					(= local0 2)
				)
				(cond
					((>= local0 2)
						(gCurRoom setScript: drownDeathFar)
					)
					((and (== local0 1) (IsFlag 102))
						(gCurRoom setScript: drownDeathFar)
					)
					(else
						(gCurRoom setScript: stickToeInFar)
					)
				)
			)
		)
	)
)

(instance river2 of Prop
	(properties
		x 61
		y 139
		scaleX 0
		scaleY 0
		priority 139
		fixPriority 1
		view 3050
		loop 1
		signal 2049
	)

	(method (init)
		(super init:)
		(self approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
		(= approachX 194)
		(= approachY 118)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (and (== gValOrRoz -3) (not (IsFlag 102))) ; Roz
					(= local0 2)
				)
				(cond
					((>= local0 2)
						(gCurRoom setScript: drownDeathFar)
					)
					((and (== local0 1) (IsFlag 102))
						(gCurRoom setScript: drownDeathFar)
					)
					(else
						(gCurRoom setScript: stickToeInFar)
					)
				)
			)
		)
	)
)

(instance river of Feature
	(properties
		approachX 27
		approachY 126
		x 45
		y 110
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 ; Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 68 61 73 128 90 181 112 207 135 61 136 54 123 29 109 0 101
					yourself:
				)
		)
		(= approachX 194)
		(= approachY 118)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (and (== gValOrRoz -3) (not (IsFlag 102))) ; Roz
					(= local0 2)
				)
				(cond
					((>= local0 2)
						(gCurRoom setScript: drownDeathFar)
					)
					((and (== local0 1) (IsFlag 102))
						(gCurRoom setScript: drownDeathFar)
					)
					(else
						(gCurRoom setScript: stickToeInFar)
					)
				)
			)
		)
	)
)

(instance riverStix of Feature
	(properties
		noun 1
		approachX 215
		approachY 99
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 165 66 164 82 192 100 204 98 200 69
					yourself:
				)
		)
		(if (!= gChapter 4)
			(self setHotspot: 8 10) ; Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (gEgo has: 3) ; Stick
					(gCurRoom setScript: sMessage)
				else
					(Load rsVIEW 8071)
					(Load 140 3051) ; WAVE
					(gCurRoom setScript: sGetStick)
				)
			)
		)
	)
)

(instance myWestExit of ExitFeature
	(properties
		approachX -5
		approachY 49
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 37 36 41 38 58 0 60 yourself:)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: sExitWest)
		)
	)
)

(instance myEastExit of ExitFeature
	(properties
		approachX 314
		approachY 62
		x 370
		y 62
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 8 10 ; Do, Exit
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 252 55 274 80 319 62 319 55
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 10 8) ; Exit, Do
			(gCurRoom setScript: exitToEast)
			(super doVerb: theVerb)
		)
	)
)

(instance mySouthExit of ExitFeature
	(properties
		approachX 255
		approachY 170
		x 255
		y 300
		exitDir 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: sExitSouth)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 193 120 217 134 299 135 260 120
					yourself:
				)
		)
	)
)

(instance stickSound of Sound
	(properties)
)

(instance riverSound of Sound
	(properties)
)

(instance waterSound of Sound
	(properties)
)

