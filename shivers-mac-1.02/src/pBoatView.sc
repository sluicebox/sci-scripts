;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3001)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	pBoatView 0
)

(class pBoatView of Prop
	(properties
		view 3152
		nextRoom 0
		crankObj 0
	)

	(method (init)
		(= gPBoatView self)
		(global103 add: self)
		(= crankObj (spCView init: yourself:))
		(self setPri: 25 1)
		(super init: &rest)
		(gCast delete: self)
	)

	(method (setView param1 &tmp temp0 temp1 temp2)
		(if (== (self isNotHidden:) 0)
			(self show:)
		)
		(= temp0 param1)
		(= temp1 (IsFlag 36))
		(= temp2 (IsFlag 37))
		(switch param1
			(0
				(self view: 3152)
				(spCView loop: (not temp1) facing: temp0 show:)
				(efBoatDown init: 5 nextRoom: 3500)
			)
			(1
				(self view: 3152)
				(spCView loop: (not temp2) facing: temp0 show:)
				(efBoatDown init: 5 nextRoom: 3500)
			)
			(2
				(self view: 3154)
				(spCView hide:)
			)
		)
		(UpdateScreenItem self)
	)

	(method (dispose)
		(= gPBoatView 0)
		(spCView dispose:)
		(global103 delete: self)
		(super dispose: &rest)
	)

	(method (hide)
		(spCView hide:)
		(super hide:)
	)

	(method (show)
		(spCView show:)
		(super show:)
	)
)

(class spCView of ShiversProp
	(properties
		view 3150
		cycleSpeed 12
		facing 0
	)

	(method (init)
		(self
			setPri: 35 1
			createPoly: 129 143 108 143 97 137 93 127 96 117 116 108 137 108 151 113 160 121 159 131 153 137 140 144
		)
		(global103 add: self)
		(super init: &rest)
		(gCast delete: self)
	)

	(method (dispose)
		(= gPBoatView 0)
		(global103 delete: self)
		(super dispose: &rest)
	)

	(method (doVerb)
		(if (and (not loop) (!= gCurRoomNum 3500)) ; insideBoat
			(gTheDoits add: self)
			(if (!= gCurRoomNum (pBoatView nextRoom:))
				(self setScript: sCrank)
			else
				(self setScript: sNoCrank)
			)
		)
	)
)

(instance sCrank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10304 0 64 self)
				(= cycles 1)
			)
			(1
				(client setCycle: End)
			)
			(2
				(client cel: 0)
				(gSounds stop: 10304)
				(UpdateScreenItem client)
				(gTheDoits delete: client)
				(gCurRoom newRoom: (pBoatView nextRoom:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNoCrank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10319 0 64 self)
				(= cycles 1)
			)
			(1
				(client setCycle: CT 1 1)
			)
			(2
				(client cel: 0)
				(gSounds stop: 10303)
				(UpdateScreenItem client)
				(gTheDoits delete: client)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance efBoatDown of ExitFeature
	(properties
		nextRoom 3500
	)

	(method (init)
		(self
			createPoly: 30 143 76 103 96 109 90 143 169 143 158 111 184 102 234 143
		)
		(super init: &rest)
	)
)

