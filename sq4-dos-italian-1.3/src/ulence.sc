;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 706)
(include sci.sh)
(use Main)
(use Interface)
(use BorderWindow)
(use PolyPath)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	ulence 0
	theBiker 1
	theZapScript 2
	theDeathScript 3
	theDodgeR 4
	theDodgeL 5
	theBikeSound 6
	theSand 7
	theDunes 8
)

(local
	local0
	local1
	local2
)

(class ulence of Rgn
	(properties
		regionVer 3891
		roomVer 0
		beenInBar 0
		status 0
		deathLoop 0
		fieldOff 0
		bikerComing 0
		saveWindow 0
		egoBusy 0
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 609 610 611 612 613 614 615 620))
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(if (!= gSystemWindow Sq1Window)
			(= saveWindow gSystemWindow)
			(= gSystemWindow Sq1Window)
		)
		(super init: &rest)
		(proc0_14 1)
		(Load rsVIEW 636)
		(Load rsSOUND 50)
		(Load rsSOUND 135)
		(Load rsSOUND 58)
		(forceField init:)
		(if (== gCurRoomNum 610)
			(forceField x: 52 y: 178 sightAngle: 90)
		)
		(if (not (OneOf gCurRoomNum 615 620))
			(gLongSong number: 58 loop: -1 vol: 127 play:)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			(script 0)
			(
				(and
					(== (gEgo edgeHit:) 3)
					(OneOf gCurRoomNum 609 610 611)
					(== (ulence fieldOff:) 0)
				)
				(HandsOff)
				(gEgo setMotion: 0 y: (- (gEgo y:) 2))
				(= local0 1)
				(gCurRoom setScript: (ScriptID 706 2)) ; theZapScript
			)
			(
				(and
					(& (gEgo onControl: 1) $2000)
					(not local0)
					(== (ulence fieldOff:) 0)
				)
				(HandsOff)
				(gEgo setMotion: 0)
				(switch gCurRoomNum
					(611
						(gEgo x: (- (gEgo x:) 2))
					)
					(612
						(if (and (> (gEgo x:) 185) (< (gEgo y:) 123))
							(gEgo y: (+ (gEgo y:) 2))
						else
							(gEgo
								y: (+ (gEgo y:) 2)
								x: (+ (gEgo x:) 2)
							)
						)
					)
					(613
						(gEgo y: (+ (gEgo y:) 2))
					)
					(614
						(gEgo x: (- (gEgo x:) 4))
					)
				)
				(= local0 1)
				(gCurRoom setScript: (ScriptID 706 2)) ; theZapScript
			)
			((and (& (gEgo onControl: 1) $1000) local0)
				(= local0 0)
			)
		)
	)

	(method (dispose)
		(= gSystemWindow saveWindow)
		(super dispose:)
	)
)

(class Sq1Window of BorderWindow
	(properties
		bordWid 3
	)

	(method (open &tmp temp0 temp1)
		(SetPort 0)
		(= color global129)
		(= back global130)
		(= temp1 1)
		(if (!= priority -1)
			(|= temp1 $0002)
		)
		(= lsTop (- top bordWid))
		(= lsLeft (- left bordWid))
		(= lsRight (+ right bordWid))
		(= lsBottom (+ bottom bordWid))
		(= underBits (Graph grSAVE_BOX lsTop lsLeft lsBottom lsRight 1))
		(if (!= priority -1)
			(= pUnderBits (Graph grSAVE_BOX lsTop lsLeft lsBottom lsRight 2))
		)
		(Graph grFILL_BOX lsTop lsLeft lsBottom lsRight temp1 back priority)
		(Graph
			grDRAW_LINE
			(+ lsTop 1)
			(+ lsLeft 1)
			(+ lsTop 1)
			(- lsRight 2)
			global131
			priority
		)
		(Graph
			grDRAW_LINE
			(- lsBottom 2)
			(+ lsLeft 1)
			(- lsBottom 2)
			(- lsRight 2)
			global131
			priority
		)
		(Graph
			grDRAW_LINE
			(+ lsTop 1)
			(+ lsLeft 1)
			(- lsBottom 2)
			(+ lsLeft 1)
			global131
			priority
		)
		(Graph
			grDRAW_LINE
			(+ lsTop 1)
			(- lsRight 2)
			(- lsBottom 2)
			(- lsRight 2)
			global131
			priority
		)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(= type 129)
		(= window
			(NewWindow top left bottom right title type priority color back)
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
				(EgoDead 0 6)
			)
		)
	)
)

(instance theZapScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(Load rsVIEW 635)
				(++ local1)
				(gEgo view: 636)
				(switch gCurRoomNum
					(609
						(if (gEgo inRect: 15 187 317 191)
							(gEgo setLoop: 2)
						)
					)
					(612
						(if (and (> (gEgo x:) 185) (< (gEgo y:) 123))
							(gEgo setLoop: 3)
						else
							(gEgo setLoop: 7)
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
				(if (not local2)
					(NormalEgo (gEgo loop:) 0)
				)
				(= cycles 3)
			)
			(2
				(if local2
					(Print 706 0) ; "As the moist surface of your oral muscle comes in contact with the fully energized force field, you realize your mistake."
					(= local1 4)
				)
				(switch local1
					(1
						(Print 706 1) ; ""YOUCH!", you mumble to yourself. A force field prevents your continued movement in that direction."
						(HandsOn)
						(self dispose:)
					)
					(2
						(Print 706 2) ; "AH! CRIPES! I hate it when that happens!"
						(HandsOn)
						(self dispose:)
					)
					(3
						(switch (Random 0 5)
							(0
								(Print 706 3) ; ""GEEEZ!" Much like life at Sierra, you find the force field a real eye-opening experience."
							)
							(1
								(Print 706 4) ; "Thousands of volts pass through your cranium, turning your brain into a gray, quivering mass of neurons which effectively terminates all interpretation of sensory impulses."
							)
							(else
								(Print 706 5) ; ""AH! CRIPES!", you mumble to yourself. A force field prevents your continued movement in that direction."
							)
						)
						(HandsOn)
						(self dispose:)
					)
					(else
						(gEgo view: 635 setLoop: 0 setCel: 2)
						(= cycles 1)
					)
				)
			)
			(3
				(if (== gCurRoomNum 613)
					(gEgo setPri: 1)
				)
				(gEgo setCycle: End self)
			)
			(4
				(EgoDead 1 7)
			)
		)
	)
)

(instance tongueScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= local2 1)
				(gEgo setMotion: PolyPath gMouseX gMouseY self)
			)
			(1
				(gCurRoom setScript: theZapScript)
				(self dispose:)
			)
		)
	)
)

(instance theDodgeR of Script
	(properties)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(or (== (event message:) JOY_UP) (& (event type:) $0040)) ; direction
				)
				(self cue:)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0 setHeading: 90 self)
				(Print 706 6) ; "You hear a high-pitched whine from the east."
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 7)
				(gEgo view: 635 setLoop: 0 setCel: 0)
			)
			(2
				(ulence status: 5)
				(HandsOff)
				(gEgo
					posn: (+ (gEgo x:) 12) (- (gEgo y:) 10)
					setLoop: 2
					setCycle: End self
				)
			)
			(3
				(SetScore 77 5)
				(NormalEgo (gEgo loop:) 0)
				(gTheIconBar enable: 7)
				(gEgo
					posn: (+ (gEgo x:) 24) (+ (gEgo y:) 5)
					heading: 90 self
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

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(or (== (event message:) JOY_UP) (& (event type:) $0040)) ; direction
				)
				(self cue:)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0 setHeading: 270 self)
				(Print 706 7) ; "You hear a high-pitched whine from the west."
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 7)
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
				(SetScore 77 5)
				(NormalEgo (gEgo loop:) 0)
				(gTheIconBar enable: 7)
				(gEgo
					posn: (- (gEgo x:) 25) (+ (gEgo y:) 2)
					setHeading: 225 self
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance theBiker of Actor
	(properties
		x 1000
		y 1000
		description {Monochrome guy.}
		lookStr {It's one of the Monochrome Boys and he seems to be traveling in your direction!}
		yStep 15
		view 632
		signal 24576
		illegalBits 0
		xStep 15
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 706 8) ; "Sure - stop him. I'm sure he'd love to stop and swap some witty repartee."
			)
			(3 ; Do
				(Print 706 9) ; "That would be a bad move."
			)
			(11 ; Smell
				(Print 706 10) ; "Get closer."
			)
			(10 ; Taste
				(Print 706 11) ; "Yeah. The appeal is obvious."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance forceField of Feature
	(properties
		y 189
		nsBottom 189
		nsRight 319
		description {force field}
		sightAngle 180
		onMeCheck 16384
		lookStr {It's a Wallmart Force Field Generation Unit (FFGU).}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Taste
				(if (== (ulence egoBusy:) 1)
					(Print 706 12) ; "Not now!"
				else
					(HandsOff)
					(Print 706 13) ; "Okay."
					(gCurRoom setScript: tongueScript)
				)
			)
			(11 ; Smell
				(switch (Random 0 6)
					(0
						(Print 706 14) ; "It's supposed to smell like a Wallmart Force Field Generating Unit, but we could only do 16 different odors in EGA so it smells a lot like the time pod."
					)
					(1
						(Print 706 15) ; "It has the acrid, coppery smell of ozone and wind-corroded metal."
					)
					(2
						(Print 706 16) ; "You've smelled a lot of force field generators in your time, but this is not one of them."
					)
					(3
						(Print 706 17) ; "The crackling smell of the FFGU stirs early memories of the force field your parents put around your playpen."
					)
					(else
						(Print 706 18) ; "You can't seem to catch a scent from the FFGU. Maybe you should try tasting it instead."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theDunes of Feature
	(properties
		y 1
		description {sand dunes}
		lookStr {In the distance you see sand dunes and sky.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 706 19) ; "In the distance you see sand dunes and sky."
				(if (OneOf gCurRoomNum 610 609)
					(Print 706 20) ; "Far away you see a few force field generators."
				)
			)
			(11 ; Smell
				(switch (Random 0 6)
					(0
						(Print 706 21) ; "You can't quite smell the faraway dunes."
					)
					(1
						(Print 706 22) ; "It's the all too familiar silent-but-deadly aroma of Ulence Flats."
					)
					(2
						(Print 706 23) ; "Above the dunes, you smell an overcast purple sky... As if it's going to purple rain any second now."
					)
					(3
						(Print 706 24) ; "You inhale deeply, and very quickly sandblast the insides of your nostrils. Good thing you got those Tufflon implants!"
					)
					(4
						(Print 706 25) ; "The spicy scent of the dunes reminds you of a lost weekend you once spent on Arrakis."
					)
					(5
						(Print 706 26) ; "The smell of the sand fills the air all around you."
					)
					(6
						(Print 706 27) ; "The air smells damp and oppressive, like a wet nun."
					)
				)
			)
			(10 ; Taste
				(switch (Random 0 4)
					(0
						(Print 706 28) ; "You can't taste the dunes, but your tongue gets a good stretching."
					)
					(1
						(Print 706 29) ; "Your tongue's too short for that."
					)
					(2
						(Print 706 30) ; "Your tongue flaps in the breeze."
					)
					(3
						(Print 706 31) ; "You won't need to lick the dunes here."
					)
					(4
						(Print 706 32) ; "Unfortunately, your woefully short tongue is nowhere near long enough to taste the faroff dunes of Ulence."
					)
					(5
						(Print 706 33) ; "There's nothing worth tasting in the air."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theSand of Feature
	(properties
		y 1
		description {sand}
		lookStr {You see a whole lot of sand.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(11 ; Smell
				(switch (Random 0 3)
					(0
						(Print 706 34) ; "It has the dry, itchy, uncomfortable smell of sand up your nose."
					)
					(1
						(Print 706 35) ; "Mmmmm! The slow-roasted whole grain goodness of sand."
					)
					(2
						(Print 706 36) ; "It smells like extremely hot sand and burnt nose hair."
					)
					(3
						(Print 706 37) ; "Funny how much smelling is going on, but the game still makes no scents!"
					)
				)
			)
			(2 ; Look
				(Print 706 38) ; "Looks like ordinary sand."
			)
			(10 ; Taste
				(switch (Random 0 4)
					(0
						(Print 706 39) ; "The taste is subtle and difficult to pin down, but you LOVE the way it crunches between your teeth!"
					)
					(1
						(Print 706 40) ; "Tastes like ordinary sand."
					)
					(2
						(Print 706 41) ; "Don't lick it. Who knows where it's been last?"
					)
					(3
						(Print 706 42) ; "It's tough to tell what the sand really tastes like when your tongue is a twitching mass of blisters."
					)
					(4
						(Print 706 43) ; "Yep, tastes just like you'd expect of flat Ulence."
					)
				)
			)
			(3 ; Do
				(Print 706 44) ; "You don't have time to play in the sand!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theBikeSound of Sound
	(properties
		flags 1
		number 841
	)
)

(instance zapSound of Sound
	(properties
		flags 1
		number 135
	)
)

