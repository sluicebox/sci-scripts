;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use n078)
(use fileScr)
(use n082)
(use LarryRoom)
(use PolyFeature)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm330 0
	gammie 1
	proc330_2 2
	clog 3
	explosion1 4
	explosion2 5
	proc330_6 6
	lever 7
	pistonShaft 8
	hoseWithHole 9
	filter 10
	lid 11
	spigot 12
)

(local
	local0
	[local1 2]
	local3
	local4
)

(procedure (proc330_6)
	(if (gCast contains: wheel)
		(wheel dispose:)
	)
	(= local0 0)
	(if (IsFlag 177)
		(pistonShaft view: 336 setLoop: 2)
	else
		(pistonShaft view: 330 setLoop: 0)
	)
	(pistonShaft show: setCycle: 0 cel: 0 setScript: 0)
	(if (gCast contains: arc)
		(arc dispose:)
	)
	(if (gCast contains: intArc)
		(intArc dispose:)
	)
	(lever show: cel: 0)
	(if (gTimers contains: explosionTimer)
		(explosionTimer dispose:)
	)
	(if (gCast contains: explosion1)
		(explosion1 dispose:)
	)
	(if (gCast contains: explosion2)
		(explosion2 dispose:)
	)
	(boobs view: 330 setLoop: 1 setCel: 0 setScript: 0 setCycle: 0)
	(longArcFx stop:)
	(shortArcFx stop:)
	(leftBoobFx stop:)
	(rightBoobFx stop:)
	(machineHumFx stop:)
	(if (not (gCast contains: hoseWithHole))
		(pipe1 dispose:)
		(pipe2 dispose:)
		(pipe3 dispose:)
		(hoseWithHole init:)
	else
		(pipe1 setCycle: 0 cel: 0)
		(pipe2 setCycle: 0 cel: 0)
		(pipe3 setCycle: 0 cel: 0)
		(hoseWithHole cel: 1 setCycle: 0 setScript: 0)
	)
	(machineHumFx number: 0 client: 0 stop:)
	(if (gCast contains: clog)
		(clog setPri: -1 setLoop: 0 setCel: 0 dispose:)
	)
	(ClearFlag 33)
)

(procedure (proc330_2)
	(return
		(cond
			((not (IsFlag 184)) 11)
			((not (IsFlag 185)) 12)
			((not (IsFlag 186)) 13)
			((not (IsFlag 187)) 14)
			(else 15)
		)
	)
)

(instance rm330 of LarryRoom
	(properties
		noun 1
		picture 330
		horizon 0
		south 310
		autoLoad 0
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 234 153 233 134 289 134 289 123 243 113 243 102 227 92 160 92 159 107 126 107 113 114 93 123 74 126 59 121 50 126 58 128 27 151 128 162 129 130 167 130 166 153
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 215 106 225 115 211 127 180 134 173 129 157 126 140 124 129 118
					yourself:
				)
		)
		(super init: &rest)
		(gEgo init: posn: 83 180 normalize:)
		(hoseWithHole init:)
		(if (== global171 8)
			(gammie init:)
			(if (IsFlag 186)
				(washCloth init:)
			)
			(if (IsFlag 184)
				(siphons init:)
			)
			(if (IsFlag 87)
				(lever cel: 1)
				(gammie setScript: suckingFatScr)
				(longArcFx play: setLoop: -1)
				(if (> gHowFast 3)
					(arc init: setCycle: Fwd)
				)
				(if (> gHowFast 3)
					(intArc init:)
				)
				(wheel init: setCycle: Fwd cycleSpeed: 0)
				(pistonShaft view: 336 setLoop: 3 1 setCycle: Fwd cycleSpeed: 0)
				(machineHumFx number: 335 loop: 1 play: changeHummScr)
			)
		)
		(self setScript: (ScriptID 331 3)) ; enterRoomScr
		(probes init:)
		(pistonShaft init: approachVerbs: 4 1 2 5 6 30) ; Do, Look, Talk, Take, Zipper, lard
		(lever init: approachVerbs: 4) ; Do
		(boobs init:)
		(electrode1 init:)
		(electrode2 init:)
		(if (IsFlag 33)
			(boobs
				view: 336
				setLoop: 4
				setCel: 0
				cycleSpeed: 0
				setScript: boobScr
			)
		)
		(filterTank init:)
		(if (and (IsFlag 30) (== ((gInventory at: 13) owner:) gCurRoomNum)) ; filter
			(filter init:)
		)
		(lid init:)
		(pipes init:)
		(table init:)
		(tanks init:)
		(redPipe init:)
		(blueVagina init:)
		(spigot init: approachVerbs: 4 1 2 5 6 39) ; Do, Look, Talk, Take, Zipper, lamp
		(if (and global110 (== global171 8))
			(SetFlag 86)
		)
	)

	(method (cue)
		(= global213 gTheCursor)
		(gGame setCursor: gNormalCursor)
		(SetCursor 180 105)
		(if
			(==
				(Print
					width: 150
					font: gUserFont
					addTitle: 25 0 41 1 330
					addText: 25 0 0 1 50 0 ; "What? Fast Forward? Now? Miss the good stuff?"
					addButton: 100 25 0 42 1 160 33 ; "Oops"
					addButton: 200 25 0 43 1 50 33 ; "Yes"
					x: 30
					y: 20
					addIcon: 1911 0 0 0 0
					init:
				)
				200
			)
			(proc330_6)
			(if (gCast contains: siphons)
				(siphons dispose:)
			)
			(if (gCast contains: dummyView)
				(dummyView dispose:)
			)
			(= gUseSortedFeatures 1)
			(if (gEgo has: 26) ; minwater
				(gEgo put: 26 gCurRoomNum) ; minwater
			)
			(gammie dispose:)
			(SetFlag 20)
			(gEgo setMotion: 0 normalize: 900 8 setCel: 0 posn: 161 129)
			(= global171 9)
			(gCurRoom setScript: cleanItUpScr)
		else
			(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
			(= global170 self)
		)
		(gGame setCursor: global213)
	)

	(method (edgeToRoom param1)
		(if (and (not script) (== param1 3))
			(cond
				((and (IsFlag 33) (not (gCast contains: gammie)))
					(if (not (gGame isHandsOff:))
						(self setScript: (ScriptID 331 2)) ; notWhileRunningScr
					)
				)
				((gCast contains: gammie)
					(self setScript: (ScriptID 331 0)) ; leaveWithMsgScr
				)
				(else
					(self setScript: (ScriptID 331 1)) ; exitScr
				)
			)
		)
		(return 0)
	)

	(method (doVerb theVerb)
		(if (not gUseSortedFeatures)
			(if (OneOf theVerb 4 1 2 5 6) ; Do, Look, Talk, Take, Zipper
				(gMessager say: noun theVerb 15)
			else
				(gMessager say: noun 0 15) ; "Why are you fooling around? You should be working on Gammie!"
			)
			(return 1)
		else
			(return (super doVerb: theVerb))
		)
	)

	(method (doit)
		(cond
			(script)
			((and (== (gEgo edgeHit:) 3) (< (gEgo y:) 145))
				(gEgo edgeHit: 0)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(ClearFlag 86)
		(= gUseSortedFeatures 1)
		(super dispose: &rest)
	)
)

(instance explosionTimer of Timer
	(properties)
)

(instance cleanItUpScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= cycles 2)
				(proc78_0)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance boobScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(leftBoobFx play:)
				(client setCycle: End self)
			)
			(2
				(rightBoobFx play:)
				(= state -1)
				(= ticks (Max (client cycleSpeed:) 1))
			)
		)
	)
)

(instance pistonShaftScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not register)
					(pistonFx play:)
					(++ state)
					(client cel: 0 setCycle: End self)
				else
					(client cel: 0 setCycle: CT 1 1 self)
				)
			)
			(1
				(pistonFx play:)
				(client setCycle: End self)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance hoseScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: End self)
			)
			(1
				(hoseFlappingFx play:)
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance changeHummScr of Script
	(properties)

	(method (cue)
		(machineHumFx number: 339 loop: 1 play: self)
	)
)

(instance suckingFatScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(pipe1 init: setCycle: Fwd)
				(pipe2 init: setCycle: Fwd)
				(pipe3 init: setCycle: Fwd)
				(hoseWithHole dispose:)
				(cond
					((and (gEgo has: 27) (not (SetFlag 58))) ; orange
						(vat1 init: setCycle: End self)
						(= register 1)
					)
					((IsFlag 58)
						(vat1 init: cel: (vat1 lastCel:))
						(self cue:)
					)
					(else
						(self dispose:)
					)
				)
			)
			(1
				(if (!= (gammie cel:) 1)
					(gammie cel: 1)
				)
				(cond
					((and register (IsFlag 185))
						(vat2 init: setCycle: End self)
						(= register 1)
					)
					((IsFlag 185)
						(vat2 init: cel: (vat2 lastCel:))
						(self cue:)
					)
					(else
						(self dispose:)
					)
				)
			)
			(2
				(if (!= (gammie cel:) 2)
					(gammie cel: 2)
				)
				(cond
					(
						(or
							(and
								(gEgo has: 39) ; washcloth
								((gInventory at: 39) cue: 1) ; washcloth
								(not (IsFlag 59))
							)
							(and (== ((gInventory at: 39) owner:) gCurRoomNum) local3) ; washcloth
						)
						(SetFlag 59)
						(vat3 init: setCycle: End self)
						(= register 1)
					)
					((IsFlag 59)
						(vat3 init: cel: (vat3 lastCel:))
						(self cue:)
					)
					(else
						(self dispose:)
					)
				)
			)
			(3
				(if (!= (gammie cel:) 3)
					(gammie cel: 3)
				)
				(cond
					((and register (IsFlag 186))
						(vat4 init: setCycle: End self)
					)
					((IsFlag 186)
						(vat4 init: cel: (vat4 lastCel:))
						(self cue:)
					)
					(else
						(self dispose:)
					)
				)
			)
			(4
				(if (!= (gammie cel:) 4)
					(gammie cel: 4)
				)
				(cond
					((and (gEgo has: 26) (not (IsFlag 60))) ; minwater
						(SetFlag 60)
						(vat5 init: setCycle: End vat5)
					)
					((IsFlag 60)
						(vat5 init: cel: (vat5 lastCel:))
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance hookUpGammieScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: navStairScr self 1)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager sayRange: 11 4 11 1 3 self) ; "Okay, Gammie, here we go! Lie very still while I stick this in..."
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo
					setSpeed: 12
					view: 335
					setLoop: 0
					setCel: 0
					setCycle: CT 1 1 self
				)
			)
			(5
				(gGlobalSound2 number: 334 loop: 1 play:)
				(gEgo setCycle: CT 4 1 self)
			)
			(6
				(gGlobalSound2 number: 334 loop: 1 play:)
				(gEgo setCycle: CT 7 1 self)
			)
			(7
				(gGlobalSound2 number: 334 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(8
				(gMessager say: 11 4 11 4 self oneOnly: 0) ; "Oh. I knew that!"
			)
			(9
				(siphons init:)
				(gEgo normalize: 900 8 setPri: 125 setCel: 3)
				(= cycles 2)
			)
			(10
				(self setScript: navStairScr self 0)
			)
			(11
				(gEgo normalize: 900 8 cel: 2 setPri: -1)
				(gGame changeScore: 2 184 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance navStairScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 200 setSpeed: 6)
				(if register
					(gEgo setMotion: MoveTo 187 119 self)
				else
					(gEgo
						setMotion:
							MoveTo
							(gammie approachX:)
							(gammie approachY:)
							self
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance turnEgoScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: -1 setHeading: register)
				(= register 0)
			)
		)
	)
)

(instance startWatching of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: -1 setMotion: PolyPath 161 129 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gTheIconBar
					enableIcon:
						(ScriptID 0 7) ; icon4
						(ScriptID 0 6) ; icon3
						(ScriptID 0 5) ; icon2
						(ScriptID 0 9) ; icon6
						(ScriptID 0 4) ; icon1
					curIcon: (ScriptID 0 4) ; icon1
					show:
				)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				(User canInput: 1)
				(dummyView init: hide:)
				(gCast delete: dummyView)
				(gCast addToFront: dummyView)
				(= gUseSortedFeatures 0)
				(self dispose:)
			)
		)
	)
)

(instance dummyView of View
	(properties
		view 98
	)

	(method (handleEvent event)
		(if (not (gammie onMe: event))
			(gCurRoom doVerb: (event message:))
			(event claimed: 1)
			(return)
		)
	)
)

(instance filter of View
	(properties
		noun 7
		sightAngle 40
		approachX 152
		approachY 108
		x 139
		y 78
		priority 70
		fixPriority 1
		view 3311
		loop 4
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1 2 5 6) ; Do, Look, Talk, Take, Zipper
		(if (IsFlag 220)
			(= cel 0)
		else
			(= cel 1)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 5) (not (IsFlag 180))) ; Take
				(gCurRoom setScript: (ScriptID 333 3) 0 1) ; takeOrPutFilterScr
			)
			((OneOf theVerb 4 1 5) ; Do, Look, Take
				(gMessager say: noun theVerb (and (IsFlag 220) 5))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lid of Prop
	(properties
		noun 9
		sightAngle 40
		approachX 152
		approachY 108
		x 137
		y 71
		view 330
		loop 4
		cycleSpeed 13
	)

	(method (cue)
		(gGlobalSound2 number: 367 loop: 1 play:)
		((ScriptID 333 2) cue:) ; operateTankLidScr
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 30)
			(self view: 3311 loop: 0 cel: 3)
		)
		(self approachVerbs: 4 1 2 5 6 64 33 32) ; Do, Look, Talk, Take, Zipper, wrench, filter [ clean ], filter
	)

	(method (doVerb theVerb)
		(cond
			((not (IsFlag 30))
				(filterTank doVerb: theVerb)
			)
			((== theVerb 4) ; Do
				(gCurRoom setScript: (ScriptID 333 2)) ; operateTankLidScr
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance filterTank of Feature
	(properties
		noun 8
		sightAngle 40
		approachX 148
		approachY 108
		x 139
		y 78
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 124 73 137 73 156 74 157 90 147 93 149 105 137 106 125 105 122 100
					yourself:
				)
			approachVerbs: 4 1 2 5 6 64 33 32 ; Do, Look, Talk, Take, Zipper, wrench, filter [ clean ], filter
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0
			(cond
				((IsFlag 30) 8)
				((not (IsFlag 29)) 7)
				(else 17)
			)
		)
		(cond
			((and (== theVerb 64) (not (IsFlag 33))) ; wrench
				(if (OneOf temp0 7 17)
					(gCurRoom setScript: (ScriptID 333 1)) ; wrenchTankScr
				else
					(gMessager say: noun theVerb 8)
				)
			)
			((== theVerb 64) ; wrench
				(gMessager say: 0 0 32) ; "You'd better turn off the Cellulite Drainage Machine before trying anything that fancy, Larry!"
			)
			((== theVerb 33) ; filter [ clean ]
				(if (== temp0 8)
					(gCurRoom setScript: (ScriptID 333 3) 0 0) ; takeOrPutFilterScr
				else
					(gMessager say: noun theVerb temp0)
				)
			)
			((== theVerb 4) ; Do
				(if (!= temp0 7)
					(gCurRoom setScript: (ScriptID 333 2)) ; operateTankLidScr
				else
					(gMessager say: noun theVerb temp0)
				)
			)
			((== theVerb 32) ; filter
				(gMessager say: noun theVerb temp0)
			)
			((== theVerb 1) ; Look
				(gMessager
					say:
						noun
						1
						(if (== temp0 8)
							(cond
								((IsFlag 180) 5)
								((IsFlag 179) 16)
								(else temp0)
							)
						else
							temp0
						)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance probes of Feature
	(properties
		noun 22
		sightAngle 40
		approachX 195
		approachY 131
		x 176
		y 119
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 189 45 186 77 175 76 171 70 150 66 150 46
					yourself:
				)
			approachVerbs: 4 ; Do
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				((not (gCast contains: gammie))
					(if (IsFlag 20)
						(gMessager say: noun theVerb 37) ; "These poor little probes have served their purpose... and quite well."
					else
						(gMessager say: noun theVerb) ; "By their viscous coating, you presume these probes are used to suck the cellulite from the patient's body."
					)
				)
				((not (IsFlag 184))
					(gammie doVerb: theVerb)
				)
				((not (IsFlag 87))
					(gMessager say: noun theVerb 36) ; "How about if I just pull these out right now? What if something happens to you?"
				)
				(else
					(gMessager say: noun theVerb 32) ; "Don't remove the probes from her thighs. Turn off the machine first!"
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance gammie of Actor
	(properties
		noun 11
		sightAngle 40
		approachX 195
		approachY 131
		x 175
		y 122
		z 27
		view 333
		loop 1
	)

	(method (init)
		(super init: &rest)
		(if (not global205)
			(proc79_8 2)
		)
		(self approachVerbs: 4 34) ; Do, orange
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 4) (not (IsFlag 184))) ; Do
				(gCurRoom setScript: hookUpGammieScr)
			)
			((and (== theVerb 4) (not (IsFlag 87))) ; Do
				(gMessager say: noun theVerb 36)
			)
			(
				(or
					(OneOf theVerb 1 2 4 6) ; Look, Talk, Do, Zipper
					(and (== (proc330_2) 13) (OneOf theVerb 35 36)) ; washcloth, washCloth [ wet ]
				)
				(gMessager say: noun theVerb (proc330_2))
			)
			((and (== theVerb 37) (== (proc330_2) 13)) ; washCloth [ chilled ]
				(gCurRoom setScript: giveClothScr)
			)
			((and (== theVerb 38) (== (proc330_2) 14)) ; minwater
				(gCurRoom setScript: giveWaterScr)
			)
			((and (== theVerb 34) (OneOf (proc330_2) 11 12)) ; orange
				(cond
					((not (IsFlag 183))
						(gMessager say: 11 34 12 1) ; "Why, thank you, darling! You certainly know how to treat a woman. But, please don't stop what you're doing. I can just feel myself getting thinner and thinner. And I love it!"
					)
					((IsFlag 184)
						(gCurRoom setScript: giveOrangeScr)
					)
					(else
						(gMessager say: noun theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if global205
			(proc79_7)
		)
		(super dispose:)
	)
)

(instance hoseWithHole of Prop
	(properties
		noun 6
		nsLeft 204
		nsTop 67
		nsRight 244
		nsBottom 82
		sightAngle 40
		approachX 214
		approachY 97
		x 224
		y 79
		z 4
		view 3310
		loop 2
		cel 1
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 182)
			(self cue:)
		)
		(self approachVerbs: 4 1 2 5 6 11) ; Do, Look, Talk, Take, Zipper, belt
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 11) (not (IsFlag 33))) ; belt
				(gCurRoom setScript: (ScriptID 333 0)) ; fixHoleScr
			)
			((== theVerb 11) ; belt
				(gMessager say: 0 0 32) ; "You'd better turn off the Cellulite Drainage Machine before trying anything that fancy, Larry!"
			)
			((IsFlag 182)
				(gMessager say: noun 0 33) ; "The hole in the hose is patched. Now direct your attention to the rest of the Cellulite Drainage Machine."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self view: 330 loop: 3 cel: 0 x: 224 y: 79 z: 4)
	)
)

(instance wheel of Prop
	(properties
		x 12
		y 110
		priority 92
		fixPriority 1
		view 336
		loop 1
		cycleSpeed 3
	)

	(method (onMe)
		(return 0)
	)
)

(instance intArc of Actor
	(properties
		noun 12
		x 262
		y 149
		z 50
		priority 200
		fixPriority 1
		view 336
		loop 8
	)

	(method (init)
		(super init: &rest)
		(self hide: setScript: arcScr)
	)
)

(instance arc of Actor
	(properties
		noun 18
		x 284
		y 38
		view 336
		cycleSpeed 10
	)
)

(instance boobs of Prop
	(properties
		noun 24
		sightAngle 40
		x 91
		y 71
		view 330
		loop 1
		signal 20513
	)
)

(instance table of Feature
	(properties
		noun 21
		sightAngle 40
		approachX 176
		approachY 132
		x 184
		y 121
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					init: 150 120 144 92 180 88 189 82 195 82 217 89 217 96 211 97 210 125 181 131 165 125
					yourself:
				)
			approachVerbs: 4 1 2 5 6 30 ; Do, Look, Talk, Take, Zipper, lard
		)
	)
)

(instance blueVagina of Feature
	(properties
		noun 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					init: 64 82 64 76 74 74 106 76 115 72 123 72 120 107 98 113 65 111
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance redPipe of Feature
	(properties
		noun 23
		sightAngle 40
		x 137
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					init: 145 0 145 16 154 16 155 30 147 30 147 35 141 41 141 56 133 56 133 40 126 40 126 32 120 29 120 16 130 16 130 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tanks of PolyFeature
	(properties
		noun 19
		sightAngle 40
		variableX 1
		variableY 1
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:)
					init: 0 21 119 21 124 34 133 41 133 56 123 71 113 71 114 62 74 62 74 73 64 76 54 89 40 98 41 107 31 112 31 100 16 86 0 86
					yourself:
				)
				((Polygon new:)
					init: 140 42 147 29 155 19 319 18 319 101 309 100 313 64 298 63 309 36 278 58 257 35 257 44 263 64 248 67 252 98 238 96 231 89 217 91 200 82 185 83 184 88 157 89 159 75 141 57
					yourself:
				)
		)
	)
)

(instance electrode1 of Feature
	(properties
		noun 26
		sightAngle 40
		x 274
		y 109
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					init: 265 65 257 46 256 35 278 58 309 36 298 65 280 67
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance electrode2 of Feature
	(properties
		noun 26
		sightAngle 40
		x 274
		y 139
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					init: 231 104 246 110 267 127 282 123 290 92 296 77 305 93 310 126 319 135 319 139 240 139 230 116
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lever of Prop
	(properties
		noun 2
		sightAngle 40
		approachX 248
		approachY 122
		x 266
		y 109
		z 21
		priority 115
		fixPriority 1
		view 330
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					init: 297 64 313 64 310 111 282 119 254 113 249 67
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(cond
					((IsFlag 187)
						(gMessager say: noun theVerb 15) ; "You've had enough of this machine to last you a lifetime! Leave it off."
					)
					((and (IsFlag 179) (not (IsFlag 180)))
						(gMessager say: noun theVerb 16) ; "It won't work. You have the filter, remember?"
					)
					((IsFlag 29)
						(gMessager say: noun theVerb 22) ; "Just before turning the machine on, you realize you forgot to tighten the bolts on the filter compartment."
					)
					((and (not (IsFlag 184)) (gCast contains: gammie))
						(gEgo setHeading: 310)
						(gMessager say: noun theVerb 38) ; "You don't know anything at all about this machine, do you, Larry? You haven't even connected me to it yet!"
					)
					((and (gCast contains: gammie) (not (IsFlag 87)))
						(self setScript: startSuckScr)
					)
					((IsFlag 87)
						(gMessager say: noun theVerb 30) ; "Oh, please don't turn it off yet, Larry honey! I'll make it up to you, I promise!"
					)
					((not (IsFlag 33))
						(self setScript: turnOnMachineScr)
					)
					(else
						(self setScript: turnOffMachineScr)
					)
				)
			)
			((and (== theVerb 1) (not (IsFlag 33))) ; Look
				(gMessager say: noun theVerb 19)
			)
			((== theVerb 6) ; Zipper
				(gMessager say: noun theVerb) ; "Taking the labels literally, eh?"
			)
			(else
				(gMessager say: 2 0 (if (IsFlag 33) 20 else 19))
			)
		)
	)
)

(instance pistonShaft of Prop
	(properties
		noun 13
		sightAngle 40
		approachX 58
		approachY 125
		x 60
		y 93
		view 330
		signal 16417
		cycleSpeed 11
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 177)
			(self view: 336 loop: 2)
		)
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 4 1) ; Do, Look
				(gMessager
					say:
						noun
						theVerb
						(cond
							((IsFlag 177) 2)
							(local0 18)
							(else 1)
						)
				)
			)
			((== theVerb 30) ; lard
				(cond
					((IsFlag 177)
						(gMessager say: noun theVerb 2) ; "The massive shaft is plenty slippery already."
					)
					((IsFlag 33)
						(gMessager say: 0 0 32) ; "You'd better turn off the Cellulite Drainage Machine before trying anything that fancy, Larry!"
					)
					(local0
						(gMessager say: noun 4 18) ; "OUCH! That piston is hot!"
					)
					(else
						(gCurRoom setScript: (ScriptID 333 4) 0 theVerb) ; greasePistonScr
					)
				)
			)
			((== theVerb 17) ; lamp [ lubed ]
				(cond
					((IsFlag 177)
						(gMessager say: noun theVerb 2) ; "The massive shaft is plenty slippery already."
					)
					((IsFlag 33)
						(gMessager say: 0 0 32) ; "You'd better turn off the Cellulite Drainage Machine before trying anything that fancy, Larry!"
					)
					(local0
						(gMessager say: noun 4 18) ; "OUCH! That piston is hot!"
					)
					(else
						(gCurRoom setScript: (ScriptID 333 4) 0 theVerb) ; greasePistonScr
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance explosion2 of Prop
	(properties
		x 138
		y 71
		priority 100
		fixPriority 1
		view 334
		loop 2
	)
)

(instance explosion1 of Prop
	(properties
		x 76
		y 88
		view 334
	)

	(method (cue)
		(= local0 0)
		(self dispose:)
	)
)

(instance clog of Prop
	(properties
		x 123
		y 96
		view 3310
	)
)

(instance siphons of Prop
	(properties
		sightAngle 40
		approachX 195
		approachY 131
		x 172
		y 119
		z 65
		priority 125
		fixPriority 1
		view 330
		loop 5
		cel 1
		signal 20513
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(probes doVerb: theVerb)
	)
)

(instance pipe1 of Prop
	(properties
		x 34
		y 57
		view 336
		loop 5
		cel 3
		cycleSpeed 30
	)

	(method (cue)
		(pipe1 dispose:)
		(pipe2 dispose:)
		(pipe3 dispose:)
		(hoseWithHole init:)
	)
)

(instance pipe2 of Prop
	(properties
		x 123
		y 96
		view 336
		loop 6
		cel 2
		cycleSpeed 30
	)
)

(instance pipe3 of Prop
	(properties
		x 225
		y 75
		view 336
		loop 7
		cel 1
		cycleSpeed 20
	)
)

(instance vat1 of Prop
	(properties
		x 25
		y 91
		view 3313
		cycleSpeed 150
	)
)

(instance vat2 of Prop
	(properties
		x 50
		y 84
		view 3313
		loop 1
		cycleSpeed 150
	)
)

(instance vat3 of Prop
	(properties
		x 247
		y 74
		view 3313
		loop 2
		cycleSpeed 150
	)
)

(instance vat4 of Prop
	(properties
		x 203
		y 74
		view 3313
		loop 3
		cycleSpeed 150
	)
)

(instance vat5 of Prop
	(properties
		x 125
		y 67
		view 3313
		loop 4
		cycleSpeed 150
	)

	(method (cue))
)

(instance washCloth of View
	(properties
		x 202
		y 79
		priority 125
		fixPriority 1
		view 335
		loop 2
	)
)

(instance trySpigot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 901 loop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(gMessager say: 4 4 (and (IsFlag 20) 31) 0 self)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 900 8 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance spigot of View
	(properties
		noun 4
		sightAngle 40
		approachX 131
		approachY 140
		x 138
		y 158
		z 56
		view 330
		loop 6
		cel 1
	)

	(method (onMe param1)
		(if (super onMe: param1)
			(if (== (param1 message:) 4)
				(= approachX 130)
				(= approachY 137)
			else
				(= approachX 131)
				(= approachY 140)
			)
			(return 1)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 39) (IsFlag 20)) ; lamp
				(gCurRoom setScript: fillLampScr)
			)
			((and (OneOf theVerb 63 1 5 2) (IsFlag 20)) ; bastardfile, Look, Take, Talk
				(gMessager say: noun theVerb 31)
			)
			((== theVerb 4) ; Do
				(gCurRoom setScript: trySpigot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pipes of PolyFeature
	(properties
		noun 20
		sightAngle 40
		variableX 1
		variableY 1
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:)
					init: 122 90 130 88 144 88 143 95 119 103 104 96 109 89
					yourself:
				)
				((Polygon new:)
					init: 13 56 36 52 54 56 49 65 36 61 20 65 14 59
					yourself:
				)
		)
	)
)

(instance machineHumFx of Sound
	(properties
		flags 5
		number 335
	)
)

(instance leftBoobFx of Sound
	(properties
		flags 5
		number 363
	)
)

(instance rightBoobFx of Sound
	(properties
		flags 5
		number 364
	)
)

(instance hoseFlappingFx of Sound
	(properties
		flags 5
		number 365
	)
)

(instance longArcFx of Sound
	(properties
		flags 5
		number 331
	)
)

(instance shortArcFx of Sound
	(properties
		flags 5
		number 332
	)
)

(instance steamFx of Sound ; UNUSED
	(properties
		flags 5
		number 336
	)
)

(instance pistonFx of Sound
	(properties
		flags 5
		number 333
	)
)

(instance startSuckScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 30)
			)
			(1
				(gEgo setHeading: 310 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager sayRange: 2 4 11 1 2 self) ; "All right, Gammie! Here we go. I hope I got everything fixed!"
			)
			(4
				(gEgo setHeading: 45 self)
			)
			(5
				(= cycles 2)
			)
			(6
				(self setScript: turnOnMachineScr self)
			)
			(7
				(if (not (lever cel:))
					(self dispose:)
				else
					(self setScript: suckingFatScr)
					(= cycles 2)
				)
			)
			(8
				(SetFlag 87)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance startWheelScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: explosionTimer)
					(explosionTimer dispose:)
				)
				(= register 25)
				(= cycles 2)
			)
			(1
				(boobs
					view: 336
					loop: 4
					cel: 0
					setScript: boobScr
					cycleSpeed: register
				)
				(wheel init: setCycle: Fwd cycleSpeed: register)
				(if (IsFlag 177)
					(pistonShaftScr register: 1)
					(pistonFx number: 334)
					(pistonShaft loop: 2)
				else
					(pistonShaftScr register: 0)
					(pistonFx number: 333)
					(pistonShaft loop: 3)
				)
				(pistonShaft
					view: 336
					cycleSpeed: register
					setScript: pistonShaftScr
				)
				(= cycles 2)
			)
			(2
				(if
					(and
						(== register 15)
						(not (IsFlag 183))
						(IsFlag 177)
						(IsFlag 180)
						(IsFlag 182)
					)
					(gMessager say: 2 4 10 1 self) ; "Is this the moment you've been waiting for?"
				)
				(if
					(or
						(and (not (IsFlag 177)) (> (-- register) 18))
						(and (IsFlag 177) (-- register))
					)
					(wheel cycleSpeed: register)
					(pistonShaft cycleSpeed: register)
					(boobs cycleSpeed: register)
					(-- state)
					(if (not (IsFlag 177))
						(= ticks 45)
					else
						(= ticks 30)
					)
				else
					(= cycles 2)
				)
			)
			(3
				(if (not (IsFlag 177))
					(if (not (gCast contains: explosion1))
						(= local0 1)
						(explosion1 init: loop: 0 setCycle: Fwd)
					)
					(= ticks 240)
				else
					(self dispose:)
				)
			)
			(4
				(gGame handsOff:)
				(self setScript: (ScriptID 332 1) self) ; pistonExplosionScr
			)
			(5
				(EgoDead 9 self)
			)
			(6
				(proc330_6)
				(gEgo
					view: 900
					setLoop: -1
					posn: (lever approachX:) (lever approachY:)
					loop: 8
					cel: 6
				)
				(gGame handsOn:)
				(client dispose:)
			)
		)
	)
)

(instance arcScr of Script
	(properties)

	(method (doit)
		(if (or (!= (gEgo view:) 900) (gTalkers size:) (Print dialog:))
			(shortArcFx number: 0 loop: 1 stop:)
			(client hide:)
		)
		(super doit:)
	)

	(method (dispose)
		(if (shortArcFx handle:)
			(shortArcFx number: 0 stop:)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local4
					(= local4 0)
				else
					(= local4 1)
				)
				(= ticks (Random 180 360))
			)
			(1
				(client show: setCycle: Fwd)
				(if (not (or (gTalkers size:) (Print dialog:)))
					(switch local4
						(1
							(shortArcFx number: 651 loop: -1 play:)
							(= ticks (Random 60 180))
						)
						(0
							(shortArcFx number: 651 loop: 1 play:)
							(= ticks 60)
						)
					)
				else
					(= ticks 90)
				)
			)
			(2
				(shortArcFx number: 0 loop: 1 stop:)
				(client hide: setCycle: 0)
				(self state: -1 cycles: 2)
			)
		)
	)
)

(instance giveOrangeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame changeScore: 6 185)
				(cond
					((!= (gammie script:) suckingFatScr)
						(gammie
							setScript:
								(suckingFatScr start: 1 register: 1 yourself:)
						)
					)
					((!= (gammie cel:) 1)
						(gammie cel: 1)
					)
				)
				(= cycles 2)
			)
			(1
				(gEgo setScript: navStairScr self 1)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo put: 27) ; orange
				(gMessager say: 11 34 12 0 self) ; "Why, thank you, darling! You certainly know how to treat a woman. But, please don't stop what you're doing. I can just feel myself getting thinner and thinner. And I love it!"
			)
			(4
				(turnEgoScr client: turnEgoScr register: 0)
				(gEgo setScript: navStairScr turnEgoScr 0)
				(= cycles 2)
			)
			(5
				(self setScript: eatOrangeScr self)
			)
			(6
				(gEgo normalize: 900 8 cel: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance eatOrangeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (= register 2))
			)
			(1
				(gammie loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gammie setCycle: Beg self)
			)
			(4
				(gammie loop: 3 cel: 0 cycleSpeed: 18 setCycle: Fwd)
				(= ticks 180)
			)
			(5
				(if (-- register)
					(= state 0)
				)
				(= cycles 2)
			)
			(6
				(gammie setCycle: 0 loop: 1 cel: 1)
				(self dispose:)
			)
		)
	)
)

(instance giveClothScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((!= (gammie script:) suckingFatScr)
						(gammie setScript: (suckingFatScr start: 2 yourself:))
					)
					((!= (gammie cel:) 3)
						(gammie cel: 3)
					)
				)
				(= cycles 2)
			)
			(1
				(gEgo setScript: navStairScr self 1)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager sayRange: 11 37 13 1 2 self) ; "Here you go, Gammie!"
			)
			(4
				(= ticks 40)
			)
			(5
				(gEgo
					view: 335
					setLoop: 1
					setCel: 0
					setCycle: 0
					cycleSpeed: 12
				)
				(= cycles 2)
			)
			(6
				(gEgo setCycle: CT 1 1 self)
			)
			(7
				(gGame changeScore: 6 186)
				(gEgo put: 39 gCurRoomNum) ; washcloth
				(washCloth init:)
				(gEgo setCycle: End self)
			)
			(8
				(gEgo normalize: 900 8 setPri: 200 setCel: 3)
				(= ticks 45)
			)
			(9
				(gMessager
					say:
						0
						0
						(switch global185
							(0 21)
							(1 24)
							(2 27)
							(3 23)
							(4 26)
							(5 40)
							(6 25)
							(8 39)
							(7 28)
						)
						0
						self
				)
			)
			(10
				(= ticks 60)
			)
			(11
				(gMessager sayRange: 11 37 13 3 4 self) ; "Well, that does cool my temperature somewhat... but now I think what I really want is a nice bottle of mineral water."
			)
			(12
				(gEgo setScript: navStairScr self 0)
			)
			(13
				(gEgo normalize: 900 8 setCel: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance turnOffMachineScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(if (gCast contains: clog)
					(clog setCycle: 0)
				)
				(self setScript: flipLeverScr self 0)
			)
			(2
				(longArcFx stop:)
				(machineHumFx stop:)
				(machineHumFx number: 369 loop: 1 play:)
				(if register
					(register cue:)
				)
				(ClearFlag 33)
				(if (gCast contains: arc)
					(arc dispose:)
				)
				(if (gCast contains: intArc)
					(intArc dispose:)
				)
				(= cycles 2)
			)
			(3
				(if (or (pistonShaft cycler:) (pistonShaft script:))
					(self setScript: stopWheelScr self)
				else
					(= cycles 2)
				)
			)
			(4
				(if (hoseWithHole script:)
					((hoseWithHole script:) dispose:)
				)
				(if (gCast contains: clog)
					(clog setCycle: Beg self)
				else
					(if (not register)
						(gGame handsOn:)
					)
					(self dispose:)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)
)

(instance flipLeverScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(cond
					((ResCheck 140 383) ; WAVE
						(Load 140 383) ; WAVE
					)
					((ResCheck rsAUDIO 383)
						(Load rsAUDIO 383)
					)
					((ResCheck rsSOUND 383)
						(Load rsSOUND 383)
					)
				)
				(gEgo setCycle: 0 view: 331 loop: 4 setSpeed: 10)
				(gEgo cel: (and (not register) (gEgo lastCel:)))
				(= cycles 2)
			)
			(1
				(lever hide:)
				(gEgo setCycle: (if register End else Beg) self)
			)
			(2
				(gGlobalSound2 number: 383 loop: 1 play: self)
				(if register
					(lever show: cel: 1)
					(SetFlag 33)
				else
					(lever show: cel: 0)
					(ClearFlag 33)
				)
				(gEgo normalize: 900 8 cel: 6)
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance stopWheelScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: explosion1)
					(explosionTimer setReal: explosion1 20)
				)
				(= register (wheel cycleSpeed:))
				(= cycles 2)
			)
			(1
				(if (hoseWithHole script:)
					(hoseWithHole cycleSpeed: (+ register 6))
				)
				(boobs cycleSpeed: register)
				(wheel cycleSpeed: register)
				(if (IsFlag 177)
					(pistonShaft loop: 2)
				else
					(pistonShaft loop: 3)
				)
				(pistonShaft cycleSpeed: register)
				(= cycles 2)
			)
			(2
				(if (<= (++ register) 25)
					(if (hoseWithHole script:)
						(hoseWithHole cycleSpeed: (+ register 6))
					)
					(wheel cycleSpeed: register)
					(pistonShaft cycleSpeed: register)
					(boobs cycleSpeed: register)
					(-- state)
					(= ticks 10)
				else
					(= cycles 2)
				)
			)
			(3
				(pistonShaft setCycle: End self)
			)
			(4
				(wheel dispose:)
				(boobs view: 330 loop: 1 cel: 0 setCycle: 0 setScript: 0)
				(if (IsFlag 177)
					(pistonShaft view: 336 loop: 2 cel: 0)
				else
					(pistonShaft view: 330 loop: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance turnOnMachineScr of Script
	(properties)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsVIEW 336 334)
				(= cycles 2)
			)
			(1
				(self setScript: flipLeverScr self 1)
			)
			(2
				(machineHumFx number: 335 loop: 1 play: changeHummScr)
				(SetFlag 33)
				(arc init: setCycle: Fwd)
				(longArcFx play: setLoop: -1)
				(if (> gHowFast 3)
					(intArc init:)
				)
				(cond
					(register
						(self dispose:)
					)
					((gCast contains: gammie)
						(gEgo setHeading: 310)
						(gMessager sayRange: 2 4 11 3 4 self) ; "This may take a while, Gammie."
					)
					(else
						(+= state 2)
						(self cue:)
					)
				)
			)
			(3
				(if (and (not (IsFlag 112)) (OneOf (proc330_2) 11 12))
					(SetFlag 112)
					(gMessager say: 2 4 11 5 self) ; "You're such a wonderful man, doing all this for little old me. But, could I ask you one favor?"
				else
					(++ state)
					(self cue:)
				)
			)
			(4
				(gMessager sayRange: 2 4 11 6 8 self) ; "Could you bring me a fresh orange? The sound of this machine has made me want to suck on something too!"
			)
			(5
				(if (!= (lever script:) startSuckScr)
					(gGame handsOn:)
				)
				(= cycles 2)
			)
			(6
				(self setScript: startWheelScr self)
			)
			(7
				(= cycles 2)
			)
			(8
				(if (not (IsFlag 182))
					(hoseWithHole cycleSpeed: 6 setScript: hoseScr)
					(= ticks 180)
				else
					(++ state)
					(= cycles 2)
				)
			)
			(9
				(gEgo setHeading: 310 self)
			)
			(10
				(if (not (IsFlag 182))
					(gMessager sayRange: 2 4 3 1 2 self) ; "That sucker!"
				else
					(= cycles 2)
				)
			)
			(11
				(cond
					((not (IsFlag 180))
						(self setScript: (ScriptID 332 0)) ; swellingPipeScr
					)
					((not (IsFlag 182))
						(self setScript: turnOffMachineScr self)
					)
					(else
						(++ state)
						(= cycles 2)
					)
				)
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
			(13
				(if (IsFlag 183)
					(self dispose:)
				else
					(= ticks 120)
				)
			)
			(14
				(if (gGame changeScore: 10 183)
					(= cycles 2)
				else
					(self dispose:)
				)
			)
			(15
				(SetFlag 183)
				(if (and (gCast contains: gammie) (IsFlag 21))
					(gMessager sayRange: 2 4 10 2 3 self) ; "YES!!"
				else
					(gMessager sayRange: 2 4 10 2 4 self) ; "YES!!"
				)
			)
			(16
				(self dispose:)
			)
		)
	)
)

(instance giveWaterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= (gammie cel:) 4)
					(gammie cel: 4)
				)
				(= register 4)
				(= cycles 2)
			)
			(1
				(gGame changeScore: 6 187)
				(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
				(= global170 gCurRoom)
				(gMessager sayRange: 11 38 14 1 2 self) ; "I brought your mineral water, Gammie! And I think you'd better check out your new body. You look wonderful!"
			)
			(2
				(gEgo
					setMotion:
						PolyPath
						(lever approachX:)
						(lever approachY:)
						self
				)
			)
			(3
				(lever setScript: turnOffMachineScr pipe1 self)
				(vat1 setCycle: 0)
				(vat2 setCycle: 0)
				(vat3 setCycle: 0)
				(vat4 setCycle: 0)
				(vat5 setCycle: 0)
			)
			(4
				(= cycles 2)
			)
			(5
				(gEgo
					setMotion:
						PolyPath
						(gammie approachX:)
						(gammie approachY:)
						self
				)
			)
			(6
				(gEgo setScript: navStairScr self 1)
			)
			(7
				(= cycles 2)
			)
			(8
				(siphons dispose:)
				(gEgo
					setSpeed: 12
					view: 335
					cel: 8
					loop: 0
					setCycle: Beg self
				)
			)
			(9
				(= cycles 2)
			)
			(10
				(gEgo put: 26 gCurRoomNum) ; minwater
				(gEgo normalize: 900 8 setPri: 125 cel: 3)
				(= ticks 30)
			)
			(11
				(gEgo setScript: navStairScr self 0)
			)
			(12
				(gEgo setScript: startWatching)
				(washCloth dispose:)
				(gammie view: 3312 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(13
				(gammie z: 0 posn: 187 120 setLoop: 1 setCel: 2)
				(= cycles 2)
			)
			(14
				(if (-- register)
					(gGlobalSound2 number: 517 loop: 1 play:)
					(-- state)
				else
					(= register 4)
				)
				(= ticks 60)
			)
			(15
				(gammie setCycle: Beg self)
			)
			(16
				(gammie
					view: 332
					setSpeed: 8
					posn: 187 121
					setCycle: Walk
					setMotion: MoveTo 199 135 self
				)
			)
			(17
				(= ticks 30)
			)
			(18
				(gMessager sayRange: 11 38 14 3 4 self) ; "You're so svelte! By golly, ol' Doc Swinebutt really knew his business, didn't he?"
			)
			(19
				(siphons priority: 9)
				(gammie view: 339 loop: 1 setSpeed: 10 setCycle: End self)
			)
			(20
				(= ticks 60)
			)
			(21
				(gammie setSpeed: 8 setCycle: CT 4 -1 self)
			)
			(22
				(gammie loop: 0 cel: 0 setSpeed: 10 setCycle: End self)
			)
			(23
				(= ticks 30)
			)
			(24
				(gMessager say: 11 38 14 5 self) ; "Why, I DO look wonderful! All my life I've hauled around a rear balcony, and now it's finally GONE!"
			)
			(25
				(= ticks 120)
			)
			(26
				(gammie setCycle: Beg self)
			)
			(27
				(gammie setSpeed: 8 loop: 1 cel: 4 setCycle: Beg self)
			)
			(28
				(gammie loop: 2 cel: 0 setCycle: CT 1 1 self)
			)
			(29
				(= ticks 45)
			)
			(30
				(gammie setCycle: End self)
			)
			(31
				(= ticks 45)
			)
			(32
				(gammie setCycle: CT 1 -1 self)
			)
			(33
				(= ticks 20)
			)
			(34
				(gMessager sayRange: 11 38 14 6 8 self) ; "I can't wait to show every single person in La Costa Lotta my new body!"
			)
			(35
				(gEgo setHeading: 180)
				(gMessager say: 11 38 14 9) ; "Now that I can have any man I want, I intend to!"
				(gammie
					view: 332
					loop: 2
					setCycle: Walk
					setSpeed: 7
					setMotion: MoveTo (gammie x:) 190 self
				)
				(SetFlag 20)
				(= global171 9)
			)
			(36
				(dummyView dispose:)
				(= gUseSortedFeatures 1)
				(gammie dispose:)
				(= global170 0)
				(gTheIconBar disableIcon: (ScriptID 0 8) show:) ; icon5
				(= cycles 2)
			)
			(37
				(gMessager sayRange: 11 38 14 10 11 self) ; "Wait. Gammie! Stop!!"
			)
			(38
				(= cycles 2)
				(proc78_0)
			)
			(39
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fillLampScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 338
					setLoop: 0 1
					cel: 0
					setCycle: 0
					cycleSpeed: 12
					posn: 140 138
				)
				(= register 0)
				(= ticks 30)
			)
			(1
				(gEgo ignoreActors: 1 setCycle: End self)
			)
			(2
				(gEgo loop: 1 cel: 0)
				(= ticks 10)
			)
			(3
				(++ register)
				(if (< register 9)
					(gGlobalSound2 number: 334 loop: 1 play:)
				)
				(if (< register 10)
					(-- state)
				)
				(gEgo cel: register)
				(= ticks 30)
			)
			(4
				(gGame changeScore: 15 188)
				((gInventory at: 23) cue:) ; lamp
				(gEgo
					posn: (spigot approachX:) (spigot approachY:)
					normalize: 900 8
					cel: 6
				)
				(= cycles 2)
			)
			(5
				(gMessager say: 4 39 31 0 self) ; "Good idea, Larry! It's a well-known fact that early settlers of the Old West often substituted cellulite when they ran out of whale oil!"
			)
			(6
				(gEgo setMotion: PolyPath 114 136 self)
			)
			(7
				(gGame handsOn:)
				((gTheIconBar curIcon:) select:)
				(self dispose:)
			)
		)
	)
)

