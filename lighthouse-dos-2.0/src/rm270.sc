;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use rm400)
(use TrackingProp)
(use Str)
(use Osc)
(use PanelPlane)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm270 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9 = 1
	local10 = 1
	local11
	[local12 2] = [0 1]
	local14
	local15 = -1
	local16 = -1
	local17 = -1
	local18 = -1
	local19 = -1
	local20 = -1
	local21 = 1
	local22
	local23
	local24
	local25
	local26 = -1
	local27 = 1
	local28 = -1
	local29
	local30 = -1
	local31 = -1
	local32
	local33
	local34
	local35 = 20
	local36 = -1
	local37 = -1
	local38 = 1
)

(instance rm270 of LightRoom
	(properties
		picture 0
	)

	(method (init)
		(super init: &rest)
		(Load rsAUDIO 9160)
		(Load rsAUDIO 808)
		(Load rsAUDIO 809)
		(Load rsAUDIO 810)
		(Load rsAUDIO 813)
		(gBackMusic number: 800 setLoop: -1 play: 0 0 fade: 127 25 10 0)
		(if (IsFlag 402)
			(trainIdle init: setLoop: -1 play: 100 0)
		)
		(switch gPrevRoomNum
			(800
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 13) doVerb: 5) ; invCompass
				)
				(SetFlag 403)
				(cond
					((== global229 9)
						(= local27 0)
						(if (== global237 1)
							(self changeScene: 990)
						else
							(self changeScene: 991)
						)
					)
					((== global237 4)
						(self changeScene: 265)
					)
					(else
						(self changeScene: 267)
					)
				)
			)
			(810
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 13) doVerb: 5) ; invCompass
				)
				(SetFlag 403)
				(= global229 4)
				(if (IsFlag 161)
					(self changeScene: 265)
				else
					(self changeScene: 264)
				)
				(gMySoundFX number: 8032 setLoop: 0 play:)
			)
			(820
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 13) doVerb: 5) ; invCompass
				)
				(SetFlag 403)
				(if (== global237 4)
					(self changeScene: 267)
				else
					(self changeScene: 265)
				)
				(gMySoundFX number: 8032 setLoop: 0 play:)
			)
			(870
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 13) doVerb: 5) ; invCompass
				)
				(SetFlag 403)
				(if (== global237 4)
					(self changeScene: 267)
				else
					(self changeScene: 265)
				)
				(gMySoundFX number: 8032 setLoop: 0 play:)
			)
			(else
				(= local27 0)
				(ClearFlag 403)
				(self changeScene: 980)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(
				(or
					(and
						(== local4 903)
						(not (gCast contains: personChanger))
						(<= 12 local5 46)
						(= global229 7)
					)
					(and
						(== local4 917)
						(not (gCast contains: personChanger))
						(<= 137 local5 199)
						(= global229 7)
					)
					(and
						(== local4 919)
						(not (gCast contains: personChanger))
						(<= 0 local5 60)
						(= global229 7)
					)
					(and
						(== local4 920)
						(<= 4 local5 50)
						(not (gCast contains: personChanger))
						(= global229 7)
					)
					(and
						(or (== local4 925) (== local4 926))
						(not (gCast contains: personChanger))
						(<= 20 local5 40)
						(= global229 7)
					)
					(and
						(or (== local4 927) (== local4 933))
						(not (gCast contains: personChanger))
						(> local5 27)
						(= global229 8)
					)
					(and
						(== local4 930)
						(not (gCast contains: personChanger))
						(<= 282 local5 330)
						(= global229 7)
					)
					(and
						(== local4 930)
						(not (gCast contains: personChanger))
						(<= 130 local5 160)
						(not (IsFlag 316))
						(= global229 8)
					)
					(== (gCurRoom scene:) 940)
				)
				(personChanger init:)
			)
			(
				(and
					(gCast contains: personChanger)
					(not (OneOf (gCurRoom scene:) 983 9830 984 9840))
					(or
						(and (== local4 903) (> local5 46))
						(and (== local4 919) (== local5 61))
						(and
							(== local4 917)
							(or (== local5 137) (== local5 200))
						)
						(and
							(or (== local4 925) (== local4 926))
							(>= 51 local5 41)
						)
						(and
							(== local4 930)
							(== global229 7)
							(or (== local5 281) (== local5 331))
						)
						(and
							(== local4 930)
							(== global229 8)
							(OneOf local5 129 161 162)
						)
						(and
							(== local4 930)
							(== global237 3)
							local8
							(> 110 local5 1)
						)
						(and (== local4 918) (or (== local5 15) (== local5 50)))
						(and (== local4 925) (< 64 local5 142))
						(and (== local4 963) (<= local5 16))
						(and
							(== local4 964)
							(or (== local5 64) (== local5 0))
							(console dispose: yourself:)
							(not (= local23 0))
							(= local8 local35)
						)
						(and (== local4 920) (or (< local5 4) (> local5 50)))
						(and (== local4 903) (<= local5 11))
						(== local4 902)
						(== local4 921)
						(== (gCurRoom scene:) 940)
					)
				)
				(personChanger dispose:)
			)
		)
	)

	(method (notify)
		(self setScript: 0)
		(personChanger setScript: 0)
		(trainBot dispose:)
	)

	(method (dispose)
		(gBackMusic number: 800 setLoop: -1 fade: 0 25 10 1)
		(if (gPanels contains: (ScriptID 271 0)) ; toolBoxPanel
			((ScriptID 271 0) dispose:) ; toolBoxPanel
		)
		(trainBot dispose:)
		(trainStartSound dispose:)
		(trainSlowDown dispose:)
		(trainSound dispose:)
		(if (trainIdle handle:)
			(SetFlag 402)
		else
			(ClearFlag 402)
		)
		(trainIdle dispose:)
		(ClearFlag 403)
		(super dispose: &rest)
	)

	(method (changeScene param1)
		(if (and local0 (not (OneOf param1 990 991 992)))
			(= local2 param1)
			(gMySoundFX number: 8032 setLoop: 0 play:)
			(local1 setCycle: Beg local1)
			(return)
		)
		(= local0 0)
		(throttle dispose:)
		(starterSwitch dispose:)
		(drillControl dispose:)
		(leftRightControl dispose:)
		(craneSwitch dispose:)
		(craneSlider dispose:)
		(powerLever dispose:)
		(leftDoor dispose:)
		(rightDoor dispose:)
		(elevatorControlFeat dispose:)
		(rotatorFeat dispose:)
		(rotatorView dispose:)
		(trainStill dispose:)
		(reverseFeature dispose:)
		(forwardFeature dispose:)
		(otherRoom dispose:)
		(console dispose:)
		(barBoxFeat dispose:)
		(switchFeat dispose:)
		(gateView dispose:)
		(craneHook dispose:)
		(drawBridge dispose:)
		(railFeat dispose:)
		(extraRailFeat dispose:)
		(railPiece dispose:)
		(boulderFeat dispose:)
		(dynamiteAddToPic dispose:)
		(myForwardExit dispose:)
		(rightDoorExit dispose:)
		(leftDoorExit dispose:)
		(toolBoxFeat dispose:)
		(vSwitchLight dispose:)
		(if (gPlanes contains: railPanel)
			(railPanel dispose:)
		)
		(if (gPlanes contains: extraRailPanel)
			(extraRailPanel dispose:)
		)
		(trainBot dispose:)
		(super changeScene: param1)
		(switch param1
			(0
				(personChanger dispose:)
			)
			(146)
			(258
				((ScriptID 1 4) newPic: 265) ; exitRight
				((ScriptID 1 3) newPic: 267) ; exitLeft
				((ScriptID 1 2) newPic: 262) ; exitBack
			)
			(259
				(powerLever init:)
				((ScriptID 1 4) newPic: 264) ; exitRight
				((ScriptID 1 3) newPic: 266) ; exitLeft
				((ScriptID 1 2) newPic: 263) ; exitBack
			)
			(260
				(SetFlag 161)
				(switch global229
					(3
						(= local9 1)
						(if (== global237 4)
							(= local10 909)
							(= local5 132)
						else
							(= local10 910)
							(= local5 0)
						)
					)
					(1
						(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
							((ScriptID 9 13) doVerb: 5) ; invCompass
						)
						(SetFlag 403)
						(personChanger init:)
						(= local9 1)
						(= local10 900)
						(= local5 170)
					)
					(2
						(switch global237
							(1
								(proc400_1 1)
								(= local10 904)
							)
							(3
								(proc400_1 5)
								(= local10 918)
							)
							(2
								(proc400_1 7)
								(= local10 901)
							)
							(4
								(proc400_1 3)
								(= local10 917)
							)
						)
						(= local5 0)
						(personChanger init:)
					)
					(4
						(if (not (IsFlag 259))
							(gateView init:)
						)
						(= local9 1)
						(= local10 900)
						(if (not local5)
							((ScriptID 1 2) newPic: 269) ; exitBack
						)
					)
					(5
						(if (IsFlag 288)
							(personChanger dispose:)
						else
							(personChanger init:)
						)
						(if (== global237 2)
							(cond
								((not (IsFlag 288))
									(if local8
										(personChanger dispose:)
									)
									(= local5 213)
									(= local10 930)
								)
								((== local9 1)
									(if local8
										(personChanger dispose:)
									)
									(= local5 216)
									(= local10 930)
								)
								(else
									(= local5 192)
									(= local10 930)
								)
							)
						else
							(if (< local5 41)
								(= local5 147)
							else
								(= local5 (determineFrame doit: 41 63 127 147))
							)
							(= local10 925)
						)
					)
					(6
						(if (== global237 2)
							(= local9 1)
							(= local5 94)
							(= local10 923)
							((ScriptID 1 2) newPic: 269) ; exitBack
						else
							(= local9 2)
							(= local5 0)
							(= local10 924)
							((ScriptID 1 2) newPic: 269) ; exitBack
						)
					)
					(7
						(switch local10
							(963
								(if local8
									(cond
										((== local9 1)
											(if (< local5 (trainBot maxFrame:))
												(= local5
													(determineFrame
														doit: 1 99 1 50
													)
												)
												(= local10 903)
											else
												(= local5 0)
												(= local10 913)
											)
										)
										(local5
											(= local5
												(determineFrame doit: 1 99 1 50)
											)
											(= local10 903)
										)
										(else
											(= local10 902)
											(= local5 146)
										)
									)
								else
									(= local5 (determineFrame doit: 1 99 1 50))
									(= local10 903)
								)
							)
							(964
								(if local8
									(cond
										((== local9 1)
											(if (< local5 (trainBot maxFrame:))
												(= local5
													(determineFrame
														doit: 7 60 4 50
													)
												)
												(= local10 920)
											else
												(= local5 0)
												(= local10 921)
											)
										)
										(local5
											(= local5
												(determineFrame doit: 7 60 4 50)
											)
											(= local10 920)
										)
										(else
											(= local10 918)
											(= local5 50)
										)
									)
								else
									(= local5 (determineFrame doit: 7 60 4 50))
									(= local10 920)
								)
							)
							(965
								(if local8
									(cond
										((== local9 1)
											(if (< local5 (trainBot maxFrame:))
												(= local5
													(determineFrame
														doit: 0 74 0 61
													)
												)
												(if (IsFlag 288)
													(= local10 926)
												else
													(= local10 925)
												)
											else
												(= local5 50)
												(if (IsFlag 288)
													(= local10 926)
												else
													(= local10 925)
												)
											)
										)
										(local5
											(= local5
												(determineFrame doit: 0 74 0 61)
											)
											(if (IsFlag 288)
												(= local10 926)
											else
												(= local10 925)
											)
										)
										(else
											(= local5 146)
											(= local10 902)
										)
									)
								else
									(= local5 (determineFrame doit: 0 74 0 61))
									(if (IsFlag 288)
										(= local10 926)
									else
										(= local10 925)
									)
								)
							)
							(966
								(if local8
									(if (== local9 1)
										(if (< local5 (trainBot maxFrame:))
											(= local5
												(determineFrame
													doit: 4 76 282 330
												)
											)
											(= local10 930)
										else
											(= local5 0)
											(= local10 921)
										)
									else
										(= local5 281)
										(= local10 930)
									)
								else
									(= local5
										(determineFrame doit: 4 76 282 330)
									)
									(= local10 930)
								)
							)
							(967
								(if local8
									(cond
										((== local9 1)
											(if (< local5 (trainBot maxFrame:))
												(= local5
													(determineFrame
														doit: 0 100 0 60
													)
												)
												(= local10 919)
											else
												(= local5 60)
												(= local10 919)
											)
										)
										(local5
											(= local5
												(determineFrame
													doit: 0 100 0 60
												)
											)
											(= local10 919)
										)
										(else
											(= local10 918)
											(= local5 50)
										)
									)
								else
									(= local5 (determineFrame doit: 0 64 0 61))
									(= local10 919)
								)
							)
							(968
								(if local8
									(if (== local9 1)
										(if (< local5 (trainBot maxFrame:))
											(= local5
												(determineFrame
													doit: 0 81 137 200
												)
											)
											(= local10 917)
										else
											(= local5 0)
											(= local10 913)
										)
									else
										(= local5
											(determineFrame doit: 0 81 137 200)
										)
										(= local10 917)
									)
								else
									(= local5
										(determineFrame doit: 0 81 137 200)
									)
									(= local10 917)
								)
							)
							(976
								(= local10 930)
								(= local5 (determineFrame doit: 0 66 178 221))
							)
						)
					)
					(8
						(if (== local10 944)
							(switch local9
								(1
									(cond
										((== local5 (trainBot maxFrame:))
											(= local5 0)
											(= local10 929)
										)
										((IsFlag 316)
											(= local5
												(determineFrame
													doit: 16 51 18 52
												)
											)
											(= local10 928)
										)
										((IsFlag 364)
											(= local10 933)
										)
										(else
											(= local5
												(determineFrame
													doit: 16 51 18 52
												)
											)
											(= local10 927)
										)
									)
								)
								(2
									(cond
										((IsFlag 316)
											(= local5
												(determineFrame
													doit: 16 51 18 53
												)
											)
											(= local10 928)
										)
										((IsFlag 364)
											(= local10 933)
										)
										(else
											(= local5
												(determineFrame
													doit: 16 51 18 53
												)
											)
											(= local10 927)
										)
									)
								)
							)
						else
							(switch local9
								(1
									(if (>= local5 60)
										(= local5 161)
									else
										(= local5
											(determineFrame doit: 21 52 130 160)
										)
									)
									(= local10 930)
								)
								(2
									(cond
										((== local5 111) 1)
										((<= local5 20)
											(= local5 111)
										)
										(else
											(= local5
												(determineFrame
													doit: 21 52 130 160
												)
											)
										)
									)
									(= local10 930)
								)
							)
						)
					)
					(10
						(switch local9
							(1
								(= local8 20)
								(= local5 31)
								(= local10 934)
								(smallThrottle setCel: (smallThrottle lastCel:))
							)
							(2
								(= local8 20)
								(= local5 117)
								(= local10 915)
								(smallThrottle setCel: 0)
							)
						)
					)
					(11
						(switch local9
							(1
								(= local8 20)
								(= local5 110)
								(= local10 934)
								(smallThrottle setCel: (smallThrottle lastCel:))
							)
							(2
								(= local8 20)
								(= local5 68)
								(= local10 915)
								(smallThrottle setCel: 0)
							)
						)
					)
					(13
						(switch global237
							(4
								(if (IsFlag 375)
									(personChanger dispose:)
									(= local5 160)
									(= local10 914)
								else
									(= local5 173)
									(= local10 934)
								)
							)
							(2
								(= local5 28)
								(= local10 915)
							)
						)
					)
					(12
						(if (== global237 4)
							(= local5 200)
							(= local10 914)
						else
							(= local5 0)
							(= local10 915)
							((ScriptID 1 2) newPic: 269) ; exitBack
						)
					)
					(9
						(rightDoor setCel: 0)
						(leftDoor setCel: 0)
						(personChanger dispose:)
						(if (== global237 1)
							(if (IsFlag 382)
								(= local10 936)
								(= local5 152)
								((ScriptID 1 2) newPic: 269) ; exitBack
							else
								(= local5 151)
								(= local10 929)
								((ScriptID 1 2) newPic: 269) ; exitBack
							)
						else
							(= local5 0)
							(= local10 930)
							((ScriptID 1 2) newPic: 269) ; exitBack
						)
					)
				)
				(if (not (gCast contains: gateView))
					(getRobot doit:)
				)
				(= local4 (trainBot number:))
				(= local6 (trainBot x:))
				(= local7 (trainBot y:))
				(if (or (== global229 10) (== global229 11))
					(trainBot start: local9 local8)
				)
				(cond
					((and (<= 0 (smallThrottle cel:) 6) local8 (== local9 2))
						(throttle init: setCel: 0)
					)
					((and (<= 8 (smallThrottle cel:) 14) local8 (== local9 1))
						(throttle init: setCel: 14)
					)
					(else
						(throttle init: setCel: 7)
					)
				)
				(starterSwitch init:)
				(drillControl init:)
				(leftRightControl init:)
				(craneSwitch init:)
				(craneSlider init:)
				(reverseFeature init:)
				(forwardFeature init:)
				(vSwitchLight init:)
			)
			(261
				(if (== global229 4)
					(gateView init:)
				)
				((ScriptID 1 2) newPic: 268) ; exitBack
				(throttle init:)
				(starterSwitch init:)
				(drillControl init:)
				(leftRightControl init:)
				(craneSwitch init:)
				(craneSlider init:)
			)
			(262
				(gateView init:)
				((ScriptID 1 3) newPic: 265) ; exitLeft
				((ScriptID 1 4) newPic: 267) ; exitRight
				((ScriptID 1 2) newPic: 258) ; exitBack
				((ScriptID 1 1) newPic: 260) ; exitForward
			)
			(263
				(if (== global229 4)
					(gateView init:)
				)
				((ScriptID 1 3) newPic: 264) ; exitLeft
				((ScriptID 1 4) newPic: 266) ; exitRight
				((ScriptID 1 2) newPic: 259) ; exitBack
				((ScriptID 1 1) newPic: 261) ; exitForward
			)
			(264
				(leftDoor init:)
				(otherRoom init:)
				((ScriptID 1 3) newPic: 259) ; exitLeft
				((ScriptID 1 4) newPic: 263) ; exitRight
				((ScriptID 1 2) newPic: 266) ; exitBack
			)
			(265
				(leftDoor init:)
				(if global229
					(otherRoom init:)
				)
				((ScriptID 1 3) newPic: 258) ; exitLeft
				((ScriptID 1 4) newPic: 262) ; exitRight
				((ScriptID 1 2) newPic: 267) ; exitBack
			)
			(266
				(rightDoor init:)
				(if global229
					(otherRoom init:)
				)
				((ScriptID 1 4) newPic: 259) ; exitRight
				((ScriptID 1 3) newPic: 263) ; exitLeft
				((ScriptID 1 2) newPic: 264) ; exitBack
			)
			(267
				(rightDoor init:)
				(if global229
					(otherRoom init:)
				)
				((ScriptID 1 4) newPic: 258) ; exitRight
				((ScriptID 1 3) newPic: 262) ; exitLeft
				((ScriptID 1 2) newPic: 265) ; exitBack
			)
			(268
				((ScriptID 1 2) newPic: 261) ; exitBack
				((ScriptID 1 1) newPic: 259) ; exitForward
				(rightDoorExit newPic: 266)
				(leftDoorExit newPic: 264)
			)
			(269
				((ScriptID 1 2) newPic: 260) ; exitBack
				((ScriptID 1 1) newPic: 258) ; exitForward
				(rightDoorExit newPic: 267)
				(leftDoorExit newPic: 265)
			)
			(940
				(gBackMusic2 number: 8002 setLoop: -1 play: 0 0 fade: 127 25 10 0)
				(proc400_1 7)
				(ClearFlag 403)
				((ScriptID 1 3) newPic: 942) ; exitLeft
				(if (or (IsFlag 364) (IsFlag 316))
					(railPiece init:)
				)
				(railFeat init:)
				(console init:)
				(switch local10
					(927
						(= local5 (determineFrame doit: 18 54 16 51))
						(= local10 944)
						(trainBot init: 944 local5 0 0 2)
						(if local8
							(trainBot start: local9 20)
							(if (== local9 1)
								(smallThrottle setCel: (smallThrottle lastCel:))
							else
								(smallThrottle setCel: 0)
							)
						)
					)
					(930
						(= local5 (determineFrame doit: 130 160 21 52))
						(= local10 947)
						(trainBot init: 947 local5 0 0 2)
						(if local8
							(trainBot start: local9 local8)
							(if (== local9 1)
								(smallThrottle setCel: (smallThrottle lastCel:))
							else
								(smallThrottle setCel: 0)
							)
						)
					)
					(933
						(= local5 (determineFrame doit: 18 54 16 51))
						(= local10 944)
						(trainBot init: 944 local5 0 0 2)
						(if local8
							(trainBot start: local9 20)
							(if (== local9 1)
								(smallThrottle setCel: (smallThrottle lastCel:))
							else
								(smallThrottle setCel: 0)
							)
						)
					)
					(947
						(determineFrame doit: 130 160 21 61)
						(trainBot init: 947 local5 0 0 2)
					)
					(else
						(= local10 944)
						(determineFrame doit: 18 54 16 51)
						(trainBot init: 944 local5 0 0 2)
						(if local8
							(trainBot start: local9 20)
							(if (== local9 1)
								(smallThrottle setCel: (smallThrottle lastCel:))
							else
								(smallThrottle setCel: 0)
							)
						)
					)
				)
				(= local4 (trainBot number:))
				(= local5 (trainBot curFrame:))
				(= local6 (trainBot x:))
				(= local7 (trainBot y:))
			)
			(942
				(proc400_1 3)
				(ClearFlag 403)
				((ScriptID 1 4) newPic: 940) ; exitRight
				(extraRailFeat init:)
			)
			(951
				(gBackMusic2 number: 8005 setLoop: -1 play: 0 0 fade: 127 25 10 0)
				(personChanger init:)
				(toolBoxFeat init:)
				(if (IsFlag 414)
					(dynamiteAddToPic init:)
				else
					(boulderFeat init:)
				)
			)
			(953
				(personChanger init:)
			)
			(954
				(gBackMusic2 number: 8005 setLoop: -1 play: 0 0 fade: 127 25 10 0)
				(personChanger init:)
				(toolBoxFeat init:)
				(if (IsFlag 414)
					(dynamiteAddToPic init:)
				else
					(boulderFeat init:)
				)
			)
			(960
				(gBackMusic2 number: 8201 setLoop: -1 play: 0 0 fade: 127 25 10 0)
				(proc400_1 3)
				(ClearFlag 403)
				(barBoxFeat init:)
				(if (not (IsFlag 319))
					(switchFeat init:)
				)
				(console init:)
				(switch local10
					(903
						(= local5 (determineFrame doit: 0 50 0 90))
						(trainBot init: 963 local5 0 0 1)
						(if local8
							(trainBot start: local9 local8)
						)
						(= local10 963)
					)
					(917
						(= local5 (determineFrame doit: 137 200 0 81))
						(trainBot init: 968 local5 0 0 1)
						(if local8
							(trainBot start: local9 local8)
						)
						(= local10 968)
					)
					(919
						(= local5 (determineFrame doit: 0 60 0 100))
						(trainBot init: 967 local5 0 0 1)
						(if local8
							(trainBot start: local9 local8)
						)
						(= local10 967)
					)
					(920
						(= local5 (determineFrame doit: 4 50 7 60))
						(trainBot init: 964 local5 0 0 1)
						(if local8
							(trainBot start: local9 local8)
						)
						(= local10 964)
					)
					(925
						(= local5 (determineFrame doit: 0 61 0 74))
						(trainBot init: 965 local5 0 0 -1)
						(if local8
							(trainBot start: local9 local8)
						)
						(= local10 965)
					)
					(926
						(= local5 (determineFrame doit: 0 61 0 74))
						(trainBot init: 965 local5 0 0 -1)
						(if local8
							(trainBot start: local9 local8)
						)
						(= local10 965)
					)
					(930
						(= local5 (determineFrame doit: 282 330 4 76))
						(trainBot init: 966 local5 0 0 -1)
						(if local8
							(trainBot start: local9 local8)
						)
						(determineFrame doit: 4 76 1 1)
						(= local10 966)
					)
				)
				(= local4 (trainBot number:))
				(= local5 (trainBot curFrame:))
				(= local6 (trainBot x:))
				(= local7 (trainBot y:))
			)
			(970
				(gBackMusic2 number: 8101 setLoop: -1 play: 0 0 fade: 127 25 10 0)
				(proc400_1 8)
				(ClearFlag 403)
				(drawBridge init:)
				(cond
					((and (== global237 2) (not (IsFlag 288)))
						(craneHook init:)
						(= local10 972)
					)
					((and (== global237 4) (not (IsFlag 288)))
						(= local10 971)
						(= local5 (determineFrame doit: 127 147 41 63))
						(trainBot init: 971 local5 0 0 1)
					)
				)
				(switch local10
					(972
						(trainBot init: 972 0 0 0 1)
					)
					(976
						(trainBot init: 976 local5 0 0 3)
					)
				)
				(console init:)
				(personChanger init:)
			)
			(980
				(proc400_1 3)
				(ClearFlag 403)
				(= global229 1)
				(elevatorControlFeat init:)
				(rotatorFeat init:)
				(personChanger init:)
			)
			(983
				(if (not (gBackMusic2 handle:))
					(gBackMusic2
						number: 8101
						setLoop: -1
						play: 0 0
						fade: 127 25 10 0
					)
				)
				(if (OneOf global237 1 3)
					(trainStill init:)
				)
				(proc400_1 1)
				(ClearFlag 403)
				((ScriptID 1 2) newPic: 984 5) ; exitBack
				((ScriptID 1 4) newPic: 9830 7) ; exitRight
				((ScriptID 1 3) newPic: 9840 3) ; exitLeft
				(elevatorControlFeat init:)
				(if (== scene global233)
					(rotatorView init:)
				)
				(personChanger init:)
			)
			(9830
				(if (not (gBackMusic2 handle:))
					(gBackMusic2
						number: 8101
						setLoop: -1
						play: 0 0
						fade: 127 25 10 0
					)
				)
				(if (OneOf global237 2 4)
					(trainStill init:)
				)
				(proc400_1 7)
				(ClearFlag 403)
				((ScriptID 1 2) newPic: 9840 3) ; exitBack
				((ScriptID 1 4) newPic: 984 5) ; exitRight
				((ScriptID 1 3) newPic: 983 1) ; exitLeft
				(if (== scene global233)
					(rotatorView init:)
				)
				(= local27 0)
				(personChanger init:)
			)
			(984
				(if (not (gBackMusic2 handle:))
					(gBackMusic2
						number: 8101
						setLoop: -1
						play: 0 0
						fade: 127 25 10 0
					)
				)
				(if (OneOf global237 1 3)
					(trainStill init:)
				)
				(proc400_1 5)
				(ClearFlag 403)
				((ScriptID 1 2) newPic: 983 1) ; exitBack
				((ScriptID 1 3) newPic: 9830 7) ; exitLeft
				((ScriptID 1 4) newPic: 9840 3) ; exitRight
				(if (== scene global233)
					(rotatorView init:)
				)
				(personChanger init:)
			)
			(9840
				(if (not (gBackMusic2 handle:))
					(gBackMusic2
						number: 8101
						setLoop: -1
						play: 0 0
						fade: 127 25 10 0
					)
				)
				(if (OneOf global237 2 4)
					(trainStill init:)
				)
				(proc400_1 3)
				(ClearFlag 403)
				((ScriptID 1 2) newPic: 9830 7) ; exitBack
				((ScriptID 1 4) newPic: 983 1) ; exitRight
				((ScriptID 1 3) newPic: 984 5) ; exitLeft
				(if (== scene global233)
					(rotatorView init:)
				)
				(personChanger init:)
			)
			(990
				(if (not (gBackMusic2 handle:))
					(gBackMusic2
						number: 8101
						setLoop: -1
						play: 0 0
						fade: 127 25 10 0
					)
				)
				(toolBoxFeat init:)
				(myForwardExit newRoom: 800)
				(= local27 0)
				(personChanger init:)
			)
			(991
				(if (not (gBackMusic2 handle:))
					(gBackMusic2
						number: 8101
						setLoop: -1
						play: 0 0
						fade: 127 25 10 0
					)
				)
				(toolBoxFeat init:)
				(myForwardExit newRoom: 800)
				(= local27 0)
				(personChanger init:)
			)
			(992
				(if (not (gBackMusic2 handle:))
					(gBackMusic2
						number: 8101
						setLoop: -1
						play: 0 0
						fade: 127 25 10 0
					)
				)
				(= local27 0)
				(personChanger init:)
			)
		)
		(if (and (gCast contains: personChanger) (personChanger approachX:))
			(if (not global105)
				(= global105 (Set new:))
			)
			(global105 add: (personChanger approachX:))
		)
	)
)

(instance lowerBridge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(smallCraneSlider setCel: 0)
				(craneHook setCycle: End self)
				(gMySoundFX number: 826 setLoop: 0 play:)
			)
			(1
				(trainBot dispose:)
				(drawBridge dispose:)
				(craneHook dispose:)
				(KillRobot 974 0 0 0 -1 1)
				(= local32 0)
			)
			(2
				(SetFlag 288)
				(= local5 37)
				(= local10 976)
				(= seconds 2)
			)
			(3
				(= local27 1)
				(= global237 2)
				(= local9 1)
				(DoRobot)
				(gCurRoom changeScene: 260)
				(= global229 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showWreck of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gPanels contains: (ScriptID 9 4)) ; InvInset
					((ScriptID 9 4) dispose:) ; InvInset
				)
				(gInventory disable: 1)
				(gBackMusic stop:)
				(gBackMusic2 stop:)
				(cond
					((== local9 2)
						(if (IsFlag 364)
							(PlayVMD 0 {944.vmd} 1024) ; Open
						else
							(PlayVMD 0 {946.vmd} 1024) ; Open
						)
					)
					((IsFlag 364)
						(PlayVMD 0 {943.vmd} 1024) ; Open
					)
					(else
						(PlayVMD 0 {945.vmd} 1024) ; Open
					)
				)
				(PlayVMD 23 0 199) ; RestrictPalette
				(PlayVMD 1 70 75 272 5 0 199) ; Put
				(PlayVMD 14 7) ; WaitEvent
				(trainBot dispose:)
				(gCurRoom changeScene: 0)
				(PlayVMD 6) ; Close
				(= ticks 1)
			)
			(1
				(SetFlag 398)
				(gInventory disable: 0)
				(if (IsFlag 394)
					((ScriptID 19 0) seconds: 0) ; BombTimer
				else
					(gGame getDisc: 1)
					(gCurRoom newRoom: 380)
				)
			)
		)
	)
)

(instance darkBeingRuns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(trainSound play: 60 0)
				(gCurRoom changeScene: 146)
				(KillRobot 146 0 0)
			)
			(1
				(DoRobot)
				(= global229 10)
				(SetFlag 372)
				(gCurRoom changeScene: 260)
				(trainSound play: 100 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance seeBouldersDrop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(trainSound play: 60 0)
				(gCurRoom changeScene: 147)
				(KillRobot 147 0 0)
			)
			(1
				(DoRobot)
				(WalkieTalkie killRobot: 0)
				(= global229 11)
				(gCurRoom changeScene: 260)
				(trainSound play: 100 0)
				(SetFlag 376)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance elevControlPanel of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(self setBitmap: 981 0 0)
		(elevLever init: self 1 1)
		(global105 delete: (bitmap approachX:))
	)
)

(instance rotatorPanel of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(self setBitmap: 985 0 0)
		(rotateDrop init: self 1 1)
		(global105 delete: (bitmap approachX:))
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				(rotateDrop cel:)
			)
			(event claimed: 1)
			(gGame handsOff:)
			(rotateLever dispose: self 1 1)
			(rotateDrop setCycle: Beg self)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (cue)
		(if (rotateDrop cycler:)
			(rotateDrop setCycle: 0)
		)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (dispose)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance boxPanel of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(if (IsFlag 321)
			(self setBitmap: 962 0 1)
			((bitmap approachX:) hotVerbs: 0)
		else
			(self setBitmap: 962 0 0)
			((bitmap approachX:) insetMember: 1 hotVerbs: 5)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(not (IsFlag 321))
			)
			(global106 disposeArrow:)
			(= global106 0)
			((bitmap approachX:) hotVerbs: 0)
			(gInventory addItem: (ScriptID 9 79)) ; invHexBar
			(self setBitmap: 962 0 1)
			(SetFlag 321)
		)
		(super handleEvent: event &rest)
	)
)

(instance switchPanel of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(self setBitmap: 961 0 0)
		(if (IsFlag 322)
			(switchProp init: self 1 1 setCel: 10)
		)
		(cond
			((and (IsFlag 322) (IsFlag 319))
				((bitmap approachX:) insetMember: 1 hotVerbs: 5)
			)
			((IsFlag 322)
				((bitmap approachX:) insetMember: 1 hotVerbs: 90)
			)
			(else
				((bitmap approachX:) insetMember: 1 hotVerbs: 87)
			)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(self onMe: event)
					(& (event type:) evMOUSEBUTTON)
					(== (gUser curVerb:) 87)
				)
				(global106 disposeArrow:)
				(= global106 0)
				((bitmap approachX:) hotVerbs: 90)
				(SetFlag 322)
				(gInventory deleteItem: (ScriptID 9 79)) ; invHexBar
				(switchProp init: self 1 1 setCycle: CT 10 1)
				(event claimed: 1)
			)
			(
				(and
					(self onMe: event)
					(& (event type:) evMOUSEBUTTON)
					(== (gUser curVerb:) 90)
					(IsFlag 322)
				)
				(global106 disposeArrow:)
				(= global106 0)
				((bitmap approachX:) hotVerbs: 5)
				(SetFlag 319)
				(switchProp init: self 1 1 setCycle: End switchProp)
				(switchFeat dispose:)
				(event claimed: 1)
			)
		)
		(super handleEvent: event &rest)
	)
)

(instance railPanel of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(cond
			((IsFlag 316)
				(self setBitmap: 941 0 2)
				(global105 delete: (bitmap approachX:))
			)
			((IsFlag 365)
				(self setBitmap: 941 0 1)
				(if (not (IsFlag 364))
					(railProp init: self 1 1 setCel: (railProp lastCel:))
					(global105 delete: (bitmap approachX:))
				else
					((bitmap approachX:) insetMember: 1 hotVerbs: 92)
					(global105 delete: (bitmap approachX:))
					(global105 addToFront: (bitmap approachX:))
				)
			)
			(else
				(railNailFeat init: self 1 1)
				(self setBitmap: 941 0 0)
				(global105 delete: (bitmap approachX:))
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(IsFlag 364)
				(not (IsFlag 316))
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(== (gUser curVerb:) 92)
			)
			(global106 disposeArrow:)
			(= global106 0)
			((bitmap approachX:) hotVerbs: 0)
			(self setBitmap: 941 0 2)
			(gMySoundFX number: 946 setLoop: 0 play:)
			(SetFlag 316)
			(gInventory deleteItem: (ScriptID 9 81)) ; invPliers
			(ClearFlag 325)
			(railPiece init: setCel: 0)
			(gInventory deleteItem: (ScriptID 9 84)) ; invRail
			(event claimed: 1)
		)
		(super handleEvent: event &rest)
	)
)

(instance extraRailPanel of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(cond
			((IsFlag 366)
				(self setBitmap: 943 0 2)
			)
			((IsFlag 367)
				(self setBitmap: 943 0 1)
				(extraRailProp init: self 1 1 setCel: (extraRailProp lastCel:))
			)
			(else
				(extraRailNailFeat init: self 1 1)
				(self setBitmap: 943 0 0)
			)
		)
		(global105 delete: (bitmap approachX:))
	)

	(method (handleEvent event)
		(super handleEvent: event &rest)
	)
)

(instance railProp of PanelProp
	(properties
		loop 1
		view 941
	)

	(method (init)
		(self setPri: 900)
		(cond
			((IsFlag 364) 1)
			((IsFlag 365)
				(self view: 941 setCel: (self lastCel:) setLoop: 1)
			)
			(else
				(self view: 941 setCel: 0 setLoop: 1)
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((== cel 7)
				(gMySoundFX number: 911 setLoop: 0 play:)
			)
			((== cel 12)
				(gMySoundFX number: 912 setLoop: 0 play:)
			)
		)
	)

	(method (cue)
		(super cue: &rest)
		(gGame handsOn:)
		(if (not (IsFlag 365))
			(SetFlag 365)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 365)
					(gMySoundFX number: 945 setLoop: 0 play:)
					(SetFlag 364)
					(railPanel setBitmap: 941 0 1)
					(self dispose: railPanel 1 1)
					(railPiece init: setCel: 1)
				)
			)
		)
	)
)

(instance extraRailProp of PanelProp
	(properties
		loop 1
		view 943
	)

	(method (init)
		(self setPri: 900)
		(cond
			((IsFlag 366) 1)
			((IsFlag 367)
				(self view: 943 setCel: (self lastCel:) setLoop: 1)
			)
			(else
				(self view: 943 setCel: 0 setLoop: 1)
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((== cel 9)
				(gMySoundFX number: 911 setLoop: 0 play:)
			)
			((== cel 13)
				(gMySoundFX number: 912 setLoop: 0 play:)
			)
		)
	)

	(method (cue)
		(super cue: &rest)
		(gGame handsOn:)
		(if (not (IsFlag 367))
			(SetFlag 367)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 367)
					(gMySoundFX number: 946 setLoop: 0 play:)
					(gInventory addItem: (ScriptID 9 84)) ; invRail
					(SetFlag 366)
					(extraRailPanel setBitmap: 943 0 2)
					(self dispose: extraRailPanel 1 1)
				)
			)
		)
	)
)

(instance elevLever of PanelProp
	(properties
		x 90
		y 68
		loop 1
		view 981
	)

	(method (doit)
		(super doit: &rest)
		(if (OneOf cel 1 3 5 7 9)
			(gMySoundFX number: 828 setLoop: 0 play:)
		)
	)

	(method (cue)
		(elevControlPanel dispose:)
		(cond
			((== global229 1)
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(PlayVMD 0 {982.vmd} 1024) ; Open
				(PlayVMD 23 0 199) ; RestrictPalette
				(PlayVMD 1 70 75 272 5 0 199) ; Put
				(PlayVMD 14 7) ; WaitEvent
				(= global237 2)
				(= global229 2)
				(= global233 983)
				(= local28 9830)
				(= local5 0)
				(gCurRoom changeScene: 9830 7)
				(PlayVMD 6) ; Close
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) show:) ; PlCompass
				)
			)
			((== global237 2)
				(= global229 1)
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(PlayVMD 0 {981.vmd} 1024) ; Open
				(PlayVMD 23 0 199) ; RestrictPalette
				(PlayVMD 1 70 75 272 5 0 199) ; Put
				(PlayVMD 14 7) ; WaitEvent
				(gCurRoom changeScene: 980)
				(PlayVMD 6) ; Close
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) show:) ; PlCompass
				)
				(= global229 1)
			)
		)
		(gGame handsOn:)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(self setCycle: Osc 1 self)
			)
		)
	)
)

(instance rotateDrop of PanelProp
	(properties
		x 71
		y 1
		loop 1
		view 985
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self setCycle: End self)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (== cel 4) (not (gMySoundFX handle:)))
			(gMySoundFX number: 909 setLoop: 0 play:)
		)
	)

	(method (cue)
		(rotateLever
			init: rotatorPanel 1 1
			setPri: 900
			setPoints:
				28
				-26
				31
				-24
				39
				-20
				44
				-16
				52
				-5
				53
				12
				41
				32
				30
				41
				-4
				49
				-19
				49
				-47
				43
				-55
				38
				-62
				22
				-63
				13
				-61
				6
				-52
				-7
				-46
				-14
				-32
				-22
				-17
				-28
				-10
				-30
				7
				-31
				13
				-29
		)
	)
)

(instance rotateLever of TrackingProp
	(properties
		x 75
		y 148
		loop 2
		view 985
		oneWay 1
	)

	(method (init param1 param2 param3)
		(= local3 0)
		(&= signal $fff7)
		(((param1 casts:) at: 0) add: self)
		(= plane param1)
		(AddScreenItem self)
		(= useInsetRect 0)
		(SetNowSeen self)
		(if (and (> argc 1) param2)
			(param1 addToDoits: self)
		)
		(if (and (> argc 2) param3)
			(param1 addToEvents: self)
		)
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		)
		(if code
			(code doit: self)
		)
		(if (and (& signal $0001) cycler cel)
			(if (not (gMySoundFX handle:))
				(gMySoundFX number: 910 setLoop: 0 play:)
			)
			(cycler doit:)
		)
		(super doit:)
	)

	(method (cue)
		(super cue: &rest)
		(if (== cel (self lastCel:))
			(self setCel: 0)
		)
		(cond
			((and (== global229 2) local3 (IsFlag 273))
				(gPlanes delete: (ScriptID 9 1)) ; PlInterface
				(rotateTrain doit:)
			)
			((== global229 1)
				(gGame handsOn:)
			)
		)
	)

	(method (setCel param1)
		(if (and tracking (== param1 0))
			(++ local3)
		)
		(gMySoundFX number: 910 setLoop: 0 play:)
		(super setCel: param1)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((and tracking (& (event type:) evMOUSERELEASE))
				(= tracking 0)
				(global206 delete: self)
				(self doMouseUp:)
				(if (<= cel 10)
					(self setCycle: CT 0 -1 self)
				else
					(++ local3)
					(gGame handsOff:)
					(self setCycle: CT 21 1 self)
				)
				(event claimed: 1)
				(return)
			)
			((and (self onMe: event) locked)
				(return)
			)
			((and (self onMe: event) (not tracking) (& (event type:) evMOUSEBUTTON))
				(if cycler
					(cycler dispose:)
					(= cycler 0)
				)
				(global206 add: self)
				(= tracking 1)
				(= cycles delay)
				(event claimed: 1)
				(return)
			)
			(tracking
				(if
					(and
						(!= (= temp0 (self findClosest: event)) -1)
						(!= cel temp0)
					)
					(self nextCel: temp0)
				)
				(event claimed:)
				(return)
			)
		)
	)

	(method (dispose param1 param2 param3)
		(if (and (> argc 1) param2)
			(param1 addToDoits: self 0)
		)
		(if (and (> argc 2) param3)
			(param1 addToEvents: self 0)
		)
		(super dispose: &rest)
	)
)

(instance switchProp of PanelProp
	(properties
		cel 1
		view 961
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100)
	)

	(method (cue)
		(gInventory deleteItem: (ScriptID 9 82)) ; invWrench
		(ClearFlag 324)
		(switchPanel dispose:)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((== cel 8)
				(gMySoundFX number: 913 setLoop: 0 play:)
			)
			((== cel 15)
				(gMySoundFX number: 914 setLoop: 0 play:)
			)
			((OneOf cel 20 26)
				(gMySoundFX number: 915 setLoop: 0 play:)
			)
		)
	)
)

(instance throttle of Prop
	(properties
		x 313
		y 293
		cel 7
		view 270
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 161)
			(self view: 270)
		else
			(self view: 271 posn: 319 299)
		)
		(self setPri: 600)
		(approachX hotVerbs: 0)
	)
)

(instance starterSwitch of Prop
	(properties
		x 282
		y 263
		loop 1
		view 270
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 161)
			(self view: 270)
		else
			(self view: 271 posn: 283 263)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((IsFlag 323)
						(gMySoundFX number: 811 setLoop: 0 play: 100 0)
						(trainIdle stop:)
						(trainSound stop:)
						(trainStartSound stop:)
						(trainSlowDown stop:)
						(ClearFlag 323)
						(if local8
							(trainSound stop:)
							(trainStartSound stop:)
							(trainSlowDown stop:)
							(trainIdle stop:)
							(if (throttle cel:)
								(throttle setCycle: CT 7 -1)
							else
								(throttle setCycle: CT 7 1)
							)
							(= local22 0)
							(= local23 1)
						)
						(gBackMusic number: 800 setLoop: -1 fade: 127 25 10 0)
					)
					((IsFlag 161)
						(SetFlag 323)
						(gMySoundFX number: 807 setLoop: 0 play: 100 trainIdle)
						(gBackMusic number: 800 setLoop: -1 fade: 0 25 10 0)
					)
				)
				(if cel
					(self setCycle: Beg)
				else
					(self setCycle: End)
				)
			)
		)
	)
)

(instance drillControl of Prop
	(properties
		x 241
		y 216
		loop 2
		view 270
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 161)
			(self view: 270)
		else
			(self view: 271 posn: 242 216)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (not (IsFlag 382)) (== global229 9) (== global237 1))
					(gGame handsOff:)
					(self setCycle: Osc 1 self)
				)
			)
		)
	)

	(method (cue)
		(gGlobalVMD number: 993 stretch: 1 dir: 1 myBlackLines: 1 init: play:)
		(= local10 936)
		(= local5 152)
		(SetFlag 382)
		(getRobot doit:)
		(personChanger init:)
		(gGlobalVMD myBlackLines: 0 close:)
		(gGame handsOn:)
	)
)

(instance leftRightControl of Prop
	(properties
		x 135
		y 299
		loop 3
		view 270
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 161)
			(self view: 270 setLoop: 3)
		else
			(self view: 271 setLoop: 4 posn: 132 299)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(5 ; Do
					(if local24
						(switch local10
							(902
								(switch local9
									(1
										(= local19 1)
									)
									(2
										(= local18 1)
									)
								)
							)
							(904
								(switch local9
									(1
										(= local15 1)
									)
									(2
										(return 0)
									)
								)
							)
							(905
								(switch local9
									(1
										(= local16 1)
									)
									(2
										(return 0)
									)
								)
							)
							(906
								(switch local9
									(1
										(= local17 1)
									)
									(2
										(return 0)
									)
								)
							)
							(911
								(switch local9
									(1
										(return 0)
									)
									(2
										(= local17 1)
									)
								)
							)
							(913
								(switch local9
									(1
										(return 0)
									)
									(2
										(= local20 1)
									)
								)
							)
							(916
								(switch local9
									(1
										(return 0)
									)
									(2
										(= local15 1)
									)
								)
							)
							(918
								(switch local9
									(1
										(= local20 1)
									)
									(2
										(return 0)
									)
								)
							)
							(921
								(switch local9
									(1
										(= local18 1)
									)
									(2
										(= local19 1)
									)
								)
							)
							(931
								(switch local9
									(1
										(return 0)
									)
									(2
										(= local17 1)
									)
								)
							)
						)
						(= local25 1)
						(leftRightSwitchSound number: 9160 setLoop: 0 play:)
						(self setCycle: Osc 1)
						(= local24 0)
					else
						(leftRightSwitchSound number: 910 setLoop: 0 play:)
					)
				)
			)
		)
	)
)

(instance craneSwitch of Prop
	(properties
		x 122
		y 230
		loop 4
		view 270
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 161)
			(self view: 270 setLoop: 4)
		else
			(self view: 271 setLoop: 5 posn: 128 225)
		)
		(approachX hotVerbs: 5)
	)
)

(instance craneSlider of Prop
	(properties
		x 130
		y 221
		loop 5
		view 270
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 161)
			(self view: 270 setLoop: 5)
		else
			(self view: 271 setLoop: 6 posn: 125 220)
		)
		(approachX hotVerbs: 5)
	)
)

(instance powerLever of Prop
	(properties
		x 300
		y 299
		view 272
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(approachX hotVerbs: 5)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (self cycler:) (== cel 0))
				(gMySoundFX number: 802 setLoop: 0 play:)
			)
			((== cel 14)
				(gMySoundFX number: 832 setLoop: 0 play:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(self setCycle: End self)
			)
		)
	)

	(method (cue)
		(super cue: &rest)
		(SetFlag 161)
		(gGame handsOn:)
		(gCurRoom changeScene: 258)
	)
)

(instance leftDoor of Prop
	(properties
		x 196
		y 207
		view 273
	)

	(method (init)
		(if (IsFlag 161)
			(self view: 273 posn: 196 207)
		else
			(self view: 274 posn: 172 202)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(super cue:)
		(= local0 0)
		(gCurRoom changeScene: local2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if cel
					(gMySoundFX number: 8032 setLoop: 0 play:)
					(= local0 0)
					(self setCycle: Beg)
					((ScriptID 1 1) dispose:) ; exitForward
				else
					(gMySoundFX number: 8031 setLoop: 0 play:)
					(= local0 1)
					(= local1 (self setCycle: End otherRoom yourself:))
				)
			)
		)
	)
)

(instance rightDoor of Prop
	(properties
		x 230
		y 194
		view 275
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 161))
			(self view: 275 posn: 230 194 setCel: 0)
		else
			(self view: 276 posn: 218 199 setCel: 0)
		)
		(approachX hotVerbs: 5)
	)

	(method (cue)
		(super cue:)
		(= local0 0)
		(gCurRoom changeScene: local2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if cel
					(gMySoundFX number: 8032 setLoop: 0 play:)
					(= local0 0)
					(self setCycle: Beg)
					((ScriptID 1 1) dispose:) ; exitForward
				else
					(gMySoundFX number: 8031 setLoop: 0 play:)
					(= local0 1)
					(= local1 (self setCycle: End otherRoom yourself:))
				)
			)
		)
	)
)

(instance personChanger of Prop
	(properties
		x 4
		y 257
		view 279
	)

	(method (doit &tmp temp0)
		(if (and (& -info- $0008) (self isNotHidden:))
			(UpdateScreenItem self)
		)
		(if script
			(script doit:)
		)
		(if code
			(code doit: self)
		)
		(if (& signal $0001)
			(if cycler
				(cycler doit:)
			)
			(if scaler
				(scaler doit:)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(5 ; Do
				(while ((= temp0 (Event new:)) type:)
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(if (not (and local23 local22 (self script:)))
					(if (trainBot cycler:)
						(if (<= local36 local5 local37)
							(self setScript: (ScriptID 0 3) self) ; sDepress
						)
					else
						(self setScript: (ScriptID 0 3) self) ; sDepress
					)
				)
			)
		)
	)

	(method (cue)
		(if (trainIdle handle:)
			(trainIdle play: 60 0)
		)
		(if (trainSound handle:)
			(trainSound play: 60 0)
		)
		(if local27
			(= local27 0)
			(if (trainIdle handle:)
				(trainIdle play: 60 0)
			)
			(switch global229
				(1
					(gCurRoom changeScene: 980)
				)
				(2
					(if (> local5 5)
						(= local5 (trainBot maxFrame:))
					else
						(= local5 0)
					)
					(gCurRoom changeScene: local28)
				)
				(5
					(gCurRoom changeScene: 970)
				)
				(7
					(gCurRoom changeScene: 960)
				)
				(8
					(gCurRoom changeScene: 940)
				)
				(13
					(if (== local10 915)
						(gCurRoom changeScene: 951)
					else
						(gCurRoom changeScene: 954)
					)
				)
				(9
					(cond
						((== global237 1)
							(gCurRoom changeScene: 990)
						)
						((IsFlag 382)
							(gCurRoom changeScene: 991)
						)
						(else
							(gCurRoom changeScene: 992)
						)
					)
				)
				(14
					(gCurRoom changeScene: 953)
				)
			)
		else
			(if (trainIdle handle:)
				(trainIdle play: 100 0)
			)
			(if (trainSound handle:)
				(trainSound play: 100 0)
			)
			(= local27 1)
			(if (== global229 2)
				(= local28 (gCurRoom scene:))
			)
			(< local28 1)
			(gBackMusic2 fade: 0 25 10 1)
			(gCurRoom changeScene: 260)
			(if local8
				(trainBot start: local9 local8)
			)
		)
		(super cue: &rest)
	)
)

(instance smallThrottle of Prop
	(properties
		loop 4
		cel 7
		view 280
	)

	(method (init)
		(super init: &rest)
		(self
			posn: (+ (console x:) 109) (console y:)
			setPri: (+ (console priority:) 1)
			setCel: (throttle cel:)
		)
	)
)

(instance smallCraneSlider of TrackingProp
	(properties
		loop 1
		view 280
		wrap 0
	)

	(method (init)
		(super init: &rest)
		(self
			posn: (+ (console x:) 11) (- (console y:) 56)
			setPri: (+ (console priority:) 1)
		)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (cue)
		(gMySoundFX stop:)
		(super cue: &rest)
	)

	(method (doMouseUp)
		(gMySoundFX stop:)
		(super doMouseUp: &rest)
	)

	(method (nextCel param1 &tmp [temp0 4])
		(if (and local32 (== local4 972) (not local5))
			(if (< param1 cel)
				(if local33
					(gCurRoom setScript: lowerBridge)
					(return)
				)
				(self setCel: (- cel 1))
				(if (not (gMySoundFX handle:))
					(gMySoundFX number: 874 setLoop: -1 play:)
				)
				(craneHook setCycle: CT (+ cel 1) -1 self)
			else
				(self setCel: (+ cel 1))
				(if (== cel 10)
					(= local33 1)
				)
				(if (not (gMySoundFX handle:))
					(gMySoundFX number: 874 setLoop: -1 play:)
				)
				(craneHook setCycle: CT (+ cel 1) 1 self)
			)
			(UpdateScreenItem self)
		)
	)
)

(instance smallCraneSwitch of Prop
	(properties
		loop 2
		view 280
	)

	(method (init)
		(super init: &rest)
		(self
			posn: (+ (console x:) 16) (- (console y:) 49)
			setPri: (+ (console priority:) 1)
		)
		(gMouseDownHandler add: self)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if
					(and
						(not (IsFlag 288))
						(== global229 5)
						(== global237 2)
						(== local4 972)
						(not local5)
					)
					(if cel
						(= local32 0)
						(self setCycle: Beg)
					else
						(= local32 1)
						(self setCycle: End)
					)
				)
			)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance smallLeftRight of Prop
	(properties
		loop 3
		view 280
	)

	(method (init)
		(super init: &rest)
		(self
			posn: (+ (console x:) 67) (- (console y:) 55)
			setPri: (+ (console priority:) 1)
		)
	)
)

(instance craneHook of Prop
	(properties
		x 252
		y 271
		view 973
	)
)

(instance trainStill of View
	(properties
		x -11
		y 298
		cel 2
		view 984
	)

	(method (init)
		(super init: &rest)
		(switch (gCurRoom scene:)
			(983
				(switch global237
					(3
						(self setCel: 1 posn: 246 224)
					)
					(1
						(self setCel: 0 posn: 246 224)
					)
				)
			)
			(9830
				(switch global237
					(2
						(self setCel: 0 posn: 246 224)
					)
					(4
						(self setCel: 1 posn: 246 224)
					)
				)
			)
			(984
				(switch global237
					(3
						(self setCel: 0 posn: 246 224)
					)
					(1
						(self setCel: 1 posn: 246 224)
					)
				)
			)
			(9840
				(switch global237
					(2
						(self setCel: 1 posn: 246 224)
					)
					(4
						(self setCel: 0 posn: 246 224)
					)
				)
			)
		)
	)
)

(instance rotatorView of View
	(properties
		loop 1
		view 984
	)

	(method (init)
		(super init: &rest)
		(self posn: 159 215)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(rotatorPanel init:)
			)
		)
	)
)

(instance otherRoom of View
	(properties
		view 2700
	)

	(method (init)
		(super init: &rest)
		(switch global229
			(4
				(switch (gCurRoom scene:)
					(264
						(self
							view: 804
							setLoop: 0
							setPri: (- (leftDoor priority:) 1)
						)
					)
					(265
						(self
							view: 803
							setLoop: 0
							setPri: (- (leftDoor priority:) 1)
						)
					)
					(266
						(self
							view: 828
							setLoop: 0
							setPri: (- (rightDoor priority:) 1)
						)
					)
					(267
						(self
							view: 828
							setLoop: 0
							setPri: (- (rightDoor priority:) 1)
						)
					)
				)
			)
			(6
				(if (== (gCurRoom scene:) 265)
					(self
						view: 803
						setLoop: 1
						setPri: (- (leftDoor priority:) 1)
					)
				else
					(self
						view: 802
						setLoop: 1
						setPri: (- (rightDoor priority:) 1)
					)
				)
			)
			(12
				(if (== (gCurRoom scene:) 265)
					(self
						view: 803
						setLoop: (if (== global237 4) 0 else 1)
						setPri: (- (leftDoor priority:) 1)
					)
				else
					(self
						view: 802
						setLoop: (if (== global237 4) 1 else 0)
						setPri: (- (rightDoor priority:) 1)
					)
				)
			)
			(3
				(if (== (gCurRoom scene:) 265)
					(self
						view: 803
						setLoop: (if (== global237 4) 1 else 0)
						setPri: (- (leftDoor priority:) 1)
					)
				else
					(self
						view: 802
						setLoop: (if (== global237 4) 0 else 1)
						setPri: (- (rightDoor priority:) 1)
					)
				)
			)
			(9
				(if (== (gCurRoom scene:) 265)
					(self
						view: 803
						setLoop: (if (== global237 3) 1 else 0)
						setPri: (- (leftDoor priority:) 1)
					)
				else
					(self
						view: 802
						setLoop: (if (== global237 3) 0 else 1)
						setPri: (- (rightDoor priority:) 1)
					)
				)
			)
		)
	)

	(method (cue)
		(super cue: &rest)
		(switch global229
			(4
				(if (== local1 rightDoor)
					((ScriptID 1 1) newRoom: 810) ; exitForward
				)
			)
			(6
				((ScriptID 1 1) newRoom: 820) ; exitForward
			)
			(12
				(cond
					((== global237 4)
						(if (== local1 rightDoor)
							((ScriptID 1 1) newRoom: 800) ; exitForward
						)
					)
					((== local1 leftDoor)
						((ScriptID 1 1) newRoom: 800) ; exitForward
					)
				)
			)
			(3
				(cond
					((== global237 4)
						(if (== local1 leftDoor)
							((ScriptID 1 1) newRoom: 870) ; exitForward
						)
					)
					((== local1 rightDoor)
						((ScriptID 1 1) newRoom: 870) ; exitForward
					)
				)
			)
			(9
				(cond
					((== global237 1)
						(if (and (== local1 rightDoor) (IsFlag 382))
							((ScriptID 1 1) newPic: 990 arrowStyle: 1) ; exitForward
						)
					)
					((== local1 leftDoor)
						(if (IsFlag 382)
							((ScriptID 1 1) newPic: 991 arrowStyle: 1) ; exitForward
						else
							((ScriptID 1 1) newPic: 992 arrowStyle: 1) ; exitForward
						)
					)
				)
			)
		)
	)
)

(instance console of View
	(properties
		x 359
		y 297
		view 280
	)

	(method (init)
		(super init: &rest)
		(smallThrottle init:)
		(smallCraneSlider
			init:
			setPoints: 6 0 9 0 11 0 14 0 16 0 19 0 21 0 23 0 26 0 28 0 31 0
		)
		(smallCraneSwitch init:)
		(smallLeftRight init:)
		(forwardFeature
			init:
			nsLeft: 466
			nsTop: 238
			nsBottom: 261
			nsRight: 489
			setPolygon: 0
		)
		(gMouseDownHandler add: forwardFeature)
		(reverseFeature
			init:
			nsTop: 261
			nsLeft: 466
			nsBottom: 287
			nsRight: 489
			setPolygon: 0
		)
		(gMouseDownHandler add: reverseFeature)
		(approachX hotVerbs: 0)
	)

	(method (handleEvent))

	(method (dispose)
		(smallThrottle dispose:)
		(smallCraneSlider dispose:)
		(smallCraneSwitch dispose:)
		(smallLeftRight dispose:)
		(gMouseDownHandler delete: forwardFeature)
		(gMouseDownHandler delete: reverseFeature)
		(super dispose: &rest)
	)
)

(instance gateView of View
	(properties
		x 55
		y 64
		view 825
	)

	(method (init)
		(switch (gCurRoom scene:)
			(260
				(self view: 821 setLoop: 0 posn: 0 22)
			)
			(261
				(if (IsFlag 259)
					(self view: 823 setLoop: 1 posn: 0 22)
				else
					(self view: 823 setLoop: 0 posn: 0 22)
				)
			)
			(262
				(switch global229
					(4
						(if (IsFlag 259)
							(self view: 824 setLoop: 1 posn: 55 64)
						else
							(self view: 824 setLoop: 0 posn: 55 64)
						)
					)
					(6
						(if (== global237 2)
							(self view: 2809)
						else
							(self view: 2824)
						)
					)
					(3
						(if (== global237 4)
							(self view: 4821)
						else
							(self view: 2824)
						)
					)
					(9
						(if (== global237 1)
							(if (IsFlag 382)
								(self view: 995 setLoop: 1)
							else
								(self view: 995 setLoop: 0)
							)
						else
							(self view: 2824 setLoop: 1)
						)
					)
					(12
						(self view: 2824)
					)
				)
			)
			(263
				(if (IsFlag 259)
					(self view: 825 setLoop: 1 posn: 55 64)
				else
					(self view: 825 setLoop: 0 posn: 55 64)
				)
			)
		)
		(super init: &rest)
	)
)

(instance drawBridge of View
	(properties
		view 978
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
		(if (IsFlag 288)
			(self setCel: 1)
		else
			(self setCel: 0)
		)
		(self setPri: 1)
	)
)

(instance railPiece of View
	(properties
		x 75
		y 277
		view 944
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
		(cond
			((IsFlag 316)
				(self setCel: 0)
			)
			((IsFlag 364)
				(self setCel: 1)
			)
			(else
				(self setCel: 0)
			)
		)
		(approachX hotVerbs: 0)
	)
)

(instance dynamiteAddToPic of View
	(properties
		x 74
		y 226
		view 951
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 35 144 33 249 151 258 153 152
					yourself:
				)
		)
		(approachX hotVerbs: 11 95)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 11 95) ; invLighter, invTorch
			(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
				((ScriptID 9 3) hide:) ; PlCompass
			)
			(PlayVMD 0 {952.vmd} 1024) ; Open
			(PlayVMD 23 0 199) ; RestrictPalette
			(PlayVMD 1 70 75 272 5 0 199) ; Put
			(PlayVMD 14 7) ; WaitEvent
			(if (== local9 1)
				(= local5 158)
				(= local10 914)
			else
				(= local5 28)
				(= local10 915)
			)
			(SetFlag 375)
			(= global229 0)
			(= local27 1)
			((ScriptID 1 2) dispose:) ; exitBack
			(gCurRoom changeScene: 260)
			(personChanger dispose:)
			((ScriptID 9 5) state: 0 cel: 0) ; invLighter
			(PlayVMD 6) ; Close
			(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
				((ScriptID 9 3) show:) ; PlCompass
			)
		)
	)
)

(instance powerLeverFeat of Feature ; UNUSED
	(properties
		nsBottom 175
		nsLeft 314
		nsRight 355
		nsTop 34
	)

	(method (cue)
		(super cue: &rest)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(ClearFlag 161)
				(gCurRoom changeScene: 259)
				(powerLever
					setCel: (- (powerLever lastCel:) 1)
					setCycle: Beg self
				)
			)
		)
	)
)

(instance elevatorControlFeat of Feature
	(properties
		nsBottom 178
		nsLeft 274
		nsRight 298
		nsTop 134
	)

	(method (init)
		(super init: &rest)
		(switch (gCurRoom scene:)
			(980
				(self nsTop: 134 nsLeft: 274 nsBottom: 178 nsRight: 298)
			)
			(983
				(self nsTop: 182 nsLeft: 85 nsBottom: 238 nsRight: 117)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(elevControlPanel init:)
			)
		)
	)
)

(instance rotatorFeat of Feature
	(properties
		nsBottom 187
		nsLeft 301
		nsRight 319
		nsTop 155
	)

	(method (init)
		(super init: &rest)
		(switch (gCurRoom scene:)
			(980
				(self nsTop: 155 nsLeft: 301 nsRight: 319 nsBottom: 187)
			)
			(983
				(self nsTop: 178 nsLeft: 312 nsBottom: 220 nsRight: 335)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(rotatorPanel init:)
			)
		)
	)
)

(instance reverseFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 356 218 439 218 445 260 380 267 363 257
					yourself:
				)
		)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(5 ; Do
					(if
						(or
							(not (IsFlag 323))
							(not (IsFlag 259))
							(smallCraneSlider cel:)
						)
						(return 0)
					)
					(if
						(and
							(not local8)
							(or
								(== (throttle cel:) 7)
								(== (smallThrottle cel:) 7)
							)
						)
						(= local9 2)
						(if (not (getRobot doit:))
							(return)
						)
					)
					((ScriptID 1 2) dispose:) ; exitBack
					(= local4 (trainBot number:))
					(= local5 (trainBot curFrame:))
					(= local6 (trainBot x:))
					(= local7 (trainBot y:))
					(if (== (gCurRoom scene:) 260)
						(switch (throttle cel:)
							(7
								(if local8
									(return local8)
								)
								(= local29 0)
								(personChanger dispose:)
								(trainIdle stop:)
								(trainSlowDown stop:)
								(trainStartSound play: 100 trainSound)
								(throttle setCycle: Beg)
								(= local8 1)
								(= local9 2)
								(trainBot start: 2 local8)
								(= local22 1)
								(= local23 0)
							)
							((throttle lastCel:)
								(trainSound stop:)
								(trainStartSound stop:)
								(trainSlowDown play: 100 trainIdle)
								(throttle setCycle: CT 7 -1)
								(= local22 0)
								(= local23 1)
							)
						)
					else
						(switch (smallThrottle cel:)
							(7
								(if local8
									(return local8)
								)
								(= local29 0)
								(trainIdle stop:)
								(trainSlowDown stop:)
								(trainStartSound play: 60 trainSound)
								(smallThrottle setCycle: Beg)
								(= local8 1)
								(= local9 2)
								(trainBot start: 2 local8)
								(= local22 1)
								(= local23 0)
							)
							((smallThrottle lastCel:)
								(trainSound stop:)
								(trainStartSound stop:)
								(trainSlowDown play: 60 trainIdle)
								(smallThrottle setCycle: CT 7 -1)
								(= local22 0)
								(= local23 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance forwardFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 356 216 389 216 392 202 461 200 453 144 364 147 340 170
					yourself:
				)
		)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(5 ; Do
					(if
						(or
							(not (IsFlag 323))
							(not (IsFlag 259))
							(smallCraneSlider cel:)
						)
						(return 0)
					)
					(if
						(and
							(not local8)
							(or
								(== (throttle cel:) 7)
								(== (smallThrottle cel:) 7)
							)
						)
						(= local9 1)
						(if (not (getRobot doit:))
							(return)
						)
					)
					((ScriptID 1 2) dispose:) ; exitBack
					(= local4 (trainBot number:))
					(= local5 (trainBot curFrame:))
					(= local6 (trainBot x:))
					(= local7 (trainBot y:))
					(if (== (gCurRoom scene:) 260)
						(switch (throttle cel:)
							(7
								(if local8
									(return local8)
								)
								(= local29 0)
								(personChanger dispose:)
								(trainIdle stop:)
								(trainSlowDown stop:)
								(trainStartSound play: 100 trainSound)
								(throttle setCycle: End)
								(= local8 1)
								(= local9 1)
								(trainBot start: 1 local8)
								(= local22 1)
								(= local23 0)
							)
							(0
								(trainSound stop:)
								(trainStartSound stop:)
								(trainSlowDown play: 100 trainIdle)
								(throttle setCycle: CT 7 1)
								(= local22 0)
								(= local23 1)
							)
						)
					else
						(switch (smallThrottle cel:)
							(7
								(if local8
									(return local8)
								)
								(= local29 0)
								(trainIdle stop:)
								(trainSlowDown stop:)
								(trainStartSound play: 60 trainSound)
								(smallThrottle setCycle: End)
								(= local8 1)
								(= local9 1)
								(trainBot start: 1 local8)
								(= local22 1)
								(= local23 0)
							)
							(0
								(trainSound stop:)
								(trainStartSound stop:)
								(trainSlowDown play: 60 trainIdle)
								(smallThrottle setCycle: CT 7 1)
								(= local22 0)
								(= local23 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance barBoxFeat of Feature
	(properties
		nsBottom 225
		nsLeft 202
		nsRight 240
		nsTop 191
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(boxPanel init:)
			)
		)
	)
)

(instance switchFeat of Feature
	(properties
		nsBottom 189
		nsLeft 325
		nsRight 355
		nsTop 153
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(switchPanel init:)
			)
			(87 ; invHexBar
				(switchPanel init:)
			)
		)
	)
)

(instance railFeat of Feature
	(properties
		nsBottom 275
		nsLeft 117
		nsRight 212
		nsTop 228
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 89 92)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(railPanel init:)
			)
			(89 ; invPliers
				(railPanel init:)
			)
			(92 ; invRail
				(railPanel init:)
			)
		)
	)
)

(instance extraRailFeat of Feature
	(properties
		nsBottom 255
		nsLeft 25
		nsRight 172
		nsTop 179
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 89)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(extraRailPanel init:)
			)
			(89 ; invPliers
				(extraRailPanel init:)
			)
		)
	)
)

(instance boulderFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 67 0 253 99 253 101 297 222 295 217 244 104 125
					yourself:
				)
		)
		(approachX hotVerbs: 77)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(77 ; invDynamite
				(dynamiteAddToPic init:)
				(gInventory deleteItem: (ScriptID 9 65)) ; invDynamite
				(SetFlag 414)
				(self dispose:)
			)
		)
	)
)

(instance toolBoxFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(switch (gCurRoom scene:)
			(951
				(self
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 497 160 497 183 452 188 451 164
							yourself:
						)
				)
			)
			(954
				(self
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 497 165 469 165 471 189 500 186
							yourself:
						)
				)
			)
			(990
				(self
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 98 180 100 216 179 201 175 172
							yourself:
						)
				)
			)
			(991
				(self
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 19 191 18 227 120 211 117 179
							yourself:
						)
				)
			)
		)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				((ScriptID 271 0) init:) ; toolBoxPanel
			)
		)
	)
)

(instance railNailFeat of PanelFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 22 78 22 139 93 139 93 78
					yourself:
				)
		)
		(approachX hotVerbs: 89)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; invPliers
				(gGame handsOff:)
				(railProp init: railPanel 1 1 setCycle: End railProp)
				(((railPanel bitmap:) approachX:) hotVerbs: 0)
				(self dispose:)
			)
		)
	)
)

(instance extraRailNailFeat of PanelFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 103 110 103 173 164 173 164 110
					yourself:
				)
		)
		(approachX hotVerbs: 89)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; invPliers
				(gGame handsOff:)
				(extraRailProp
					init: extraRailPanel 1 1
					setCycle: End extraRailProp
				)
			)
		)
	)
)

(instance trainBot of RobotPlayer
	(properties)

	(method (init)
		(super init: &rest)
		(= local4 (trainBot number:))
		(= local5 (trainBot curFrame:))
		(= local6 (trainBot x:))
		(= local7 (trainBot y:))
		(approachX hotVerbs: 0)
	)

	(method (start)
		(if (OneOf local10 944 947 963 964 965 966 967 968 971 972 976)
			(= local35 10)
		else
			(= local35 20)
		)
		(if (== (gCurRoom scene:) 940)
			((ScriptID 1 3) dispose:) ; exitLeft
		)
		(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
			((ScriptID 9 3) dispose:) ; PlCompass
		)
		(SetFlag 403)
		(= local29 0)
		(super start: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (not local27) (!= global229 5))
					((ScriptID 271 0) init:) ; toolBoxPanel
				)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(= local14 1)
		(= local5 (self curFrame:))
		(if (and local22 (< local8 local35) (not (-- local21)))
			(= local21 5)
			(++ local8)
			(self start: local9 local8)
		)
		(if (and local23 (>= local8 1) (not (-- local21)))
			(= local21 5)
			(-- local8)
			(self start: local9 local8)
		)
		(if (<= local8 1)
			(= local8 0)
			(self stop:)
		)
		(switch local4
			(902
				(if
					(or
						(and
							(== local9 1)
							(>= local5 (- maxFrame local26))
							(IsFlag 319)
						)
						(and (== local9 2) (<= local5 local26))
					)
					(= local24 1)
				else
					(= local24 0)
				)
			)
			(904
				(if (>= local5 (- maxFrame local26))
					(= local24 1)
				else
					(= local24 0)
				)
			)
			(905
				(if (>= local5 (- maxFrame local26))
					(= local24 1)
				else
					(= local24 0)
				)
			)
			(906
				(if (>= local5 (- maxFrame local26))
					(= local24 1)
				else
					(= local24 0)
				)
			)
			(911
				(if (and (== local9 2) (<= local5 local26))
					(= local24 1)
				else
					(= local24 0)
				)
			)
			(912
				(if (and (== local9 2) (<= local5 local26))
					(= local24 1)
				else
					(= local24 0)
				)
			)
			(913
				(if (and (== local9 2) (<= local5 local26))
					(= local24 1)
				else
					(= local24 0)
				)
			)
			(916
				(if (and (== local9 2) (<= local5 local26))
					(= local24 1)
				else
					(= local24 0)
				)
			)
			(918
				(if (and (== local9 1) (>= local5 (- maxFrame local26)))
					(= local24 1)
				else
					(= local24 0)
				)
			)
			(921
				(if
					(or
						(and (>= local5 (- maxFrame local26)) (== local9 1))
						(and (<= local5 local26) (== local9 2) (IsFlag 319))
					)
					(= local24 1)
				else
					(= local24 0)
				)
			)
			(931
				(if (and (== local9 2) (<= local5 local26))
					(= local24 1)
				else
					(= local24 0)
				)
			)
			(else
				(= local24 0)
			)
		)
		(if
			(or
				(and
					(== local10 930)
					(== local9 2)
					(not (IsFlag 316))
					(<= local5 128)
				)
				(and
					(== local10 944)
					(== local9 1)
					(not (IsFlag 316))
					(>= local5 53)
				)
				(and
					(== local10 947)
					(== local9 2)
					(not (IsFlag 316))
					(== local5 20)
				)
			)
			(= local8 0)
			(self stop:)
			(if (gPanels contains: railPanel)
				(railPanel dispose:)
			)
			(gCurRoom setScript: showWreck)
		)
		(if
			(or
				(and
					(not (IsFlag 351))
					(not (IsFlag 372))
					(== local10 934)
					(== local5 30)
				)
				(and
					(not (IsFlag 351))
					(not (IsFlag 372))
					(== local10 915)
					(== local5 118)
				)
			)
			(= local8 0)
			(self stop:)
			(gCurRoom setScript: darkBeingRuns)
		)
		(if
			(or
				(and
					(not (IsFlag 351))
					(not (IsFlag 376))
					(== local10 934)
					(== local5 109)
				)
				(and
					(not (IsFlag 351))
					(not (IsFlag 376))
					(== local10 915)
					(== local5 69)
				)
			)
			(= local8 0)
			(self stop:)
			(gCurRoom setScript: seeBouldersDrop)
		)
		(if
			(or
				(and
					(== local10 925)
					(not (IsFlag 288))
					(>= local5 (- maxFrame 5))
					(== (throttle cel:) (throttle lastCel:))
					(= global229 5)
					(= global237 4)
					(personChanger init: yourself:)
				)
				(and
					(== local10 930)
					(not (IsFlag 288))
					(<= local5 216)
					(not (throttle cel:))
					(== local9 2)
					(= global229 5)
					(= global237 2)
				)
				(and
					(== local10 972)
					(<= local5 5)
					(not (smallThrottle cel:))
					(= global229 5)
					(= global237 2)
				)
				(and
					(== local10 923)
					(>= local5 (- maxFrame 5))
					(== (throttle cel:) (throttle lastCel:))
					(== local8 local35)
					(= global229 6)
					(= global237 2)
					((ScriptID 1 2) newPic: 269 yourself:) ; exitBack
				)
				(and
					(== local10 924)
					(<= local5 5)
					(not (throttle cel:))
					(= global229 6)
					(= global237 4)
					((ScriptID 1 2) newPic: 269 yourself:) ; exitBack
				)
				(and
					(== local10 909)
					(>= local5 (- maxFrame 5))
					(== (throttle cel:) (throttle lastCel:))
					(= global229 3)
					(= global237 4)
					((ScriptID 1 2) newPic: 269 yourself:) ; exitBack
				)
				(and
					(== local10 910)
					(<= local5 5)
					(not (throttle cel:))
					(= global229 3)
					(= global237 2)
					((ScriptID 1 2) newPic: 269 yourself:) ; exitBack
				)
				(and
					(== local10 934)
					(>= local5 (- maxFrame 3))
					(== (throttle cel:) (throttle lastCel:))
					(= global229 13)
					(= global237 4)
					(personChanger init: yourself:)
				)
				(and
					(not (IsFlag 375))
					(== local10 915)
					(<= local5 37)
					(not (throttle cel:))
					(= global229 13)
					(= global237 2)
					(personChanger init: yourself:)
				)
				(and
					(== local10 915)
					(<= local5 5)
					(not (throttle cel:))
					(= global237 2)
					(= global229 12)
					((ScriptID 1 2) newPic: 269 yourself:) ; exitBack
				)
				(and
					(== local10 929)
					(>= local5 (- maxFrame 5))
					(== (throttle cel:) (throttle lastCel:))
					(= global229 9)
					(= global237 1)
				)
				(and
					(IsFlag 301)
					(== local10 912)
					(<= local5 12)
					(not (throttle cel:))
					(personChanger init: yourself:)
					(= global229 14)
				)
				(and
					(== local10 914)
					(>= local5 (- maxFrame 5))
					(== (throttle cel:) (throttle lastCel:))
					(= global237 4)
					(= global229 12)
					((ScriptID 1 2) newPic: 269 yourself:) ; exitBack
				)
			)
			(trainSound stop:)
			(trainStartSound stop:)
			(trainSlowDown play: 100 trainIdle)
			(if (== local9 1)
				(throttle setCycle: CT 7 -1)
			else
				(throttle setCycle: CT 7 1)
			)
			(= local22 0)
			(= local23 1)
		)
	)

	(method (stop)
		(super stop: &rest)
		(return
			(cond
				((== local27 0)
					(if
						(OneOf
							local10
							944
							947
							963
							964
							965
							966
							967
							968
							971
							972
							976
						)
						(if (or (== local5 (self maxFrame:)) (== local5 0))
							(if
								(and
									(== local4 972)
									(== local5 (trainBot maxFrame:))
								)
								(personChanger init:)
							else
								(personChanger dispose:)
							)
							(if (gPanels contains: boxPanel)
								(boxPanel dispose:)
							)
							(if (gPanels contains: switchPanel)
								(switchPanel dispose:)
							)
							(if (gPanels contains: (ScriptID 271 0)) ; toolBoxPanel
								((ScriptID 271 0) dispose:) ; toolBoxPanel
							)
							(switch local9
								(1
									(throttle setCel: (throttle lastCel:))
									(if (== local10 971)
										(= local8 0)
										(= local14 0)
										(smallThrottle setCycle: CT 7 -1)
										(trainStartSound stop:)
										(trainSound stop:)
										(= global229 5)
										(= global237 4)
										(= local22 0)
										(= local23 0)
										(= local21 1)
										(= local24 0)
										(return (= local26 0))
									)
								)
								(2
									(throttle setCel: 0)
									(if (== local10 972)
										(if (not (IsFlag 288))
											(craneHook init:)
										)
										(= local8 0)
										(= local14 0)
										(smallThrottle setCycle: CT 7 1)
										(trainSound stop:)
										(= global229 5)
										(= global237 2)
										(= local22 0)
										(= local23 0)
										(= local21 1)
										(= local24 0)
										(= local26 0)
										(return (personChanger init:))
									)
								)
							)
							(personChanger cue:)
							(= global229 0)
							(self start: local9 local8)
						else
							(= local22 0)
							(= local23 0)
							(= local21 1)
							(= local24 0)
							(= local26 0)
							(if (== (gCurRoom scene:) 940)
								((ScriptID 1 3) newPic: 942) ; exitLeft
							)
						)
					)
				)
				((not local8)
					(switch global229
						(5
							(if (and (== (gCurRoom scene:) 260) (<= local5 216))
								(personChanger init:)
								(smallThrottle setCel: 7)
							)
						)
						(13
							(if (<= 35 local5 37)
								(personChanger init:)
							)
						)
					)
					(= local22 0)
					(= local23 0)
					(= local21 1)
					(= local24 0)
					(= local26 0)
					(if
						(or
							(and
								(OneOf local4 901 918 917 904)
								(<= local5 10)
							)
							(and
								(OneOf local4 922 913 919 916)
								(>= local5 (- (trainBot maxFrame:) 10))
							)
						)
						(if (!= global229 1)
							(= local27 1)
							(= global229 2)
							(cond
								((OneOf local4 913 904)
									(= local28 983)
									(= global237 1)
								)
								((OneOf local4 919 901)
									(= local28 9830)
									(= global237 2)
								)
								((OneOf local4 916 918)
									(= local28 984)
									(= global237 3)
								)
								((OneOf local4 922 917)
									(= local28 9840)
									(= global237 4)
								)
							)
						)
						(personChanger init:)
					)
				)
				((== local10 900)
					(cond
						((== (trainBot curFrame:) (trainBot maxFrame:))
							(= global229 1)
							(personChanger init:)
						)
						((not (trainBot curFrame:))
							(= global229 4)
							((ScriptID 1 2) newPic: 269) ; exitBack
						)
					)
					(= local22 0)
					(= local23 0)
					(= local21 1)
					(= local8 0)
					(trainSound stop:)
					(trainStartSound stop:)
					(trainSlowDown play: 100 trainIdle)
					(if (== local9 1)
						(throttle setCycle: CT 7 -1)
					else
						(throttle setCycle: CT 7 1)
					)
				)
				((== local10 901)
					(switch local9
						(1
							(self init: 902 0 0 -49 1 start: local9 local8)
							(= local10 902)
							(= local26 20)
						)
						(2
							(self init: 919 193 0 -49 1 start: local9 local8)
							(determineFrame doit: 0 100 0 60)
							(= local10 919)
						)
					)
					(= global237 2)
					(= local28 9830)
				)
				((== local10 902)
					(switch local9
						(1
							(if (== local19 1)
								(= local19 -1)
								(= local26 0)
								(if (IsFlag 288)
									(determineFrame doit: 0 61 0 74)
									(self
										init: 926 0 0 -49 1
										start: local9 local8
									)
									(= local10 926)
								else
									(determineFrame doit: 41 63 127 147)
									(self
										init: 925 0 0 -49 1
										start: local9 local8
									)
									(= local10 925)
								)
							else
								(determineFrame doit: 1 99 1 45)
								(self init: 903 0 0 -49 1 start: local9 local8)
								(= local10 903)
							)
						)
						(2
							(if (== local18 1)
								(= local18 -1)
								(self
									init: 924 100 0 -49 1
									start: local9 local8
								)
								(= local10 924)
							else
								(self init: 901 90 0 -49 1 start: local9 local8)
								(= local10 901)
							)
						)
					)
				)
				((== local10 903)
					(determineFrame doit: 1 99 1 45)
					(switch local9
						(1
							(self init: 913 0 0 -49 1 start: local9 local8)
							(= local10 913)
						)
						(2
							(self init: 902 146 0 -49 1 start: local9 local8)
							(= local10 902)
							(= local26 20)
						)
					)
				)
				((== local10 904)
					(switch local9
						(1
							(cond
								((== local15 1)
									(if (IsFlag 375)
										(self
											init: 914 0 0 -49 1
											start: local9 local8
										)
										(= local10 914)
									else
										(self
											init: 934 0 0 -49 1
											start: local9 local8
										)
										(= local10 934)
									)
									(= local15 -1)
								)
								((IsFlag 301)
									(self
										init: 935 0 0 -49 1
										start: local9 local8
									)
									(= local10 935)
								)
								(else
									(self
										init: 905 0 0 -49 1
										start: local9 local8
									)
									(= local10 905)
									(= local26 20)
								)
							)
						)
						(2
							(self init: 913 43 0 -49 1 start: local9 local8)
							(= local10 913)
							(= local26 20)
						)
					)
					(= global237 1)
					(= local28 983)
				)
				((== local10 905)
					(switch local9
						(1
							(if (== local16 1)
								(self init: 908 0 0 -49 1 start: local9 local8)
								(= local10 908)
								(= local16 -1)
							else
								(self init: 906 0 0 -49 1 start: local9 local8)
								(= local10 906)
								(= local26 20)
							)
						)
						(2
							(self init: 904 26 0 -49 1 start: local9 local8)
							(= local10 904)
							(= local26 15)
						)
					)
				)
				((== local10 906)
					(switch local9
						(1
							(if (== local17 1)
								(if (IsFlag 301)
									(self
										init: 932 0 0 -49 1
										start: local9 local8
									)
									(= local10 932)
								else
									(self
										init: 907 0 0 -49 1
										start: local9 local8
									)
									(= local10 907)
								)
								(= local17 -1)
							else
								(self init: 909 0 0 -49 1 start: local9 local8)
								(= local10 909)
							)
						)
						(2
							(if (IsFlag 301)
								(= local8 0)
								(throttle setCycle: CT 7 1)
								(trainSound stop:)
								(trainSlowDown play: 100 trainIdle)
								(= global229 14)
								(personChanger init:)
							else
								(self init: 905 97 0 -49 1 start: local9 local8)
								(= local10 905)
							)
						)
					)
				)
				((== local10 907)
					(switch local9
						(1
							(self init: 912 0 0 -49 1 start: local9 local8)
							(= local10 912)
						)
						(2
							(self init: 906 104 0 -49 1 start: local9 local8)
							(= local10 906)
						)
					)
				)
				((== local10 908)
					(switch local9
						(1
							(if (IsFlag 301)
								(self init: 931 0 0 -49 1 start: local9 local8)
								(= local10 931)
							else
								(self init: 911 0 0 -49 1 start: local9 local8)
								(= local10 911)
							)
						)
						(2
							(self init: 905 97 0 -49 1 start: local9 local8)
							(= local10 905)
						)
					)
				)
				((== local10 909)
					(switch local9
						(1
							(= local8 0)
							((ScriptID 1 2) newPic: 269) ; exitBack
							(= local14 0)
							(= global229 3)
							(= global237 4)
						)
						(2
							(self init: 906 104 0 -49 1 start: local9 local8)
							(= local10 906)
						)
					)
				)
				((== local10 910)
					(switch local9
						(1
							(if (IsFlag 301)
								(self init: 931 0 0 -49 1 start: local9 local8)
								(= local10 931)
							else
								(self init: 911 0 0 -49 1 start: local9 local8)
								(= local10 911)
							)
						)
						(2
							(= local8 0)
							((ScriptID 1 2) newPic: 269) ; exitBack
							(= local14 0)
							(= global229 3)
							(= global237 2)
						)
					)
				)
				((== local10 911)
					(switch local9
						(1
							(self init: 912 0 0 -49 1 start: local9 local8)
							(= local10 912)
						)
						(2
							(if (== local17 1)
								(self init: 908 65 0 -49 1 start: local9 local8)
								(= local10 908)
								(= local17 -1)
							else
								(self
									init: 910 132 0 -49 1
									start: local9 local8
								)
								(= local10 910)
							)
						)
					)
				)
				((== local10 912)
					(switch local9
						(1
							(self init: 916 0 0 -49 1 start: local9 local8)
							(= local10 916)
						)
						(2
							(cond
								((and (IsFlag 301) (<= local5 12))
									(= local8 0)
									(throttle setCycle: CT 7 1)
									(trainSound stop:)
									(trainSlowDown play: 100 trainIdle)
									(= global229 14)
									(personChanger init:)
								)
								((== local16 1)
									(self
										init: 907 65 0 -49 1
										start: local9 local8
									)
									(= local10 907)
									(= local16 -1)
								)
								(else
									(self
										init: 911 106 0 -49 1
										start: local9 local8
									)
									(= local10 911)
									(= local26 15)
								)
							)
						)
					)
				)
				((== local10 913)
					(switch local9
						(1
							(self init: 904 0 0 -49 1 start: local9 local8)
							(= local10 904)
							(= local26 15)
						)
						(2
							(if (== local20 1)
								(self
									init: 917 200 0 -49 1
									start: local9 local8
								)
								(determineFrame doit: 0 81 137 200)
								(= local10 917)
							else
								(determineFrame doit: 1 99 1 45)
								(self init: 903 67 0 -49 1 start: local9 local8)
								(= local10 903)
								(= local26 20)
							)
						)
					)
					(= global237 1)
					(= local28 983)
				)
				((== local10 914)
					(switch local9
						(1
							(= local8 0)
							(throttle setCycle: CT 7 -1)
							(trainSound stop:)
							(= global237 4)
							(= global229 12)
							((ScriptID 1 2) newPic: 269) ; exitBack
						)
						(2
							(self init: 904 26 0 -49 1 start: local9 local8)
							(= local10 904)
						)
					)
				)
				((== local10 915)
					(switch local9
						(1
							(self init: 916 0 0 -49 1 start: local9 local8)
							(= local10 916)
						)
						(2
							(= local8 0)
							(throttle setCycle: CT 7 1)
							(trainSound stop:)
							(= global237 2)
							(= global229 12)
							((ScriptID 1 2) newPic: 269) ; exitBack
						)
					)
				)
				((== local10 916)
					(switch local9
						(1
							(self init: 918 0 0 -49 1 start: local9 local8)
							(= local10 918)
							(= local26 15)
						)
						(2
							(if (== local15 1)
								(self
									init: 915 172 0 -49 1
									start: local9 local8
								)
								(= local10 915)
								(= local15 -1)
							else
								(self init: 912 90 0 -49 1 start: local9 local8)
								(= local10 912)
								(= local26 15)
							)
						)
					)
					(= global237 3)
					(= local28 984)
				)
				((== local10 917)
					(= local20 -1)
					(switch local9
						(1
							(self init: 913 0 0 -49 1 start: local9 local8)
							(= local10 913)
						)
						(2
							(self init: 922 84 0 -49 1 start: local9 local8)
							(= local10 922)
						)
					)
					(= global237 4)
					(= local28 9840)
				)
				((== local10 918)
					(switch local9
						(1
							(if (== local20 1)
								(self init: 919 0 0 -49 1 start: local9 local8)
								(determineFrame doit: 0 100 0 60)
								(= local10 919)
							else
								(determineFrame doit: 4 50 7 60)
								(self init: 920 0 0 -49 1 start: local9 local8)
								(= local10 920)
							)
						)
						(2
							(self init: 916 42 0 -49 1 start: local9 local8)
							(= local10 916)
							(= local26 15)
						)
					)
					(= global237 3)
					(= local28 984)
				)
				((== local10 919)
					(= local20 -1)
					(switch local9
						(1
							(self init: 901 0 0 -49 1 start: local9 local8)
							(= local10 901)
						)
						(2
							(self init: 918 50 0 -49 1 start: local9 local8)
							(= local10 918)
							(= local26 15)
						)
					)
					(= global237 2)
					(= local28 9830)
				)
				((== local10 920)
					(determineFrame doit: 0 64 0 61)
					(switch local9
						(1
							(self init: 921 0 0 -49 1 start: local9 local8)
							(= local10 921)
							(= local26 20)
						)
						(2
							(self init: 918 50 0 -49 1 start: local9 local8)
							(= local10 918)
						)
					)
				)
				((== local10 921)
					(= local26 20)
					(switch local9
						(1
							(if (== local18 1)
								(self init: 923 0 0 -49 1 start: local9 local8)
								(= local10 923)
								(= local18 -1)
							else
								(self init: 922 0 0 -49 start: local9 local8)
								(= local10 922)
							)
						)
						(2
							(if (== local19 1)
								(= local19 -1)
								(self init: 930 344 0 -49 start: local9 local8)
								(determineFrame doit: 282 330 4 76)
								(= local10 930)
							else
								(determineFrame doit: 4 50 7 60)
								(self init: 920 61 0 -49 start: local9 local8)
								(= local10 920)
							)
						)
					)
				)
				((== local10 922)
					(switch local9
						(1
							(self init: 917 0 0 -49 start: local9 local8)
							(determineFrame doit: 0 81 137 200)
							(= local10 917)
						)
						(2
							(self init: 921 151 0 -49 start: local9 local8)
							(= local10 921)
							(= local26 20)
						)
					)
					(= local28 9840)
					(= global237 4)
				)
				((== local10 923)
					(switch local9
						(1
							(= local8 0)
							(= global237 2)
							(= global229 6)
							((ScriptID 1 2) newPic: 269) ; exitBack
						)
						(2
							(= local10 921)
							(= local26 20)
							(trainBot
								init: 921 151 0 -49 1
								start: local9 local8
							)
						)
					)
				)
				((== local10 924)
					(= local18 -1)
					(switch local9
						(1
							(= local10 902)
							(= local26 20)
							(trainBot init: 902 0 0 -49 1 start: local9 local8)
						)
						(2
							(= local8 0)
							(= global237 4)
							(= global229 6)
							((ScriptID 1 2) newPic: 269) ; exitBack
						)
					)
				)
				((== local10 925)
					(determineFrame doit: 41 63 127 147)
					(switch local9
						(1
							(= local8 0)
							(= global237 4)
							(= global229 5)
							(personChanger init:)
						)
						(2
							(self init: 902 146 0 -49 1 start: local9 local8)
							(= local10 902)
							(= local26 20)
						)
					)
				)
				((== local10 926)
					(switch local9
						(1
							(cond
								((IsFlag 316)
									(self
										init: 928 0 0 -49 1
										start: local9 local8
									)
									(determineFrame doit: 16 51 18 52)
									(= local10 928)
								)
								((IsFlag 364)
									(self
										init: 933 0 0 -49 1
										start: local9 local8
									)
									(= local10 933)
								)
								(else
									(self
										init: 927 0 0 -49 1
										start: local9 local8
									)
									(determineFrame doit: 16 51 18 52)
									(= local10 927)
								)
							)
						)
						(2
							(self init: 902 146 0 -49 1 start: local9 local8)
							(= local10 902)
							(= local26 20)
						)
					)
				)
				((== local10 927)
					(switch local9
						(1
							(= local8 0)
							(self stop:)
							(gCurRoom setScript: showWreck)
						)
						(2
							(determineFrame doit: 0 61 0 74)
							(self init: 926 161 0 -49 1 start: local9 local8)
							(= local10 926)
						)
					)
				)
				((== local10 928)
					(switch local9
						(1
							(if (IsFlag 382)
								(self init: 936 0 0 -49 1 start: local9 local8)
								(= local10 936)
							else
								(self init: 929 0 0 -49 1 start: local9 local8)
								(= local10 929)
							)
						)
						(2
							(determineFrame doit: 0 61 0 74)
							(self init: 926 161 0 -49 1 start: local9 local8)
							(= local10 926)
						)
					)
				)
				((== local10 929)
					(switch local9
						(1
							(= local8 0)
							(= local14 0)
							(throttle setCycle: CT 7 -1)
							(= global229 9)
							(= global237 1)
						)
						(2
							(self init: 928 52 0 -49 1 start: local9 local8)
							(determineFrame doit: 16 51 18 52)
							(= local10 928)
						)
					)
					(if (IsFlag 382)
						((ScriptID 1 2) newPic: 269 yourself:) ; exitBack
					else
						1
					)
				)
				((== local10 930)
					(switch local9
						(1
							(self init: 921 0 0 -49 1 start: local9 local8)
							(= local10 921)
							(= local26 20)
						)
						(2
							(cond
								((not (IsFlag 288))
									(= global237 2)
									(= global229 5)
									(personChanger init:)
								)
								((not (trainBot curFrame:))
									(= local8 0)
									(throttle setCycle: CT 7 1)
									(trainSound stop:)
									(trainSlowDown play: 100 trainIdle)
									(= local14 0)
									(= global229 9)
									(= global237 3)
									((ScriptID 1 2) newPic: 269 yourself:) ; exitBack
								)
							)
						)
					)
				)
				((== local10 931)
					(switch local9
						(1
							(= local8 0)
							(= local14 0)
							(throttle setCycle: CT 7 -1)
						)
						(2
							(if (== local17 1)
								(self init: 908 65 0 -49 1 start: local9 local8)
								(= local10 908)
								(= local17 -1)
							else
								(self
									init: 910 132 0 -49 1
									start: local9 local8
								)
								(= local10 910)
							)
						)
					)
				)
				((== local10 932)
					(switch local9
						(1
							(= local8 0)
							(= local14 0)
							(throttle setCycle: CT 7 -1)
						)
						(2
							(self init: 906 104 0 -49 1 start: local9 local8)
							(= local10 906)
						)
					)
				)
				((== local10 933)
					(switch local9
						(1
							(= local8 0)
							(self stop:)
							(gCurRoom setScript: showWreck)
						)
						(2
							(determineFrame doit: 0 61 0 74)
							(self init: 926 161 0 -49 1 start: local9 local8)
							(= local10 926)
						)
					)
				)
				((== local10 934)
					(switch local9
						(1
							(= local8 0)
							(= local14 0)
							(throttle setCycle: CT 7 -1)
							(trainSound stop:)
							(if (IsFlag 161)
								(trainIdle play: 100 0)
							)
							(= global229 13)
							(= global237 4)
							(personChanger init:)
						)
						(2
							(self init: 904 26 0 -49 1 start: local9 local8)
							(= local10 904)
						)
					)
				)
				((== local10 935)
					(switch local9
						(1
							(= local8 0)
							(= local14 0)
							(throttle setCycle: CT 7 -1)
							(trainSound stop:)
							(trainStartSound stop:)
							(if (IsFlag 323)
								(trainIdle play: 100 0)
							)
						)
						(2
							(self init: 904 26 0 -49 1 start: local9 local8)
							(= local10 904)
						)
					)
				)
				((== local10 936)
					(switch local9
						(1
							(= local8 0)
							(= local14 0)
							(throttle setCycle: CT 7 -1)
							(trainSound stop:)
							(if (IsFlag 161)
								(trainIdle play: 100 0)
							)
							(trainSound stop:)
							(= global229 9)
							(= global237 1)
							(if (IsFlag 382)
								((ScriptID 1 2) newPic: 269) ; exitBack
							)
						)
						(2
							(if (== local5 (trainBot maxFrame:))
								(= local8 0)
								(= local14 0)
								(throttle setCycle: CT 7 1)
								(trainSound stop:)
								(if (IsFlag 161)
									(trainIdle play: 100 0)
								)
								(trainSound stop:)
								(= global229 9)
								(= global237 3)
								(if (IsFlag 382)
									((ScriptID 1 2) newPic: 269) ; exitBack
								)
							else
								(self init: 928 52 0 -49 1 start: local9 local8)
								(determineFrame doit: 16 51 18 52)
								(= local10 928)
							)
						)
					)
				)
				((== local10 947)
					(switch local9
						(1
							(self init: 930 160 0 -49 1 start: local9 local8)
							(determineFrame doit: 130 160 21 61)
							(= local10 930)
						)
						(2
							(if (not (IsFlag 316))
								(= local8 0)
								(self stop:)
								(gCurRoom setScript: showWreck)
							else
								(self
									init: 930 111 0 -49 1
									start: local9 local8
								)
								(determineFrame doit: 130 160 21 61)
								(= local10 930)
							)
						)
					)
				)
				((== local10 976)
					(switch local9
						(1
							(self init: 930 216 0 -49 1 start: local9 local8)
							(determineFrame doit: 282 330 4 76)
							(= local10 930)
						)
						(2
							(self init: 930 230 0 -49 1 start: local9 local8)
							(determineFrame doit: 282 330 4 76)
							(= local10 930)
						)
					)
				)
			)
		)
	)
)

(instance rotateTrain of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(switch global237
			(2
				(= temp2 986)
			)
			(3
				(= temp2 987)
			)
			(4
				(= temp2 988)
			)
			(1
				(= temp2 989)
			)
		)
		(= temp1 (Str new:))
		(temp1 format: {%d.vmd} temp2)
		(if (gPanels contains: rotatorPanel)
			(rotatorPanel dispose:)
		)
		(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
			((ScriptID 9 3) hide:) ; PlCompass
		)
		(gGame handsOn:)
		(PlayVMD 0 (temp1 data:) 1024) ; Open
		(PlayVMD 23 0 199) ; RestrictPalette
		(PlayVMD 1 70 75 272 5 0 199) ; Put
		(PlayVMD 14 7) ; WaitEvent
		(PlayVMD 6) ; Close
		(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
			((ScriptID 9 3) show:) ; PlCompass
		)
		(if (> (++ temp2) 989)
			(= temp2 986)
		)
		(switch (gCurRoom scene:)
			(983
				(= global233 9830)
			)
			(9830
				(= global233 984)
			)
			(984
				(= global233 9840)
			)
			(9840
				(= global233 983)
			)
		)
		(temp1 dispose:)
		(= local3 0)
		(= local4 0)
		(switch temp2
			(986
				(PrintDebug {gTrainFacing EAST})
				(= global237 2)
				(gCurRoom changeScene: 9830)
			)
			(987
				(PrintDebug {gTrainFacing SOUTH})
				(= global237 3)
				(gCurRoom changeScene: 984)
			)
			(988
				(PrintDebug {gTrainFacing WEST})
				(= global237 4)
				(gCurRoom changeScene: 9840)
			)
			(989
				(PrintDebug {gTrainFacing NORTH})
				(= global237 1)
				(gCurRoom changeScene: 983)
			)
		)
		(gPlanes addToFront: (ScriptID 9 1)) ; PlInterface
	)
)

(instance getRobot of Code
	(properties)

	(method (doit)
		(switch local10
			(1
				(switch local9
					(1
						(switch global237
							(1
								(if (== local15 1)
									(= local11 914)
								else
									(= local11 905)
								)
								(= local10 904)
								(trainBot init: 904 local5 0 -49 1)
								(= local26 15)
							)
							(2
								(= local11 902)
								(= local10 901)
								(trainBot init: 901 local5 0 -49 1)
							)
							(3
								(= local11 920)
								(= local10 918)
								(= local26 215)
								(trainBot init: 918 local5 0 -49 1)
							)
							(4
								(= local11 913)
								(= local10 917)
								(determineFrame doit: 0 81 137 200)
								(trainBot init: 917 local5 0 -49 1)
							)
						)
					)
					(2
						(switch global237
							(1
								(= local11 903)
								(= local10 913)
								(= local26 20)
								(trainBot init: 913 43 0 -49 1)
							)
							(3
								(if (== local15 1)
									(= local11 915)
								else
									(= local11 912)
								)
								(= local10 916)
								(trainBot init: 916 42 0 -49 1)
								(= local26 15)
							)
							(4
								(= local11 921)
								(= local10 922)
								(trainBot init: 922 84 0 -49 1)
								(= local26 20)
							)
						)
					)
				)
			)
			(900
				(if (not local5)
					(= global229 4)
				else
					(= global229 1)
				)
				(trainBot init: 900 local5 0 -49 1)
			)
			(901
				(switch local9
					(1
						(= local11 902)
						(trainBot init: 901 local5 0 -49 1)
					)
					(2
						(trainBot init: 901 local5 0 -49 1)
					)
				)
				(= global237 2)
			)
			(902
				(switch local9
					(1
						(if (== local19 1)
							(if (IsFlag 288)
								(= local11 926)
							else
								(= local11 925)
							)
						else
							(= local11 903)
						)
						(= local26 20)
					)
					(2
						(if (== local18 1)
							(= local11 924)
						else
							(= local11 901)
						)
						(= local26 20)
					)
				)
				(trainBot init: 902 local5 0 -49 1)
			)
			(903
				(determineFrame doit: 1 99 1 45)
				(switch local9
					(1
						(= local11 913)
						(trainBot init: 903 local5 0 -49 1)
					)
					(2
						(= local11 902)
						(trainBot init: 903 local5 0 -49 1)
					)
				)
				(= local19 -1)
			)
			(904
				(switch local9
					(1
						(if (== local15 1)
							(if (IsFlag 375)
								(= local11 914)
							else
								(= local11 934)
							)
						else
							(= local11 905)
						)
						(trainBot init: 904 local5 0 -49 1)
						(= local26 15)
					)
					(2
						(= local11 913)
						(trainBot init: 904 local5 0 -49 1)
						(= local26 0)
					)
				)
				(= global237 1)
			)
			(905
				(switch local9
					(1
						(if (== local16 1)
							(= local11 908)
						else
							(= local11 906)
						)
						(= local26 15)
					)
					(2
						(= local11 904)
						(= local26 0)
					)
				)
				(trainBot init: 905 local5 0 -49 1)
			)
			(906
				(switch local9
					(1
						(if (== local17 1)
							(if (IsFlag 301)
								(= local11 932)
							else
								(= local11 907)
							)
						else
							(= local11 909)
						)
						(= local26 20)
					)
					(2
						(= local11 905)
					)
				)
				(trainBot init: 906 local5 0 -49 1)
			)
			(907
				(switch local9
					(1
						(= local11 912)
					)
					(2
						(= local11 906)
					)
				)
				(trainBot init: 907 local5 0 -49 1)
			)
			(908
				(switch local9
					(1
						(= local11 911)
					)
					(2
						(= local11 905)
					)
				)
				(trainBot init: 908 local5 0 -49 1)
			)
			(909
				(switch local9
					(1
						(trainBot init: 909 local5 0 -49 1)
						(if (== (trainBot curFrame:) (trainBot maxFrame:))
							(throttle setCycle: CT 7 -1)
							((ScriptID 1 2) newPic: 269) ; exitBack
							(return 0)
						)
					)
					(2
						(= local11 906)
						(trainBot init: 909 local5 0 -49 1)
					)
				)
			)
			(910
				(switch local9
					(1
						(= local11 911)
					)
					(2
						(if (not (trainBot curFrame:))
							(throttle setCycle: CT 7 1)
							(return 0)
						)
					)
				)
				(trainBot init: 910 local5 0 -49 1)
			)
			(911
				(switch local9
					(1
						(= local11 912)
					)
					(2
						(if (== local17 1)
							(= local11 908)
						else
							(= local11 910)
						)
						(= local26 15)
					)
				)
				(trainBot init: 911 local5 0 -49 1)
			)
			(912
				(switch local9
					(1
						(= local11 916)
					)
					(2
						(if (== local16 1)
							(= local11 907)
						else
							(= local11 911)
						)
						(= local26 15)
					)
				)
				(trainBot init: 912 local5 0 -49 1)
			)
			(913
				(switch local9
					(1
						(= local11 904)
					)
					(2
						(= local26 20)
						(if (== local20 1)
							(= local11 917)
						else
							(= local11 903)
						)
					)
				)
				(trainBot init: 913 local5 0 -49 1)
				(= global237 1)
			)
			(914
				(switch local9
					(1
						(if (== (trainBot curFrame:) (trainBot maxFrame:))
							(throttle setCycle: CT 7 -1)
							(trainBot init: 914 local5 0 -49 1)
							(if (== (trainBot curFrame:) (trainBot maxFrame:))
								((ScriptID 1 2) newPic: 269) ; exitBack
							)
							(return 0)
						else
							(trainBot init: 914 local5 0 -49 1)
						)
					)
					(2
						(= local11 904)
						(trainBot init: 914 local5 0 -49 1)
					)
				)
			)
			(915
				(switch local9
					(1
						(= local11 916)
					)
					(2)
				)
				(trainBot init: 915 local5 0 -49 1)
			)
			(916
				(switch local9
					(1
						(= local11 918)
					)
					(2
						(= local26 15)
						(if (== local15 1)
							(= local11 915)
						else
							(= local11 912)
						)
					)
				)
				(= global237 3)
				(trainBot init: 916 local5 0 -49 1)
			)
			(917
				(switch local9
					(1
						(= local11 913)
					)
					(2
						(= local11 901)
					)
				)
				(determineFrame doit: 0 81 137 200)
				(trainBot init: 917 local5 0 -49 1)
				(= local20 -1)
				(= global237 4)
			)
			(918
				(switch local9
					(1
						(if (== local20 1)
							(= local11 919)
						else
							(= local11 920)
						)
						(= local26 15)
					)
					(2
						(= local11 916)
					)
				)
				(trainBot init: 918 local5 0 -49 1)
				(= global237 3)
			)
			(919
				(switch local9
					(1
						(= local11 901)
					)
					(2
						(= local11 918)
					)
				)
				(determineFrame doit: 0 100 0 60)
				(trainBot init: 919 local5 0 -49 1)
				(= global237 2)
			)
			(920
				(switch local9
					(1
						(= local11 921)
					)
					(2
						(= local11 918)
					)
				)
				(determineFrame doit: 4 50 7 60)
				(trainBot init: 920 local5 0 -49 1)
			)
			(921
				(switch local9
					(1
						(if (== local18 1)
							(= local11 923)
						else
							(= local11 922)
						)
					)
					(2
						(if (== local19 1)
							(= local11 930)
						else
							(= local11 920)
						)
					)
				)
				(= local26 20)
				(trainBot init: 921 local5 0 -49 1)
			)
			(922
				(switch local9
					(1
						(= local11 917)
					)
					(2
						(= local11 921)
					)
				)
				(trainBot init: 922 local5 0 -49 1)
				(= global237 4)
			)
			(923
				(switch local9
					(1
						(if (== (trainBot curFrame:) (trainBot maxFrame:))
							(throttle setCycle: CT 7 -1)
							(trainBot init: 923 local5 0 -49 1)
							((ScriptID 1 2) newPic: 269) ; exitBack
							(return 0)
						else
							(trainBot init: 923 local5 0 -49 1)
						)
					)
					(2
						(= local11 921)
						(trainBot init: 923 local5 0 -49 1)
					)
				)
			)
			(924
				(switch local9
					(1
						(= local11 902)
					)
					(2
						(if (not (trainBot curFrame:))
							((ScriptID 1 2) newPic: 269) ; exitBack
							(throttle setCycle: CT 7 1)
							(trainBot init: 924 0 0 -49 1)
							(return 0)
						)
					)
				)
				(= local18 -1)
				(trainBot init: 924 local5 0 -49 1)
			)
			(925
				(determineFrame doit: 41 63 127 147)
				(switch local9
					(1
						(if
							(and
								(== local4 925)
								(== (trainBot curFrame:) (trainBot maxFrame:))
							)
							(throttle setCycle: CT 7 -1)
							(return 0)
						)
					)
					(2
						(= local11 902)
					)
				)
				(= local19 -1)
				(trainBot init: 925 local5 0 -49 1)
			)
			(926
				(determineFrame doit: 0 61 0 74)
				(switch local9
					(1
						(if (IsFlag 316)
							(= local11 928)
						else
							(= local11 927)
						)
					)
					(2
						(= local11 902)
					)
				)
				(= local19 -1)
				(trainBot init: 926 local5 0 -49 1)
			)
			(927
				(switch local9
					(1)
					(2
						(= local11 926)
					)
				)
				(determineFrame doit: 16 51 18 52)
				(trainBot init: 927 local5 0 -49 1)
			)
			(928
				(switch local9
					(1
						(if (IsFlag 382)
							(= local11 936)
						else
							(= local11 929)
						)
					)
					(2
						(= local11 926)
					)
				)
				(determineFrame doit: 16 51 18 52)
				(trainBot init: 928 local5 0 -49 1)
			)
			(929
				(switch local9
					(1
						(trainBot init: 929 local5 0 -49 1)
						(if (== (trainBot curFrame:) (trainBot maxFrame:))
							(throttle setCycle: CT 7 -1)
							(return 0)
						)
					)
					(2
						(= local11 928)
					)
				)
				(trainBot init: 929 local5 0 -49 1)
			)
			(930
				(switch local9
					(1
						(= local11 921)
					)
					(2
						(if (and (not (IsFlag 288)) (<= local5 212))
							(throttle setCycle: CT 7 1)
							(return 0)
						)
					)
				)
				(if (== global229 8)
					(determineFrame doit: 130 160 21 52)
				else
					(determineFrame doit: 282 330 4 76)
				)
				(trainBot init: 930 local5 0 -49 1)
			)
			(931
				(switch local9
					(1)
					(2
						(if (== local17 1)
							(= local11 908)
						else
							(= local11 910)
						)
						(= local26 15)
					)
				)
				(trainBot init: 931 local5 0 -49 1)
			)
			(932
				(switch local9
					(1)
					(2
						(= local11 906)
					)
				)
				(trainBot init: 932 local5 0 -49 1)
			)
			(933
				(switch local9
					(1)
					(2
						(= local11 926)
					)
				)
				(trainBot init: 933 local5 0 -49 1)
			)
			(934
				(switch local9
					(1)
					(2
						(= local11 904)
					)
				)
				(trainBot init: 934 local5 0 -49 1)
			)
			(935
				(switch local9
					(1
						(if (== local5 (trainBot maxFrame:))
							(return 0)
						)
					)
					(2
						(= local11 904)
					)
				)
				(trainBot init: 935 local5 0 -49 1)
			)
			(936
				(switch local9
					(1)
					(2
						(= local11 928)
					)
				)
				(trainBot init: 936 local5 0 -49 1)
			)
			(947
				(determineFrame doit: 130 160 21 61)
				(= local11 930)
				(trainBot init: 947 local5 0 0 2)
			)
			(963
				(switch local9
					(1
						(= local11 913)
					)
					(2
						(= local11 902)
					)
				)
				(determineFrame doit: 0 50 0 100)
				(trainBot init: 963 local5 0 0 1)
			)
			(964
				(switch local9
					(1
						(= local11 921)
					)
					(2
						(= local11 918)
					)
				)
				(determineFrame doit: 7 60 4 50)
				(trainBot init: 964 local5 0 0 1)
			)
			(965
				(switch local9
					(1
						(if (IsFlag 288)
							(= local11 926)
						else
							(= local11 925)
						)
					)
					(2
						(= local11 902)
					)
				)
				(determineFrame doit: 0 61 0 74)
				(trainBot init: 965 local5 0 0 -1)
			)
			(966
				(switch local9
					(1
						(= local11 921)
					)
					(2
						(= local11 930)
					)
				)
				(determineFrame doit: 4 76 1 1)
				(trainBot init: 966 local5 0 0 -1)
			)
			(967
				(switch local9
					(1
						(= local11 901)
					)
					(2
						(= local11 918)
					)
				)
				(determineFrame doit: 0 60 0 100)
				(trainBot init: 967 local5 0 0 1)
			)
			(968
				(switch local9
					(1
						(= local11 913)
					)
					(2
						(= local11 922)
					)
				)
				(determineFrame doit: 137 200 0 81)
				(trainBot init: 968 local5 0 0 1)
			)
			(971
				(switch local9
					(1)
					(2
						(= local11 902)
					)
				)
				(determineFrame doit: 127 147 41 63)
				(trainBot init: 971 local5 0 0 1)
			)
			(972
				(craneHook dispose:)
				(switch local9
					(1
						(= local11 930)
					)
					(2
						(= local11 930)
					)
				)
				(trainBot init: 972 local5 0 0 1)
			)
			(976
				(switch local9
					(1
						(= local11 930)
					)
					(2
						(= local11 930)
					)
				)
				(trainBot init: 976 local5 0 0 3)
			)
		)
		(return 1)
	)
)

(instance determineFrame of Code
	(properties)

	(method (doit param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
		(= local36 param1)
		(= local37 param2)
		(if local29
			(= temp2 (- param4 param3))
			(return (+ (/ (* local29 temp2) 100) param3))
		)
		(if (>= param1 param2)
			(PrintDebug
				{ERROR: rbtRngAStart can't be greater than or equal to rbtRngAEnd.\n}
			)
		)
		(if (>= param3 param4)
			(PrintDebug
				{ERROR: rbtRngBStart can't be greater than or equal to rbtRngBEnd.\n}
			)
		)
		(= temp1 (- param2 param1))
		(if (> (= temp0 (- local5 param1)) temp1)
			(= temp0 temp1)
		)
		(= local30 local5)
		(= local29 (/ (* temp0 100) temp1))
		(PrintDebug {frameRangeRbtA = %d} temp1)
		(PrintDebug {rangeIndex = %d} temp0)
		(PrintDebug {validRangePct = %d\n} local29)
		(= temp2 (- param4 param3))
		(if (>= local29 100)
			(= local29 99)
		)
		(if (<= local29 1)
			(= local29 1)
		)
		(= temp3 (+ (/ (* local29 temp2) 100) param3))
		(PrintDebug {frameRangeRbtB = %d} temp2)
		(PrintDebug {desiredFrame = %d} temp3)
		(PrintDebug {validRangePct = %d\n} local29)
		(= local31 temp3)
		(return temp3)
	)
)

(instance trainStartSound of Sound
	(properties
		number 809
	)

	(method (stop)
		(= client 0)
		(super stop: &rest)
	)
)

(instance trainSlowDown of Sound
	(properties
		number 813
	)

	(method (stop)
		(= client 0)
		(super stop: &rest)
	)
)

(instance trainSound of RandomMusic
	(properties
		number 810
	)

	(method (stop)
		(= client 0)
		(super stop: &rest)
	)

	(method (play param1 param2)
		(if (not local8)
			(return)
		)
		(= vol 127)
		(= client 0)
		(if argc
			(if (== argc 1)
				(= client param1)
			else
				(= client param2)
				(= vol (& param1 $007f))
			)
		)
		(if (not (gSounds contains: self))
			(self init:)
		)
		(if (not loop)
			(= loop 1)
		)
		(DoSound sndPLAY self)
	)

	(method (cue)
		(if local27
			(self init: number: 810 setLoop: -1 play: 100 0)
		else
			(self init: number: 810 setLoop: -1 play: 60 0)
		)
	)
)

(instance trainIdle of RandomMusic
	(properties
		number 808
	)

	(method (stop)
		(= client 0)
		(super stop: &rest)
	)

	(method (play param1 param2)
		(= vol 127)
		(= client 0)
		(if argc
			(if (== argc 1)
				(= client param1)
			else
				(= client param2)
				(= vol (& param1 $007f))
			)
		)
		(if (not (gSounds contains: self))
			(self init:)
		)
		(if (not loop)
			(= loop 1)
		)
		(DoSound sndPLAY self)
	)

	(method (cue)
		(if local27
			(self init: number: 808 setLoop: -1 play: 100 0)
		else
			(self init: number: 808 setLoop: -1 play: 60 0)
		)
	)
)

(instance leftRightSwitchSound of Sound
	(properties)
)

(instance myForwardExit of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(self
			createPoly: 346 62 315 108 314 162 350 204 417 183 439 120 414 60 360 47
		)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 3)
		(self
			setPolygon: 0
			createPoly: 346 62 315 108 314 162 350 204 417 183 439 120 414 60 360 47
		)
		(PrintDebug {__MYFORWARD: %d} (self curPic:))
	)
)

(instance rightDoorExit of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 8)
		(self createPoly: 11 199 45 77 132 71 154 203 149 295 54 296)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 8)
		(self
			setPolygon: 0
			createPoly: 11 199 45 77 132 71 154 203 149 295 54 296
		)
		(PrintDebug {__RIGHTDOOR: %d} (self curPic:))
	)
)

(instance leftDoorExit of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 7)
		(self createPoly: 366 70 421 66 480 162 435 296 338 298 333 256 339 81)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 7)
		(self
			setPolygon: 0
			createPoly: 366 70 421 66 480 162 435 296 338 298 333 256 339 81
		)
		(PrintDebug {__LEFTDOOR: %d} (self curPic:))
	)
)

(instance vSwitchLight of Prop
	(properties
		x 122
		y 247
		loop 6
		view 270
	)

	(method (init)
		(super init: &rest)
		(self hide:)
	)

	(method (doit)
		(if local24
			(self show:)
		else
			(self hide:)
		)
		(super doit:)
	)
)

