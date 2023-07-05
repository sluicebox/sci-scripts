;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1460)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use useObj)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1460 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2)
	(cond
		((== global302 param1)
			(= global302 param2)
		)
		((== global303 param1)
			(= global303 param2)
		)
		((== global304 param1)
			(= global304 param2)
		)
		((== global301 param1)
			(= global301 param2)
		)
		((== global300 param1)
			(= global300 param2)
		)
		((== global317 param1)
			(= global317 param2)
		)
	)
)

(instance rm1460 of KQRoom
	(properties
		picture 1460
	)

	(method (init)
		(super init:)
		(gGame handsOn:)
		(if ((ScriptID 0 6) seconds:) ; scorpDeathTimer
			(= local0 ((ScriptID 0 6) seconds:)) ; scorpDeathTimer
			((ScriptID 0 6) client: 0 delete: dispose:) ; scorpDeathTimer
		)
		(rainDrop init:)
		(if (not (IsFlag 28))
			(redGemProp init:)
			(yellowGemProp init:)
			(greenGemProp init:)
		)
		(if (IsFlag 316)
			(lightBeam init:)
		)
		(if (and (IsFlag 49) (not (IsFlag 15)))
			(cornRelief init: setCel: 21)
		)
		(if (IsFlag 28)
			(redGem init:)
			(yellowGem init:)
			(greenGem init:)
		)
		(if (not (IsFlag 96))
			(statue init:)
		)
		(if (IsFlag 28)
			(leftHand init:)
			(rightHand init:)
			(redGemArea init:)
			(greenGemArea init:)
			(yellowGemArea init:)
			(sunImage init:)
		)
		(proc11_6 1450)
		(gKqMusic1 number: 1460 setLoop: -1 play: setVol: 0 fade: 127 25 10 0)
		(Load 140 810) ; WAVE
		(Load rsVIEW 1462)
		(gMouseDownHandler add: leftHand rightHand redGem greenGem yellowGem)
	)

	(method (doit)
		(super doit:)
		(if (and (IsFlag 20) (not (mySound handle:)))
			(stuckSoundManager doit:)
		)
	)

	(method (dispose)
		(gKqMusic1 fade:)
		(if local0
			((ScriptID 0 6) setReal: (ScriptID 0 6) local0) ; scorpDeathTimer, scorpDeathTimer
		)
		(mySound stop: dispose:)
		(gMouseDownHandler delete: redGem greenGem yellowGem leftHand rightHand)
		(super dispose:)
	)
)

(instance getThePuzzlePiece of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqSound1 number: 12550 setLoop: 1 play:)
				(cornRelief init: setCycle: End self)
			)
			(1
				(SetFlag 49)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance turnRainDrop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 1462) ; WAVE
				(rainDrop setCycle: End self)
				(gKqSound1 number: 1107 setLoop: 1 play:)
			)
			(1
				(redGemProp setCycle: End)
				(yellowGemProp setCycle: End)
				(greenGemProp setCycle: End self)
				(gKqSound1 number: 839 play:)
			)
			(2
				(SetFlag 28)
				(rainDrop setHotspot: 0)
				(gKqSound1 number: 810 play: self)
			)
			(3
				(redGemProp dispose:)
				(redGem init:)
				(yellowGemProp dispose:)
				(yellowGem init:)
				(greenGemProp dispose:)
				(greenGem init:)
				(SetFlag 316)
				(gGame handsOn:)
				(gCurRoom newRoom: 1450)
			)
		)
	)
)

(instance lightBeam of Prop
	(properties
		x 170
		y 5
		z -3
		view 1462
		loop 15
		signal 4129
	)

	(method (init)
		(super init:)
		(cond
			((and (not global300) (not global301))
				(self setCel: 2)
			)
			(global301
				(self setCel: 0)
			)
			(else
				(self setCel: 1)
			)
		)
	)
)

(instance rainDrop of Prop
	(properties
		x 132
		y 56
		view 1460
	)

	(method (init)
		(super init:)
		(if (IsFlag 28)
			(self setCel: 8)
		)
		(if (not (IsFlag 28))
			(self setHotspot: 8 10) ; Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (not (IsFlag 28))
					(gCurRoom setScript: turnRainDrop)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance redGemProp of Prop
	(properties
		x 55
		y 50
		view 1461
		loop 1
	)
)

(instance yellowGemProp of Prop
	(properties
		x 231
		y 47
		view 1461
	)
)

(instance greenGemProp of Prop
	(properties
		x 150
		y 124
		view 1461
		loop 2
	)
)

(instance cornRelief of Prop
	(properties
		x 73
		y 52
		view 1460
		loop 1
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(SetFlag 15)
				(gEgo get: 5) ; Turquoise_Piece_a
				(self dispose:)
			)
		)
	)
)

(instance redGem of useObj
	(properties
		view 1461
		loop 4
		verb 47
		myCursorView 14610
	)

	(method (init)
		(super init:)
		(cond
			((== global302 1)
				(self posn: 63 46)
			)
			((== global303 1)
				(self posn: 159 119)
			)
			((== global304 1)
				(self posn: 239 44)
			)
			((== global317 1)
				(self posn: 196 36)
			)
			((== global301 1)
				(self posn: 172 8)
				(if global300
					(cond
						((== global300 3)
							(yellowGemProp
								init:
								view: 1462
								x: (yellowGem x:)
								y: (yellowGem y:)
								setLoop: 14
								setCel: 4
							)
							(yellowGem setCel: 1)
						)
						((== global300 2)
							(greenGemProp
								init:
								view: 1462
								x: (greenGem x:)
								y: (greenGem y:)
								setLoop: 3
								setCel: 4
							)
							(greenGem setCel: 1)
						)
					)
					(redGemProp
						init:
						view: 1462
						x: (redGem x:)
						y: (redGem y:)
						setLoop: 5
						setCel: 4
					)
					(self setCel: 1)
				else
					(redGemProp
						init:
						view: 1462
						x: (redGem x:)
						y: (redGem y:)
						setLoop: 6
						setCel: 4
					)
					(self setCel: 1)
				)
			)
			((== global300 1)
				(self posn: 121 33)
				(redGemProp
					init:
					view: 1462
					x: (redGem x:)
					y: (redGem y:)
					setLoop: 5
					setCel: 4
				)
				(self setCel: 1)
			)
		)
		(self setHotspot: 8 10 49 48) ; Do, Exit, yellowGem, greenGem
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (IsFlag 28)
					(redGemProp dispose:)
					(self setCel: 0)
					(cond
						((== global300 1)
							(cond
								((== global301 2)
									(greenGemProp
										setLoop: 1
										setCel: 0
										setCycle: End
									)
									(rightHand init:)
								)
								((== global301 3)
									(yellowGemProp
										setLoop: 11
										setCel: 0
										setCycle: End
									)
									(rightHand init:)
								)
								(else
									(rightHand init:)
									(lightBeam setCel: 2)
								)
							)
						)
						((== global301 1)
							(cond
								((== global300 2)
									(greenGemProp
										setLoop: 2
										setCel: 0
										setCycle: End
									)
									(lightBeam setCel: 1)
									(leftHand init:)
								)
								((== global300 3)
									(yellowGemProp
										setLoop: 12
										setCel: 0
										setCycle: End
									)
									(lightBeam setCel: 1)
									(leftHand init:)
								)
								(else
									(lightBeam setCel: 2)
									(leftHand init:)
								)
							)
						)
					)
					(localproc_0 1 0)
					(super doVerb: theVerb)
				)
			)
			(49 ; yellowGem
				(yellowGem
					setHotspot: 8 10 47 48 ; Do, Exit, redGem, greenGem
					setCel: 0
					show:
					posn: (redGem x:) (redGem y:)
				)
				(super doVerb: 8)
				(redGemProp dispose:)
				(self setCel: 0)
				(if (or (== global300 1) (== global301 1))
					(gemManager doit: 1 3)
				else
					(localproc_0 1 3)
				)
			)
			(48 ; greenGem
				(greenGem
					setHotspot: 8 10 47 49 ; Do, Exit, redGem, yellowGem
					setCel: 0
					show:
					posn: (redGem x:) (redGem y:)
				)
				(super doVerb: 8)
				(redGemProp dispose:)
				(self setCel: 0)
				(if (or (== global300 1) (== global301 1))
					(gemManager doit: 1 2)
				else
					(localproc_0 1 2)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (show)
		(super show:)
		(gKqSound1 number: 810 play:)
	)
)

(instance yellowGem of useObj
	(properties
		view 1461
		loop 3
		verb 49
		myCursorView 14610
	)

	(method (init)
		(super init:)
		(cond
			((== global302 3)
				(self posn: 63 46)
			)
			((== global303 3)
				(self posn: 159 119)
			)
			((== global304 3)
				(self posn: 239 44)
			)
			((== global317 3)
				(self posn: 196 36)
			)
			((== global301 3)
				(self posn: 172 8)
				(if global300
					(cond
						((== global300 1)
							(redGemProp
								init:
								view: 1462
								x: (redGem x:)
								y: (redGem y:)
								setLoop: 9
								setCel: 4
							)
							(redGem setCel: 1)
						)
						((== global300 2)
							(greenGemProp
								init:
								view: 1462
								x: (greenGem x:)
								y: (greenGem y:)
								setLoop: 4
								setCel: 4
							)
							(greenGem setCel: 1)
						)
					)
					(yellowGemProp
						init:
						view: 1462
						x: (yellowGem x:)
						y: (yellowGem y:)
						setLoop: 10
						setCel: 4
					)
					(self setCel: 1)
				else
					(yellowGemProp
						init:
						view: 1462
						x: (yellowGem x:)
						y: (yellowGem y:)
						setLoop: 11
						setCel: 4
					)
					(self setCel: 1)
				)
			)
			((== global300 3)
				(self posn: 121 33)
				(yellowGemProp
					init:
					view: 1462
					x: (yellowGem x:)
					y: (yellowGem y:)
					setLoop: 12
					setCel: 4
				)
				(self setCel: 1)
			)
		)
		(self setHotspot: 8 10 47 48) ; Do, Exit, redGem, greenGem
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (IsFlag 28)
					(yellowGemProp dispose:)
					(self setCel: 0)
					(cond
						((== global300 3)
							(cond
								((== global301 2)
									(greenGemProp
										setLoop: 1
										setCel: 0
										setCycle: End
									)
									(rightHand init:)
								)
								((== global301 1)
									(redGemProp
										setLoop: 6
										setCel: 0
										setCycle: End
									)
									(redGem setCel: 1)
									(rightHand init:)
								)
								(else
									(rightHand init:)
									(lightBeam setCel: 2)
								)
							)
						)
						((== global301 3)
							(cond
								((== global300 2)
									(greenGemProp
										setLoop: 2
										setCel: 0
										setCycle: End
									)
									(leftHand init:)
									(lightBeam setCel: 1)
								)
								((== global300 1)
									(redGemProp
										setLoop: 7
										setCel: 0
										setCycle: End
									)
									(redGem setCel: 1)
									(leftHand init:)
									(lightBeam setCel: 1)
								)
								(else
									(leftHand init:)
									(lightBeam setCel: 2)
								)
							)
						)
					)
					(localproc_0 3 0)
					(super doVerb: theVerb)
				)
			)
			(47 ; redGem
				(redGem
					setHotspot: 8 10 48 49 ; Do, Exit, greenGem, yellowGem
					setCel: 0
					show:
					posn: (yellowGem x:) (yellowGem y:)
				)
				(super doVerb: 8)
				(yellowGemProp dispose:)
				(self setCel: 0)
				(if (or (== global300 3) (== global301 3))
					(gemManager doit: 3 1)
				else
					(localproc_0 3 1)
				)
			)
			(48 ; greenGem
				(greenGem
					setHotspot: 8 10 47 49 ; Do, Exit, redGem, yellowGem
					setCel: 0
					show:
					posn: (yellowGem x:) (yellowGem y:)
				)
				(super doVerb: 8)
				(yellowGemProp dispose:)
				(self setCel: 0)
				(if (or (== global300 3) (== global301 3))
					(gemManager doit: 3 2)
				else
					(localproc_0 3 2)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (show)
		(super show:)
		(gKqSound1 number: 810 play:)
	)
)

(instance greenGem of useObj
	(properties
		view 1461
		loop 5
		verb 48
		myCursorView 14610
	)

	(method (init)
		(super init:)
		(cond
			((== global302 2)
				(self posn: 63 46)
			)
			((== global303 2)
				(self posn: 159 119)
			)
			((== global304 2)
				(self posn: 239 44)
			)
			((== global317 2)
				(self posn: 196 36)
			)
			((== global301 2)
				(self posn: 172 8)
				(if global300
					(cond
						((== global300 1)
							(redGemProp
								init:
								view: 1462
								x: (redGem x:)
								y: (redGem y:)
								setLoop: 8
								setCel: 4
							)
							(redGem setCel: 1)
						)
						((== global300 3)
							(yellowGemProp
								init:
								view: 1462
								x: (yellowGem x:)
								y: (yellowGem y:)
								setLoop: 13
								setCel: 4
							)
							(yellowGem setCel: 1)
						)
					)
					(greenGemProp
						init:
						view: 1462
						x: (greenGem x:)
						y: (greenGem y:)
						setLoop: 0
						setCel: 4
					)
					(greenGem setCel: 1)
				else
					(greenGemProp
						init:
						view: 1462
						x: (greenGem x:)
						y: (greenGem y:)
						setLoop: 1
						setCel: 4
					)
					(greenGem setCel: 1)
				)
			)
			((== global300 2)
				(self posn: 121 33)
				(if global301
					(cond
						((== global301 1)
							(greenGemProp
								init:
								view: 1462
								x: (greenGem x:)
								y: (greenGem y:)
								setLoop: 3
								setCel: 4
							)
							(greenGem setCel: 1)
						)
						((== global301 3)
							(greenGemProp
								init:
								view: 1462
								x: (greenGem x:)
								y: (greenGem y:)
								setLoop: 4
								setCel: 4
							)
							(greenGem setCel: 1)
						)
					)
				else
					(greenGemProp
						init:
						view: 1462
						x: (greenGem x:)
						y: (greenGem y:)
						setLoop: 0
						setCel: 4
					)
					(greenGem setCel: 1)
				)
			)
		)
		(self setHotspot: 8 10 47 49) ; Do, Exit, redGem, yellowGem
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (IsFlag 28)
					(greenGemProp dispose:)
					(cond
						((== global300 2)
							(cond
								((== global301 3)
									(yellowGemProp
										setLoop: 11
										setCel: 0
										setCycle: End
									)
									(rightHand init:)
								)
								((== global301 1)
									(redGemProp
										setLoop: 6
										setCel: 0
										setCycle: End
									)
									(redGem setCel: 1)
									(rightHand init:)
								)
								(else
									(rightHand init:)
									(lightBeam setCel: 2)
								)
							)
						)
						((== global301 2)
							(cond
								((== global300 3)
									(yellowGemProp
										setLoop: 12
										setCel: 0
										setCycle: End
									)
									(leftHand init:)
									(lightBeam setCel: 1)
								)
								((== global300 1)
									(redGemProp
										setLoop: 7
										setCel: 0
										setCycle: End
									)
									(redGem setCel: 1)
									(leftHand init:)
									(lightBeam setCel: 1)
								)
								(else
									(leftHand init:)
									(lightBeam setCel: 2)
								)
							)
						)
					)
					(localproc_0 2 0)
					(super doVerb: theVerb)
				)
			)
			(47 ; redGem
				(redGem
					setHotspot: 8 10 48 49 ; Do, Exit, greenGem, yellowGem
					setCel: 0
					show:
					posn: (greenGem x:) (greenGem y:)
				)
				(super doVerb: 8)
				(greenGemProp dispose:)
				(greenGem setCel: 0)
				(if (or (== global300 2) (== global301 2))
					(gemManager doit: 2 1)
				else
					(localproc_0 2 1)
				)
			)
			(49 ; yellowGem
				(yellowGem
					setHotspot: 8 10 48 47 ; Do, Exit, greenGem, redGem
					setCel: 0
					show:
					posn: (greenGem x:) (greenGem y:)
				)
				(super doVerb: 8)
				(greenGemProp dispose:)
				(greenGem setCel: 0)
				(if (or (== global300 2) (== global301 2))
					(gemManager doit: 2 3)
				else
					(localproc_0 2 3)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (show)
		(super show:)
		(gKqSound1 number: 810 play:)
	)
)

(instance statue of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 96))
			(self setHotspot: 8 10) ; Do, Exit
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 4 136 9 141 13 136 29 118 28 115 37 132 36 134 51 128 56 133 61 146 53 166 53 184 59 184 53 175 50 171 32 161 29 172 21 171 9 183 2 167 0 164 7 159 22 159 3
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: 1 8 0 0) ; "That looks like it's attached to the altar."
				(self setHotspot: 0)
				(SetFlag 96)
			)
		)
	)
)

(instance leftHand of Feature
	(properties
		x 172
		y 8
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 47 48 49 ; Do, Exit, redGem, greenGem, yellowGem
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 171 10 178 10 178 6 171 6
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; redGem
				(redGem setHotspot: 8 10 49 48 setCel: 0 show: posn: x y) ; Do, Exit, yellowGem, greenGem
				(handManager doit: 1 1)
				(self dispose:)
			)
			(48 ; greenGem
				(greenGem setHotspot: 8 10 49 47 setCel: 0 show: posn: x y) ; Do, Exit, yellowGem, redGem
				(handManager doit: 2 1)
				(self dispose:)
				(if (and (== global317 1) (== global300 3) (not (IsFlag 49)))
					(gCurRoom setScript: getThePuzzlePiece)
				)
			)
			(49 ; yellowGem
				(yellowGem setHotspot: 8 10 48 47 setCel: 0 show: posn: x y) ; Do, Exit, greenGem, redGem
				(handManager doit: 3 1)
				(self dispose:)
				(if (and (== global317 1) (== global300 2) (not (IsFlag 49)))
					(gCurRoom setScript: getThePuzzlePiece)
				)
			)
		)
	)
)

(instance rightHand of Feature
	(properties
		x 121
		y 32
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 47 48 49 ; Do, Exit, redGem, greenGem, yellowGem
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 35 127 35 127 31 120 31
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; redGem
				(redGem setHotspot: 8 10 48 49 setCel: 0 show:) ; Do, Exit, greenGem, yellowGem
				(handManager doit: 1 0)
				(self dispose:)
			)
			(48 ; greenGem
				(greenGem setHotspot: 8 10 47 49 setCel: 0 show:) ; Do, Exit, redGem, yellowGem
				(handManager doit: 2 0)
				(self dispose:)
				(if (and (== global317 1) (== global301 3) (not (IsFlag 49)))
					(gCurRoom setScript: getThePuzzlePiece)
				)
			)
			(49 ; yellowGem
				(yellowGem setHotspot: 8 10 47 48 setCel: 0 show:) ; Do, Exit, redGem, greenGem
				(handManager doit: 3 0)
				(self dispose:)
				(if (and (== global317 1) (== global301 2) (not (IsFlag 49)))
					(gCurRoom setScript: getThePuzzlePiece)
				)
			)
		)
	)
)

(instance redGemArea of Feature
	(properties
		x 63
		y 45
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 47 48 49 ; Do, Exit, redGem, greenGem, yellowGem
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 61 47 61 49 67 49 67 47 yourself:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; redGem
				(redGem setHotspot: 8 10 48 49 setCel: 0 show:) ; Do, Exit, greenGem, yellowGem
				(= global302 1)
			)
			(48 ; greenGem
				(greenGem setHotspot: 8 10 47 49 setCel: 0 show:) ; Do, Exit, redGem, yellowGem
				(= global302 2)
			)
			(49 ; yellowGem
				(yellowGem setHotspot: 8 10 47 48 setCel: 0 show:) ; Do, Exit, redGem, greenGem
				(= global302 3)
			)
		)
	)
)

(instance greenGemArea of Feature
	(properties
		x 159
		y 117
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 47 48 49 ; Do, Exit, redGem, greenGem, yellowGem
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 156 120 165 120 165 117 156 117
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; redGem
				(redGem setHotspot: 8 10 48 49 setCel: 0 show:) ; Do, Exit, greenGem, yellowGem
				(= global303 1)
			)
			(48 ; greenGem
				(greenGem setHotspot: 8 10 47 49 setCel: 0 show:) ; Do, Exit, redGem, yellowGem
				(= global303 2)
			)
			(49 ; yellowGem
				(yellowGem setHotspot: 8 10 47 48 setCel: 0 show:) ; Do, Exit, redGem, greenGem
				(= global303 3)
			)
		)
	)
)

(instance yellowGemArea of Feature
	(properties
		x 239
		y 43
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 47 48 49 ; Do, Exit, redGem, greenGem, yellowGem
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 236 46 245 46 245 44 236 44
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; redGem
				(redGem setHotspot: 8 10 48 49 setCel: 0 show:) ; Do, Exit, greenGem, yellowGem
				(= global304 1)
			)
			(48 ; greenGem
				(greenGem setHotspot: 8 10 47 49 setCel: 0 show:) ; Do, Exit, redGem, yellowGem
				(= global304 2)
			)
			(49 ; yellowGem
				(yellowGem setHotspot: 8 10 47 48 setCel: 0 show:) ; Do, Exit, redGem, greenGem
				(= global304 3)
			)
		)
	)
)

(instance sunImage of Feature
	(properties
		x 196
		y 35
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 47 48 49 ; Do, Exit, redGem, greenGem, yellowGem
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 192 38 200 38 200 36 192 36
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; redGem
				(redGem setHotspot: 8 10 48 49 setCel: 0 show:) ; Do, Exit, greenGem, yellowGem
				(if
					(and
						(or (== global301 2) (== global300 2))
						(or (== global301 3) (== global300 3))
						(not (IsFlag 49))
					)
					(gCurRoom setScript: getThePuzzlePiece)
				)
				(= global317 1)
			)
			(48 ; greenGem
				(greenGem setHotspot: 8 10 47 49 setCel: 0 show:) ; Do, Exit, redGem, yellowGem
				(= global317 2)
			)
			(49 ; yellowGem
				(yellowGem setHotspot: 8 10 47 48 setCel: 0 show:) ; Do, Exit, redGem, greenGem
				(= global317 3)
			)
		)
	)
)

(instance handManager of Code
	(properties)

	(method (doit param1 param2)
		(if (== param2 1)
			(lightBeam setCel: 0)
			(cond
				((== param1 1)
					(if global300
						(cond
							((== global300 2)
								(greenGemProp
									setLoop: 3
									setCel: 0
									setCycle: End
								)
							)
							((== global300 3)
								(yellowGemProp
									setLoop: 14
									setCel: 0
									setCycle: End
								)
							)
						)
						(redGemProp
							init:
							view: 1462
							posn: (redGem x:) (redGem y:)
							setLoop: 5
							setCel: 0
							setCycle: End
						)
						(redGem setCel: 1)
					else
						(redGemProp
							init:
							view: 1462
							posn: (redGem x:) (redGem y:)
							setLoop: 6
							setCel: 0
							setCycle: End
						)
						(redGem setCel: 1)
					)
					(= global301 1)
				)
				((== param1 2)
					(if global300
						(cond
							((== global300 1)
								(redGemProp setLoop: 8 setCel: 0 setCycle: End)
							)
							((== global300 3)
								(yellowGemProp
									setLoop: 13
									setCel: 0
									setCycle: End
								)
							)
						)
						(greenGemProp
							init:
							view: 1462
							posn: (greenGem x:) (greenGem y:)
							setLoop: 0
							setCel: 0
							setCycle: End
						)
						(greenGem setCel: 1)
					else
						(greenGemProp
							init:
							view: 1462
							posn: (greenGem x:) (greenGem y:)
							setLoop: 1
							setCel: 0
							setCycle: End
						)
						(greenGem setCel: 1)
					)
					(= global301 2)
				)
				((== param1 3)
					(if global300
						(cond
							((== global300 1)
								(redGemProp setLoop: 9 setCel: 0 setCycle: End)
							)
							((== global300 2)
								(greenGemProp
									setLoop: 4
									setCel: 0
									setCycle: End
								)
							)
						)
						(yellowGemProp
							init:
							view: 1462
							posn: (yellowGem x:) (yellowGem y:)
							setLoop: 10
							setCel: 0
							setCycle: End
						)
						(yellowGem setCel: 1)
					else
						(yellowGemProp
							init:
							view: 1462
							posn: (yellowGem x:) (yellowGem y:)
							setLoop: 11
							setCel: 0
							setCycle: End
						)
						(yellowGem setCel: 1)
					)
					(= global301 3)
				)
			)
		else
			(if (not global301)
				(lightBeam setCel: 1)
			)
			(cond
				((== param1 1)
					(if global301
						(cond
							((== global301 3)
								(yellowGemProp setLoop: 10 setCel: 4)
								(redGemProp
									init:
									view: 1462
									posn: (redGem x:) (redGem y:)
									setLoop: 9
									setCel: 0
									setCycle: End
								)
								(redGem setCel: 1)
							)
							((== global301 2)
								(greenGemProp setLoop: 0 setCel: 4)
								(redGemProp
									init:
									view: 1462
									posn: (redGem x:) (redGem y:)
									setLoop: 8
									setCel: 0
									setCycle: End
								)
								(redGem setCel: 1)
							)
						)
					else
						(redGemProp
							init:
							view: 1462
							posn: (redGem x:) (redGem y:)
							setLoop: 7
							setCel: 0
							setCycle: End
						)
						(redGem setCel: 1)
					)
					(= global300 1)
				)
				((== param1 2)
					(if global301
						(cond
							((== global301 3)
								(yellowGemProp setLoop: 10 setCel: 4)
								(greenGemProp
									init:
									view: 1462
									posn: (greenGem x:) (greenGem y:)
									setLoop: 4
									setCel: 0
									setCycle: End
								)
								(greenGem setCel: 1)
							)
							((== global301 1)
								(redGemProp setLoop: 5 setCel: 4)
								(greenGemProp
									init:
									view: 1462
									posn: (greenGem x:) (greenGem y:)
									setLoop: 3
									setCel: 0
									setCycle: End
								)
								(greenGem setCel: 1)
							)
						)
					else
						(greenGemProp
							init:
							view: 1462
							posn: (greenGem x:) (greenGem y:)
							setLoop: 2
							setCel: 0
							setCycle: End
						)
						(greenGem setCel: 1)
					)
					(= global300 2)
				)
				((== param1 3)
					(if global301
						(cond
							((== global301 2)
								(greenGemProp setLoop: 0 setCel: 4)
								(yellowGemProp
									init:
									view: 1462
									posn: (yellowGem x:) (yellowGem y:)
									setLoop: 13
									setCel: 0
									setCycle: End
								)
								(yellowGem setCel: 1)
							)
							((== global301 1)
								(redGemProp setLoop: 5 setCel: 4)
								(yellowGemProp
									init:
									view: 1462
									posn: (yellowGem x:) (yellowGem y:)
									setLoop: 14
									setCel: 0
									setCycle: End
								)
								(yellowGem setCel: 1)
							)
						)
					else
						(yellowGemProp
							init:
							view: 1462
							posn: (yellowGem x:) (yellowGem y:)
							setLoop: 12
							setCel: 0
							setCycle: End
						)
						(yellowGem setCel: 1)
					)
					(= global300 3)
				)
			)
		)
	)
)

(instance gemManager of Code
	(properties)

	(method (doit param1 param2)
		(cond
			((== param1 1)
				(cond
					((== param2 3)
						(yellowGemProp
							init:
							view: 1462
							x: (yellowGem x:)
							y: (yellowGem y:)
							setLoop:
								(cond
									((== global301 1)
										(lightBeam setCel: 0)
										(if global300 10 else 11)
									)
									(global301 13)
									(else
										(lightBeam setCel: 1)
										12
									)
								)
							setCel: 0
							setCycle: End
						)
						(yellowGem setCel: 1)
						(if (and (== global301 1) global300)
							(greenGemProp setLoop: 4 setCel: 0 setCycle: End)
						)
						(localproc_0 1 3)
					)
					((== param2 2)
						(greenGemProp
							init:
							view: 1462
							x: (greenGem x:)
							y: (greenGem y:)
							setLoop:
								(cond
									((== global301 1)
										(lightBeam setCel: 0)
										(if global300 0 else 1)
									)
									(global301 4)
									(else
										(lightBeam setCel: 1)
										2
									)
								)
							setCel: 0
							setCycle: End
						)
						(greenGem setCel: 1)
						(if (and (== global301 1) global300)
							(yellowGemProp setLoop: 13 setCel: 0 setCycle: End)
						)
						(localproc_0 1 2)
					)
				)
			)
			((== param1 3)
				(cond
					((== param2 2)
						(greenGemProp
							init:
							view: 1462
							x: (greenGem x:)
							y: (greenGem y:)
							setLoop:
								(cond
									((== global301 3)
										(lightBeam setCel: 0)
										(if global300 0 else 1)
									)
									(global301 3)
									(else
										(lightBeam setCel: 1)
										2
									)
								)
							setCel: 0
							setCycle: End
						)
						(greenGem setCel: 1)
						(if (and (== global301 3) global300)
							(redGemProp setLoop: 8 setCel: 0 setCycle: End)
						)
						(localproc_0 3 2)
					)
					((== param2 1)
						(redGemProp
							init:
							view: 1462
							x: (redGem x:)
							y: (redGem y:)
							setLoop:
								(cond
									((== global301 3)
										(lightBeam setCel: 0)
										(if global300 5 else 6)
									)
									(global301 8)
									(else
										(lightBeam setCel: 1)
										7
									)
								)
							setCel: 0
							setCycle: End
						)
						(redGem setCel: 1)
						(if (and (== global301 3) global300)
							(greenGemProp setLoop: 3 setCel: 0 setCycle: End)
						)
						(localproc_0 3 1)
					)
				)
			)
			((== param1 2)
				(cond
					((== param2 1)
						(redGemProp
							init:
							view: 1462
							x: (redGem x:)
							y: (redGem y:)
							setLoop:
								(cond
									((== global301 2)
										(lightBeam setCel: 0)
										(if global300 5 else 6)
									)
									(global301 9)
									(else
										(lightBeam setCel: 1)
										7
									)
								)
							setCel: 0
							setCycle: End
						)
						(redGem setCel: 1)
						(if (and (== global301 2) global300)
							(yellowGemProp setLoop: 14 setCel: 0 setCycle: End)
						)
						(localproc_0 2 1)
					)
					((== param2 3)
						(yellowGemProp
							init:
							view: 1462
							x: (yellowGem x:)
							y: (yellowGem y:)
							setLoop:
								(cond
									((== global301 2)
										(lightBeam setCel: 0)
										(if global300 10 else 11)
									)
									(global301 14)
									(else
										(lightBeam setCel: 1)
										12
									)
								)
							setCel: 0
							setCycle: End
						)
						(yellowGem setCel: 1)
						(if (and (== global301 2) global300)
							(redGemProp setLoop: 9 setCel: 0 setCycle: End)
						)
						(localproc_0 2 3)
					)
				)
			)
		)
	)
)

(instance mySound of Sound
	(properties)
)

(instance stuckSoundManager of Code
	(properties)

	(method (doit &tmp temp0)
		(switch (= temp0 (Random 0 2))
			(0
				(mySound number: 1459 setLoop: 1 play: setVol: 50)
			)
			(1
				(mySound number: 14590 setLoop: 1 play: setVol: 50)
			)
			(2
				(mySound number: 14591 setLoop: 1 play: setVol: 50)
			)
		)
	)
)

