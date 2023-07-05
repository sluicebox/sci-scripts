;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 472)
(include sci.sh)
(use Main)
(use n013)
(use Scaler)
(use Osc)
(use PolyPath)
(use StopWalk)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	theOpeningCartoon 0
	leaveRoom 1
	enterEgoScript 2
	kneelingCop 3
)

(local
	local0
)

(procedure (localproc_0 param1)
	(if (and (!= param1 (ScriptID 470 6)) (gCast contains: (ScriptID 470 6))) ; limo, limo
		((ScriptID 470 6) dispose:) ; limo
	)
	(if (and (!= param1 (ScriptID 470 8)) (gCast contains: (ScriptID 470 8))) ; mosley, mosley
		((ScriptID 470 8) dispose:) ; mosley
	)
	(if (and (!= param1 (ScriptID 470 9)) (gCast contains: (ScriptID 470 9))) ; writingCop, writingCop
		((ScriptID 470 9) dispose:) ; writingCop
	)
	(if
		(and
			(!= param1 (ScriptID 470 10)) ; deadBody
			(gCast contains: (ScriptID 470 10)) ; deadBody
		)
		((ScriptID 470 10) dispose:) ; deadBody
	)
	(if
		(and
			(!= param1 (ScriptID 470 11)) ; polCar2
			(gCast contains: (ScriptID 470 11)) ; polCar2
		)
		((ScriptID 470 11) dispose:) ; polCar2
	)
	(if
		(and
			(!= param1 (ScriptID 470 12)) ; ambulance
			(gCast contains: (ScriptID 470 12)) ; ambulance
		)
		((ScriptID 470 12) dispose:) ; ambulance
	)
	(if
		(and
			(!= param1 (ScriptID 470 13)) ; ambulanceLights
			(gCast contains: (ScriptID 470 13)) ; ambulanceLights
		)
		((ScriptID 470 13) dispose:) ; ambulanceLights
	)
	(if
		(and
			(!= param1 (ScriptID 470 14)) ; polCar2Lights
			(gCast contains: (ScriptID 470 14)) ; polCar2Lights
		)
		((ScriptID 470 14) dispose:) ; polCar2Lights
	)
	(if
		(and
			(!= param1 (ScriptID 470 15)) ; coroner
			(gCast contains: (ScriptID 470 15)) ; coroner
		)
		((ScriptID 470 15) dispose:) ; coroner
	)
	(if (and (!= param1 photoCop) (gCast contains: photoCop))
		(photoCop dispose:)
	)
	(if (and (!= param1 polCar1Lights) (gCast contains: polCar1Lights))
		(polCar1Lights dispose:)
	)
	(if (and (!= param1 polCar1) (gCast contains: polCar1))
		(polCar1 dispose:)
	)
	(if (and (!= param1 kneelingCop) (gCast contains: kneelingCop))
		(kneelingCop dispose:)
	)
)

(instance theOpeningCartoon of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE))
			(cond
				((SkipSceneDialog)
					(gMessager caller: 0)
					(gMessager killed: 1)
					(if (gEgo cycler:)
						(gEgo setCycle: 0)
					)
					(self changeState: 99)
					(return 1)
				)
				((not (gNarrator dialog:))
					(Platform 0 2 0)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				(photoCop init:)
				(polCar1 init:)
				(polCar1Lights init:)
				(Load rsVIEW 4792)
				(kneelingCop setCycle: Osc 1 self)
				((ScriptID 470 9) xStep: 4 setCycle: Fwd) ; writingCop
			)
			(1
				(gMessager say: 11 0 8 0 self) ; "The crime scene team is still at the site. Gabriel parks a bit out of the way and walks over to avoid adding to the general confusion."
			)
			(2
				(gEgo show: posn: 169 180 setMotion: MoveTo 175 145 self)
				(photoCop setCycle: Osc 1 self)
				(kneelingCop setCycle: Osc 3)
			)
			(3)
			(4
				(photoCop loop: 4 cel: 0 setCycle: End self)
			)
			(5
				(photoCop loop: 5 cel: 0 setCycle: Osc 1 self)
				(kneelingCop loop: 7 cel: 0 setCycle: End)
			)
			(6
				(photoCop view: 4791 loop: 1 cel: 0 setCycle: Walk)
				(= cycles 1)
			)
			(7
				((ScriptID 470 9) loop: 1 cel: 0 setCycle: End) ; writingCop
				(photoCop
					view: 4791
					ignoreActors: 1
					setCycle: Walk
					setPri: 130
					setScaler: Scaler 100 60 124 84
					setMotion: MoveTo 78 123 self
				)
				(kneelingCop
					view: 4791
					setLoop: 1 1
					cel: 0
					setCycle: Walk
					setSpeed: 4
					setScaler: Scaler 100 60 124 84
					setMotion: MoveTo 182 93
				)
			)
			(8
				(photoCop setMotion: MoveTo 89 110 self)
			)
			(9
				(photoCop setLoop: 6 1 setMotion: MoveTo 135 93 self)
			)
			(10
				(Load rsVIEW 479)
				(Load rsVIEW 4713)
				((ScriptID 470 9) loop: 0 cel: 0 setCycle: Osc 1 self) ; writingCop
			)
			(11
				((ScriptID 470 9) ; writingCop
					view: 2373
					setLoop: 1 1
					cel: 0
					setCycle: Walk
					ignoreActors: 1
					setMotion: PolyPath 104 116 self
				)
				(polCar1 setScript: leaveRoom)
			)
			(12
				((ScriptID 470 9) ; writingCop
					view: 4713
					setCel: 1
					setLoop: 0
					setScale: 0
					setCycle: CT 2 1 self
				)
			)
			(13
				(gGkSound1 number: 475 play:)
				((ScriptID 470 9) ; writingCop
					view: 4713
					setCel: 3
					setLoop: 0
					setPri: 130
					setCycle: CT 10 1 self
				)
			)
			(14
				((ScriptID 470 9) setCel: 11 setLoop: 0 setCycle: End self) ; writingCop
				((ScriptID 470 10) setCel: 1) ; deadBody
			)
			(15
				((ScriptID 470 9) ; writingCop
					view: 2373
					setLoop: 0 1
					setCel: 0
					setPri: -1
					setCycle: Walk
					setMotion: PolyPath 215 120 self
				)
			)
			(16
				(gKeyDownHandler delete: leaveRoom)
				(gKeyDownHandler delete: self)
				(gEgo setScript: enterEgoScript)
				((ScriptID 470 9) ; writingCop
					view: 4711
					setCel: 0
					setLoop: 0 1
					setCycle: Osc 2 self
				)
			)
			(17
				(self dispose:)
			)
			(99
				(gKeyDownHandler delete: self)
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(if (gKeyDownHandler contains: leaveRoom)
					(gKeyDownHandler delete: leaveRoom)
				)
				(if (gKeyDownHandler contains: enterEgoScript)
					(gKeyDownHandler delete: enterEgoScript)
				)
				(gCast eachElementDo: #dispose)
				(= cycles 15)
			)
			(100
				((ScriptID 470 1) init:) ; waves
				((ScriptID 470 2) init:) ; patternOnGround
				((ScriptID 470 3) init:) ; leftPoliceTape
				((ScriptID 470 4) init:) ; rightPoliceTape
				((ScriptID 470 5) init:) ; topPoliceTape
				(gEgo
					init:
					normalize: 0 4792
					ignoreActors: 1
					posn: 173 117
					setScaler: Scaler 100 57 109 64
					setPri: -1
					setSpeed: 6
				)
				(= cycles 1)
			)
			(101
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 15)
			)
			(102
				(SetFlag 11)
				(SetFlag 65)
				(SetFlag 222)
				(ClearFlag 200)
				(Platform 0 2 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE))
			(cond
				((SkipSceneDialog)
					(gMessager caller: 0)
					(gMessager killed: 1)
					(if (gEgo cycler:)
						(gEgo setCycle: 0)
					)
					(self changeState: 99)
					(return 1)
				)
				((not (gNarrator dialog:))
					(Platform 0 2 0)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				(gGkSound2 number: 476 play:)
				(kneelingCop
					setScale: 0
					view: 479
					setLoop: 0
					setCel: 0
					posn: 187 88
					ignoreActors: 1
					setMotion: 0
					setCycle: End self
				)
				(photoCop
					ignoreActors: 1
					setPri: 75
					setMotion: MoveTo 165 83 self
				)
			)
			(1
				(gGkSound2 number: 477 play:)
			)
			(2
				(gGkSound2 number: 476 play:)
				(photoCop
					setScale: 0
					view: 479
					setLoop: 1
					setCel: 0
					posn: 159 75
					setCycle: End self
				)
			)
			(3
				(gGkSound2 number: 477 play:)
				(= seconds 2)
			)
			(4
				(photoCop dispose:)
				(kneelingCop dispose:)
				(polCar1Lights dispose:)
				(gGkSound1 number: 472 play:)
				(polCar1 view: 4704 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(5
				(polCar1
					view: 4705
					ignoreActors: 1
					setCel: 0
					setLoop: 0 1
					setSpeed: 3
					setPri: 1
					setScaler: Scaler 100 68 79 60
					setMotion: MoveTo 33 64 self
				)
			)
			(6
				(polCar1
					view: 478
					setCel: 0
					setLoop: 0
					setSpeed: 6
					posn: 77 60
					setScale: 0
					setCycle: End self
				)
			)
			(7
				(if (gKeyDownHandler contains: leaveRoom)
					(gKeyDownHandler delete: leaveRoom)
				)
				(polCar1 dispose:)
				(self dispose:)
			)
			(99
				(gKeyDownHandler delete: self)
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(if (gKeyDownHandler contains: enterEgoScript)
					(gKeyDownHandler delete: enterEgoScript)
				)
				(if (gKeyDownHandler contains: theOpeningCartoon)
					(gKeyDownHandler delete: theOpeningCartoon)
				)
				(localproc_0 polCar1)
				(= cycles 5)
			)
			(100
				(gEgo
					normalize: 0 4792
					ignoreActors: 1
					posn: 173 117
					setScaler: Scaler 100 57 109 64
					setPri: -1
					setSpeed: 6
				)
				(= cycles 1)
			)
			(101
				(polCar1 dispose:)
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(SetFlag 11)
				(SetFlag 65)
				(SetFlag 222)
				(ClearFlag 200)
				(Platform 0 2 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterEgoScript of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE))
			(cond
				((SkipSceneDialog)
					(gMessager caller: 0)
					(gMessager killed: 1)
					(self cycles: 0)
					(if (gEgo cycler:)
						(gEgo setCycle: 0)
					)
					(self changeState: 99)
					(return 1)
				)
				((not (gNarrator dialog:))
					(Platform 0 2 0)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				(gGame handsOff:)
				(gEgo ignoreActors: 1 setMotion: MoveTo 175 117 self)
			)
			(1
				((ScriptID 470 8) ; mosley
					view: 4793
					setCel: 0
					setLoop: 8
					setLooper: Grooper
					setCycle: StopWalk -1
				)
				(Face gEgo (ScriptID 470 8) self) ; mosley
			)
			(2
				(gMessager say: 11 0 1 1 self) ; "(APPROACHING MOSELY AT CRIME SCENE)Hey, Mostly."
			)
			(3
				(Face (ScriptID 470 8) gEgo self) ; mosley
			)
			(4
				(gMessager sayRange: 11 0 1 2 7 self) ; "(STARTLED)Huh?"
			)
			(5
				((ScriptID 470 8) ; mosley
					setSpeed: 9
					ignoreActors: 1
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: PolyPath 134 127
				)
				(gEgo setMotion: PolyPath 98 114 self)
			)
			(6
				(Face gEgo (ScriptID 470 10) self) ; deadBody
			)
			(7
				((ScriptID 470 8) ; mosley
					setSpeed: 6
					view: 4793
					setCycle: StopWalk -1
					setMotion: PolyPath 105 127 self
				)
			)
			(8
				(Face (ScriptID 470 8) (ScriptID 470 5) self) ; mosley, topPoliceTape
			)
			(9
				((ScriptID 470 8) ; mosley
					view: 472
					setCel: 1
					setLoop: 3
					setCycle: CT 2 1 self
				)
			)
			(10
				(gGkSound1 number: 475 play:)
				((ScriptID 470 8) ; mosley
					view: 472
					setCel: 3
					setLoop: 3
					setCycle: End self
				)
			)
			(11
				((ScriptID 470 10) setCel: 0) ; deadBody
				(= cycles 1)
			)
			(12
				(gEgo view: 475 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(13
				(gMessager say: 11 0 1 8 self) ; "It's another one, as you can see. Same M.O. and no fricking clues. We're still waiting on an I.D. for the body."
			)
			(14
				(gMessager say: 11 0 1 9 self) ; "That's disgusting. Isn't this a rather, er, public area for this kind of thing?"
				(gEgo view: 475 setCel: 0 setLoop: 1 setCycle: Osc 1 self)
			)
			(15)
			(16
				(Load rsVIEW 473)
				(gMessager say: 11 0 1 10 self) ; "(NRCC)Yeah, they're fricking ghosts, these guys. Lakeshore Drive isn't exactly the 10 expressway, but it IS open to the public. No reports of nothin'."
			)
			(17
				(gGkSound1 number: 473 play:)
				(= cycles 5)
			)
			(18
				((ScriptID 470 6) init: setCycle: End self) ; limo
			)
			(19
				((ScriptID 470 7) dispose:) ; moveTheTape
				(= cycles 1)
			)
			(20
				((ScriptID 470 8) ; mosley
					view: 472
					setCel: 0
					setLoop: 4
					setCycle: End self
				)
				(gEgo view: 473 setCel: 0 setLoop: 3 setCycle: End self)
			)
			(21)
			(22
				(gMessager say: 11 0 1 11 self) ; "(A CAR PULLS UP)Now who the hell is that?"
			)
			(23
				(gGkMusic1 fade:)
				((ScriptID 470 8) ; mosley
					view: 4793
					setCel: 1
					setLoop: 8
					setCycle: StopWalk -1
					setMotion: MoveTo 80 127
				)
				(gEgo
					view: 4792
					setCel: 1
					setLoop: 8
					setCycle: StopWalk -1
					setMotion: MoveTo 88 114 self
				)
			)
			(24
				(gKeyDownHandler delete: self)
				(SetFlag 222)
				(gCurRoom newRoom: 471)
				(self dispose:)
			)
			(99
				(gKeyDownHandler delete: self)
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(if (gKeyDownHandler contains: theOpeningCartoon)
					(gKeyDownHandler delete: theOpeningCartoon)
				)
				(if (gKeyDownHandler contains: leaveRoom)
					(gKeyDownHandler delete: leaveRoom)
				)
				(localproc_0 0)
				(= cycles 5)
			)
			(100
				(gEgo
					normalize: 0 4792
					ignoreActors: 1
					posn: 173 117
					setScaler: Scaler 100 57 109 64
					setPri: -1
					setSpeed: 6
				)
				(= cycles 1)
			)
			(101
				(gGkMusic1 fade:)
				(SetFlag 11)
				(SetFlag 65)
				(SetFlag 222)
				(ClearFlag 200)
				(= cycles 1)
			)
			(102
				(gCurRoom exitStyle: 0)
				(gCurRoom newRoom: 471)
				(self dispose:)
			)
		)
	)
)

(instance kneelingCop of Actor
	(properties
		x 283
		y 117
		view 4712
		loop 6
	)
)

(instance photoCop of Actor
	(properties
		x 91
		y 133
		view 471
		loop 3
	)
)

(instance polCar1 of Actor
	(properties
		x 188
		y 79
		view 4702
	)
)

(instance polCar1Lights of Prop
	(properties
		x 188
		y 79
		view 4702
		loop 1
		signal 16417
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

