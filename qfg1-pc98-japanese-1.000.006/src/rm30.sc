;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use RFeature)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm30 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0 param1)
	(if (and (!= local3 param1) (== (fenrus loop:) 1))
		(= local3 param1)
		(fenrus cel: param1 forceUpd:)
	)
)

(procedure (localproc_1)
	(HighPrint 30 0) ; "This room is full of odds, ends, and stuff. The wizard must be a real character."
)

(procedure (localproc_2)
	(HighPrint 30 1) ; "Through the portal to the east is a large formal dining room."
)

(procedure (localproc_3)
	(HighPrint 30 2) ; "Through the portal to the west is a small sitting room."
)

(procedure (localproc_4)
	(HighPrint 30 3) ; "Against the east wall, you see a bookcase and a desk, above which is hung a dragon's head trophy. These are on either side of a doorway, above which hangs a shield."
	(localproc_2)
)

(procedure (localproc_5)
	(HighPrint 30 4) ; "Leaning against the west wall is a mummy case. Above that hangs an ancient tapestry."
	(localproc_3)
)

(procedure (localproc_6)
	(HighPrint 30 5) ; "The wall is plain. You see nothing but the front door of the house."
)

(procedure (localproc_7)
	(HighPrint 30 6) ; "Above the staircase hangs a portrait, flanked by decorative wall hangings.  In an alcove on the landing stands a suit of armor."
	(HighPrint 30 7) ; "There is a table up against the staircase wall, and on the wall hangs an onklunk."
)

(instance Magic of Prop
	(properties
		view 530
		cycleSpeed 2
	)
)

(instance rm30 of Rm
	(properties
		picture 30
		style 0
	)

	(method (dispose)
		(SetFlag 20)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 530 30 199)
		(super init:)
		(gMouseHandler add: self)
		(SolvePuzzle 658 3)
		(SL enable:)
		(NormalEgo)
		(gEgo posn: 160 189 init: setScript: intro)
		(gAddToPics
			add:
				theFrame
				bigChair
				smChair
				hang1
				hang2
				lunk
				plane
				armor
				mummy
				shelf
			eachElementDo: #init
			doit:
		)
		(theDunker setPri: 14 posn: 112 160 init: startUpd: setScript: dunker)
		(peacock posn: 186 122 init: stopUpd:)
		(dragon posn: 282 116 init: stopUpd:)
		(theLight
			setPri: 9
			posn: 161 102
			init:
			setCycle: Fwd
			startUpd:
			setScript: lightBulb
		)
		(theWiz setPri: 5 posn: 146 72 init: stopUpd:)
		(fenrus setPri: 1 posn: 82 50 init: stopUpd:)
	)

	(method (doit)
		(if local2
			(= local2 0)
			(self setScript: teleportOut)
		)
		(cond
			(
				(and
					(== (gEgo onControl: 1) 8192)
					(== (gEgo loop:) 0)
					(not local0)
				)
				(= local0 1)
				(gEgo setScript: intoTheTower)
			)
			((and (== (gEgo edgeHit:) EDGE_BOTTOM) (not local5))
				(= local5 1)
				(= local2 1)
			)
			((and (== (gEgo onControl: 1) 4096) (not local4))
				(= local4 1)
				(= local2 1)
			)
		)
		(cond
			((<= (gEgo x:) 120)
				(localproc_0 0)
			)
			((<= (gEgo x:) 180)
				(localproc_0 1)
			)
			(else
				(localproc_0 2)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'look,look/dragon,head,trophy')
					(MouseClaimed dragon event 3)
				)
				(HighPrint 30 8) ; "It was a moderately large and fearful dragon at one time."
			)
			(
				(or
					(Said 'look,look/chandelier,chandelier,ball')
					(MouseClaimed theLight event 3)
				)
				(HighPrint 30 9) ; "The Ball of Light floats magically over the center of the room."
			)
			((or (Said 'look,look/peacock,bird') (MouseClaimed peacock event 3))
				(if (> (peacock cel:) 0)
					(HighPrint 30 10) ; "You admire the plumage on the peacock."
					(showFeathers changeState: 2)
				else
					(HighPrint 30 11) ; "The poor stuffed peacock seems bedraggled, worn, and over-used."
					(showFeathers changeState: 0)
				)
			)
			(
				(or
					(Said 'look,look/toy,(dragon<little,lady),drink,drink')
					(MouseClaimed theDunker event 3)
				)
				(HighPrint 30 12) ; "You can make out the runes imprinted on the strange device: "Acme Toy Co.""
				(HighPrint 30 13) ; "Oh my! It's a Dunking Dragon! You thought they were only to be found in myths and legends."
			)
			((or (Said 'look,look/desk') (MouseClaimed onDesk event 3))
				(HighPrint 30 14) ; "It is a standard roll-top desk. There is nothing on it."
			)
			((or (Said 'look,look/armor,chainmail') (MouseClaimed armor event 3))
				(HighPrint 30 15) ; "The suit of armor was made for someone much taller than you. The plaque underneath it reads:  "Bequeathed by Colonel Gulden Dijon.""
			)
			((or (Said 'look,look/airplane') (MouseClaimed plane event 3))
				(HighPrint 30 16) ; "You have no idea what it is, but it has the words "Lytton P. D." inscribed upon it."
			)
			((or (Said 'look,look/mummy,coffin') (MouseClaimed mummy event 3))
				(HighPrint 30 17) ; "Dredging up your ancient Egyptian, you translate the hieroglyphs:  "She of the golden hair.""
				(HighPrint 30 18) ; "This is an excerpt from the Rosella Stone! There is a picture next to the message."
				(Print 30 19 #title {The Picture.} #icon 30 6 4)
			)
			((or (Said 'look,look/onklunk') (MouseClaimed lunk event 3))
				(HighPrint 30 20) ; "By golly, it's a rare Peruvian Onklunk!"
			)
			(
				(or
					(Said 'look,look/painting,portrait,wizard,erasmus')
					(MouseClaimed theFrame event 3)
				)
				(if (IsFlag 21)
					(HighPrint 30 21) ; "You wonder if the portrait of Erasmus is really a painting, or something completely different."
				else
					(HighPrint 30 22) ; "Your eyes are drawn to the eyes of the figure in the portrait. His intense stare is unnerving."
					(HighPrint 30 23) ; "This would not be someone to trifle with, for he looks subtle and quick to anger."
				)
			)
			((or (Said 'look,look/chest') (MouseClaimed onChest event 3))
				(HighPrint 30 24) ; "This item appears to be an ebony chest. It could contain anything."
			)
			((or (Said 'look,look/table') (MouseClaimed onTable event 3))
				(HighPrint 30 25) ; "The table is bare, except for a stuffed bird which faces the door."
			)
			(
				(or
					(Said 'look,look/bookcase,case,book,shelf')
					(MouseClaimed onBookcase event 3)
				)
				(HighPrint 30 26) ; "The books on the shelves of the bookcase appear to be very old, very rare, and very magical."
				(HighPrint 30 27) ; "You find titles like: "Zen and the Art of Magical Maintenance", "How to Be a Halfling", "The Sensuous Succubus",  and "Tobin's Spirit Guide, Volume II:  Asmodeus to Casper"."
			)
			((MouseClaimed onWest event 3)
				(localproc_3)
			)
			((and (MouseClaimed onEast event 3) (not (MouseClaimed dragon event 3)))
				(localproc_2)
			)
			((or (Said 'look,look/shield') (MouseClaimed onShield event 3))
				(HighPrint 30 28) ; "The shield looks like it belonged to one of those "Once and Future" kings."
			)
			((MouseClaimed fenrus event 3)
				(HighPrint 30 29) ; "There is a strange figure on a shelf above the stairs. It looks like an overgrown rat wearing a wizard's hat."
			)
			((MouseClaimed onTapestry event 3)
				(HighPrint 30 30) ; "An adumbrated wall hanging. It's design evokes thoughts of ancient times and battles past."
			)
			(128
				(cond
					((Said 'look,look>')
						(cond
							((Said '[<around,at][/room,house,foyer,!*]')
								(localproc_1)
							)
							((or (Said '/east') (Said '/wall<east'))
								(localproc_4)
							)
							((or (Said '/west') (Said '/wall<west'))
								(localproc_5)
							)
							((or (Said '/north') (Said '/wall<north'))
								(localproc_7)
							)
							((or (Said '/south') (Said '/wall<south'))
								(localproc_6)
							)
							((Said '/wall')
								(switch (gEgo loop:)
									(0
										(localproc_4)
									)
									(1
										(localproc_5)
									)
									(2
										(localproc_6)
									)
									(3
										(localproc_7)
									)
								)
							)
							((Said '/chair')
								(HighPrint 30 31) ; "There are two finely crafted chairs, one larger than the other."
							)
							((Said '/trunk,box')
								(HighPrint 30 32) ; "Beneath the "Dunking Dragon" is an old steamer trunk."
							)
							((Said '/door')
								(HighPrint 30 33) ; "The only actual door visible is the door leading back outside."
								(localproc_2)
								(localproc_3)
							)
							((Said '/ladder,staircase')
								(HighPrint 30 34) ; "The staircase connects the upstairs to the downstairs."
							)
							((Said '/tapestry,hang')
								(HighPrint 30 35) ; "The pattern is obscured by age."
							)
							((or (Said '/ceiling,roof,sconce') (Said '<up'))
								(HighPrint 30 36) ; "The high ceiling has ornate sconcing and scrollwork."
							)
							((or (Said '/floor') (Said '<down'))
								(HighPrint 30 37) ; "Purple planking?"
							)
						)
					)
					((Said 'cast>')
						(switch (= temp0 (SaidSpell event))
							(18
								(if (CastSpell temp0)
									(HighPrint 30 38) ; "You detect a strange, magical aura in this place."
								)
							)
							(20
								(if (CastSpell temp0)
									(HighPrint 30 39) ; "There's nothing here to dazzle."
								)
							)
							(23
								(if (CastSpell temp0)
									(if local1
										(= local2 1)
									else
										(dragon setScript: warning)
									)
								)
							)
							(17
								(if (CastSpell temp0)
									(if local1
										(= local2 1)
									else
										(dragon setScript: warning)
									)
								)
							)
						)
					)
					(
						(or
							(Said
								'open,open,open/desk,drawer,chest,box,bookcase'
							)
							(Said 'sat,get,get,throw,grab')
						)
						(if local1
							(= local2 1)
						else
							(dragon setScript: warning)
						)
					)
					((and (not gNight) (Said 'japaneserestorsleep>')))
					((or (Said 'nap,nap[/!*]') (Said 'go[<to]/nap,nap'))
						(HighPrint 30 40) ; "The wizard does not run an inn."
						(= local2 1)
					)
				)
			)
		)
	)
)

(instance showFeathers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(peacock setCycle: End self)
			)
			(1
				(peacock stopUpd:)
			)
			(2
				(peacock setCycle: Beg self)
			)
			(3
				(peacock stopUpd:)
			)
		)
	)
)

(instance dunker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(theDunker setLoop: 4 cel: 0 setCycle: End self)
			)
			(2
				(= seconds 5)
			)
			(3
				(theDunker setLoop: 5 cel: 0 setCycle: End self)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance lightBulb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theLight y: 102)
				(= cycles 16)
			)
			(1
				(theLight y: 103)
				(= cycles 16)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance intro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 160 189 setMotion: MoveTo 160 184 self)
			)
			(1
				(if (not (IsFlag 20))
					(localproc_1)
				)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance intoTheTower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 112 112 self)
			)
			(1
				(gEgo setMotion: MoveTo 205 70 self)
			)
			(2
				(gEgo setMotion: MoveTo 215 70 self)
			)
			(3
				(gEgo setMotion: MoveTo 215 67 self)
			)
			(4
				(fenrus setLoop: 0 cycleSpeed: 2 setCycle: End)
				(gEgo setPri: 1 setMotion: MoveTo 189 62 self)
			)
			(5
				(theWiz setCycle: End)
				(= seconds 3)
			)
			(6
				(gCurRoom newRoom: 31)
			)
		)
	)
)

(instance warning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(dragon setCel: -1 setCycle: Fwd)
				(Print 30 41 #at 215 15 #width 75 #dispose #time 4) ; "I wouldn't do that if I were you!"
				(= seconds 3)
			)
			(1
				(= local1 1)
				(HandsOn)
				(dragon setCycle: 0 setCel: 0 stopUpd: setScript: 0)
			)
		)
	)
)

(instance teleportOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (fenrus cel:) 2)
					(fenrus setCycle: CT 2 1 self)
				else
					(self cue:)
				)
			)
			(1
				(fenrus setLoop: 2 setCycle: Fwd)
				(= cycles 2)
			)
			(2
				(Magic
					ignoreActors:
					setPri: (gEgo priority:)
					posn: (gEgo x:) (gEgo y:)
					init:
					setCycle: CT 6 1 self
				)
			)
			(3
				(dragon setCel: -1 setCycle: Fwd)
				(cond
					(local4
						(Print 30 42 #at 215 15 #width 90 #dispose #time 3) ; "Those rooms are forbidden!"
					)
					(local5
						(Print 30 43 #at 215 15 #width 90 #dispose #time 3) ; "Since you're leaving anyway..."
					)
					(else
						(Print 30 44 #at 215 15 #width 90 #dispose #time 3) ; "That'll learn ya!"
					)
				)
				(gEgo hide:)
				(Magic setCycle: End)
				(= seconds 4)
			)
			(4
				(SetFlag 142)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 16)
				(self cue:)
			)
			(5
				(gCurRoom newRoom: 28)
			)
		)
	)
)

(instance theDunker of Prop
	(properties
		view 30
		loop 4
		cycleSpeed 2
	)
)

(instance peacock of Prop
	(properties
		view 30
		loop 7
		cycleSpeed 1
	)
)

(instance dragon of Prop
	(properties
		view 30
		loop 2
		cycleSpeed 2
	)
)

(instance theLight of Prop
	(properties
		view 30
		loop 1
		cycleSpeed 1
	)
)

(instance theWiz of Prop
	(properties
		view 30
		loop 8
		cycleSpeed 2
	)
)

(instance fenrus of Prop
	(properties
		view 199
		loop 1
	)
)

(instance bigChair of PV
	(properties
		y 151
		x 210
		view 30
		loop 3
	)
)

(instance smChair of PV
	(properties
		y 182
		x 248
		view 30
		loop 3
		cel 1
	)
)

(instance hang1 of PV
	(properties
		y 48
		x 115
		view 30
		loop 3
		cel 2
	)
)

(instance hang2 of PV
	(properties
		y 48
		x 176
		view 30
		loop 3
		cel 3
		priority 4
	)
)

(instance theFrame of RPicView
	(properties
		y 75
		x 146
		view 30
	)
)

(instance lunk of RPicView
	(properties
		y 109
		x 222
		view 30
		loop 6
	)
)

(instance plane of RPicView
	(properties
		y 183
		x 102
		view 30
		loop 6
		cel 1
		priority 14
	)
)

(instance armor of RPicView
	(properties
		y 110
		x 83
		view 30
		loop 6
		cel 2
	)
)

(instance mummy of RPicView
	(properties
		y 166
		x 20
		view 30
		loop 6
		cel 3
	)
)

(instance shelf of PV
	(properties
		y 54
		x 81
		view 30
		loop 3
		cel 4
	)
)

(instance onDesk of RFeature
	(properties
		nsTop 130
		nsLeft 266
		nsBottom 189
		nsRight 319
	)
)

(instance onChest of RFeature
	(properties
		nsTop 151
		nsBottom 189
		nsRight 82
	)
)

(instance onTable of RFeature
	(properties
		nsTop 116
		nsLeft 125
		nsBottom 136
		nsRight 175
	)
)

(instance onBookcase of RFeature
	(properties
		nsTop 78
		nsLeft 237
		nsBottom 147
		nsRight 258
	)
)

(instance onShield of RFeature
	(properties
		nsTop 19
		nsLeft 263
		nsBottom 55
		nsRight 275
	)
)

(instance onEast of RFeature
	(properties
		nsTop 60
		nsLeft 264
		nsBottom 129
		nsRight 275
	)
)

(instance onWest of RFeature
	(properties
		nsTop 61
		nsLeft 43
		nsBottom 150
		nsRight 53
	)
)

(instance onTapestry of RFeature
	(properties
		nsTop 14
		nsLeft 10
		nsBottom 95
		nsRight 28
	)
)

