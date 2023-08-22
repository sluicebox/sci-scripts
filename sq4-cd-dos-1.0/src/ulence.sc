;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 706)
(include sci.sh)
(use Main)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Game)
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
	tRoger 9
)

(local
	local0
	local1
	local2
)

(class ulence of Rgn
	(properties
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
		(LoadMany rsSOUND 135 58 50)
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
					(== (gEgo edgeHit:) EDGE_BOTTOM)
					(OneOf gCurRoomNum 609 610 611)
					(== (ulence fieldOff:) 0)
				)
				(HandsOff)
				(gEgo setMotion: 0 y: (- (gEgo y:) 2))
				(= local0 1)
				(gCurRoom setScript: theZapScript)
				(theZapScript init:)
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
				(gCurRoom setScript: theZapScript)
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

(class Sq1Window of SysWindow
	(properties
		underBits 0
		pUnderBits 0
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
		(super open:)
	)

	(method (dispose)
		(SetPort 0)
		(Graph grRESTORE_BOX underBits)
		(Graph grRESTORE_BOX pUnderBits)
		(Graph grREDRAW_BOX lsTop lsLeft lsBottom lsRight)
		(super dispose:)
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
				(gNarrator modNum: 707 say: 1 self) ; "Nice reflexes! Life is pounded loose from your body by the impact of the sand bike."
			)
			(3
				(EgoDead 0 6) ; "Now this is a pain that'll linger! All the Ben Gay in Florida won't relieve this stiffness."
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
				(= cycles 20)
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
					(= local1 4)
					(gNarrator modNum: 706 say: 1 self) ; "As the moist surface of your oral muscle comes in contact with the fully energized force field, you realize your mistake."
				else
					(= cycles 3)
				)
			)
			(3
				(switch local1
					(1
						(tRoger modNum: 706 say: 1) ; "YOUCH!"
						(HandsOn)
						(self dispose:)
					)
					(2
						(tRoger modNum: 706 say: 2) ; "AH! CRIPES! I hate it when that happens!"
						(HandsOn)
						(self dispose:)
					)
					(3
						(switch (Random 0 5)
							(0
								(tRoger modNum: 706 say: 3) ; "GEEEZ!!"
							)
							(else
								(tRoger modNum: 706 say: 4) ; "AH! CRIPES!"
							)
						)
						(HandsOn)
						(self dispose:)
					)
					(else
						(gEgo view: 635 setLoop: 0 setCel: 2)
						(= cycles 3)
					)
				)
			)
			(4
				(if (== gCurRoomNum 613)
					(gEgo setPri: 1)
				)
				(gEgo setCycle: End self)
			)
			(5
				(gNarrator modNum: 706 say: 2 self) ; "Thousands of volts pass through your cranium, turning your brain into a quivering mass of short-circuited neurons which effectively terminates all interpretation of sensory impulses."
			)
			(6
				(EgoDead 1 7) ; "Your musculature spasms for the last time as the force field shock causes you to give up the ghost."
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
					(or (== (event message:) JOY_RIGHT) (& (event type:) $0040)) ; direction
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
				(gNarrator modNum: 706 say: 3) ; "You hear a high-pitched whine from the east."
			)
			(1
				(HandsOn)
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
					(or (== (event message:) JOY_RIGHT) (& (event type:) $0040)) ; direction
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
				(gNarrator modNum: 706 say: 4) ; "You hear a high-pitched whine from the west."
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
				(SetScore 77 5)
				(NormalEgo (gEgo loop:) 0)
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

(instance theBiker of Sq4Actor
	(properties
		x 1000
		y 1000
		yStep 15
		view 632
		signal 24576
		illegalBits 0
		xStep 15
		lookStr 5
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 706 say: 5) ; "It's one of the Monochrome Boys and he seems to be traveling in your direction!"
			)
			(2 ; Talk
				(gNarrator modNum: 706 say: 6) ; "Sure - just try and stop him."
			)
			(4 ; Do
				(gNarrator modNum: 706 say: 7) ; "That would be a bad move."
			)
			(6 ; Smell
				(gNarrator modNum: 706 say: 8) ; "Get closer, Roger."
			)
			(7 ; Taste
				(gNarrator modNum: 706 say: 9) ; "Yeah. The appeal is obvious."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance forceField of Sq4Feature
	(properties
		y 189
		nsBottom 189
		nsRight 319
		sightAngle 180
		onMeCheck 16384
		lookStr 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 706 say: 10) ; "It's a Wallmart Force Field Generation Unit."
			)
			(7 ; Taste
				(if (== (ulence egoBusy:) 1)
					(gNarrator modNum: 706 say: 11) ; "Not now, Roger!"
				else
					(HandsOff)
					(gNarrator modNum: 706 say: 12) ; "Okay."
					(gCurRoom setScript: tongueScript)
				)
			)
			(6 ; Smell
				(switch (Random 0 6)
					(0
						(gNarrator modNum: 706 say: 13) ; "It's supposed to smell like a Wallmart Force Field Generating Unit, but we could only do 16 different odors in EGA so it smells a lot like the time pod."
					)
					(1
						(gNarrator modNum: 706 say: 14) ; "It has the acrid, coppery smell of ozone and wind-corroded metal."
					)
					(2
						(gNarrator modNum: 706 say: 15) ; "You've smelled a lot of force field generators in your time, but this is not one of them."
					)
					(3
						(gNarrator modNum: 706 say: 16) ; "The crackling smell of the force field generator stirs early memories of the force field your parents put around your playpen."
					)
					(else
						(gNarrator modNum: 706 say: 17) ; "You are unable to catch a scent from the force field generator. Maybe you should try tasting it instead."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theDunes of Sq4Feature
	(properties
		y 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 706 say: 18) ; "In the distance you see sand dunes and sky."
				(if (OneOf gCurRoomNum 610 609)
					(gNarrator modNum: 706 say: 19) ; "Far away you see a few force field generators."
				)
			)
			(6 ; Smell
				(switch (Random 0 6)
					(0
						(gNarrator modNum: 706 say: 20) ; "You can't quite smell the faraway dunes."
					)
					(1
						(gNarrator modNum: 706 say: 21) ; "It's the silent-but-deadly aroma of Ulence Flats."
					)
					(2
						(gNarrator modNum: 706 say: 22) ; "Above the dunes, you smell an overcast purple sky."
					)
					(3
						(gNarrator modNum: 706 say: 23) ; "You inhale deeply, sandblasting the insides of your nostrils."
					)
					(4
						(gNarrator modNum: 706 say: 24) ; "The spicy scent of the dunes reminds you of a weekend you once spent on Arrakis."
					)
					(5
						(gNarrator modNum: 706 say: 25) ; "The smell of the sand fills the air all around you."
					)
					(6
						(gNarrator modNum: 706 say: 26) ; "The air smells damp and oppressive, like a wet nun."
					)
				)
			)
			(7 ; Taste
				(switch (Random 0 4)
					(0
						(gNarrator modNum: 706 say: 27) ; "You can't taste the dunes, but your tongue gets a good stretching."
					)
					(1
						(gNarrator modNum: 706 say: 28) ; "Your tongue's too short for that."
					)
					(2
						(gNarrator modNum: 706 say: 29) ; "Your tongue flaps in the breeze."
					)
					(3
						(gNarrator modNum: 706 say: 31) ; "Your woefully short tongue is nowhere near long enough to taste the faroff dunes of Ulence."
					)
					(4
						(gNarrator modNum: 706 say: 30) ; "You will not need to lick the dunes here."
					)
					(5
						(gNarrator modNum: 706 say: 32) ; "There's nothing worth tasting in the air."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theSand of Sq4Feature
	(properties
		y 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(6 ; Smell
				(switch (Random 0 3)
					(0
						(gNarrator modNum: 706 say: 34) ; "It has the dry, itchy, uncomfortable smell of sand up your nose."
					)
					(1
						(gNarrator modNum: 706 say: 35) ; "Mmmmm! The slow-roasted whole grain goodness of sand."
					)
					(2
						(gNarrator modNum: 706 say: 36) ; "It smells like extremely hot sand and burnt nose hair."
					)
					(3
						(gNarrator modNum: 706 say: 37) ; "There's a whole lot of smelling is going on, but the game still makes no scents! Get it?"
					)
				)
			)
			(1 ; Look
				(gNarrator modNum: 706 say: 38) ; "Looks like ordinary sand to me, Roger."
			)
			(7 ; Taste
				(switch (Random 0 4)
					(0
						(gNarrator modNum: 706 say: 39) ; "The taste is subtle and difficult to pin down, but you LOVE the way it crunches between your teeth!"
					)
					(1
						(gNarrator modNum: 706 say: 40) ; "Tastes like ordinary sand."
					)
					(2
						(gNarrator modNum: 706 say: 41) ; "Don't lick it. Who knows where it's been last?"
					)
					(3
						(gNarrator modNum: 706 say: 42) ; "It's tough to tell what the sand really tastes like when your tongue is a twitching mass of blisters."
					)
					(4
						(gNarrator modNum: 706 say: 43) ; "Yep, tastes just like you'd expect."
					)
				)
			)
			(4 ; Do
				(gNarrator modNum: 706 say: 44) ; "You don't have time to play in the sand, Roger!"
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

(instance tRoger of Sq4Talker
	(properties
		z 400
		noun 7
		modNum 706
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

