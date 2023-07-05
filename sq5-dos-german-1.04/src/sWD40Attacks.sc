;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 208)
(include sci.sh)
(use Main)
(use rm201)
(use sStartEggTimer)
(use eureka)
(use Scaler)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	sWD40Attacks 0
	sWD40Kills 1
	wd40Ship 2
)

(local
	local0
)

(instance explosionSound of Sound
	(properties)
)

(instance sWD40Attacks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 207)
				(= seconds 1)
			)
			(1
				(ShakeScreen 5 ssFULL_SHAKE)
				(explosionSound number: 202 setLoop: 1 play:)
				(self setScript: (ScriptID 201 1) self) ; sFlashRed
				(ClearFlag 32)
			)
			(2
				(proc201_6 self)
			)
			(3
				(= cycles 1)
			)
			(4
				(gMessager say: 1 0 0 1 self 208) ; "What was that?!"
			)
			(5
				(self setScript: (ScriptID 201 4)) ; sBusyFlo
				(proc201_7 self)
			)
			(6
				(gMessager say: 1 0 0 2 4 self 208) ; "We've been hit by a proton torpedo!"
			)
			(7
				(self setScript: (ScriptID 201 8) self) ; sTurnDrooleBack
			)
			(8
				(explosionSound number: 211 loop: -1 play:)
				(= cycles 1)
			)
			(9
				(= global113 16)
				(eureka state: 2 curLocation: 3)
				(self setScript: (ScriptID 201 39) self) ; sBigPlanet
			)
			(10
				(explosionSound stop:)
				(proc201_7 self)
			)
			(11
				(gMessager say: 1 0 0 5 self 208) ; "Helm not responding, sir. Weapons systems inoperative!"
			)
			(12
				(self setScript: (ScriptID 201 8) self) ; sTurnDrooleBack
			)
			(13
				(eureka state: 3)
				((ScriptID 201 24) startUpd:) ; droole
				((ScriptID 201 34) startUpd:) ; drooleArm
				((ScriptID 201 2) startUpd:) ; flo
				(self setScript: (ScriptID 201 36) self) ; sInToOrbit
			)
			(14
				(wd40Ship init: addToPic:)
				(gCurRoom drawPic: 41 9)
				(gSq5Music1 number: 20 setLoop: -1 play:)
				(= seconds 2)
			)
			(15
				((ScriptID 201 9) addToPic:) ; bigPlanet
				(wd40Ship addToPic:)
				(torpedo init: ignoreActors: 1)
				((ScriptID 201 24) stopUpd:) ; droole
				((ScriptID 201 2) stopUpd:) ; flo
				(= cycles 2)
			)
			(16
				(torpedo setMotion: MoveTo 284 120 self)
				(gSq5Music2 number: 657 setLoop: 1 play:)
				(fireBall init:)
			)
			(17
				(for ((= register -20)) (<= register 100) ((+= register 40))
					(Palette palSET_INTENSITY 236 255 register)
					(if (>= register 100)
						(= cycles 1)
					)
				)
				(torpedo dispose:)
				(ShakeScreen 3 ssFULL_SHAKE)
				(explosionSound number: 202 setLoop: 1 play:)
			)
			(18
				((ScriptID 202 13) init:) ; monitor1
				((ScriptID 202 14) init:) ; monitor2
				((ScriptID 202 15) init:) ; monitor3
				(for ((= register 120)) (>= register 0) ((-= register 40))
					(Palette palSET_INTENSITY 236 255 register)
					(if (<= register 0)
						(= cycles 1)
					)
				)
			)
			(19
				(fireBall dispose:)
				(= seconds 1)
			)
			(20
				(= seconds 2)
			)
			(21
				(proc201_6 self)
			)
			(22
				(gMessager say: 1 0 0 6 self 208) ; "We're being hailed, sir. I'm putting it on screen."
			)
			(23
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
			)
			(24
				(self setScript: (ScriptID 209 0) self 207) ; sStartViewPort
				((ScriptID 202 13) dispose:) ; monitor1
				((ScriptID 202 14) dispose:) ; monitor2
				((ScriptID 202 15) dispose:) ; monitor3
				(gSq5Music2 number: 206 setLoop: -1 play:)
			)
			(25
				((ScriptID 201 15) talkWidth: 250) ; rogTalker
				(gMessager say: 1 0 1 0 self 208) ; "Roger Wilco, under the authority of ERGS (Extensively Revised Galactic Statute) 2564.45 chapter 4123, sub paragraph 23..."
			)
			(26
				((ScriptID 201 15) talkWidth: 0) ; rogTalker
				(eureka state: 3 destination: 0 damaged: 1 hits: 1)
				(self setScript: (ScriptID 209 1) self) ; sStopViewPort
			)
			(27
				(proc201_7 self)
			)
			(28
				(gMessager say: 2 0 0 1 self 208) ; "I think she means business, Captain."
			)
			(29
				(self setScript: (ScriptID 201 8) self) ; sTurnDrooleBack
			)
			(30
				(proc201_6 self)
			)
			(31
				(gMessager say: 2 0 0 2 self 208) ; "I agree... And could you hurry up and beam down, sir--before she gets impatient and blows us all up."
			)
			(32
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
			)
			(33
				(Palette palSET_INTENSITY 1 255 100)
				(eureka setScript: (ScriptID 210 6) 0 120) ; sWD40Timer
				(++ global127)
				(SetFlag 106)
				(explosionSound dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWD40Kills of Script
	(properties)

	(method (doit)
		(switch state
			(4
				(if (>= local0 100)
					(self cue:)
				)
			)
			(5
				(if (<= local0 0)
					(self cue:)
				)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 84)
					(self setScript: sRemoveEggTimer self)
				else
					(= seconds 1)
				)
				(= register 3)
			)
			(1
				(= seconds 1)
				(fireBall init: hide:)
			)
			(2
				(torpedo init: ignoreActors: 1)
				(= cycles 1)
			)
			(3
				(torpedo setMotion: MoveTo 284 120 self)
				(gSq5Music2 number: 657 setLoop: 1 play:)
				(fireBall show:)
			)
			(4
				(for ((= local0 -20)) (<= local0 100) ((+= local0 40))
					(Palette palSET_INTENSITY 236 255 local0)
				)
				(ShakeScreen 3 ssFULL_SHAKE)
				(gSq5Music2 number: 202 setLoop: 1 play:)
			)
			(5
				(for ((= local0 100)) (>= local0 0) ((-= local0 40))
					(Palette palSET_INTENSITY 236 255 local0)
				)
			)
			(6
				(-- register)
				(if register
					(-= state 6)
				)
				(= cycles 2)
			)
			(7
				(fireBall dispose:)
				(torpedo dispose:)
				(= seconds 1)
			)
			(8
				(client setScript: (ScriptID 210 3) 0 6) ; sBlowUpEureka
				(self dispose:)
			)
		)
	)
)

(instance sRemoveEggTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(proc204_2)
				(= cycles 1)
			)
			(2
				(self setScript: (ScriptID 209 0) self 207) ; sStartViewPort
			)
			(3
				(gMessager say: 3 0 0 1 self 208) ; "Time's up, Wilco! So sorry."
			)
			(4
				(self setScript: (ScriptID 209 1) self) ; sStopViewPort
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance fireBall of View
	(properties
		x 221
		y 65
		view 221
		loop 4
		priority 5
		signal 16401
	)

	(method (init)
		(super init: &rest)
		(Palette palSET_INTENSITY 236 255 0)
	)
)

(instance torpedo of Actor
	(properties
		x 164
		y 60
		view 221
		loop 3
		priority 5
		signal 16400
	)

	(method (init)
		(self
			setLoop: 3
			setCel: 0
			x: 164
			y: 60
			setStep: 20 20
			moveSpeed: 0
			setScale: Scaler 100 20 97 60
		)
		(super init: &rest)
	)
)

(instance wd40Ship of View
	(properties
		x 19
		y 18
		view 221
		loop 2
		priority 6
		signal 16401
	)

	(method (init)
		(if (IsFlag 61)
			(super init: &rest)
		else
			(self dispose:)
		)
	)
)

