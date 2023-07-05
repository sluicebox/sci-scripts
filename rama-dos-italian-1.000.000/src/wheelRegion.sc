;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use RamaRegion)
(use SaveManager)
(use SoundManager)
(use RegionSFX)
(use n1111)
(use Sound)
(use Actor)
(use System)

(public
	wheelRegion 0
	soundsOfAdvancement 1
	resetWheel 2
	flashLight 3
)

(local
	local0
	local1
)

(class WheelRegion of RamaRegion
	(properties
		wheelPosition 0
		wheelIncrement 1
	)

	(method (init)
		(if
			(and
				(not initialized)
				(or
					(and (IsFlag 61) (not (IsFlag 66)))
					(not (IsFlag 62))
				)
			)
			(SoundManager
				playSounds:
					(sSparks
						setProx:
							2010
							50
							180
							2011
							50
							230
							2012
							25
							260
							2015
							127
							0
							2016
							25
							280
							2018
							25
							280
							2031
							127
							135
						yourself:
					)
					(sAvianSqwauk_1
						setProx:
							2010
							50
							180
							2011
							50
							230
							2012
							25
							260
							2015
							127
							0
							2016
							25
							280
							2018
							25
							280
							2031
							127
							135
						yourself:
					)
					(sAvianSqwauk_2
						setProx:
							2010
							50
							180
							2011
							50
							230
							2012
							25
							260
							2015
							127
							0
							2016
							25
							280
							2018
							25
							280
							2031
							127
							135
						yourself:
					)
			)
		)
		(if (== gPrevRoomNum 2000) ; cplains
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 1020)
		)
		(super init: &rest)
		(= global190 6)
	)

	(method (dispose &tmp temp0)
		(if (== (& $00ff ((ScriptID 200 0) curCornDispenser:)) 1) ; cplainRegion
			(= temp0 (& $ff00 ((ScriptID 200 0) curCornDispenser:))) ; cplainRegion
			((ScriptID 200 0) curCornDispenser: (| temp0 $0002)) ; cplainRegion
		)
		(super dispose:)
	)

	(method (setKeep)
		(= keep (<= 2010 gNewRoomNum 2039)) ; wheelRgn1, wheelHubLadder
	)

	(method (advanceSpokes &tmp temp0)
		(= temp0 wheelPosition)
		(= wheelPosition (mod (+ wheelPosition wheelIncrement) 5))
		(= local0 wheelIncrement)
		(= wheelIncrement (+ (mod wheelIncrement 3) 1))
		(return wheelPosition)
	)

	(method (serialize param1 &tmp [temp0 4])
		(if (and argc param1)
			(super serialize: param1 &rest)
			(self wheelPosition: (SaveManager readWord:))
			(self wheelIncrement: (SaveManager readWord:))
		else
			(super serialize:)
			(SaveManager writeWord: (self wheelPosition:))
			(SaveManager writeWord: (self wheelIncrement:))
		)
	)
)

(instance doorLight of View
	(properties
		x 285
		y 133
		view 2257
	)

	(method (init)
		(switch (wheelRegion wheelPosition:)
			(0
				(= cel 0)
			)
			(1
				(= cel 1)
			)
			(2
				(= cel 2)
			)
			(3
				(= cel 3)
			)
			(4
				(= cel 4)
			)
		)
		(super init: global117)
	)
)

(instance wheelRegion of WheelRegion
	(properties)
)

(instance soundsOfAdvancement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register local0)
				(= cycles 3)
			)
			(1
				(if (>= (-- register) 0)
					(-- state)
					(spokeSound play: self)
				else
					(= cycles 1)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance resetWheel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (wheelRegion wheelPosition:))
				(= cycles 3)
			)
			(1
				(if register
					(= register (mod (+ register 1) 5))
					(-- state)
					(spokeSound play: self)
				else
					(= cycles 1)
				)
			)
			(2
				(wheelRegion wheelPosition: 0 wheelIncrement: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance flashLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(doorLight init: global117)
				(= seconds 1)
			)
			(1
				(doorLight hide:)
				(= ticks 30)
			)
			(2
				(doorLight show:)
				(= ticks 30)
			)
			(3
				(doorLight hide:)
				(= ticks 20)
			)
			(4
				(doorLight show:)
				(= ticks 20)
			)
			(5
				(doorLight hide:)
				(= ticks 20)
			)
			(6
				(doorLight show:)
				(= ticks 20)
			)
			(7
				(doorLight dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance spokeSound of Sound
	(properties
		number 2200
		flags 5
	)
)

(instance sSparks of RegionSFX
	(properties
		number 2218
	)

	(method (pan)
		(super pan: &rest)
		(cond
			((and (== gCurRoomNum 2015) (== ((gCurRoom picObj:) heading:) 0)) ; wheelRgn6
				(self setVol: 0)
			)
			((== gCurRoomNum 2031) ; ruinCU
				(self setVol: 0)
			)
		)
	)

	(method (play)
		(if (or (== gCurRoomNum 2031) (IsFlag 62)) ; ruinCU
			(if (and (IsFlag 61) (not (IsFlag 66)))
				(sAvianSqwauk_1 play: &rest)
			else
				(self setVol: 0)
				(super play: &rest)
			)
		else
			(super play: &rest)
		)
	)
)

(instance sAvianSqwauk_1 of RegionSFX
	(properties
		number 2233
	)

	(method (pan)
		(super pan: &rest)
		(cond
			((and (== gCurRoomNum 2015) (== ((gCurRoom picObj:) heading:) 0)) ; wheelRgn6
				(self setVol: 0)
			)
			((== gCurRoomNum 2031) ; ruinCU
				(self setVol: 0)
			)
		)
	)

	(method (play)
		(cond
			((and (IsFlag 61) (not (IsFlag 66)))
				(super play: &rest)
			)
			((not (IsFlag 62))
				(sSparks play: &rest)
			)
			(else
				(self setVol: 0)
				(super play: &rest)
			)
		)
	)
)

(instance sAvianSqwauk_2 of RegionSFX
	(properties
		number 2234
	)

	(method (pan)
		(super pan: &rest)
		(cond
			((and (== gCurRoomNum 2015) (== ((gCurRoom picObj:) heading:) 0)) ; wheelRgn6
				(self setVol: 0)
			)
			((== gCurRoomNum 2031) ; ruinCU
				(self setVol: 0)
			)
		)
	)

	(method (play)
		(cond
			((and (IsFlag 61) (not (IsFlag 66)))
				(super play: &rest)
			)
			((not (IsFlag 62))
				(sSparks play: &rest)
			)
			(else
				(self setVol: 0)
				(super play: &rest)
			)
		)
	)
)

