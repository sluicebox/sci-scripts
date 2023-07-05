;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 307)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	openPbox 0
)

(local
	local0
)

(instance openPbox of Script
	(properties)

	(method (init param1)
		(Load rsVIEW 40)
		(Load rsVIEW 21)
		(Load rsVIEW 519)
		(Load rsVIEW 43)
		(Load rsVIEW 685)
		(Load rsVIEW 684)
		(super init: param1)
		(HandsOff)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 307 0 #at -1 20 #time 6) ; "Ok, but you'll be sorry!"
				(gEgo viewer: 0)
				(if gIndoors
					(gEgo view: 40)
				else
					(gEgo view: 21)
				)
				(gEgo cel: 0 loop: 0 setCycle: End self)
			)
			(1
				((Sound new:) number: 58 loop: 1 play:)
				(gEgo
					view: 43
					loop: (if gIndoors 0 else 2)
					cel: 0
					setCycle: End
				)
				(aBox
					loop: (if gIndoors 1 else 3)
					cel: 0
					x:
						(if gIndoors
							(+ (gEgo x:) 30)
						else
							(+ (gEgo x:) 24)
						)
					y: (gEgo y:)
					init:
					setCycle: End self
				)
				(ills
					posn: (aBox x:) (- (aBox y:) 5)
					ignoreHorizon: 1
					ignoreActors: 1
					setPri: (aBox priority:)
					init:
					setLoop: 6
					setCycle: End
				)
				(Print 307 1 #font gSmallFont #at 5 20 #width 120 #dispose) ; "That was very foolish, Rosella! Now look what you've gone and done! You've loosed the terrible demons...and killed yourself in the process!!"
			)
			(2
				(smokeFirst
					posn: (aBox x:) (- (aBox y:) 5)
					ignoreHorizon: 1
					ignoreActors: 1
					setPri: (aBox priority:)
					init:
					setLoop: 0
					moveSpeed: 1
					setCycle: End self
				)
			)
			(3
				(ills hide:)
				((ills new:)
					posn: (aBox x:) (- (aBox y:) 5)
					ignoreHorizon: 1
					ignoreActors: 1
					setPri: (aBox priority:)
					init:
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo (* 10 (Random 0 32)) -10
				)
				((ills new:)
					posn: (aBox x:) (- (aBox y:) 5)
					ignoreHorizon: 1
					ignoreActors: 1
					setPri: (aBox priority:)
					init:
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (Random 0 320) -10
				)
				((ills new:)
					posn: (aBox x:) (- (aBox y:) 5)
					ignoreHorizon: 1
					ignoreActors: 1
					setPri: (aBox priority:)
					init:
					setLoop: 2
					setCycle: Fwd
					setMotion: MoveTo (Random 0 320) -10
				)
				((ills new:)
					posn: (aBox x:) (- (aBox y:) 5)
					ignoreHorizon: 1
					ignoreActors: 1
					setPri: (aBox priority:)
					init:
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo (Random 0 320) -10
				)
				((ills new:)
					posn: (aBox x:) (- (aBox y:) 5)
					ignoreHorizon: 1
					ignoreActors: 1
					setPri: (aBox priority:)
					init:
					setLoop: 4
					setCycle: Fwd
					setMotion: MoveTo (Random 0 320) -10
				)
				((ills new:)
					posn: (aBox x:) (- (aBox y:) 5)
					ignoreHorizon: 1
					ignoreActors: 1
					setPri: (aBox priority:)
					init:
					setLoop: 5
					setCycle: Fwd
					setMotion: MoveTo (Random 0 320) -10
				)
				(smokeFirst
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (aBox x:) (- (aBox y:) 20) self
				)
			)
			(4
				((smokes new:)
					posn: (smokeFirst x:) (smokeFirst y:)
					setPri: (aBox priority:)
					init:
					setLoop: 2
					setMotion: MoveTo (* 10 (Random 10 20)) -10
				)
				((smokes new:)
					posn: (smokeFirst x:) (smokeFirst y:)
					setPri: (aBox priority:)
					init:
					setLoop: 3
					moveSpeed: 1
					setMotion: MoveTo (* 10 (Random 10 20)) -10
				)
				((smokes new:)
					posn: (smokeFirst x:) (smokeFirst y:)
					setPri: (aBox priority:)
					init:
					setLoop: 4
					setMotion: MoveTo (* 10 (Random 10 20)) -10
				)
				((smokes new:)
					posn: (smokeFirst x:) (smokeFirst y:)
					setPri: (aBox priority:)
					init:
					setLoop: 5
					setMotion: MoveTo (* 10 (Random 10 20)) -10
				)
				(smokeFirst hide:)
				((ScriptID 0 8) setReal: self 10) ; timer5
			)
			(5
				(gEgo
					loop: (if gIndoors 1 else 3)
					cycleSpeed: 2
					setCycle: End
				)
				(cls)
				((ScriptID 0 8) setReal: self 10) ; timer5
			)
			(6
				(= gDeathFlag 1)
			)
		)
	)
)

(instance aBox of Prop
	(properties
		view 519
	)
)

(instance smokeFirst of Act
	(properties
		view 685
		illegalBits 0
	)

	(method (init param1)
		(super init: param1)
		(self ignoreHorizon: 1 ignoreActors: 1 moveSpeed: 1 setCycle: Fwd)
	)
)

(instance smokes of Act
	(properties
		view 685
		illegalBits 0
	)

	(method (init param1)
		(super init: param1)
		(self ignoreHorizon: 1 ignoreActors: 1 moveSpeed: 1 setCycle: Fwd)
	)
)

(instance ills of Act
	(properties
		view 684
		illegalBits 0
	)
)

