;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use n013)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Hounfour 0
	xDJ 1
	xDrawThePic 2
	disposeCode 3
)

(local
	local0 = 1
	local1 = 806
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9 = 16
)

(class Hounfour of Room
	(properties
		noun 1
		picture 99
		style 0
		timeForCeremony 0
		BackToElevator 0
		roomLookCase 0
		goToDeath 0
		curLoc 5
		drumCount 0
		okayToDie 0
	)

	(method (doWalk)
		(GK setScript: sDrJohnWalk)
	)

	(method (getSpoke)
		(switch curLoc
			(0
				(gCurRoom curLoc: 12)
			)
			(2
				(gCurRoom curLoc: 13)
			)
			(4
				(gCurRoom curLoc: 14)
			)
			(6
				(gCurRoom curLoc: 15)
			)
			(8
				(gCurRoom curLoc: 16)
			)
			(10
				(gCurRoom curLoc: 17)
			)
		)
	)

	(method (getHall)
		(switch curLoc
			(12
				(gCurRoom curLoc: 0)
			)
			(13
				(gCurRoom curLoc: 2)
			)
			(14
				(gCurRoom curLoc: 4)
			)
			(15
				(gCurRoom curLoc: 6)
			)
			(16
				(gCurRoom curLoc: 8)
			)
			(17
				(gCurRoom curLoc: 10)
			)
		)
	)

	(method (init)
		(Palette 2 0 255 0) ; PalIntensity
		(super init:)
		(= gDay 10)
		(gEgo normalize: init: posn: 1000 0 state: 2)
		(self setScript: sMainHallways)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb roomLookCase)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (gWalkHandler contains: hall)
			(gWalkHandler delete: hall)
		)
		(if (GK script:)
			(sDrJohnWalk dispose:)
		)
		(super dispose:)
	)
)

(instance sMainHallways of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (gEgo inRect: 0 140 235 148) local2 (not script))
			(self setScript: sEgoInRoundHallway 0 0)
		)
		(if (and (gEgo inRect: 180 100 221 118) local2 (not script))
			(self setScript: sEgoInRoundHallway 0 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (not local0)
					(Fade)
					(disposeCode doit:)
				)
				(= local2 0)
				(gGame handsOff:)
				(if (and (not (GK script:)) (!= local1 802))
					(gGkMusic1 fade:)
				)
				(gCurRoom curLoc: local1)
				(self setScript: (ScriptID local1 0) self local0)
			)
			(2
				(Fade)
				(disposeCode doit:)
				(= cycles 1)
			)
			(3
				(DisposeScript local1)
				(= cycles 1)
			)
			(4
				(cond
					((Hounfour timeForCeremony:)
						(gCurRoom newRoom: 899) ; EndGame
					)
					((Hounfour BackToElevator:)
						(gCurRoom newRoom: 455)
					)
					((Hounfour goToDeath:)
						(gCurRoom newRoom: 770) ; deathRm
					)
					(else
						(= local0 0)
						(= local2 1)
						(self setScript: sEgoInRoundHallway self 2)
					)
				)
			)
			(5 0)
			(6
				(self changeState: 0)
			)
		)
	)
)

(instance sGoToSpoke of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (gEgo inRect: 38 120 50 138) (not local2))
			(= local2 1)
			(gCurRoom getHall:)
			(client setScript: sEgoInRoundHallway 0 3)
			(= local7 0)
		)
		(if (and (gEgo inRect: 267 120 280 138) (not local2))
			(= local2 1)
			(Fade)
			(disposeCode doit:)
			(gCurRoom getSpoke:)
			(self setScript: (ScriptID 900 0) self (gCurRoom curLoc:)) ; sCeremonialRoom
			(= local7 0)
		)
		(if local7
			(Palette 2 0 255 (Random 96 100)) ; PalIntensity
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Hounfour okayToDie: 0 getSpoke:)
				(gEgo setMotion: MoveTo 226 133 self)
			)
			(1
				(gEgo hide:)
				(= cycles 1)
			)
			(2
				(gEgo scaleY: 128 scaleX: 128 setScaler: 0)
				(Fade)
				(disposeCode doit:)
				(= cycles 2)
			)
			(3
				(if register
					(DisposeScript 900)
				)
				(= cycles 1)
			)
			(4
				(= local7 1)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 15 137 316 137 313 122 19 122
							yourself:
						)
				)
				(gCurRoom roomLookCase: 2)
				(xDrawThePic doit: 895)
				(if (and (GK script:) (== (gCurRoom curLoc:) 13))
					(LoadMany rsVIEW 812 8121 813 8131 815 8151)
				)
				(wallPanel init:)
				(spokeCeiling init:)
				(spokeLights init:)
				(spokeFloor init:)
				(if register
					(gEgo
						normalize: 1
						posn: 300 130
						init:
						setMotion: MoveTo 260 130 self
					)
				else
					(gEgo
						normalize: 0
						posn: 30 130
						init:
						setMotion: MoveTo 55 130 self
					)
				)
				(Hounfour okayToDie: 1)
			)
			(5
				(if (== (xDJ room:) (gCurRoom curLoc:))
					(sDrJohnWalk dispose:)
					(if register
						(self setScript: sBeatTheShitOutOfGabeR)
					else
						(self setScript: sBeatTheShitOutOfGabeL)
					)
				else
					(= cycles 1)
				)
			)
			(6
				(gGame handsOn:)
				(= local2 0)
			)
			(7
				(gGame handsOff:)
				(= register 1)
				(self changeState: 2)
			)
		)
	)
)

(instance sDrJohnWalk of Script
	(properties)

	(method (cue)
		(if client
			(= lastTicks gGameTime)
			(if (not (Hounfour okayToDie:))
				(= ticks 4)
			else
				(self changeState: (+ state 1) &rest)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGkMusic1
					number: 895
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(xDJ room: 1)
				(= seconds 5)
			)
			(1
				(xDJ room: 2)
				(if (== (xDJ room:) (gCurRoom curLoc:))
					(xDJ init: posn: 0 0 setScript: sDJKillGabeInOR 0 1)
					(self dispose:)
				else
					(= seconds local9)
				)
			)
			(2
				(xDJ room: 13)
				(if (== (xDJ room:) (gCurRoom curLoc:))
					(gCurRoom setScript: sBeatTheShitOutOfGabeR)
					(self dispose:)
				else
					(= seconds local9)
				)
			)
			(3
				(xDJ room: 900)
				(if (== (xDJ room:) (gCurRoom curLoc:))
					((ScriptID 900 0) setScript: (ScriptID 900 1) 0 1) ; sCeremonialRoom, sGabeDies
					(self dispose:)
				else
					(= seconds local9)
				)
			)
			(4
				(xDJ room: 13)
				(if (== (xDJ room:) (gCurRoom curLoc:))
					(gCurRoom setScript: sBeatTheShitOutOfGabeL)
					(self dispose:)
				else
					(= seconds local9)
				)
			)
			(5
				(xDJ room: 2)
				(= seconds local9)
				(if (== (xDJ room:) (gCurRoom curLoc:))
					(xDJ init: posn: 0 0 setScript: sDJKillGabeInOR 0 2)
					(self dispose:)
				else
					(= seconds local9)
				)
			)
			(6
				(xDJ room: 1)
				(if (== (xDJ room:) (gCurRoom curLoc:))
					(xDJ init: posn: 0 0 setScript: sDJKillGabeInOR 0 0)
					(self dispose:)
				else
					(= seconds local9)
				)
			)
			(7
				(xDJ room: 802)
				(if (== (xDJ room:) (gCurRoom curLoc:))
					((ScriptID 802 0) setScript: (ScriptID 802 1)) ; sHRoom2, sDJKillGabe2
				else
					(gMessager say: 13 0 14 0 0 900) ; "A door opens and shuts in the distance. Dr. John must have returned to his room."
					(if
						(OneOf
							(Hounfour curLoc:)
							12
							13
							14
							15
							17
							0
							1
							2
							3
							4
							5
							6
							7
							8
							9
							10
							11
							900
						)
						(gGkMusic1
							number: 550
							setLoop: -1
							stop:
							play:
							setVol: 0
							fade: (gGkMusic1 musicVolume:) 5 10 0
						)
					)
				)
				(if (not (gEgo has: 80)) ; hounfourKey
					(ClearFlag 346)
				)
				(= cycles 1)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo theDoor self)
			)
			(1
				(gEgo view: 801 setCel: 0 setLoop: 1 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setCel: 4 setCycle: End self)
				(if (theDoor unlocked:)
					(gGkSound1 setLoop: 1 number: 802 play:)
				)
			)
			(3
				(gEgo normalize: 1)
				(if (theDoor unlocked:)
					(gGkSound1 number: 811 play:)
					(theDoor setCycle: End self)
				else
					(gMessager say: 20 8 14) ; "It's locked."
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(4
				(gEgo setMotion: MoveTo 60 127 self)
			)
			(5
				(sMainHallways cue:)
				(self dispose:)
			)
		)
	)
)

(instance sUnlockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo theDoor self)
			)
			(1
				(gEgo view: 801 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(2
				(gEgo normalize: 1)
				(if (theDoor unlocked:)
					(gMessager say: 20 123 15 0 0) ; "This door isn't locked."
					(gGame handsOn:)
					(self dispose:)
				else
					(switch (gCurRoom curLoc:)
						(0
							(gEgo getPoints: 188 1)
						)
						(7
							(gEgo getPoints: 190 1)
						)
						(10
							(gEgo getPoints: 189 1)
						)
					)
					(theDoor unlocked: 1)
					(gGkSound1 setLoop: 1 number: 811 play:)
					(if (not local8)
						(= local8 1)
						(gMessager say: 20 123 14 0 self) ; "It fits!"
					else
						(= cycles 1)
					)
					(theDoor setCycle: End self)
				)
			)
			(3 0)
			(4
				(gEgo setMotion: MoveTo 60 127 self)
			)
			(5
				(sMainHallways cue:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theDoor setCel: 5)
				(gEgo
					normalize: 4
					setScaler: Scaler 100 53 123 103
					posn: 55 127
					init:
					setMotion: MoveTo 58 130 self
				)
				(Hounfour okayToDie: 1)
			)
			(1
				(gGkSound1 number: 812 play:)
				(theDoor setCycle: Beg self)
				(self dispose:)
			)
		)
	)
)

(instance sEgoInRoundHallway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom roomLookCase: 1)
				(gCurRoom
					curLoc:
						(switch register
							(0
								(if (gCurRoom curLoc:)
									(- (gCurRoom curLoc:) 1)
								else
									11
								)
							)
							(1
								(if (<= (gCurRoom curLoc:) 10)
									(+ (gCurRoom curLoc:) 1)
								else
									0
								)
							)
							(2
								(- (gCurRoom curLoc:) 801)
							)
							(else
								(gCurRoom curLoc:)
							)
						)
				)
				(Fade)
				(if (!= register 2)
					(disposeCode doit:)
				)
				(= cycles 1)
			)
			(1
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 221 148 200 137 192 128 186 117 194 112 221 112 221 104 162 110 117 120 91 127 75 124 55 126 40 146
							yourself:
						)
				)
				(if (OneOf (gCurRoom curLoc:) 0 2 4 6 8 10)
					(gWalkHandler add: hall)
				)
				(if (OneOf (gCurRoom curLoc:) 0 7 10)
					(theDoor unlocked: 0)
				else
					(theDoor unlocked: 1)
				)
				(signFeat init:)
				(orLights init:)
				(ceiling init:)
				(floor init:)
				(keypad init: approachVerbs: 8 123) ; Operate, hounfourKey
				(switch (gCurRoom curLoc:)
					(0
						(= local4 16)
						(theDoor init:)
						(= local1 801)
						(= local5
							((View new:)
								view: 810
								setCel: 0
								setLoop: 6
								posn: 148 52
								setPri: -1
								signal: 0
								noun: 12
								init:
							)
						)
						(doorSign
							view: 810
							setCel: 0
							setLoop: 12
							posn: 45 50
							setPri: 190
							fixPriority: 1
							init:
						)
						(hall init: ignoreActors: 1 approachVerbs: 13) ; Walk
					)
					(1
						(= local4 17)
						(theDoor init:)
						(= local1 802)
						(= local5
							((View new:)
								view: 810
								setCel: 0
								setLoop: 3
								posn: 104 47
								setPri: -1
								signal: 0
								noun: 12
								init:
							)
						)
						(doorSign
							view: 810
							setCel: 1
							setLoop: 12
							posn: 45 50
							setPri: 190
							fixPriority: 1
							init:
						)
					)
					(2
						(= local4 18)
						(theDoor init:)
						(= local1 803)
						(= local5
							((View new:)
								view: 810
								setCel: 0
								setLoop: 7
								posn: 265 65
								setPri: -1
								signal: 0
								noun: 9
								init:
							)
						)
						(doorSign
							view: 810
							setCel: 2
							setLoop: 12
							posn: 45 50
							setPri: 190
							fixPriority: 1
							init:
						)
						(hall init: ignoreActors: 1 approachVerbs: 13) ; Walk
					)
					(3
						(= local4 19)
						(theDoor init:)
						(= local1 804)
						(= local6
							((View new:)
								view: 810
								setCel: 0
								setLoop: 5
								posn: 228 59
								setPri: 190
								fixPriority: 1
								noun: 10
								init:
							)
						)
						(doorSign
							view: 810
							setCel: 3
							setLoop: 12
							posn: 45 50
							setPri: 190
							fixPriority: 1
							init:
						)
					)
					(4
						(= local4 20)
						(theDoor init:)
						(= local1 805)
						(= local6
							((View new:)
								view: 810
								setCel: 0
								setLoop: 8
								posn: 76 85
								signal: 0
								noun: 14
								init:
							)
						)
						(doorSign
							view: 810
							setCel: 4
							setLoop: 12
							posn: 45 50
							setPri: 190
							fixPriority: 1
							init:
						)
						(hall init: ignoreActors: 1 approachVerbs: 13) ; Walk
					)
					(5
						(= local4 21)
						(theDoor init:)
						(= local1 806)
						(= local5
							((View new:)
								view: 810
								setCel: 0
								setLoop: 9
								posn: 6 116
								setPri: 190
								fixPriority: 1
								noun: 14
								init:
							)
						)
						(doorSign
							view: 810
							setCel: 5
							setLoop: 12
							posn: 45 50
							setPri: 190
							fixPriority: 1
							init:
						)
					)
					(6
						(= local4 22)
						(theDoor init:)
						(= local1 807)
						(= local5
							((View new:)
								view: 810
								setCel: 0
								setLoop: 10
								posn: 264 51
								setPri: 190
								fixPriority: 1
								noun: 9
								init:
							)
						)
						(doorSign
							view: 810
							setCel: 6
							setLoop: 12
							posn: 45 50
							setPri: 190
							fixPriority: 1
							init:
						)
						(hall init: ignoreActors: 1 approachVerbs: 13) ; Walk
					)
					(7
						(= local4 23)
						(theDoor init:)
						(= local1 808)
						(= local5
							((View new:)
								view: 810
								setCel: 0
								setLoop: 1
								posn: 9 22
								setPri: 190
								fixPriority: 1
								noun: 8
								init:
							)
						)
						(= local6
							((View new:)
								view: 810
								setCel: 1
								setLoop: 1
								posn: 71 35
								setPri: 3
								noun: 8
								init:
							)
						)
						(doorSign
							view: 810
							setCel: 7
							setLoop: 12
							posn: 45 50
							setPri: 190
							fixPriority: 1
							init:
						)
					)
					(8
						(= local4 24)
						(theDoor init:)
						(= local1 809)
						(= local5
							((View new:)
								view: 810
								setCel: 1
								setLoop: 5
								posn: 3 53
								setPri: 190
								fixPriority: 1
								noun: 10
								init:
							)
						)
						(doorSign
							view: 810
							setCel: 8
							setLoop: 12
							posn: 45 50
							setPri: 190
							fixPriority: 1
							init:
						)
						(hall init: ignoreActors: 1 approachVerbs: 13) ; Walk
					)
					(9
						(= local4 25)
						(theDoor init:)
						(= local1 810)
						(= local5
							((View new:)
								view: 810
								setCel: 0
								setLoop: 3
								posn: 104 47
								setPri: -1
								signal: 0
								noun: 12
								init:
							)
						)
						(= local6
							((View new:)
								view: 810
								setCel: 0
								setLoop: 8
								posn: 76 85
								setPri: -1
								signal: 0
								noun: 14
								init:
							)
						)
						(doorSign
							view: 810
							setCel: 9
							setLoop: 12
							posn: 45 50
							init:
						)
					)
					(10
						(= local4 26)
						(theDoor init:)
						(= local1 811)
						(= local5
							((View new:)
								view: 810
								setCel: 0
								setLoop: 2
								posn: 16 109
								setPri: 190
								fixPriority: 1
								noun: 11
								init:
							)
						)
						(= local6
							((View new:)
								view: 810
								setCel: 1
								setLoop: 2
								posn: 71 100
								setPri: -1
								signal: 0
								noun: 11
								init:
							)
						)
						(doorSign
							view: 810
							setCel: 10
							setLoop: 12
							posn: 45 50
							init:
						)
						(hall init: ignoreActors: 1 approachVerbs: 13) ; Walk
					)
					(11
						(= local4 27)
						(theDoor init:)
						(= local1 812)
						(= local5
							((View new:)
								view: 810
								setCel: 0
								setLoop: 9
								posn: 77 100
								signal: 0
								noun: 14
								init:
							)
						)
						(= local6
							((View new:)
								view: 810
								setCel: 0
								setLoop: 6
								posn: 149 52
								setPri: -1
								signal: 0
								noun: 12
								init:
							)
						)
						(doorSign
							view: 810
							setCel: 11
							setLoop: 12
							posn: 45 50
							init:
						)
					)
				)
				(= cycles 1)
			)
			(2
				(xDrawThePic doit: 810)
				(gGame handsOff:)
				(if (== (xDJ room:) (gCurRoom curLoc:))
					(xDJ init: posn: 0 0 setScript: sDJKillGabeInOR 0 3)
				)
				(switch register
					(0
						(gEgo
							normalize: 5
							setScaler: Scaler 100 53 123 103
							posn: 212 106
							init:
							setMotion: MoveTo 172 115 self
						)
						(Hounfour okayToDie: 1)
					)
					(1
						(gEgo
							normalize: 3
							setScaler: Scaler 100 53 123 103
							posn: 137 163
							init:
							setMotion: MoveTo 137 138 self
						)
						(Hounfour okayToDie: 1)
					)
					(2
						(cond
							((== local1 806))
							((GK script:)
								(if (!= local1 802)
									(gGkMusic1
										number: 895
										setLoop: -1
										stop:
										play:
										setVol: 0
										fade: (gGkMusic1 musicVolume:) 5 10 0
									)
								)
							)
							(else
								(gGkMusic1
									number: 550
									setLoop: -1
									stop:
									play:
									setVol: 0
									fade: (gGkMusic1 musicVolume:) 5 10 0
								)
							)
						)
						(Hounfour okayToDie: 1)
						(self setScript: sCloseDoor self)
					)
					(3
						(gEgo
							normalize: 1
							setScaler: Scaler 100 53 123 103
							posn: 225 133
							init:
							setMotion: MoveTo 182 133 self
						)
						(Hounfour okayToDie: 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(if (== (xDJ room:) (gCurRoom curLoc:))
					(sDJKillGabeInOR cue:)
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sDJKillGabeInOR of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(xDJ
					view: 835
					setCel: 0
					setLoop: 0 0
					setLooper: Grooper
					ignoreActors: 1
					setCycle: StopWalk -1
					setScaler: Scaler 100 53 123 103
				)
				(switch register
					(0
						(xDJ posn: 212 106)
					)
					(1
						(xDJ posn: 137 189 setPri: 120 fixPriority: 1)
					)
					(2
						(xDJ posn: 235 134)
					)
					(3
						(xDJ posn: 180 134)
					)
				)
				(Face xDJ gEgo)
				(if (GK script:)
					(sDrJohnWalk dispose:)
				)
				(gNarrator dispose:)
				(= cycles 2)
			)
			(1
				(if (== register 3)
					(Face xDJ gEgo)
					0
				else
					(= cycles 1)
				)
			)
			(2
				(gGame handsOff:)
				(gEgo setMotion: MyPolyPath 90 132 self)
			)
			(3
				(Face gEgo xDJ)
				(xDJ setCycle: StopWalk -1 setMotion: MoveTo 120 135 self)
			)
			(4
				(Face xDJ gEgo)
				(gMessager say: 13 0 32 1 self 800) ; "Gabriel Knight! So it was YOU on the drums!"
				(Face gEgo xDJ)
			)
			(5
				(gMessager say: 13 0 32 2 self 800) ; "Uh...no. Malia invited me down."
			)
			(6
				(gMessager say: 13 0 32 3 self 800) ; "You lie! You will die for that!"
			)
			(7
				(gEgo hide:)
				(xDJ
					posn: 88 133
					view: 814
					setSpeed: 8
					setCel: 0
					setLoop: 1
					setCycle: CT 9 1 self
				)
			)
			(8
				(gGkSound1 setLoop: 1 number: 891 play:)
				(xDJ setCycle: End self)
			)
			(9
				(xDJ view: 8141 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(10
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(class MyPolyPath of PolyPath
	(properties)

	(method (doit)
		(super doit:)
		(if (OneOf (gEgo cel:) 0 4 8)
			(Face xDJ gEgo)
		)
	)
)

(instance sBeatTheShitOutOfGabeL of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gNarrator dispose:)
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setSpeed: 6 setMotion: MoveTo 154 130 self)
			)
			(2
				(xDJ
					view: 835
					setCel: 0
					setLoop: 0
					init:
					setCycle: StopWalk -1
					posn: 340 130
					setMotion: MoveTo 181 130 self
				)
				(Face gEgo xDJ)
			)
			(3
				(gMessager say: 13 0 32 1 self 800) ; "Gabriel Knight! So it was YOU on the drums!"
				(Face (ScriptID 800 1) gEgo) ; xDJ
				(Face gEgo (ScriptID 800 1)) ; xDJ
			)
			(4
				(gMessager say: 13 0 32 2 self 800) ; "Uh...no. Malia invited me down."
			)
			(5
				(gMessager say: 13 0 32 3 self 800) ; "You lie! You will die for that!"
			)
			(6
				(xDJ hide:)
				(gEgo
					view: 812
					setCel: 0
					setLoop: 1 1
					posn: 154 130
					setCycle: CT 3 1 self
				)
			)
			(7
				(gGkSound1 setLoop: 1 number: 889 play:)
				(gEgo setCel: 4 setCycle: End self)
			)
			(8
				(gEgo setCel: 0 setCycle: CT 3 1 self)
			)
			(9
				(gGkSound1 setLoop: 1 number: 889 play:)
				(gEgo setCel: 4 setCycle: End self)
			)
			(10
				(gEgo setCel: 0 setLoop: 3 1 setCycle: CT 3 1 self)
			)
			(11
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCel: 4 setCycle: End self)
			)
			(12
				(gEgo
					view: 8121
					setCel: 0
					setLoop: 1 1
					setCycle: CT 5 1 self
				)
			)
			(13
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCel: 6 setCycle: End self)
			)
			(14
				(gEgo
					view: 813
					posn: 137 130
					setCel: 0
					setLoop: 1 1
					setCycle: CT 2 1 self
				)
			)
			(15
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCycle: CT 4 1 self)
			)
			(16
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCycle: CT 6 1 self)
			)
			(17
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCycle: CT 9 1 self)
			)
			(18
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCycle: CT 11 1 self)
			)
			(19
				(gEgo setCycle: End self)
			)
			(20
				(gEgo view: 8131 setLoop: 1 1)
				(= register 3)
				(= cycles 1)
			)
			(21
				(gGkSound1 setLoop: 1 number: 892 play:)
				(gEgo setCel: 0 setCycle: CT 4 1 self)
			)
			(22
				(gGkSound1 setLoop: 1 number: 893 play:)
				(gEgo setCel: 5 setCycle: End self)
				(= seconds 4)
			)
			(23
				(-- register)
				(if register
					(-= state 3)
				)
				(= cycles 1)
			)
			(24
				(gEgo
					view: 8121
					setCel: 0
					setLoop: 1 1
					posn: 155 129
					setCycle: CT 5 1 self
				)
			)
			(25
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCel: 6 setCycle: End self)
			)
			(26
				(gEgo
					view: 815
					setCel: 0
					setLoop: 1 1
					setCycle: CT 10 1 self
				)
			)
			(27
				(gGkSound1 setLoop: 1 number: 891 play:)
				(gEgo setCel: 11 setCycle: End self)
			)
			(28
				(gEgo view: 8151 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(29
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance sBeatTheShitOutOfGabeR of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gNarrator dispose:)
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setSpeed: 6 setMotion: MoveTo 174 130 self)
			)
			(2
				(xDJ
					view: 835
					setCel: 0
					setLoop: 0
					init:
					setCycle: StopWalk -1
					posn: -30 130
					setMotion: MoveTo 147 130 self
				)
				(Face gEgo xDJ)
			)
			(3
				(gMessager say: 13 0 32 1 self 800) ; "Gabriel Knight! So it was YOU on the drums!"
				(Face (ScriptID 800 1) gEgo) ; xDJ
				(Face gEgo (ScriptID 800 1)) ; xDJ
			)
			(4
				(gMessager say: 13 0 32 2 self 800) ; "Uh...no. Malia invited me down."
			)
			(5
				(gMessager say: 13 0 32 3 self 800) ; "You lie! You will die for that!"
			)
			(6
				(xDJ hide:)
				(gEgo
					view: 812
					setCel: 0
					setLoop: 0
					posn: 174 130
					setCycle: CT 3 1 self
				)
			)
			(7
				(gGkSound1 setLoop: 1 number: 889 play:)
				(gEgo setCel: 4 setCycle: End self)
			)
			(8
				(gEgo setCel: 0 setCycle: CT 3 1 self)
			)
			(9
				(gGkSound1 setLoop: 1 number: 889 play:)
				(gEgo setCel: 4 setCycle: End self)
			)
			(10
				(gEgo setCel: 0 setLoop: 2 1 setCycle: CT 3 1 self)
			)
			(11
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCel: 4 setCycle: End self)
			)
			(12
				(gEgo
					view: 8121
					setCel: 0
					setLoop: 0 1
					setCycle: CT 5 1 self
				)
			)
			(13
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCel: 6 setCycle: End self)
			)
			(14
				(gEgo
					view: 813
					posn: 191 130
					setCel: 0
					setLoop: 0 1
					setCycle: CT 2 1 self
				)
			)
			(15
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCycle: CT 4 1 self)
			)
			(16
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCycle: CT 6 1 self)
			)
			(17
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCycle: CT 9 1 self)
			)
			(18
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCycle: CT 11 1 self)
			)
			(19
				(gEgo setCycle: End self)
			)
			(20
				(gEgo view: 8131 setLoop: 0 1)
				(= register 3)
				(= cycles 1)
			)
			(21
				(gGkSound1 setLoop: 1 number: 892 play:)
				(gEgo setCel: 0 setCycle: CT 4 1 self)
			)
			(22
				(gGkSound1 setLoop: 1 number: 893 play:)
				(gEgo setCel: 5 setCycle: End self)
				(= seconds 4)
			)
			(23
				(-- register)
				(if register
					(-= state 3)
				)
				(= cycles 1)
			)
			(24
				(gEgo
					view: 8121
					setCel: 0
					setLoop: 0 1
					posn: 174 129
					setCycle: CT 5 1 self
				)
			)
			(25
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCel: 6 setCycle: End self)
			)
			(26
				(gEgo
					view: 815
					setCel: 0
					setLoop: 0 1
					setCycle: CT 10 1 self
				)
			)
			(27
				(gGkSound1 setLoop: 1 number: 891 play:)
				(gEgo setCel: 11 setCycle: End self)
			)
			(28
				(gEgo view: 8151 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(29
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance xDrawThePic of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (gTalkers size:)
			(gMessager cue: 1)
		)
		(gCurRoom picture: param1 style: 14)
		(gCurRoom drawPic: param1)
		(gCurRoom
			roomLookCase:
				(switch param1
					(800 10)
					(810 1)
					(820 9)
					(830 4)
					(840 3)
					(850
						(if (== local1 808) 8 else 7)
					)
					(860 6)
					(870 12)
					(880 5)
					(890 11)
					(895 2)
					(900 13)
				)
		)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
	)
)

(class xDJ of Actor
	(properties
		modNum 802
		x 147
		y 126
		view 830
		signal 16417
		room 802
	)
)

(instance disposeCode of Code
	(properties)

	(method (doit)
		(Hounfour okayToDie: 0)
		(gEgo setScaler: 0)
		(if (gWalkHandler contains: hall)
			(gWalkHandler delete: hall)
		)
		(gFeatures eachElementDo: #dispose release:)
		(gCast eachElementDo: #dispose)
		(FrameOut)
		((gCurRoom obstacles:) dispose:)
		(gCurRoom obstacles: 0)
	)
)

(class theDoor of Prop
	(properties
		noun 2
		x 41
		y 66
		view 811
		cel 3
		signal 16417
		unlocked 1
	)
)

(instance doorSign of View
	(properties
		noun 7
		priority 199
		fixPriority 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 7) ; Look
			(gMessager say: noun theVerb local4)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance hall of View
	(properties
		noun 3
		approachX 195
		approachY 133
		x 225
		y 132
		priority 9
		view 810
	)

	(method (init)
		(super init:)
		(hallFront init: ignoreActors: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				((gCurRoom script:) setScript: sGoToSpoke 0 0)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hallFront of View
	(properties
		x 220
		y 44
		priority 136
		fixPriority 1
		view 810
		cel 1
	)
)

(instance keypad of Feature
	(properties
		noun 20
		nsLeft 65
		nsTop 83
		nsRight 70
		nsBottom 94
		sightAngle 40
		approachX 87
		approachY 127
		x 67
		y 123
		z 35
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(theDoor setScript: sOpenDoor)
				(return 1)
			)
			(123 ; hounfourKey
				(theDoor setScript: sUnlockDoor)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance signFeat of Feature
	(properties
		noun 7
		nsLeft 45
		nsTop 50
		nsRight 62
		nsBottom 61
		sightAngle 40
		approachX 53
		approachY 55
		x 53
		y 126
		z 71
	)

	(method (doVerb theVerb)
		(if (== theVerb 7) ; Look
			(gMessager say: noun theVerb local4)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance ceiling of Feature
	(properties
		noun 6
		sightAngle 40
		x 160
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 21 319 26 253 34 203 50 203 60 176 58 107 48 70 42 35 36 0 25 0 21
					yourself:
				)
		)
		(super init:)
	)
)

(instance spokeCeiling of Feature
	(properties
		noun 6
		sightAngle 40
		x 160
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 39 46 39 31 280 31 281 46
					yourself:
				)
		)
		(super init:)
	)
)

(instance wallPanel of Feature
	(properties
		noun 19
		nsLeft 180
		nsTop 71
		nsRight 229
		nsBottom 92
		sightAngle 40
		approachX 204
		approachY 81
		x 204
		y 121
		z 40
	)
)

(instance floor of Feature
	(properties
		noun 5
		sightAngle 40
		x 160
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 142 73 123 157 108 199 104 199 124 211 135 242 148 0 147
					yourself:
				)
		)
		(super init:)
	)
)

(instance spokeFloor of Feature
	(properties
		noun 5
		sightAngle 40
		x 160
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 38 121 280 121 280 138 39 139
					yourself:
				)
		)
		(super init:)
	)
)

(instance orLights of Feature
	(properties
		noun 15
		sightAngle 40
		x 160
		y 45
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 31 35 31 41 0 34 0 28 yourself:)
				((Polygon new:) type: PTotalAccess init: 99 48 99 52 71 48 71 44 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 172 57 171 61 109 53 107 50
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 202 61 203 64 179 63 179 59
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 251 36 250 42 205 53 204 50
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 319 26 319 32 268 39 268 34
					yourself:
				)
		)
		(super init:)
	)
)

(instance spokeLights of Feature
	(properties
		noun 15
		sightAngle 40
		x 160
		y 45
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 122 31 125 37 72 37 66 31
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 185 37 187 31 247 31 241 37
					yourself:
				)
		)
		(super init:)
	)
)

