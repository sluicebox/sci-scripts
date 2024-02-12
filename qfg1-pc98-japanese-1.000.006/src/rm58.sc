;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 58)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm58 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(Print &rest #width 305 #mode 0 #window giantWin)
)

(procedure (localproc_1)
	(localproc_0 58 0) ; "Brauggi I be, to boast of my boldness, Strong as the storm that sends forth the snow. Fiercer in fighting than foes in their fury, Fear now this Frost Giant fighter and flee!"
)

(procedure (localproc_2)
	(localproc_0 58 1) ; "Find me some fruit for to mellow my mead horn, Gift I will give of a gem that now glows -- Jewel from Jotunheim, flare of the frost flame, Fetch to me fruit that will fill up my fists!"
	(LowPrint 58 2) ; "(It looks like it will take a lot of fruit to fill up THOSE fists!)"
)

(instance giantWin of SysWindow
	(properties
		color 1
	)

	(method (open &tmp temp0)
		(= temp0 (- 188 bottom))
		(+= top temp0)
		(+= bottom temp0)
		(super open:)
	)
)

(instance frostStart of Prop
	(properties
		view 59
		loop 5
	)
)

(instance frostKill of Prop
	(properties
		view 59
		loop 6
	)
)

(instance frostSound of Sound
	(properties
		number 14
		priority 2
	)
)

(instance giant of Act
	(properties
		y 82
		x 32
		yStep 3
		view 59
		cycleSpeed 1
		illegalBits 0
		xStep 5
		moveSpeed 1
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((super handleEvent: event))
			(local2 1)
			((or (MouseClaimed self event 3) (Said 'look,look/giant,brauggi,man'))
				(LowPrint 58 3) ; "From the blue color of his skin and his huge height, you can tell this is a Frost Giant."
			)
			((== (event type:) evSAID)
				(cond
					((Said 'cut,hit,attack,kill,damage')
						(self setScript: giantFights)
					)
					((Said 'cast>')
						(switch (= temp0 (SaidSpell event))
							(18
								(if (CastSpell temp0)
									(LowPrint 58 4) ; "The Giant (who does not seem pleased at your casting a spell in his presence) radiates a magical aura. The strongest magic centers on the glowing gem at his belt."
								)
							)
							(19
								(giant setScript: giantMagic)
							)
							(20
								(giant setScript: giantMagic)
							)
							(21
								(giant setScript: giantMagic)
							)
							(22
								(giant setScript: giantMagic)
							)
							(23
								(giant setScript: giantMagic)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'give,bargain,bargain>')
						(cond
							((Said 'give,bargain,bargain[/!*]')
								(localproc_2)
							)
							((not (= temp1 (SaidInv event)))
								(HighPrint 58 5) ; "You can't offer what you don't have."
							)
							((== temp1 11)
								(gEgo setScript: giveFruit)
							)
							(else
								(event claimed: 1)
								(LowPrint 58 6) ; "The Giant looks at you in disgust. Apparently, you did not offer what he desires."
							)
						)
					)
					((Said 'make/bargain,bargain,deal,deal')
						(localproc_2)
					)
					((Said 'bargain,bargain,deal,deal')
						(localproc_2)
					)
					((Said 'talk,talk')
						(localproc_1)
					)
					((Said 'throw[/boulder,dagger]')
						(= local1 1)
						(giant setScript: giantMagic)
					)
					((Said 'ask>')
						(cond
							((Said '//man,fighter,giant,brauggi,you')
								(localproc_1)
							)
							(
								(Said
									'//home,north,jotunheim,(field[<frost,about]),jotunheim'
								)
								(localproc_0 58 7) ; "Near now is North, for the winter has wandered, Bringing this brave one to barter so bold. I journey from Jotunheim, home of the giants, Source of all snowstorms, the sender of sleet."
							)
							((Said '//bargain,bargain,deal,deal')
								(localproc_2)
							)
							(
								(Said
									'//attack,ax,weapon,blade,(attack,attack[<blade,about])'
								)
								(self setScript: Challenge)
							)
							((Said '//hunger')
								(localproc_0 58 8) ; "Hollow my food house,     for my hunt has been hindered, By having to hurry here from my home."
							)
							((Said '//food,apple,apple,beet')
								(localproc_0 58 9) ; "Highpoint of harvest, the finest of flavor, Apples or oranges, peaches or pears."
							)
							((Said '//mead,horn')
								(localproc_0 58 10) ; "Mead is the mother's milk, mighty yet mellow, That brings joy to Giants and madness to men."
							)
							((Said '//gem,(flame[<frost,about])')
								(localproc_0 58 11) ; "Glow of the frost flame that fills up the night field, A jewel that is flawless, the finest of gems."
							)
							(else
								(event claimed: 1)
								(switch (++ local0)
									(1
										(localproc_0 58 12) ; "Bored I become when the banter so blindly Speaks of the subjects I care not about."
									)
									(2
										(localproc_0 58 13) ; "Annoy me not over matters so minor."
									)
									(3
										(localproc_0 58 14) ; "Waste not my wits, for I weary of words; My axe it is asking for action and more."
										(= local0 0)
										(giant setScript: giantExits)
									)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance rm58 of Rm
	(properties
		picture 59
		style 8
		west 57
	)

	(method (dispose)
		(SetFlag 48)
		(super dispose:)
	)

	(method (init)
		(Load rsTEXT 58)
		(LoadMany rsSOUND 47 (SoundFX 9))
		(LoadMany rsVIEW 5 517 503)
		(if (not (= local2 (IsFlag 208)))
			(LoadMany rsVIEW 59 502 513 515)
			(LoadMany rsSOUND 48 (SoundFX 59) (SoundFX 65) (SoundFX 14))
		)
		(super init:)
		(gContMusic fade:)
		(SL enable:)
		(NormalEgo)
		(EgoGait 0 0) ; walking
		(if local2
			(gContMusic number: 47)
			(gEgo posn: 1 140 init: setMotion: MoveTo 35 140)
		else
			(gContMusic number: 48)
			(frostSound number: (SoundFX 14) init:)
			(gEgo posn: 0 135 init: setScript: egoInit)
			(if (< global211 8)
				(giantWin color: 0 back: 15)
			)
			(giant
				setPri: 4
				setLoop: 0
				setCycle: Walk
				init:
				setScript: giantInit
			)
		)
		(gContMusic loop: 1 play: self)
	)

	(method (cue)
		(gContMusic number: 47 loop: -1 play:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((== (event type:) evSAID)
				(cond
					((Said 'run[/!*]')
						(gEgo setScript: egoRuns)
					)
					((Said 'look,look>')
						(cond
							(
								(Said
									'[<at,around][/!*,hill,ice,clearing,north,east,south]'
								)
								(HighPrint 58 15) ; "The mountains rise quickly from this point and are covered with snow."
							)
							((Said '/west,forest')
								(HighPrint 58 16) ; "The snow has melted in most of the forest, but here it is still heavy."
							)
							((Said '/gem')
								(if (or (not local2) (gEgo has: 13)) ; magic gem
									(HighPrint 58 17) ; "The gem glows like an aurora in the night sky."
								else
									(HighPrint 58 18) ; "You don't see a gem here."
								)
							)
							((Said '/giant,brauggi,man')
								(if (IsFlag 208)
									(HighPrint 58 19) ; "Brauggi has departed on the long journey to his homeland."
								else
									(HighPrint 58 20) ; "Brauggi has become impatient with your questions and gone elsewhere. You will have to return another time."
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance egoInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client setMotion: MoveTo 130 125 self)
			)
			(1
				(LookAt client giant)
				(client setScript: 0)
			)
		)
	)
)

(instance giantInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: MoveTo 106 82 self)
			)
			(1
				(client setPri: -1 setMotion: MoveTo 125 93 self)
			)
			(2
				(client setCycle: End self)
			)
			(3
				(frostSound number: (SoundFX 59) play:)
				(client setLoop: 2 cel: 2 cycleSpeed: 0 setCycle: CT 0 1 self)
			)
			(4
				(if (== gHowFast 0)
					(self cue:)
				else
					(frostSound play:)
					(giant setCycle: CT 0 1 self)
				)
			)
			(5
				(HandsOn)
				(if (not (IsFlag 48))
					(localproc_0 58 21) ; "Far from the frost field, fares forth this fighter, Hunger has hurled me hither from home. My name it is known in the Northlands as Brauggi, Barter with blade's clash, or bargain with me."
				)
				(client setScript: giantBlocks)
			)
		)
	)
)

(instance giantExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(giant
					setLoop: 4
					setCel: -1
					cel: 0
					setCycle: Fwd
					moveSpeed: 1
					cycleSpeed: 1
					illegalBits: 0
					setMotion: MoveTo 106 82 self
				)
			)
			(1
				(giant setMotion: MoveTo -20 75 self)
			)
			(2
				(gContMusic number: 47 play:)
				(= local2 1)
				(HandsOn)
				(giant dispose:)
			)
		)
	)
)

(instance doneDeal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo get: 13 1) ; magic gem
				(localproc_0 58 22) ; "Fruit you have found, to fill all my food stores, Thus filled the bargain, my gem you have bought. Brauggi has bartered, and all has been answered; The mead it may mellow, and now I head home."
				(SolvePuzzle 679 8)
				(= seconds 2)
			)
			(1
				(SetFlag 208)
				(giant setScript: giantExits)
			)
		)
	)
)

(instance ShowOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(frostSound number: (SoundFX 59) play:)
				(giant cycleSpeed: 0 setLoop: 2 cel: 0 setCycle: End self)
			)
			(1
				(if (== gHowFast 0)
					(self cue:)
				else
					(giant setCycle: End self)
				)
			)
			(2
				(frostSound stop:)
				(client setScript: 0)
			)
		)
	)
)

(instance Challenge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: ShowOff self)
			)
			(1
				(localproc_0 58 23) ; "Fiercer than frost's bite, my fury is fearless, My axe it is edged as is the ice. This warrior is willing to wield now the war drum, The battleaxe blazes and bellows for blood."
				(client setScript: giantBlocks)
			)
		)
	)
)

(instance WalkToGiant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1 illegalBits: 0)
				(if (< (gEgo y:) (+ (giant y:) 10))
					(gEgo
						setMotion: MoveTo (gEgo x:) (+ (giant y:) 10) self
					)
				else
					(self cue:)
				)
			)
			(1
				(gEgo
					setMotion: MoveTo (+ (giant x:) 5) (+ (giant y:) 10) self
				)
			)
			(2
				(gEgo ignoreActors: 0 illegalBits: -32768)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giantFights of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(switch (= state newState)
			(0
				(gEgo setScript: WalkToGiant self)
			)
			(1
				(HandsOff)
				(= temp0 (if (gEgo has: 9) 0 else 2)) ; shield
				(gEgo
					illegalBits: 0
					ignoreActors:
					view: 502
					setLoop: temp0
					cel: 0
					posn: (+ (giant x:) 5) (+ (giant y:) 2)
					setCycle: End
				)
				(= cycles 4)
			)
			(2
				(frostSound number: (SoundFX 59) play:)
				(giant setLoop: 3 cel: 0 cycleSpeed: 1 setCycle: CT 5 1 self)
			)
			(3
				(giant setCycle: End self)
				(gEgo
					view: 513
					posn: (+ (gEgo x:) 20) (gEgo y:)
					setLoop: 0
					setCel: -1
					cel: 5
					cycleSpeed: 2
					moveSpeed: 2
					illegalBits: 0
				)
				(= temp2 (gEgo x:))
				(= temp3 (gEgo y:))
				(= temp4 260)
				(= temp5 140)
				(= temp6 (/ (- temp4 temp2) (- (gEgo lastCel:) 5)))
				(= temp7 (/ (- temp5 temp3) (- (gEgo lastCel:) 5)))
				(gEgo
					xStep: temp6
					yStep: temp7
					setCycle: End
					setMotion: MoveTo temp4 temp5
				)
			)
			(4
				(giant setCycle: Beg self)
			)
			(5
				(frostSound stop:)
				(if (or (IsFlag 213) (not (TakeDamage 20)))
					(EgoDead ; "Next time, pick on someone your own size."
						58
						24
						80
						{The bigger they come, the harder they hit}
						82
						59
						3
						3
					)
				else
					(SetFlag 213)
					(self cue:)
				)
			)
			(6
				(if (> (= temp1 (gEgo x:)) 237)
					(= temp1 237)
				)
				(giant
					setLoop: 1
					setCel: -1
					cel: 0
					setCycle: Walk
					moveSpeed: 1
					cycleSpeed: 1
					setMotion: MoveTo temp1 (giant y:)
				)
				(= seconds 3)
			)
			(7
				(gEgo view: 515 setLoop: 1)
				(gEgo
					cel: (gEgo lastCel:)
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(8
				(NormalEgo)
				(gEgo loop: 3 forceUpd:)
				(self setScript: ShowOff self)
			)
			(9
				(localproc_0 58 25) ; "Courage you carry, but skill it is scanty; Face not this foe before fiercer you fight."
				(HandsOn)
				(client setScript: giantBlocks)
			)
		)
	)
)

(instance giantBlocks of Script
	(properties)

	(method (init)
		(super init: &rest)
		(client setLoop: 1 setCel: 0)
		(= register 4)
	)

	(method (dispose)
		(client setLoop: 2 setCel: 0 setCel: -1)
		(super dispose:)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (gEgo x:))
		(= temp1 (client x:))
		(= temp2 (client cel:))
		(cond
			((and (> temp1 117) (<= temp0 (- temp1 5)))
				(= register 4)
				(if (< (-- temp2) 0)
					(= temp2 (client lastCel:))
				)
				(client setCel: temp2 posn: (- temp1 7) (client y:))
			)
			((and (< temp1 231) (>= temp0 (+ temp1 5)))
				(= register 4)
				(if (> (++ temp2) (client lastCel:))
					(= temp2 0)
				)
				(client setCel: temp2 posn: (+ temp1 7) (client y:))
			)
			((not (-- register))
				(client setCel: 0)
				(= register 4)
			)
		)
		(super doit:)
	)
)

(instance giveFruit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: WalkToGiant self)
			)
			(1
				(if (gEgo has: 11) ; apple
					(cond
						((>= (+= global329 (gEgo use: 11 50)) 50) ; apple
							(giant setScript: doneDeal)
						)
						((>= global329 40)
							(LowPrint 58 26) ; "Your fruit definitely makes a generous pile in the Giant's cupped hands, but they're not full yet."
						)
						((== global329 0)
							(HighPrint 58 27) ; "Oops!" you say. "I guess I don't have any fruit for you. Sorry!"
						)
						(else
							(LowPrint 58 28) ; "Your meagre selection of fruit makes a paltry pile at the bottom of the Giant's cupped hands. You'll need to get quite a few more apples to fill THOSE hands!"
						)
					)
				else
					(HighPrint 58 27) ; "Oops!" you say. "I guess I don't have any fruit for you. Sorry!"
				)
				(self dispose:)
			)
		)
	)
)

(instance giantMagic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local1
					(TimePrint 4 58 29 107) ; "As you start to throw..."
				else
					(TimePrint 4 58 30 107) ; "As you begin to cast your spell..."
				)
				(= seconds 2)
			)
			(1
				(giant setLoop: 2 setCel: 0)
				(= cycles 2)
			)
			(2
				(giant setCel: 1)
				(= cycles 2)
			)
			(3
				(giant stopUpd:)
				(frostStart
					ignoreActors: 1
					posn: (giant x:) (- (giant y:) 26)
					setPri: (giant priority:)
					z: 1
					init:
					setCycle: Fwd
				)
				(= cycles 8)
			)
			(4
				(frostKill
					ignoreActors: 1
					posn: (gEgo x:) (- (gEgo y:) 25)
					setPri: (gEgo priority:)
					z: 2
					init:
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(5
				(frostSound number: (SoundFX 65) play: self)
			)
			(6
				(frostSound number: (SoundFX 14) play:)
				(frostStart setCycle: 0 stopUpd: hide:)
				(gEgo
					view: 513
					posn: (+ (gEgo x:) 20) (gEgo y:)
					setLoop: 0
				)
				(gEgo setCel: (gEgo lastCel:))
				(frostKill
					setPri: (gEgo priority:)
					posn: (gEgo x:) (- (gEgo y:) 9)
					setCycle: Fwd
				)
				(= seconds 5)
			)
			(7
				(frostKill hide:)
				(EgoDead ; "In matters of magic, I am your master; Seek not to slay me with sendings so small."
					58
					31
					80
					{Just because he's big doesn't mean he's stupid! }
					82
					59
					0
					0
				)
			)
		)
	)
)

(instance egoRuns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					view: 5
					setStep: 6 4
					setPri: (+ (giant priority:) 2)
					setCycle: Walk
				)
				(if (< (gEgo x:) 170)
					(gEgo
						setMotion: MoveTo (+ (gEgo x:) 30) (gEgo y:) self
					)
				else
					(gEgo
						setMotion: MoveTo (- (gEgo x:) 30) (gEgo y:) self
					)
				)
			)
			(1
				(frostSound number: (SoundFX 9) play:)
				(gEgo
					view: 517
					setLoop: 2
					setCel: -1
					cel: 0
					posn: (- (gEgo x:) 4) (- (gEgo y:) 15)
					moveSpeed: 2
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(frostSound stop:)
				(= cycles 8)
			)
			(3
				(if (> (gEgo y:) 148)
					(gEgo posn: (gEgo x:) 148)
				)
				(gEgo
					view: 503
					setLoop: 4
					setPri: -1
					cel: 0
					posn: (+ (gEgo x:) 9) (+ (gEgo y:) 36)
					illegalBits: -32768
					setCycle: End self
				)
			)
			(4
				(= seconds 2)
			)
			(5
				(TakeDamage 2)
				(HandsOn)
				(NormalEgo)
				(HighPrint 58 32) ; "Running on the ice is apparently not a very good idea."
				(self dispose:)
			)
		)
	)
)

