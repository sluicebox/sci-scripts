;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1005)
(include sci.sh)
(use Main)
(use Osc)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm1005 0
)

(instance rm1005 of Rm
	(properties
		noun 4
		picture 121
		style -32758
	)

	(method (init)
		(LoadMany rsVIEW 667)
		(NormalEgo 0)
		(gEgo init: hide:)
		(if (IsFlag 59)
			(lightPulse loop: 4)
			(lightCurve loop: 5)
			(statusLight cel: 0)
			(onOffText cel: 1)
		)
		(lightPulse init:)
		(lightCurve init:)
		(statusLight init:)
		(onOffText init:)
		(recepticle init: setOnMeCheck: 1 1024)
		(if (IsFlag 59)
			(gCurRoom setScript: sOnLine)
		else
			(gCurRoom setScript: sOffLine)
		)
		(super init:)
		(gWalkHandler addToFront: self)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 59)
					(gMessager say: noun theVerb 1 0) ; "The warp distributor cap has been replaced and the Goliath's warp drive is now back on line."
				else
					(gMessager say: noun theVerb 2 0) ; "This must be the place where Beatrice ''liberated'' the Goliath's warp distributor cap."
				)
			)
			(else
				(if (== gPrevRoomNum 1000)
					(gCurRoom newRoom: 1000)
				else
					(gCurRoom newRoom: 1001)
				)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose: &rest)
	)
)

(instance sOffLine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(lightPulse loop: 0 cel: 0 setCycle: End self)
				(lightCurve loop: 2 cel: 0 setCycle: End)
			)
			(2
				(lightFlash loop: 1 cel: 0 init: setCycle: Osc 1 self)
			)
			(3
				(lightFlash dispose:)
				(lightPulse setCycle: Osc)
				(lightCurve setCycle: Osc)
				(gGame handsOn:)
			)
			(4
				(= next sInstallCap)
				(self dispose:)
			)
		)
	)
)

(instance sInstallCap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cap init:)
				(SetScore 245 100)
				(capTop
					init:
					setCycle: 0
					setLoop: -1
					setLoop: 8
					setMotion: MoveTo 104 26 self
				)
			)
			(1
				(gSq5Music2 number: 651 setLoop: 1 play:)
				(SetFlag 59)
				(gEgo put: 3) ; Distributor_Cap
				(gMessager say: 1 0 0 0 self) ; "The warp distributor cap snaps into its receptacle with a quiet click and the Goliath's star drive reawakens from its slumber..."
			)
			(2
				(gGame handsOn:)
				(= next sOnLine)
				(self dispose:)
			)
		)
	)
)

(instance sOnLine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cap init:)
				(capTop x: 104 y: 26 init:)
				(lightPulse loop: 4 cel: 0 setCycle: End self)
				(lightCurve loop: 5 cel: 0 setCycle: End)
				(statusLight cel: 0 x: 210 y: 43)
				(onOffText cel: 1)
			)
			(1
				(lightFlash loop: 6 cel: 0 init: setCycle: Osc 1 self)
			)
			(2
				(lightFlash dispose:)
				(lightPulse setCycle: Osc)
				(lightCurve setCycle: Osc)
				(gGame handsOn:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance lightPulse of Prop
	(properties
		x 121
		y 95
		noun 2
		view 667
		signal 16384
	)
)

(instance lightFlash of Prop
	(properties
		x 133
		y 96
		noun 2
		view 667
		loop 1
		signal 16384
	)
)

(instance lightCurve of Prop
	(properties
		x 172
		y 93
		noun 2
		view 667
		loop 2
		signal 16384
	)
)

(instance statusLight of View
	(properties
		x 224
		y 45
		noun 2
		view 667
		loop 9
		cel 1
		signal 16384
	)
)

(instance onOffText of View
	(properties
		x 134
		y 139
		noun 2
		view 667
		loop 3
		signal 16384
	)
)

(instance cap of Actor
	(properties
		x 113
		y 43
		noun 3
		view 667
		loop 7
		priority 6
		signal 24592
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 59)
					(gMessager say: noun theVerb 1 0) ; "The panel hums with electrical activity now that the warp distributor cap has been replaced."
				else
					(gMessager say: noun theVerb 2 0) ; "This appears to be an empty receptacle of some kind."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance capTop of Actor
	(properties
		x 104
		y -10
		noun 3
		view 667
		loop 8
		priority 8
		signal 24592
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 59)
					(gMessager say: noun theVerb 1 0) ; "The panel hums with electrical activity now that the warp distributor cap has been replaced."
				else
					(gMessager say: noun theVerb 2 0) ; "This appears to be an empty receptacle of some kind."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance recepticle of Feature
	(properties
		x 160
		y 95
		noun 3
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(19 ; Distributor_Cap
				(sOffLine cue:)
			)
			(1 ; Look
				(if (IsFlag 59)
					(gMessager say: noun theVerb 1 0) ; "The panel hums with electrical activity now that the warp distributor cap has been replaced."
				else
					(gMessager say: noun theVerb 2 0) ; "This appears to be an empty receptacle of some kind."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

