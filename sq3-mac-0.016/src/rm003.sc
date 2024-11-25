;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Interface)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm003 0
)

(synonyms
	(craft craft)
)

(local
	local0
	local1
	local2
)

(instance rm003 of Rm
	(properties
		picture 3
		style 0
		horizon 52
		north 2
		east 4
	)

	(method (init &tmp [temp0 50])
		(= global56 120)
		(if (!= gPrevRoomNum 12)
			(self setLocales: 700 setFeatures: jupiter acme bow bore)
		)
		(if (== gPrevRoomNum 12)
			(HandsOff)
		else
			(HandsOn)
		)
		(if (== gPrevRoomNum 12)
			(Load rsVIEW 258)
			(Load rsSOUND 76)
		else
			(Load rsVIEW 0)
			(Load rsVIEW 193)
			(Load rsVIEW 6)
		)
		(Load rsSOUND 45)
		(if (== global149 gCurRoomNum)
			(Load rsVIEW 36)
			(motivator init:)
		)
		(if (or (== gPrevRoomNum 15) (== gPrevRoomNum 4))
			(gEgo setLoop: -1)
		)
		(if (or (== gPrevRoomNum 4) (== gPrevRoomNum 15))
			(Load rsSOUND 11)
			(gLongSong number: 11 loop: -1 play:)
		)
		(super init:)
		(if (and (!= gPrevRoomNum 15) (!= gPrevRoomNum 4))
			(gEgo posn: 127 57 loop: 1)
		)
		(if (== gPrevRoomNum 15)
			(if (not global133)
				(Print 3 0) ; "Bending aside a thin piece of scrap, you find an opening into another area and climb on in."
				(= global133 1)
			)
			(gEgo
				view: 6
				posn: 37 162
				setLoop: -1
				setPri: -1
				illegalBits: $8000
			)
		)
		(= global100 0)
		(if (== gPrevRoomNum 12)
			(self setScript: grabScript)
		else
			(gEgo init:)
		)
	)

	(method (handleEvent event)
		(if (or global100 (event claimed:))
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '/bow,bow,tie')
								(Print 3 1) ; "This bulbous craft looks like it has seen a lot of action in its day. You believe it to be a bowtie fighter dating back to the cologne wars - a true relic."
							)
							((Said '/acme')
								(Print 3 2) ; "This on is another fine, but worthless, Acme product."
							)
							((Said '/jup,2')
								(Print 3 3) ; "This ship says Jupiter 2. This baby must have been floating around out there for a long time. It doesn't hold your interest for very long."
							)
							((Said '/nozzle')
								(Print 3 4) ; "None are visible."
							)
							(
								(and
									global133
									(IsItemAt 2 15) ; Ladder
									(Said 'look/ladder')
								)
								(if (gEgo inRect: 22 149 66 175)
									(Print 3 5) ; "It looks like your standard low-tech ascent/descent unit."
								else
									(Print 3 6) ; "It's not visible from here."
								)
							)
							((and global133 (Said '[<in,in,through,at]/cavity'))
								(if (gEgo inRect: 22 149 66 175)
									(Print 3 7) ; "You can see down into the hole you once passed through. Nothing much can be seen from here."
								else
									(Print 3 8) ; "You can't from here."
								)
							)
							(
								(Said
									'[<in,through,at,in]/pane,port,(port<cavity)'
								)
								(if (gEgo inRect: 39 148 105 167)
									(Print 3 9) ; "The limited detail you make out through the ship's film-laden viewport is enough to convince you that everything of worth has been harvested."
								else
									(NotClose) ; "It's not quite within reach."
								)
							)
							((Said '/box')
								(Print 3 10) ; "The square object looks like an empty component cover for some craft. It covers nothing but deck now."
							)
							((Said '[<below,at]/iron')
								(Print 3 11) ; "You see nothing but riveted steel."
							)
							((Said '[<around,at,in][/area,!*]')
								(Print 3 12) ; "Various types of abandoned spacecraft litter the floor of this intergalactic junkyard. All this place needs is a junk yard dog. You shiver at the thought."
							)
						)
					)
					((Said 'break,open/pane,glass,dome,port,(cavity<port)')
						(Print 3 13) ; "You can't do that, nor would it be helpful."
					)
					(
						(Said
							'hoist,manipulate,press,pull/craft,leech,bow,bow,tie,bore,acme,jup,2,(craft<flying)'
						)
						(Print 3 14) ; "Despite technological advances in strong, lightweight ship materials, you can't possibly budge it."
					)
					((Said 'listen[/sound]')
						(Print 3 15) ; "You hear the faint sound of machinery in operation."
					)
					(
						(Said
							'open,board,enter,(climb[<in,in])/craft,bow,bow,tie,bore,acme,jup,2,(craft<flying),door'
						)
						(Print 3 16) ; "There is no visible means of entry."
					)
					((Said 'walk,climb[<on,up]/craft')
						(Print 3 17) ; "You are not skilled in ship climbing."
					)
					((Said 'clean')
						(Print 3 18) ; "It's against your nature to do that."
					)
					((Said 'get,manipulate/box')
						(Print 3 19) ; "Don't waste your time with that stupid box."
					)
					(
						(Said
							'erect,stand,place,drop,lower,use/ladder[/cavity[<in,in,in]]'
						)
						(if (or (gEgo has: 2) ((gInventory at: 2) ownedBy: 8)) ; Ladder, Ladder
							(if (gEgo inRect: 22 149 66 175)
								(if (gEgo has: 2) ; Ladder
									(PutItem 2 15) ; Ladder
									(gGame changeScore: -10)
									(Print 3 20) ; "OK."
								else
									(Print 3 21) ; "You don't have it."
								)
							else
								(Print 3 22) ; "Not from here."
							)
						else
							(event claimed: 0)
							(return)
						)
					)
					((Said 'descend,climb,go[<down][/ladder,cavity]')
						(if global133
							(if (gEgo inRect: 22 149 66 175)
								(if
									(and
										(not (gEgo has: 2)) ; Ladder
										(not (IsItemAt 2 8)) ; Ladder
									)
									(gEgo hide:)
									(RedrawCast)
									(gCurRoom newRoom: 15)
								else
									(Print 3 23) ; "There is no ladder here to climb."
								)
							else
								(Print 3 22) ; "Not from here."
							)
						else
							(Print 3 24) ; "There is nothing to climb into."
						)
					)
					((Said 'use,get,climb/debris,scrap,iron')
						(if (gEgo inRect: 210 89 276 110)
							(gEgo setScript: bleedScript)
						else
							(Print 3 25) ; "That would be fruitless. Don't bother."
						)
					)
					((Said 'get/ladder')
						(if global133
							(if (and (not (gEgo has: 2)) (not global134)) ; Ladder
								(if (gEgo inRect: 22 149 66 175)
									(gGame changeScore: 10)
									(gEgo get: 2) ; Ladder
									(Print 3 26) ; "You grab the ladder and jam it in your pocket."
									(Print 3 27) ; "Ouch!"
								else
									(Print 3 22) ; "Not from here."
								)
							else
								(Print 3 28) ; "It's not here to be gotten."
							)
						else
							(Print 3 29) ; "There is no ladder here."
						)
					)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (or (== newRoomNumber 15) (== newRoomNumber 4))
			(gLongSong stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(if (or (== (gEgo view:) 0) (== (gEgo view:) 6))
			(cond
				(
					(or
						(== (gEgo onControl: 0) 4)
						(== (gEgo onControl: 0) 5)
					)
					(gEgo view: 6)
				)
				((== (gEgo onControl: 0) 1)
					(gEgo view: 0)
				)
			)
		)
		(super doit:)
	)
)

(instance rmScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global100 1)
				(gEgo hide:)
				(Print 3 30) ; "You ease your way into the hole."
				(Timer set: self 2)
				(fallTune play:)
			)
			(1
				(Print 3 31) ; "Unfortunately, the fall was too much for your frail frame to withstand."
				(EgoDead 901 0 0 1)
			)
		)
	)
)

(instance grabScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= local1 (Act new:))
					view: 258
					setLoop: (if (== global135 3) 2 else 0)
					setPri: 8
					setStep: 1 2
					x: (if global147 249 else 81)
					y: -16
					illegalBits: 0
					ignoreHorizon: 1
					ignoreActors: 1
					init:
					setCycle: Fwd
					setMotion: MoveTo (if global147 249 else 81) 99 self
				)
			)
			(1
				(Timer set: self 2)
			)
			(2
				(cond
					((== global135 3)
						(= global148 4)
						(= global135 global147)
						(motivator init:)
						(= global149 gCurRoomNum)
						(gLongSong number: 76 loop: 1 play:)
						(gGame changeScore: -15)
						(RedrawCast)
						(Print 3 32) ; "Sensing the floor the claw releases its cargo and begins the ascent to the grabber unit."
					)
					((and (== global149 gCurRoomNum) (== global135 global147))
						(local1 setLoop: 2)
						(motivator hide:)
						(= global149 0)
						(= global135 3)
						(= global148 5)
						(gLongSong number: 76 loop: 1 play:)
						(gGame changeScore: 15)
						(RedrawCast)
						(Print 3 33) ; "The claw senses contact with the warp motivator, grasps it firmly, and begins the ascent back to the grabber."
					)
					(else
						(Print 3 34) ; "Finding nothing here the claw begins to ascend to the grabber unit."
						(= global148 4)
					)
				)
				(self changeState: 3)
			)
			(3
				(local1
					setLoop: (if (== global135 3) 2 else 0)
					setMotion: MoveTo (if global147 249 else 81) -16 self
				)
			)
			(4
				(gCurRoom newRoom: 12)
			)
		)
	)
)

(instance bleedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 193
					illegalBits: 0
					setLoop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(= local2 (Print 3 35 #dispose)) ; "YEOW!"
			)
			(1
				(gEgo setLoop: 1 cel: 0 cycleSpeed: 1 setCycle: Fwd)
				(= seconds 4)
				(cls)
			)
			(2
				(gEgo cycleSpeed: 3)
				(= cycles 25)
			)
			(3
				(gEgo cycleSpeed: 6)
				(= seconds 4)
			)
			(4
				(gEgo cycleSpeed: 3)
				(= cycles 25)
			)
			(5
				(gEgo cel: 0 setCycle: 0)
				(RedrawCast)
				(Print 3 36 #at -1 20 #width 280) ; "It's obvious that the metal was sharper than you. The resulting laceration turns you into a living fountain - at least for a few moments. Unfortunately for you, this show was your finale. Good luck in the afterlife."
				(EgoDead 901 0 6 8)
			)
		)
	)
)

(instance motivator of Act
	(properties
		view 36
	)

	(method (init)
		(super init:)
		(self
			setLoop: 0
			setCel: 0
			x: (if (== global135 1) 264 else 96)
			y: 115
			setPri: 7
			stopUpd:
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look>')
				(cond
					((Said '/motivator,artifact,device')
						(if global186
							(Print 3 37) ; "It looks like the warp motivator you saw on the Aluminum Mallard's Status Computer. Sturdily constructed, its only protrusion is a modular plug near its base."
						else
							(Print 3 38) ; "A closer look at the object on the floor reveals that it is a warp motivator. It looks a bit more high-tech than the other junk strewn about this locale. Sturdily constructed, its only protrusion is a modular plug near its base."
						)
					)
					(
						(or
							(Said '/plug[<modular,8,eightprong]')
							(Said '/eightprong[<8]')
						)
						(Print 3 39) ; "The eight-pronged plug protrudes only slightly from the motivator's exterior."
					)
					((Said '[<down,below,at][/dirt,deck]')
						(Print 3 40) ; "The floor is composed of a mosaic of overlapping welded steel plates. The melange of used metal plates appear to have been cut from a variety of sources. There is a small round object lying nearby."
					)
				)
			)
			(
				(Said
					'turn,get,manipulate,press,roll,pull/motivator,artifact,device'
				)
				(Print 3 41) ; "While relatively small, it seems to be quite dense. I think we're looking at a potential hernia if any attempts are made to manually relocate it."
			)
			((Said '(turn<on),start/motivator,artifact,device')
				(Print 3 42) ; "You aren't capable of doing that."
			)
			((Said 'press,pull,remove,get/plug[<modular,8,eightprong]')
				(Print 3 43) ; "You can't. It's permanently attached."
			)
		)
	)
)

(instance jupiter of Feature
	(properties
		y 75
		x 269
	)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			((Said 'look/craft')
				(Print 3 3) ; "This ship says Jupiter 2. This baby must have been floating around out there for a long time. It doesn't hold your interest for very long."
			)
		)
	)
)

(instance bow of Feature
	(properties
		y 144
		x 61
	)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			((Said 'look/craft,bow,tie,bow')
				(Print 3 1) ; "This bulbous craft looks like it has seen a lot of action in its day. You believe it to be a bowtie fighter dating back to the cologne wars - a true relic."
			)
		)
	)
)

(instance bore of Feature
	(properties
		y 138
		x 212
	)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			((Said 'look/craft,bore,implement')
				(Print 3 44) ; "This looks like some type of tunnel boring implement."
			)
		)
	)
)

(instance acme of Feature
	(properties
		y 85
		x 172
	)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			((Said 'look/craft')
				(Print 3 45) ; "This ship is another fine, but worthless, Acme product."
			)
		)
	)
)

(instance fallTune of Sound
	(properties
		number 45
		priority 5
	)
)

