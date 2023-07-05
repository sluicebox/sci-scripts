;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 706)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use StopWalk)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	ulence 0
	proc706_1 1
	theBiker 2
	theZapScript 3
	theDeathScript 4
	theDodgeR 5
	theDodgeL 6
)

(local
	local0
	local1
)

(procedure (proc706_1)
	(gEgo
		view: 0
		normal: 1
		moveHead: 1
		setLoop: -1
		setPri: -1
		setMotion: 0
		setCycle: StopWalk 4
		setStep: 3 2
		illegalBits: 0
		ignoreActors: 1
		cycleSpeed: 0
		moveSpeed: 0
	)
)

(class ulence of Rgn
	(properties
		srcVer 11891
		roomVer 0
		beenInBar 0
		status 0
		deathLoop 0
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 609 610 611 612 613 614 615 620))
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(super init: &rest)
		(proc0_14 {Space Quest I} 54)
		(Load rsVIEW 636)
		(Load rsSOUND 50)
		(Load rsSOUND 135)
		(forceField init:)
		(if (OneOf gCurRoomNum 612 613 614)
			(gCurRoom setFeatures: dunes)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			(script 0)
			((and (& (gEgo onControl: 1) $2000) (not local0))
				(HandsOff)
				(= local0 1)
				(gEgo setMotion: 0)
				(gCurRoom setScript: (ScriptID 706 3)) ; theZapScript
			)
			((and (& (gEgo onControl: 1) $1000) local0)
				(= local0 0)
			)
		)
	)

	(method (dispose)
		(DisposeScript 941)
		(DisposeScript 969)
		(DisposeScript 972)
		(DisposeScript 991)
		(super dispose:)
	)
)

(instance theBiker of Actor
	(properties
		x 1000
		y 1000
		yStep 15
		view 632
		signal 24576
		illegalBits 0
		xStep 15
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 706 0) ; "*** You can't talk to him."
			)
			(4 ; Do
				(Print 706 1) ; "*** Yeah, I bet you would, too!"
			)
			(1 ; Look
				(Print 706 2) ; "*** You see a biker-dude."
			)
			(2 ; Smell
				(Print 706 3) ; "*** You have no business sticking your nose there!"
			)
			(3 ; Taste
				(Print 706 4) ; "*** NOT in public!"
				(Print 706 5) ; "*** Maybe later, Big Guy..."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theDeathScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 635
					cel: 0
					setLoop: (ulence deathLoop:)
					setCycle: End self
				)
			)
			(1
				(= seconds 4)
			)
			(2
				(Print 706 6) ; "THWUMP! Nice Reactions, Roger! Life is pounded loose from your body by the impact of the sand bike."
				(= seconds 3)
			)
			(3
				(EgoDead 706 7)
			)
		)
	)
)

(instance theDodgeR of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(if (not (event claimed:))
			(switch (event type:)
				(evMOUSEBUTTON
					(if (and (User controls:) (not (event modifiers:)))
						(self cue:)
						(event claimed: 1)
					)
				)
				($0040 ; direction
					(self cue:)
					(event claimed: 1)
				)
				(evVERB
					(super handleEvent: event)
				)
			)
		)
		(event claimed:)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0 setHeading: 90 self)
			)
			(1
				(HandsOn)
				(gEgo view: 635 setLoop: 0 setCel: 0)
			)
			(2
				(HandsOff)
				(ulence status: 5)
				(gEgo
					posn: (+ (gEgo x:) 12) (- (gEgo y:) 10)
					setLoop: 2
					setCycle: End self
				)
			)
			(3
				(proc706_1)
				(gEgo
					posn: (+ (gEgo x:) 24) (+ (gEgo y:) 5)
					heading: 90
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance theDodgeL of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(if (not (event claimed:))
			(switch (event type:)
				(evMOUSEBUTTON
					(if (and (User controls:) (not (event modifiers:)))
						(self cue:)
						(event claimed: 1)
					)
				)
				($0040 ; direction
					(self cue:)
					(event claimed: 1)
				)
				(evVERB
					(super handleEvent: event)
				)
			)
		)
		(event claimed:)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0 setHeading: 270 self)
			)
			(1
				(HandsOn)
				(gEgo view: 635 setLoop: 1 setCel: 0)
			)
			(2
				(HandsOff)
				(ulence status: 5)
				(gEgo
					posn: (- (gEgo x:) 14) (- (gEgo y:) 7)
					setLoop: 3
					setCycle: End self
				)
			)
			(3
				(proc706_1)
				(gEgo
					posn: (- (gEgo x:) 25) (+ (gEgo y:) 2)
					setHeading: 225 self
				)
				(self dispose:)
			)
		)
	)
)

(instance theZapScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(++ local1)
				(gEgo view: 636)
				(switch gCurRoomNum
					(609
						(if (gEgo inRect: 15 187 317 191)
							(gEgo setLoop: 2)
						)
					)
					(612
						(if (gEgo inRect: 194 100 320 120)
							(gEgo setLoop: 3)
						)
					)
					(611
						(if (gEgo inRect: 0 181 235 190)
							(gEgo setLoop: 2)
						)
					)
					(610
						(gEgo setLoop: 2)
					)
					(614
						(gEgo setLoop: 0)
					)
					(613
						(gEgo setLoop: 3)
					)
				)
				(zapSound play:)
				(= cycles 2)
			)
			(1
				(zapSound stop:)
				(proc706_1)
				(= cycles 3)
			)
			(2
				(HandsOn)
				(switch local1
					(1
						(Print 706 8) ; ""YOUCH!", you mumble to yourself. A Force Field prevents your continued movement in that direction."
					)
					(2
						(Print 706 9) ; "AH! CRIPES! I hate it when that happens!"
					)
					(3
						(Print 706 10) ; ""GEEEZ!" Much like life at Sierra, you find the force field a real eye-opening experience."
					)
					(else
						(EgoDead 706 11)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance forceField of Feature
	(properties
		nsBottom 189
		nsRight 319
		description {force field}
		sightAngle 360
		onMeCheck 16384
		lookStr {It's a Wallmart Force Field Generation Unit (FFGU).}
	)
)

(instance zapSound of Sound
	(properties
		number 135
	)
)

(instance dunes of Feature
	(properties
		x 159
		y 51
		nsBottom 102
		nsRight 319
		description {dunes}
		sightAngle 180
		lookStr {*** You see yellow EGA dunes.}
	)
)

