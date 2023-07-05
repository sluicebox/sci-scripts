;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 560)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Stage)
(use TargActor)
(use Full)
(use LoadMany)
(use Timer)
(use Motion)
(use Actor)

(public
	rm560 0
)

(local
	lampMsg
	hotFootCounter
	hotFootMsg
	usedWaterMsg
	saveX
	saveY
	healthCounter = 12
	flameCount
	flameCount2 = 4
	flameCount3 = 8
	flowCount
	flame2
	flame3
	[flameTimes 15] = [26 28 29 24 22 28 26 27 22 24 28 23 26 29 22]
	[flamePosn 24] = [264 171 233 155 175 152 134 154 193 145 216 138 227 124 182 94 146 113 48 103 93 106 36 124]
	[flamePri 12] = [13 12 11 11 10 10 9 3 8 6 7 8]
	[flowPosn 16] = [31 91 300 125 301 142 160 100 25 143 101 178 204 183 145 130]
)

(procedure (HeatStroke)
	(EgoDead 1 560 0 #title {Hot Shot Got Caught for Naught}) ; "Too hot? Wear your thermal underwear next time."
)

(instance rm560 of Stage
	(properties
		picture 560
		style 8
		east 580
		west 590
		rightFromX 321
		rightFromY 186
		rightToX 299
		rightToY 169
		leftFromX -10
		leftFromY 99
		leftToX 6
		leftToY 103
	)

	(method (dispose)
		(flowT dispose: delete:)
		(flameT dispose: delete:)
		(flameT2 dispose: delete:)
		(flameT3 dispose: delete:)
		(super dispose:)
	)

	(method (cue)
		(super cue: &rest)
		(if (not (IsFlag 118))
			(HighPrint 560 1) ; "The heat of this room is painful. You feel the sweat pour down from you and hear it sizzle on the ground below. There is the distinct odor of brimstone around you."
			(SetFlag 118)
		)
	)

	(method (init)
		(LoadMany rsVIEW 560 561 19)
		(LoadMany rsSCRIPT 78 956)
		(LoadMany rsSOUND 560 561)
		(= gSpellChecker gAllChecker)
		(gEgo init:)
		(super init:)
		(flame init:)
		(flameT setCycle: flameT 3)
		(if (>= gArcadeLevel 2)
			(= flame2 (flame new:))
			(flame2 init:)
			(flameT2 setCycle: flameT2 13)
			(if (>= gArcadeLevel 3)
				(= flame3 (flame new:))
				(flame3 init:)
				(flameT3 setCycle: flameT3 21)
			)
		)
		(flow init: setCycle: Fwd)
		(flowT setCycle: flowT 3)
		(kludge init: hide:)
		(gCSound number: 560 loop: -1 playBed:)
	)

	(method (doit &tmp thisControl)
		(cond
			(
				(and
					(& (= thisControl (gEgo onControl: 1)) $4000)
					(not (gEgo script:))
				)
				(gEgo setScript: hotFootS)
			)
			((& thisControl $4000))
			(else
				(= saveX (gEgo x:))
				(= saveY (gEgo y:))
			)
		)
		(if (and (gEgo edgeHit:) (!= gEgoGait 4) (not lampMsg)) ; holdingLamp
			(= lampMsg 1)
			(EgoGait 4 0) ; holdingLamp
			(HighPrint 560 2) ; "You rekindle your lamp."
		)
		(if (not (-- healthCounter))
			(= healthCounter 12)
			(cond
				((not (TakeDamage 1))
					(HeatStroke)
				)
				(usedWaterMsg
					(HighPrint 560 3) ; "Most of the water you poured over yourself has evaporated. You are starting to get very hot."
					(= usedWaterMsg 0)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/cave')
				)
				(HighPrint 560 4) ; "This room is filled with molten lava and small geysers."
			)
			((or (Said 'get,get<wet') (Said 'use,apply,splash/water'))
				(cond
					((and (> gDrinksLeft 0) (not usedWaterMsg))
						(HighPrint 560 5) ; "You pour some water over your clothes and feel a little relief from the heat."
						(if (< (-= gDrinksLeft 5) 0)
							(= gDrinksLeft 0)
						)
						(= healthCounter 120)
						(= usedWaterMsg 1)
					)
					(usedWaterMsg
						(HighPrint 560 6) ; "You've just poured some water on yourself. You're still wet."
					)
					(else
						(HighPrint 560 7) ; "You don't have any water, although you wish you did right now."
					)
				)
			)
			((Said 'put,drop,extinguish,douse,(turn<off)/lamp,light')
				(HighPrint 560 8) ; "OK, but you'd better keep it handy. There may be other dark caves to explore."
				(EgoGait 0 0) ; walking
			)
			((Said 'use,rub,rub,light,(turn<on)/lamp,light')
				(HighPrint 560 9) ; "OK, but it seems silly to walk around holding a flame in a place like this."
				(EgoGait 4 0) ; holdingLamp
			)
		)
	)
)

(instance flame of Prop
	(properties
		noun '/fire,flame,geyser'
		description {the flaming geyser}
		lookStr {The flaming geysers seem to spout at predictable intervals.}
		view 560
		signal 16
		cycleSpeed 1
	)

	(method (doit)
		(super doit:)
		(if (and (<= 2 cel 4) (< (gEgo distanceTo: self) 24))
			(gEgo setScript: singeS)
		)
	)
)

(instance flow of Prop
	(properties
		noun '/lava'
		description {lava flow}
		lookStr {The molten lava gives off an intermittent glow and abundant heat.}
		view 560
		loop 1
		signal 16
		cycleSpeed 1
	)
)

(instance hotFootS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 561
					loop: (Random 0 1)
					cel: 0
					illegalBits: 0
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 561
					loop: (Random 0 1)
					cel: 0
					posn: saveX saveY
					setCycle: End self
				)
			)
			(2
				(if (< (++ hotFootCounter) 6)
					(self changeState: 1)
				else
					(= hotFootCounter 0)
					(self cue:)
				)
			)
			(3
				(if (TakeDamage 5)
					(NormalEgo)
					(= cycles 4)
				else
					(HeatStroke)
				)
			)
			(4
				(if (not hotFootMsg)
					(HighPrint 560 10) ; "You stepped on something that wasn't quite solid rock and felt the heat through your boot."
					(= hotFootMsg 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance singeS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo client 0 self)
			)
			(1
				(gEgo view: 19 cel: 0 setCycle: Full 1)
				(= seconds 2)
			)
			(2
				(if (TakeDamage 10)
					(NormalEgo)
					(= cycles 4)
				else
					(HeatStroke)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance flameT of Timer
	(properties)

	(method (cue)
		(super cue: &rest)
		(if (> (++ flameCount) 11)
			(= flameCount 0)
		)
		(flame
			posn: [flamePosn (* flameCount 2)] [flamePosn (+ (* flameCount 2) 1)] 10
			priority: [flamePri flameCount]
			show:
			setCycle: End
		)
		(gMiscSound number: 561 loop: 1 play:)
		(self setCycle: self [flameTimes flameCount])
	)
)

(instance flameT2 of Timer
	(properties)

	(method (cue)
		(super cue: &rest)
		(if (> (++ flameCount2) 11)
			(= flameCount2 0)
		)
		(flame2
			posn: [flamePosn (* flameCount2 2)] [flamePosn (+ (* flameCount2 2) 1)] 10
			priority: [flamePri flameCount2]
			show:
			setCycle: End
		)
		(gMiscSound number: 561 loop: 1 play:)
		(self setCycle: self [flameTimes flameCount2])
	)
)

(instance flameT3 of Timer
	(properties)

	(method (cue)
		(super cue: &rest)
		(if (> (++ flameCount3) 11)
			(= flameCount3 0)
		)
		(flame3
			posn: [flamePosn (* flameCount3 2)] [flamePosn (+ (* flameCount3 2) 1)] 10
			priority: [flamePri flameCount3]
			show:
			setCycle: End
		)
		(gMiscSound number: 561 loop: 1 play:)
		(self setCycle: self [flameTimes flameCount3])
	)
)

(instance flowT of Timer
	(properties)

	(method (cue)
		(super cue: &rest)
		(if (== (++ flowCount) 8)
			(= flowCount 0)
		)
		(flow posn: [flowPosn (* flowCount 2)] [flowPosn (+ (* flowCount 2) 1)])
		(self setCycle: self (Random 6 15))
	)
)

(instance kludge of TargActor
	(properties
		x 100
		y 100
		view 560
		signal 16384
		illegalBits 0
	)

	(method (detectMe)
		(HighPrint 560 11) ; "There is magic throughout this room."
		(return 1)
	)

	(method (calmMe &tmp timeOut)
		(= timeOut (/ [gEgoStats 18] 10)) ; mana
		(flameT setCycle: flameT 0 setReal: flameT timeOut)
		(if (>= gArcadeLevel 2)
			(flameT2 setCycle: flameT2 0 setReal: flameT2 timeOut)
			(if (>= gArcadeLevel 3)
				(flameT3 setCycle: flameT3 0 setReal: flameT3 timeOut)
			)
		)
		(return 1)
	)
)

