;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use n078)
(use n079)
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
)

(local
	local0
	[local1 2]
	local3
)

(procedure (proc330_6)
	(wheel dispose:)
	(= local0 0)
	(if (IsFlag 177)
		(pistonShaft view: 336 loop: 2 cel: 0)
	else
		(pistonShaft view: 330 loop: 0)
	)
	(pistonShaft setCycle: 0 cel: 0 show:)
	(arc dispose:)
	(intArc dispose:)
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
	(boobs view: 330 loop: 1 cel: 0 setScript: 0 setCycle: 0)
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
	)
	(clog setPri: -1 loop: 0 cel: 0 dispose:)
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
				(arc init: setCycle: Fwd)
				(intArc init:)
				(wheel init: setCycle: Fwd cycleSpeed: 0)
				(pistonShaft view: 336 setCycle: Fwd cycleSpeed: 0)
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
			(boobs view: 336 loop: 4 cel: 0 cycleSpeed: 0 setScript: boobScr)
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
		(spigot init: stopUpd: approachVerbs: 4 1 2 5 6 39) ; Do, Look, Talk, Take, Zipper, lamp
		(if (and global110 (== global171 8))
			(SetFlag 86)
		)
	)

	(method (cue)
		(SetCursor 231 86)
		(if
			(==
				(Print
					addTitle: 25 0 41 1 330
					addText: 25 0 0 1 0 0 ; "What? Fast Forward? Now? Miss the good stuff?"
					addButton: 100 25 0 42 1 5 35 ; "Oops"
					addButton: 200 25 0 43 1 150 35 ; "Yes"
					init:
				)
				200
			)
			(proc330_6)
			(siphons dispose:)
			(dummyView dispose:)
			(= gUseSortedFeatures 1)
			(if (gEgo has: 26) ; minwater
				(gEgo put: 26 gCurRoomNum) ; minwater
			)
			(gammie dispose:)
			(SetFlag 20)
			(gEgo setMotion: 0 normalize: 900 8 cel: 0 posn: 161 129)
			(= global171 9)
			(gCurRoom setScript: cleanItUpScr)
		else
			((ScriptID 0 8) enable:) ; icon5
			(= global170 self)
		)
	)

	(method (edgeToRoom param1)
		(if (== param1 3)
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
		(if (and (== (gEgo edgeHit:) EDGE_BOTTOM) (< (gEgo y:) 145))
			(gEgo edgeHit: EDGE_NONE)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(ClearFlag 86)
		(= gUseSortedFeatures 1)
		(DisposeScript 331)
		(DisposeScript 332)
		(DisposeScript 333)
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

(instance flipLeverScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lever hide:)
				(gEgo view: 331 loop: 4 setSpeed: 10)
				(if register
					(gEgo cel: 0 setCycle: End self)
				else
					(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
				)
			)
			(1
				(gGlobalSound2 loop: 1 number: 330 play:)
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
			(2
				(self dispose:)
			)
		)
	)
)

(instance arcScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 60 300))
			)
			(1
				(shortArcFx play:)
				(client show: setCycle: Fwd)
				(= ticks (Random 60 120))
			)
			(2
				(shortArcFx stop:)
				(client hide: setCycle: 0)
				(self state: -1 cycles: 2)
			)
		)
	)

	(method (dispose)
		(if (shortArcFx handle:)
			(shortArcFx stop:)
		)
		(super dispose:)
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
				(gEgo posn: (lever approachX:) (lever approachY:) cel: 6)
				(gGame handsOn:)
				(client dispose:)
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
		(machineHumFx number: 339 loop: -1 play:)
	)
)

(instance turnOnMachineScr of Script
	(properties)

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
				(intArc init:)
				(if (!= (lever script:) startSuckScr)
					(gGame handsOn:)
				)
				(= cycles 2)
			)
			(3
				(self setScript: startWheelScr self)
			)
			(4
				(= cycles 2)
			)
			(5
				(if (not (IsFlag 182))
					(hoseWithHole cycleSpeed: 6 setScript: hoseScr)
					(= ticks 180)
				else
					(++ state)
					(= cycles 2)
				)
			)
			(6
				(gMessager say: 2 4 3 1 2) ; "That sucker!"
			)
			(7
				(if (not (IsFlag 180))
					(self setScript: (ScriptID 332 0)) ; swellingPipeScr
				else
					(= cycles 2)
				)
			)
			(8
				(if (IsFlag 183)
					(self dispose:)
				else
					(= ticks 120)
				)
			)
			(9
				(if (gGame changeScore: 10 183)
					(= cycles 2)
				else
					(self dispose:)
				)
			)
			(10
				(if (IsFlag 21)
					(gMessager say: 2 4 10 2 self oneOnly: 0) ; "YES!!"
				else
					(gMessager say: 2 4 10 2 3 self) ; "YES!!"
				)
			)
			(11
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
				(arc dispose:)
				(intArc dispose:)
				(= cycles 2)
			)
			(3
				(self setScript: stopWheelScr self)
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
				(vat1 stopUpd:)
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
				(vat2 stopUpd:)
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
				(vat3 stopUpd:)
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
				(vat4 stopUpd:)
				(if (!= (gammie cel:) 4)
					(gammie cel: 4)
				)
				(cond
					((and (gEgo has: 26) (not (IsFlag 60))) ; minwater
						(SetFlag 60)
						(vat5 init: setCycle: End vat5)
					)
					((IsFlag 60)
						(vat5 init: cel: (vat5 lastCel:) stopUpd:)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance startSuckScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 4 11 1 2 self) ; "All right, Gammie! Here we go. I hope I got everything fixed!"
			)
			(1
				(self setScript: turnOnMachineScr self)
			)
			(2
				(self setScript: suckingFatScr)
				(= cycles 2)
			)
			(3
				(gMessager say: 2 4 11 3 self oneOnly: 0) ; "This may take a while, Gammie."
			)
			(4
				(SetFlag 87)
				(gGame handsOn:)
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
				(gMessager say: 11 4 11 1 3 self) ; "Okay, Gammie, here we go! Lie very still while I stick this in..."
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo
					setSpeed: 12
					view: 335
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(5
				(gMessager say: 11 4 11 4 self oneOnly: 0) ; "Oh. I knew that!"
			)
			(6
				(siphons init:)
				(gEgo normalize: 900 8 setPri: 14 cel: 3)
				(= cycles 2)
			)
			(7
				(self setScript: navStairScr self 0)
			)
			(8
				(gEgo normalize: 900 8 cel: 2 setPri: -1)
				(gGame changeScore: 2 184)
				(gGame handsOn:)
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
				(gEgo setPri: 14 setSpeed: 6)
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
				(gMessager say: 11 37 13 1 2 self) ; "Here you go, Gammie!"
			)
			(4
				(= ticks 40)
			)
			(5
				(gEgo view: 335 loop: 1 cel: 0 setCycle: 0 cycleSpeed: 12)
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
				(gEgo normalize: 900 8 setPri: 14 cel: 3)
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
				(gMessager say: 11 37 13 3 self oneOnly: 0) ; "Well, that does cool my temperature somewhat... but now I think what I really want is a nice bottle of mineral water."
			)
			(12
				(gEgo setScript: navStairScr self 0)
			)
			(13
				(gEgo normalize: 900 8 cel: 2)
				(gGame handsOn:)
				(self dispose:)
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
					enable:
						(ScriptID 0 7) ; icon4
						(ScriptID 0 6) ; icon3
						(ScriptID 0 5) ; icon2
						(ScriptID 0 9) ; icon6
						(ScriptID 0 4) ; icon1
					curIcon: (ScriptID 0 4) ; icon1
				)
				(gGame setCursor: ((ScriptID 0 4) cursor:)) ; icon1
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

(instance giveWaterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= (gammie cel:) 4)
					(gammie cel: 4)
				)
				(= cycles 2)
			)
			(1
				(gGame changeScore: 6 187)
				((ScriptID 0 8) enable:) ; icon5
				(= global170 gCurRoom)
				(gMessager say: 11 38 14 1 2 self) ; "I brought your mineral water, Gammie! And I think you'd better check out your new body. You look wonderful!"
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
				(gEgo normalize: 900 8 setPri: 14 cel: 3)
				(= cycles 2)
			)
			(11
				(gEgo setScript: navStairScr self 0)
			)
			(12
				(gEgo setScript: startWatching)
				(washCloth dispose:)
				(gammie view: 3312 loop: 0 cel: 0 setCycle: End self)
			)
			(13
				(= ticks 30)
			)
			(14
				(gammie z: 0 posn: 187 120 loop: 1 cel: 0 setCycle: End self)
			)
			(15
				(= ticks 120)
			)
			(16
				(gammie setCycle: Beg self)
			)
			(17
				(gammie
					setSpeed: 8
					view: 332
					posn: 187 121
					setCycle: Walk
					setMotion: MoveTo 199 135 self
				)
			)
			(18
				(= ticks 30)
			)
			(19
				(gMessager say: 11 38 14 3 4 self) ; "You're so svelte! By golly, ol' Doc Swinebutt really knew his business, didn't he?"
			)
			(20
				(siphons priority: 9)
				(gammie view: 339 loop: 1 setSpeed: 10 setCycle: End self)
			)
			(21
				(= ticks 60)
			)
			(22
				(gammie setSpeed: 8 setCycle: CT 4 -1 self)
			)
			(23
				(gammie loop: 0 cel: 0 setSpeed: 10 setCycle: End self)
			)
			(24
				(= ticks 30)
			)
			(25
				(gMessager say: 11 38 14 5 self) ; "Why, I DO look wonderful! All my life I've hauled around a rear balcony, and now it's finally GONE!"
			)
			(26
				(= ticks 120)
			)
			(27
				(gammie setCycle: Beg self)
			)
			(28
				(gammie setSpeed: 8 loop: 1 cel: 4 setCycle: Beg self)
			)
			(29
				(gammie loop: 2 cel: 0 setCycle: CT 1 1 self)
			)
			(30
				(= ticks 45)
			)
			(31
				(gammie setCycle: End self)
			)
			(32
				(= ticks 45)
			)
			(33
				(gammie setCycle: CT 1 -1 self)
			)
			(34
				(= ticks 20)
			)
			(35
				(gMessager say: 11 38 14 6 9 self) ; "I can't wait to show every single person in La Costa Lotta my new body!"
			)
			(36
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
			(37
				(dummyView dispose:)
				(= gUseSortedFeatures 1)
				(gammie dispose:)
				(= global170 0)
				((ScriptID 0 8) disable:) ; icon5
				(= cycles 2)
			)
			(38
				(gMessager say: 11 38 14 10 11 self) ; "Wait. Gammie! Stop!!"
			)
			(39
				(= cycles 2)
				(proc78_0)
			)
			(40
				(gGame handsOn:)
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
		x 139
		y 78
		noun 7
		sightAngle 40
		approachX 152
		approachY 108
		view 3311
		loop 4
		priority 2
		signal 16
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
		x 137
		y 71
		noun 9
		sightAngle 40
		approachX 152
		approachY 108
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
		x 139
		y 78
		noun 8
		sightAngle 40
		approachX 152
		approachY 108
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
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
		x 176
		y 119
		noun 22
		sightAngle 40
		approachX 195
		approachY 131
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
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
		x 175
		y 122
		z 27
		noun 11
		sightAngle 40
		approachX 195
		approachY 131
		view 333
		loop 1
	)

	(method (init)
		(super init: &rest)
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
			((and (== theVerb 34) (== (proc330_2) 12)) ; orange
				(if (IsFlag 87)
					(gCurRoom setScript: giveOrangeScr)
				else
					(gMessager say: noun theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hoseWithHole of Prop
	(properties
		x 225
		y 75
		noun 6
		sightAngle 40
		approachX 214
		approachY 97
		view 331
		loop 2
		cel 1
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 182)
			(self view: 330 loop: 3 cel: 0)
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
)

(instance wheel of Prop
	(properties
		x 12
		y 110
		view 336
		loop 1
		priority 1
		signal 16
		cycleSpeed 3
	)

	(method (onMe)
		(return 0)
	)
)

(instance intArc of Actor
	(properties
		x 262
		y 149
		z 50
		noun 12
		view 336
		loop 8
		priority 14
		signal 4112
	)

	(method (init)
		(super init: &rest)
		(self hide: setScript: arcScr)
	)
)

(instance arc of Actor
	(properties
		x 284
		y 38
		noun 18
		view 336
		cycleSpeed 10
	)
)

(instance boobs of Prop
	(properties
		x 91
		y 71
		noun 24
		sightAngle 40
		view 330
		loop 1
		signal 4096
	)
)

(instance table of Feature
	(properties
		x 184
		y 121
		noun 21
		sightAngle 40
		approachX 176
		approachY 132
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
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
			setOnMeCheck:
				2
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
		x 137
		y 100
		noun 23
		sightAngle 40
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
		x 274
		y 109
		noun 26
		sightAngle 40
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
		x 274
		y 139
		noun 26
		sightAngle 40
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
		x 266
		y 109
		z 21
		noun 2
		sightAngle 40
		approachX 248
		approachY 122
		view 330
		loop 2
		priority 7
		signal 16
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
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
		x 42
		y 100
		noun 13
		sightAngle 40
		approachX 58
		approachY 125
		view 330
		signal 16384
		cycleSpeed 11
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 177)
			(self view: 336 loop: 2)
		)
	)

	(method (doVerb theVerb &tmp [temp0 200])
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
		view 334
		loop 2
		priority 4
		signal 16400
	)
)

(instance explosion1 of Prop
	(properties
		x 76
		y 88
		view 334
		priority 8
		signal 16
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
		view 331
		signal 16384
	)
)

(instance siphons of Prop
	(properties
		x 173
		y 119
		z 65
		sightAngle 40
		approachX 195
		approachY 131
		view 330
		loop 5
		cel 1
		priority 9
		signal 4112
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
		signal 16384
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
		x 20
		y 85
		view 3313
		cycleSpeed 150
	)
)

(instance vat2 of Prop
	(properties
		x 51
		y 79
		view 3313
		loop 1
		cycleSpeed 150
	)
)

(instance vat3 of Prop
	(properties
		x 248
		y 71
		view 3313
		loop 2
		cycleSpeed 150
	)
)

(instance vat4 of Prop
	(properties
		x 204
		y 73
		view 3313
		loop 3
		cycleSpeed 150
	)
)

(instance vat5 of Prop
	(properties
		x 161
		y 76
		view 3313
		loop 4
		cycleSpeed 150
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance washCloth of View
	(properties
		x 202
		y 79
		view 335
		loop 2
		priority 9
		signal 16
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
					loop: 0
					cel: 0
					setCycle: 0
					cycleSpeed: 12
					posn: 140 138
				)
				(= ticks 30)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gEgo loop: 1 setCycle: End self)
			)
			(3
				(gGame changeScore: 15 188)
				((gInventory at: 23) cue:) ; lamp
				(gEgo
					posn: (spigot approachX:) (spigot approachY:)
					normalize: 900 8
					cel: 6
				)
				(= cycles 2)
			)
			(4
				(gMessager say: 4 39 31 0 self) ; "Good idea, Larry! It's a well-known fact that early settlers of the Old West often substituted cellulite when they ran out of whale oil!"
			)
			(5
				(gGame handsOn:)
				((gTheIconBar curIcon:) select:)
				(self dispose:)
			)
		)
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
		x 138
		y 138
		z 36
		noun 4
		sightAngle 40
		approachX 131
		approachY 140
		view 330
		loop 6
		cel 1
		signal 20480
	)

	(method (onMe param1)
		(return
			(if (super onMe: param1)
				(if (== (param1 message:) 4)
					(= approachX 130)
					(= approachY 137)
				else
					(= approachX 131)
					(= approachY 140)
				)
				1
			)
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
		flags 1
		number 335
	)
)

(instance leftBoobFx of Sound
	(properties
		flags 1
		number 363
	)
)

(instance rightBoobFx of Sound
	(properties
		flags 1
		number 364
	)
)

(instance hoseFlappingFx of Sound
	(properties
		flags 1
		number 365
	)
)

(instance longArcFx of Sound
	(properties
		flags 1
		number 331
	)
)

(instance shortArcFx of Sound
	(properties
		flags 1
		number 332
		loop -1
	)
)

(instance steamFx of Sound ; UNUSED
	(properties
		flags 1
		number 336
	)
)

(instance pistonFx of Sound
	(properties
		flags 1
		number 333
	)
)

