;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3020)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Motion)
(use Actor)
(use System)

(public
	s2_3020 0
)

(instance s2_3020 of PQRoom
	(properties
		picture 0
	)

	(method (init)
		(SetFlag 12)
		(super init: &rest)
		((ScriptID 4054 0) changeMusic: 29803) ; kiplandRegion
		(northE init:)
		(westE init:)
		(eastE init:)
		(gCurRoom setScript: sEnterBuilding)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(SetFlag 300)
				(gCurRoom setScript: sEgoFiring)
			)
			(6
				(SetFlag 290)
				(gCurRoom setScript: sEgoFiring)
			)
			(16
				(SetFlag 289)
				(gCurRoom setScript: sEgoFlashBang)
			)
			(45
				(if (not (IsFlag 219))
					(gMessager say: 0 theVerb 2 0) ; "Wrong. GO!"
				)
			)
			(44
				(if (not (IsFlag 219))
					(gMessager say: 0 theVerb 2 0) ; "I gotch ya. Go!"
				)
			)
			(46
				(if (not (IsFlag 219))
					(gMessager say: 0 theVerb 2 0) ; "Correct. Now... GO!"
				)
			)
			(48
				(if (not (IsFlag 219))
					(gMessager say: 0 48 2) ; "Where, pup? Pacmeyer, do you see threat?"
				else
					(gMessager say: 0 48 4) ; "Sierra One reporting. Suspect not observed side one. No suspect movement side one."
				)
			)
			(43
				(if (not (IsFlag 219))
					(gMessager say: 0 theVerb 2 0) ; "What?"
				)
			)
			(42
				(if (not (IsFlag 219))
					(gMessager say: 0 theVerb 2 0) ; "What?"
				)
			)
			(47
				(if (not (IsFlag 219))
					(gMessager say: 0 theVerb 2 0) ; "GO!"
				)
			)
			(47
				(if (not (IsFlag 219))
					(gMessager say: 0 theVerb 2 0) ; "GO!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)
)

(instance sEnterBuilding of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette 2 42 254 0) ; PalIntensity
				(Load rsPIC 3020)
				(Load rsVIEW 30201)
				(= seconds 1)
			)
			(1
				(gCurRoom drawPic: 3020)
				(proc4_6 30200 -8 72 0 0 378 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(2
				(gMessager say: 0 0 1 2 self) ; "Entry team in."
			)
			(3
				(team2 init:)
				(proc4_5)
				(gGame handsOn:)
				(= seconds 8)
			)
			(4
				(gGame handsOff:)
				(SetFlag 222)
				(SetFlag 219)
				(team2 setPri: 378 setCycle: End self)
			)
			(5
				(team2 dispose:)
				(gGame handsOn:)
				(= seconds 8)
			)
			(6
				(gGame handsOff:)
				(gMessager say: 0 0 2 0 self) ; "Pup! Where are you? Get moving!"
			)
			(7
				(gGame handsOn:)
				(= seconds 8)
			)
			(8
				(gGame handsOff:)
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(9
				(= seconds 2)
			)
			(10
				(SetFlag 209)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance sEgoFiring of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 10 3 0 self) ; "Cease fire! Cease fire!"
			)
			(1
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance sEgoFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 30203)
				(cannister
					view: 30202
					loop: 0
					cel: 0
					posn: 223 311
					init:
					setCycle: End self
				)
				(if (gCast contains: team2)
					(gMessager say: 0 16 2 1) ; "Compromised!"
				else
					(gMessager say: 0 16 4 1) ; "Compromised!"
				)
			)
			(1
				(gFxSound number: 1002 loop: 1 play:)
				(cannister
					view: 30203
					loop: 0
					cel: 0
					posn: 218 12
					setPri: 600
					init:
				)
				(= cycles 2)
			)
			(2
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(cannister dispose:)
				(= cycles 1)
			)
			(3
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(if (gCast contains: team2)
					(team2 setPri: 378 setCycle: End)
					(gMessager say: 0 16 2 2 self) ; "Status! Status!"
				else
					(gMessager say: 0 16 4 2 self) ; "Status! Status!"
				)
			)
			(5
				(if (team2 cycler:)
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance officerShot of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp0
					(switch register
						(1 9014)
						(2 9016)
						(else 9012)
					)
				)
				(gGame showCloseUp: temp0 -1 -1 self 1)
			)
			(1
				(gMessager say: 1 10 3 0 self) ; "Cease fire! Cease fire!"
			)
			(2
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 94)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance team2 of Prop
	(properties
		x -8
		y 389
		view 30201
	)

	(method (onMe param1 &tmp temp0)
		(= scratch 1)
		(if (and (= temp0 (super onMe: param1)) (>= (param1 x:) 70))
			(= scratch 2)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: officerShot 0 scratch)
			)
			(10
				(gCurRoom setScript: officerShot 0 scratch)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance westE of HotSpot
	(properties
		nsLeft 191
		nsTop 22
		nsRight 260
		nsBottom 356
		type 32770
	)

	(method (doVerb)
		(gCurRoom newRoom: 3030) ; s2_3030
	)
)

(instance northE of HotSpot
	(properties
		nsLeft 230
		nsTop 26
		nsRight 385
		nsBottom 358
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 3470) ; s2_3470
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 352
		nsTop 25
		nsRight 417
		nsBottom 358
		type 8194
	)

	(method (doVerb)
		(gCurRoom newRoom: 3490) ; s2_3490
	)
)

(instance cannister of Prop
	(properties)
)

