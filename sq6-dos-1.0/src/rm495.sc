;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 495)
(include sci.sh)
(use Main)
(use SQRoom)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	rm495 0
)

(local
	local0
	local1
)

(instance rm495 of SQRoom
	(properties)

	(method (init)
		(gTheIconBar clearInvItem:)
		(cond
			((and (IsFlag 174) (== global120 2))
				(= global148 0)
				(= style 14)
				(= picture -1)
			)
			((and (IsFlag 171) (== global120 2))
				(bigRoger init:)
				(if (IsFlag 94)
					(bigManual init:)
				)
				(powerLights1 init: setCycle: Fwd)
				(powerLights3 init: setCycle: Fwd)
				(= style 0)
				(= global148 500)
				(= picture 4901)
				(gGSound1 number: 493 play: setVol: 80)
			)
			(else
				(bigRoger init:)
				(powerLights1 init: setCycle: Fwd)
				(powerLights3 init: setCycle: Fwd)
				(gEgo put: 27 get: 103) ; Datacorder, Subroutine_Card
				(ClearFlag 94)
				(ClearFlag 186)
				(ClearFlag 187)
				(ClearFlag 171)
				(ClearFlag 174)
				(SetFlag 158)
				(= global170 1)
				(= global148 610)
				(= global120 3)
				(= style 0)
				(= picture 4902)
				(gGSound1 number: 199 loop: -1 play:)
			)
		)
		(super init:)
		(gTheIconBar clearInvItem:)
		(gTheIconBar setupExit: 0)
		(gTheIconBar clearInvItem:)
		(gGame handsOff:)
		(gTheIconBar clearInvItem:)
		(ClearFlag 73)
		(ClearFlag 74)
		(cond
			((IsFlag 174)
				(gCurRoom setScript: sLeaveDelta)
			)
			((IsFlag 171)
				(Palette 2 0 79 100) ; PalIntensity
				(Palette 2 87 256 100) ; PalIntensity
				(gCurRoom setScript: sEnterDelta)
			)
			(else
				(Palette 2 0 79 100) ; PalIntensity
				(Palette 2 87 256 100) ; PalIntensity
				(gCurRoom setScript: sEnterTheBody)
			)
		)
	)

	(method (dispose)
		(if local1
			(WalkieTalkie killRobot:)
		)
		(if (!= gNewRoomNum 610)
			(gGSound1 fade:)
		)
		(super dispose:)
	)
)

(instance sLeaveDelta of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(if (<= gHowFast 3)
					(PlayVMD 0 {500.vmd}) ; Open
					(PlayVMD 1 0 0) ; Put
				else
					(PlayVMD 0 {1500.vmd}) ; Open
					(PlayVMD 1 109 57) ; Put
				)
				(PlayVMD 21 0 0 320 138) ; Black
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
				(= cycles 1)
			)
			(2
				(ClearFlag 174)
				(gCurRoom newRoom: 490)
				(self dispose:)
			)
		)
	)
)

(instance sEnterDelta of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gAutoRobot
					((WalkieTalkie new:)
						init: 0 4901 self
						holdOnLastCel: 1
						start:
						yourself:
					)
				)
				(= local1 1)
			)
			(1
				(SetFlag 187)
				(SetFlag 174)
				(ClearFlag 73)
				(ClearFlag 171)
				(gCurRoom newRoom: 480)
				(self dispose:)
			)
		)
	)
)

(instance sEnterTheBody of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gAutoRobot
					((WalkieTalkie new:) init: 0 4902 self start: yourself:)
				)
				(= local1 1)
			)
			(1
				(= gAutoRobot
					((WalkieTalkie new:)
						holdOnLastCel: 1
						init: 0 4903 self
						start:
						yourself:
					)
				)
			)
			(2
				(gCurRoom newRoom: 610)
				(self dispose:)
			)
		)
	)
)

(class CockpitProp of Prop
	(properties)

	(method (init)
		(if (IsFlag 171)
			(= view 4911)
		else
			(= view 4912)
		)
		(super init:)
	)
)

(instance powerLights1 of CockpitProp
	(properties
		x 134
		y 66
		priority 124
		fixPriority 1
	)
)

(instance powerLights3 of CockpitProp
	(properties
		x 41
		y 87
		priority 124
		fixPriority 1
		loop 1
	)
)

(instance bigRoger of CockpitProp
	(properties
		x 22
		y 83
		priority 125
		fixPriority 1
		loop 2
	)
)

(instance bigManual of CockpitProp
	(properties
		x 264
		y 85
		priority 125
		fixPriority 1
		loop 3
	)
)

