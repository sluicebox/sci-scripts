;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use n001)
(use Talker)
(use Stage)
(use Guard)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rmPalaceGatesE 0
)

(local
	talkedToEgo
	[standingGuards 2]
	[pacingGuards 2]
	[guardNames 4] = [{I am Kuzay bin Bishr.} {I have been named al-Hajjaj.} {My name is Abd al-Malik.} {I am called Sadik Isfahani.}]
)

(instance palaceGuard of Guard
	(properties)

	(method (init doesPace)
		(if doesPace
			(= illegalBits 0)
			(super init: 1)
			(self setScript: (guardPace new:))
		else
			(super init: 0)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (not talkedToEgo) (< (self distanceTo: gEgo) 30) (not gModelessDialog))
			(Say self 240 0) ; "No one enters the gates of the Palace of the Sultan Harun al-Rashid (May he reign forever!) unless ordered to do so."
			(= talkedToEgo 1)
		)
	)

	(method (showSelf)
		(Say self [guardNames nameNum])
	)

	(method (showText what)
		(switch what
			(13
				(Say self 240 1) ; "It is very well guarded, and only those whom the Sultan trusts and respects may enter."
			)
			(11
				(Say self 240 2) ; "Although few see the Sultan, he sees all. The Sultan knows everyone and everything in the city of Shapeir."
			)
			(else
				(super showText: what)
			)
		)
	)

	(method (endTalk &tmp theScript)
		(super endTalk:)
		(if (self script:)
			((self script:) changeState: (script state:))
		)
	)
)

(instance rmPalaceGatesE of Stage
	(properties
		picture 240
		south 335
		bottomFromX 160
		bottomFromY 250
		bottomExit 4
		bottomToX 160
		bottomToY 188
	)

	(method (init)
		(LoadMany rsVIEW 460 294 295)
		(gEgo init:)
		(NormalEgo)
		(super init:)
		(InitAddToPics leftDoor rightDoor)
		(if (== gElementalState 3)
			(= gRopeHighY 50)
		)
		(if (not gAirPoints)
			(= gAirPoints 808)
		)
		(cond
			((and (<= 0 gTimeODay 4) (!= gElementalState 3))
				((= [standingGuards 0] (palaceGuard new:))
					nameNum: 0
					posn: 204 112
					init: 0
				)
				((= [standingGuards 1] (palaceGuard new:))
					nameNum: 1
					posn: 120 112
					init: 0
				)
				((= [pacingGuards 0] (palaceGuard new:))
					nameNum: 2
					posn: 30 144
					init: 1
				)
				((= [pacingGuards 1] (palaceGuard new:))
					nameNum: 3
					posn: 295 156
					loop: 1
					init: 1
				)
			)
			((== gElementalState 3)
				((ScriptID 241 0) init:) ; airElemental
				(= gSpellChecker gAllChecker)
			)
			(else
				(= gSpellChecker gAllChecker)
			)
		)
		(SetFlag 132)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/castle,courtyard,courtyard')
				)
				(HighPrint 240 3) ; "The courtyard plaza of the Palace of the Sultan is very clean."
			)
			((Said 'cast,drop,use,throw,climb,climb/rope[<magic]')
				(if
					(and
						(< (gEgo y:) 145)
						(== gSpellChecker gAllChecker)
						(gEgo has: 16) ; Rope
					)
					(HighPrint 240 4) ; "You can't use your rope very well underneath the balcony."
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance guardPace of Script
	(properties)

	(method (init theClient)
		(if (> (theClient x:) 160)
			(= start 1)
		)
		(super init: theClient &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: MoveTo 295 (client y:) self)
			)
			(1
				(client setMotion: MoveTo 30 (client y:) self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance leftDoor of PicView
	(properties
		x 133
		y 109
		noun '/door'
		description {the gate}
		lookStr {The doors appear copper clad, judging from the color of them.}
		view 460
		loop 1
		priority 7
		signal 16
	)

	(method (init)
		(if gNight
			(= palette 2)
		else
			(= palette 1)
		)
		(super init:)
	)
)

(instance rightDoor of PicView
	(properties
		x 189
		y 109
		noun '/gate'
		description {the right side of the gate}
		lookStr {The doors appear copper clad, judging from the color of them.}
		view 460
		loop 2
		priority 7
		signal 16
	)

	(method (init)
		(if gNight
			(= palette 2)
		else
			(= palette 1)
		)
		(super init:)
	)
)

