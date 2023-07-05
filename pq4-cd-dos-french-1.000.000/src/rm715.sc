;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 715)
(include sci.sh)
(use Main)
(use n030)
(use Polygon)
(use Feature)
(use Game)
(use System)

(public
	rm715 0
)

(local
	local0
)

(instance rm715 of Room
	(properties
		noun 2
		picture 715
	)

	(method (init)
		(gGlobalSound0 number: 710 play:)
		(gPqFlags clear: 110)
		(super init: &rest)
		(door init:)
		(opening init:)
		(rail init:)
		(stairs init:)
		(gGame handsOn:)
		(gWalkHandler addToFront: self)
		(gGame handsOn:)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(cond
				((> (event y:) 147)
					(gCurRoom newRoom: 710)
				)
				(local0
					(gMessager say: 4 3 1 0) ; "You stand at the top of the stairs."
				)
				(else
					(= local0 1)
					(gMessager say: 4 3 0 0) ; "You walk to the top of the stairs..."
				)
			)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
					(== (gTheIconBar curInvIcon:) (gInventory at: 5)) ; vest
				)
				(self setScript: wearVest)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gGlobalSound1 number: 981 play:)
		(super dispose:)
	)
)

(instance wearVest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(gMessager say: 2 15 0 1 self) ; "Not knowing what lurks behind the door, you put your vest."
			)
			(2
				(gGame handsOn:)
				(gEgo put: 5 0) ; vest
				(self dispose:)
			)
		)
	)
)

(instance thruDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 4 0 0 self) ; "Pushing the door open..."
			)
			(1
				(gCurRoom newRoom: 725)
			)
		)
	)
)

(instance door of Feature
	(properties
		noun 1
		x 162
		y 12
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 130 17 162 10 167 10 174 93 127 93
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: thruDoor)
				(return 1)
			)
			(49 ; stickMirror
				(opening doVerb: theVerb)
				(return 1)
			)
			(22 ; handgun
				(proc30_0 3 22 0 1 715)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance opening of Feature
	(properties
		noun 3
		x 134
		y 12
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 124 7 164 7 168 11 150 16 132 19 129 90 124 90
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(super doVerb: theVerb)
				(gCurRoom newRoom: 725)
			)
			(49 ; stickMirror
				(gPqFlags set: 110)
				(gGame points: 5 79)
				(gMessager say: noun theVerb 0 0) ; "There is no one in sight. The coast appears clear, Detective."
			)
			(22 ; handgun
				(proc30_0 3 22 0 1 715)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rail of Feature
	(properties
		noun 5
		x 162
		y 12
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 170 52 282 40 282 55 170 55 yourself:)
		)
	)
)

(instance stairs of Feature
	(properties
		noun 4
		x 162
		y 12
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 89 147 90 137 121 94 177 94 211 134 215 145 222 147
				yourself:
			)
		)
	)
)

