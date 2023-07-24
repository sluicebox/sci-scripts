;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3500)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	insideBoat 0
)

(local
	local0
)

(instance insideBoat of ShiversRoom
	(properties
		picture 3500
	)

	(method (init &tmp temp0 temp1)
		(if (<= 3000 gPrevRoomNum 3999)
			(= global548 gPrevRoomNum)
		else
			(gPBoatView show:)
			(= local0 (gPBoatView crankObj:))
			(local0 show:)
		)
		(if (or (== global548 3130) (== global548 3300))
			(self picture: 3510)
		)
		(super init: &rest)
		(= local0 (gPBoatView crankObj:))
		(= temp0 (local0 facing:))
		(gPBoatView view: 3153)
		(local0 view: 3151)
		(if temp0
			(= temp1 (not (IsFlag 37)))
		else
			(= temp1 (not (IsFlag 36)))
		)
		(local0 cel: (* temp1 (local0 lastCel:)) show:)
		(UpdateScreenItem gPBoatView)
		(UpdateScreenItem local0)
		(efExitBack init: 4 nextRoom: global548)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(cond
			((== global548 3300)
				(efExitRight nextRoom: 3310)
				(efExitLeft nextRoom: 3290)
			)
			((== global548 3280)
				(efExitRight nextRoom: 3290)
				(efExitLeft nextRoom: 3310)
			)
			((== global548 3240)
				(efExitRight nextRoom: 3250)
				(efExitLeft nextRoom: 3270)
			)
			((== global548 3260)
				(efExitRight nextRoom: 3270)
				(efExitLeft nextRoom: 3250)
			)
			((== global548 3200)
				(efExitRight nextRoom: 3210)
				(efExitLeft nextRoom: 3230)
			)
			((== global548 3220)
				(efExitRight nextRoom: 3230)
				(efExitLeft nextRoom: 3210)
			)
			((== global548 3160)
				(efExitRight nextRoom: 3170)
				(efExitLeft nextRoom: 3190)
			)
			((== global548 3180)
				(efExitRight nextRoom: 3190)
				(efExitLeft nextRoom: 3170)
			)
			((== global548 3130)
				(efExitRight nextRoom: 3140)
				(efExitLeft nextRoom: 3120)
			)
			((== global548 3150)
				(efExitRight nextRoom: 3120)
				(efExitLeft nextRoom: 3140)
			)
			(else
				(efExitRight nextRoom: global548)
				(efExitLeft nextRoom: global548)
			)
		)
		(hsLever init:)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(if (<= 3000 newRoomNumber 3999)
			(= temp0 (local0 facing:))
			(gPBoatView view: 3152)
			(local0 view: 3150)
			(if temp0
				(local0 loop: (not (IsFlag 37)))
			else
				(local0 loop: (not (IsFlag 36)))
			)
			(UpdateScreenItem gPBoatView)
			(UpdateScreenItem local0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties)

	(method (init)
		(self
			createPoly: 0 0 0 50 100 50 90 63 100 75 120 80 130 80 150 75 160 63 150 50 264 50 264 0 0 0
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties)

	(method (init)
		(self createPoly: 0 51 50 51 50 130 0 130 0 51)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties)

	(method (init)
		(self createPoly: 270 51 220 51 220 130 270 130 270 51)
		(super init: &rest)
	)
)

(instance hsLever of HotSpot
	(properties)

	(method (init)
		(self createPoly: 142 127 142 82 153 76 157 71 170 71 177 110 161 127)
		(super init:)
	)

	(method (doVerb &tmp temp0)
		(proc951_16 160)
		(cond
			((= temp0 (local0 facing:))
				(if (local0 cel:)
					(if (not (IsFlag 36))
						(local0 setScript: sEngage)
						(SetFlag 37)
					else
						(local0 setScript: sNoEngage)
					)
				else
					(ClearFlag 37)
					(local0 setScript: sDisengage)
				)
			)
			((local0 cel:)
				(if (not (IsFlag 37))
					(local0 setScript: sEngage)
					(SetFlag 36)
					(proc951_16 160)
				else
					(local0 setScript: sNoEngage)
				)
			)
			(else
				(ClearFlag 36)
				(local0 setScript: sDisengage)
			)
		)
	)
)

(instance sEngage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits add: client)
				(gSounds play: 10301 0 64 self)
				(client setCycle: Beg)
			)
			(1
				(client setCycle: 0)
				(gSounds stop: 10301)
				(UpdateScreenItem client)
				(gTheDoits delete: client)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNoEngage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits add: client)
				(gSounds play: 10303 0 64 self)
				(client setCycle: CT (- (client cel:) 2) -1 self)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client setCycle: 0)
				(gSounds stop: 10303)
				(UpdateScreenItem client)
				(gTheDoits delete: client)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDisengage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits add: client)
				(gSounds play: 10302 0 64 self)
				(client setCycle: End self)
			)
			(1
				(client setCycle: 0)
				(gSounds stop: 10302)
				(UpdateScreenItem client)
				(gTheDoits delete: client)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

