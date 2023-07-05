;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 344)
(include sci.sh)
(use Main)
(use rSacred)
(use KQ6Print)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	proc344_0 0
	proc344_1 1
	nightMare 2
	blowinIt 3
)

(local
	local0
	local1
	local2
)

(procedure (proc344_0)
	(nightMare init:)
)

(procedure (proc344_1)
	(if (& ((gInventory at: 11) state:) $0008) ; skull
		(nightMare setScript: catchNiteMare)
	else
		(nightMare setScript: coldEmbers)
	)
)

(instance myConv of Conversation
	(properties)
)

(instance nightMare of Actor
	(properties
		x 265
		y 112
		noun 10
		view 335
		signal 24576
	)

	(method (init)
		(rSacred marePresent: 1)
		(self cycleSpeed: 10 setCycle: Fwd)
		(super init:)
	)

	(method (doit)
		(if
			(and
				(< (gEgo distanceTo: self) 65)
				(== (self loop:) 0)
				(not (self script:))
				(!= (gCurRoom script:) mareFlyAway)
			)
			(gGame handsOff:)
			(gCurRoom setScript: mareFlyAway 0 3)
		)
		(super doit:)
	)

	(method (dispose)
		(ClearFlag 59)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(= local1 (gEgo x:))
		(= local2 (gEgo y:))
		(switch theVerb
			(13 ; mirror
				(self setScript: reflectMare)
			)
			(28 ; spellBook
				(gGame handsOff:)
				(gCurRoom setScript: 190) ; openBook
			)
			(31 ; flute
				(self setScript: blowinIt)
			)
			(5 ; Do
				(self setScript: grabForMare)
			)
			(51 ; skull
				(self setScript: alasPoorYorick)
			)
			(37 ; nightingale
				(self setScript: giveHorseBird)
			)
			(19 ; egg
				(super doVerb: theVerb &rest)
			)
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(14 ; potion
				(super doVerb: theVerb &rest)
			)
			(16 ; scythe
				(super doVerb: theVerb &rest)
			)
			(1 ; Look
				(super doVerb: theVerb &rest)
			)
			(32 ; poem
				(super doVerb: theVerb &rest)
			)
			(12 ; map
				(super doVerb: theVerb &rest)
			)
			(44 ; teaCup
				(self setScript: offerItem 0 theVerb)
			)
			(20 ; tinderBox
				(self setScript: offerItem 0 theVerb)
			)
			(30 ; feather
				(self setScript: offerItem 0 theVerb)
			)
			(47 ; flower
				(self setScript: offerItem 0 theVerb)
			)
			(65 ; note
				(self setScript: offerItem 0 theVerb)
			)
			(67 ; peppermint
				(self setScript: offerItem 0 theVerb)
			)
			(68 ; rabbitFoot
				(self setScript: offerItem 0 theVerb)
			)
			(33 ; ribbon
				(self setScript: offerItem 0 theVerb)
			)
			(70 ; royalRing
				(self setScript: offerItem 0 theVerb)
			)
			(else
				(self setScript: offerItem 0 0)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 210
		y 92
		view 336
		loop 9
		priority 15
		signal 16400
		cycleSpeed 10
	)
)

(instance theSkull of View
	(properties
		x 220
		y 126
		view 336
		loop 4
		priority 1
		signal 16400
	)
)

(instance reflectMare of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 336
					setLoop: 0
					cel: 0
					normal: 0
					posn: (+ (gEgo x:) 14) (+ (gEgo y:) 7)
					setCycle: CT 1 1 self
				)
			)
			(1
				(gMessager say: 10 13 0 1 self 340) ; "Alexander holds Beast's mirror out towards Night Mare."
			)
			(2
				(gGlobalSound4 number: 346 setLoop: 1 play:)
				(nightMare setLoop: 0 setCycle: Beg self)
			)
			(3
				(nightMare cel: 5)
				(= ticks 6)
			)
			(4
				(nightMare cel: 0)
				(= ticks 6)
			)
			(5
				(nightMare cel: 5)
				(= ticks 6)
			)
			(6
				(nightMare cel: 0)
				(= ticks 6)
			)
			(7
				(gMessager say: 10 13 0 2 self 340) ; "!!!Do sound effect here:"WHREE!""
			)
			(8
				(client setScript: mareFlyAway 0 13)
			)
		)
	)
)

(instance alasPoorYorick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 336
					setLoop: 0
					cel: 0
					normal: 0
					cycleSpeed: 6
					posn: (+ (gEgo x:) 14) (+ (gEgo y:) 7)
					setCycle: CT 1 1 self
				)
			)
			(1
				(gMessager say: 10 51 0 1 self 340) ; "Alexander holds the skull out to Night Mare."
			)
			(2
				(gEgo setLoop: 8)
				(nightMare setCycle: Beg self)
			)
			(3
				(gGlobalSound4 number: 346 setLoop: 1 play:)
				(nightMare setCycle: CT 5 1)
				(= seconds 4)
			)
			(4
				(nightMare setCycle: Fwd)
				(gMessager say: 10 51 0 2 self 340) ; "Night Mare is unmoved by the skull, at least in its current state."
			)
			(5
				(gEgo setLoop: 0 cel: 2 setCycle: Beg self)
			)
			(6
				(gEgo posn: local1 local2 reset: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveHorseBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					normal: 0
					view: 883
					posn: (- (gEgo x:) 5) (gEgo y:)
					loop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: Fwd
				)
				(birdSound number: 930 loop: -1 play:)
				(= seconds 5)
			)
			(1
				(birdSound stop:)
				(gMessager say: 10 37 0 1 self 340) ; "Alexander winds the bird and plays it for the black creature...."
			)
			(2
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(birdSound number: 931 loop: -1 play:)
				(= seconds 7)
			)
			(4
				(birdSound stop:)
				(gMessager say: 10 37 0 2 self 340) ; "Night Mare just continues to eat."
			)
			(5
				(gEgo loop: 2 cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(6
				(gEgo posn: local1 local2 reset: 1)
				(= cycles 6)
			)
			(7
				(gEgo setHeading: 45)
				(= cycles 6)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(if (not (== (birdSound prevSignal:) -1))
			(birdSound stop:)
		)
		(super dispose:)
	)
)

(instance offerItem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 336
					setLoop: 0
					cel: 0
					normal: 0
					posn: (+ (gEgo x:) 14) (+ (gEgo y:) 7)
					setCycle: CT 1 1 self
				)
			)
			(1
				(gMessager say: 10 register 0 1 self 340)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo posn: local1 local2 reset: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance blowinIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 10 31 0 1 self 340) ; "Determined to beguile the creature with his great musical skill, Alexander puts the flute to his lips."
			)
			(1
				(nightMare setCycle: Beg)
				(self setScript: (ScriptID 85 0) self) ; playTheFlute
			)
			(2
				(gGlobalSound4 number: 346 setLoop: 1 play:)
				(nightMare setCycle: CT 5 1 self)
			)
			(3
				(= seconds 5)
			)
			(4
				(gMessager say: 10 31 0 2 self 340) ; "The winged horse seems unimpressed."
			)
			(5
				(gGame handsOn:)
				(nightMare setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance grabForMare of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 10 5 0 1 self 340) ; "Alexander decides to take the straight-forward approach and grab the black creature."
			)
			(1
				(gGlobalSound4 number: 346 setLoop: 1 play:)
				(nightMare setCycle: Beg)
				(gEgo
					setMotion:
						PolyPath
						(- (nightMare x:) 20)
						(+ (nightMare y:) 20)
						self
				)
			)
			(2
				(= cycles 4)
			)
			(3
				(gGame handsOn:)
				(= local1 (gEgo x:))
				(= local2 (gEgo y:))
				(client setScript: mareFlyAway 0 5)
			)
		)
	)
)

(instance mareFlyAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register 3)
					(myConv add: 340 3 3 19 1 add: 340 3 3 19 2 init: self) ; "The sound of Alexander's footsteps startle the black horse.", "!!!Do sound effect here: "BREEEAA!""
				else
					(self cue:)
				)
			)
			(1
				(gGlobalSound4 number: 346 setLoop: 1 play:)
				(nightMare
					view: 335
					setLoop: 1
					cel: 0
					cycleSpeed: 12
					setPri: 8
					setCycle: End self
				)
			)
			(2
				(switch register
					(13
						(gMessager say: 10 13 0 3 self 340) ; "Night Mare whinnies with fear at the sight of her own reflection. She gathers her muscles and flies off!"
					)
					(5
						(myConv add: 340 10 5 0 2 add: 340 10 5 0 3 init: self) ; "!!!Do sound effect here: "WHREEE! <snort>"", "Night Mare is not amused."
					)
					(3
						(gMessager say: 3 3 19 3 self 340) ; "She flies off, leaving Alexander alone at the top of the cliffs."
					)
					(else
						(gMessager say: 10 0 0 1 self 340) ; "Night Mare merely eyes the object in Alexander's hand with suspicion, and goes back to eating the nightshade."
					)
				)
			)
			(3
				(gGlobalSound2 fade: 0 20 5)
				(gEgo reset: 6)
				(rSacred marePresent: 0)
				(nightMare dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coldEmbers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 193 131 self)
			)
			(1
				(gEgo setHeading: 45)
				(= local1 (gEgo x:))
				(= local2 (gEgo y:))
				(= cycles 6)
			)
			(2
				(gEgo
					view: 336
					normal: 0
					setLoop: 0
					cel: 0
					cycleSpeed: 18
					posn: (+ (gEgo x:) 14) (+ (gEgo y:) 7)
					setCycle: Fwd
				)
				(= seconds 5)
			)
			(3
				(gMessager say: 1 0 4 1 self 340) ; "Alexander solemnly speaks the incantation over the skull."
			)
			(4
				(KQ6Print
					say: 0 1 0 4 2
					posn: 10 10
					ticks: 120
					modeless: 1
					init:
				)
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(6
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(7
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(8
				(gEgo setLoop: 7 cel: 0 setCycle: End self)
			)
			(9
				(gEgo setLoop: 8)
				(= seconds 1)
			)
			(10
				(nightMare setCycle: Beg self)
				(gGlobalSound4 number: 346 setLoop: 1 play:)
			)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gMessager say: 1 0 30 1 self 340) ; "The skull does not respond to Alexander's incantation. The embers have grown cold since Alexander gathered them, thus ruining the spell."
			)
			(12
				(nightMare setCycle: Fwd)
				(= seconds 3)
			)
			(13
				(gMessager say: 1 0 30 2 self 340) ; "Night Mare regards Alexander with disdain and continues her meal."
			)
			(14
				(gEgo posn: local1 local2 reset: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance catchNiteMare of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 11 340) ; skull
				(gGame handsOff:)
				(gTheIconBar disable: 6)
				(gEgo setMotion: PolyPath 193 131 self)
			)
			(1
				(gEgo setHeading: 45)
				(= cycles 6)
			)
			(2
				(gEgo
					view: 336
					normal: 0
					setLoop: 0
					cel: 0
					cycleSpeed: 6
					posn: (+ (gEgo x:) 14) (+ (gEgo y:) 7)
					setCycle: Fwd
				)
				(= seconds 5)
			)
			(3
				(gMessager say: 1 0 4 1 self 340) ; "Alexander solemnly speaks the incantation over the skull."
			)
			(4
				(KQ6Print
					say: 0 1 0 4 2
					posn: 10 10
					ticks: 120
					modeless: 1
					init:
				)
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo setLoop: 1 cel: 0 cycleSpeed: 8 setCycle: Fwd)
				(= seconds 12)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(gEgo cel: 0)
				(= cycles 4)
			)
			(8
				(gEgo setLoop: 7 cel: 0)
				(= cycles 6)
			)
			(9
				(gEgo cel: 1)
				(= cycles 6)
			)
			(10
				(gEgo setLoop: 8)
				(= seconds 1)
			)
			(11
				(smoke init: setCycle: End self)
			)
			(12
				(gGlobalSound4 number: 346 setLoop: 1 play:)
				(nightMare setCycle: Beg)
				(smoke setLoop: 10 cel: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(13
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gMessager say: 1 0 4 3 self 340) ; "Night Mare flares her nostrils at the scent of the fire and brimstone."
			)
			(14
				(gEgo view: 336 setLoop: 2 setCycle: End self)
				(smoke setLoop: 9 cel: 10 setCycle: Beg)
				(nightMare
					view: 337
					loop: 0
					cel: 0
					posn: 265 112
					setCycle: End self
				)
			)
			(15
				(smoke dispose:)
			)
			(16
				(gMessager say: 1 0 4 4 self 340) ; "That's it! Come on. I need passage to your homeland, fiery one!"
			)
			(17
				(theSkull init: setPri: 1 stopUpd:)
				(gEgo put: 11 340) ; skull
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				(gEgo
					posn: (- (gEgo x:) 14) (- (gEgo y:) 7)
					ignoreActors:
					reset: 6
					setPri: 9
				)
				(nightMare
					setScale: Scaler 100 80 134 112
					posn: (- (nightMare x:) 5) (- (nightMare y:) 3)
					setLoop: 1
					setPri: 10
					setCycle: Walk
					illegalBits: 0
					setMotion: MoveTo 220 134 self
				)
			)
			(18
				(gMessager say: 1 0 4 5 self 340) ; "Unable to resist the power of the enchanted smell, Night Mare approaches Alexander. Her eyes appear glassy and sightless. In her hypnotized state, she is unaware of the human so close to her flank or of anything at all except that marvelous smell!"
			)
			(19
				(nightMare
					setScale: 0
					view: 336
					setLoop: 5
					cel: 0
					posn: 216 135
					setCycle: End
				)
				(gEgo setMotion: PolyPath 167 122 self)
			)
			(20
				(gEgo setHeading: 135)
				(= cycles 8)
			)
			(21
				(nightMare hide:)
				(gEgo
					view: 336
					normal: 0
					posn: 216 135
					setLoop: 3
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(22
				(nightMare show: view: 335 setLoop: 1 cel: 0 posn: 216 135)
				(gEgo
					setScale: 0
					view: 336
					normal: 0
					setLoop: 6
					cel: 0
					setPri: (+ (nightMare priority:) 1)
					posn: (+ (nightMare x:) 35) (- (nightMare y:) 46)
				)
				(gGame givePoints: 2)
				(= cycles 2)
			)
			(23
				(gMessager say: 1 0 4 6 self 340) ; "Now ride!"
			)
			(24
				(gGlobalSound2 number: 155 setLoop: -1 play:)
				(gGlobalSound fade:)
				(gGlobalSound3 fade:)
				(gGlobalSound4 fade:)
				(= ticks 4)
			)
			(25
				(++ local0)
				(nightMare cel: (+ (nightMare cel:) 1))
				(gEgo cel: (+ (gEgo cel:) 1))
				(= ticks 14)
			)
			(26
				(if (< local0 9)
					(-= state 2)
				)
				(self cue:)
			)
			(27
				(gEgo x: 1000)
				(nightMare cel: (+ (nightMare cel:) 1))
				(= seconds 2)
			)
			(28
				(gGame handsOn:)
				(gTheIconBar enable: 6)
				(gCurRoom newRoom: 155)
			)
		)
	)
)

(instance birdSound of Sound
	(properties)
)

