;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use Interface)
(use Door)
(use LoadMany)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm300 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

(procedure (localproc_0)
	(if (< gTimeOfDay 4)
		(HighPrint 300 0) ; "This seems like a quiet little town. On the porch ahead of you are two people. The standing one is large, rather ugly, and playing with a yo-yo. The seated person smoking a pipe looks like he might be the Sheriff."
	else
		(HighPrint 300 1) ; "Otto and the Sheriff have retired for the evening."
	)
)

(instance rm300 of Rm
	(properties
		picture 300
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 88)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 300 515 606)
		(rm300
			style:
				(switch gPrevRoomNum
					(301 3)
					(310 3)
					(320 2)
					(else 8)
				)
		)
		(super init:)
		(gContMusic fade:)
		(gMouseHandler add: self)
		(self setLocales: 811 801)
		(= gPerspective 70)
		(= local9 50)
		(= local8 1)
		(if (not (IsFlag 88))
			(= gDay 0)
			(FixTime 11)
			(SetFlag 328)
		)
		(SL enable:)
		(NormalEgo)
		(gEgo illegalBits: (if (< gTimeOfDay 4) -16384 else -32768) init:)
		(if gNight
			((= local2 (View new:)) posn: 211 182 cel: 0)
		else
			((= local2 (View new:)) posn: 114 173 cel: 1)
		)
		(local2 view: 300 loop: 1 setPri: 15 init: stopUpd: ignoreActors:)
		(if (< gTimeOfDay 4)
			(sheriff init:)
		)
		((= local1 (Door new:))
			view: 300
			loop: 0
			posn: 71 122
			doorControl: 1024
			locked: (if (>= gTimeOfDay 6) 1 else 0)
			facingLoop: 3
			entranceTo: 301
			init:
		)
		((View new:)
			view: 300
			posn: 58 69
			loop: 2
			cel: 0
			setPri: 14
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 300
			posn: 259 58
			loop: 2
			cel: 1
			setPri: 14
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 300
			posn: 173 72
			loop: 2
			cel: 2
			setPri: 14
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 300
			posn: 271 104
			loop: 2
			cel: 3
			setPri: 8
			init:
			stopUpd:
			addToPic:
		)
		(switch gPrevRoomNum
			(301
				(gEgo posn: 69 126)
				(local1 close:)
			)
			(310
				(gEgo posn: 1 135 setMotion: MoveTo 25 142)
			)
			(320
				(gEgo posn: 305 113 setMotion: MoveTo 305 125)
			)
			(65
				(gEgo posn: 205 188 setMotion: MoveTo 187 177)
			)
			(999
				(gEgo view: 515 setLoop: 3 cel: 5 init: setScript: egoWakes)
			)
			(73
				(gEgo cel: 0 init: posn: 26 163 setMotion: MoveTo 55 154)
			)
			(65
				(gEgo init: posn: 263 148 setMotion: MoveTo 254 143)
			)
			(else
				(gEgo posn: 205 235)
				(self setScript: entranceScript)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (not local0) (> (gEgo x:) 0) (< (gEgo y:) 189))
			(= local0 1)
		)
		(cond
			((and (< (gEgo x:) 1) local0)
				(gCurRoom newRoom: 310)
			)
			(
				(or
					(> (gEgo x:) 318)
					(and (> (gEgo x:) 250) (< (gEgo y:) 113))
				)
				(if (and (not (IsFlag 88)) (< gTimeOfDay 4))
					(HighPrint 300 2) ; "The Sheriff calls out behind you: "Just a friendly suggestion, but whatever you do, don't drink the Dragon's Breath. Not even Otto can drink Dragon's Breath!""
				)
				(gCurRoom newRoom: 320)
			)
			((and (> (gEgo y:) 188) local0)
				(if gNight
					(gEgo y: 186 setMotion: 0)
				else
					(gCurRoom newRoom: 65)
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look/deputy,otto,goon,assistant')
				(HighPrint 300 3) ; "There's no hint of the Ogre."
			)
			((Said 'look/meisterson,man')
				(HighPrint 300 4) ; "You see no sign of the Sheriff."
			)
			(
				(or
					(Said 'look/jail')
					(Said 'look/office,building<meisterson')
					(MouseClaimed onJailSign event 3)
				)
				(HighPrint 300 5) ; "The Sheriff's office doubles as a jail for the town and a hangout for the Sheriff and the Goon."
			)
			((or (Said 'look/scissors') (MouseClaimed onScissors event 3))
				(if (> (gEgo x:) 125)
					(HighPrint 300 6) ; "The Sign of the Scissors above the door, along with the striped pole, indicates that the building contains a Barber Shop."
				else
					(HighPrint 300 7) ; "You can't see it."
				)
			)
			((or (Said 'look/pole') (MouseClaimed onBarberPole event 3))
				(if (> (gEgo x:) 125)
					(HighPrint 300 8) ; "A typical barber's pole."
				else
					(HighPrint 300 7) ; "You can't see it."
				)
			)
			(
				(or
					(Said 'look/hotel')
					(MouseClaimed local1 event 3)
					(MouseClaimed onInnSign event 3)
				)
				(if (< (gEgo x:) 220)
					(if (>= gTimeOfDay 6)
						(HighPrint 300 9) ; "The shades are drawn, and it appears that the Inn is closed."
					else
						(HighPrint 300 10) ; "The windows glow from the light inside. The sign reads "Hero's Tale Inn"."
					)
				else
					(HighPrint 300 7) ; "You can't see it."
				)
			)
			((or (Said 'look/gate') (MouseClaimed local2 event 3))
				(HighPrint 300 11) ; "The town gate is made of sturdy logs."
				(if (local2 cel:)
					(HighPrint 300 12) ; "It stands open."
				else
					(HighPrint 300 13) ; "It is closed, locked, and barred."
				)
			)
			(
				(or
					(Said 'look,read/note,sign,door,shop,shop')
					(MouseClaimed onBarberNote event 3)
				)
				(if (== (gEgo onControl: 1) 4096)
					(HighPrint 300 14) ; "There's a sign on the door of the barber shop, informing whoever reads it that the barber is out to lunch. The door is locked."
					(if (> gTimeOfDay 4)
						(HighPrint 300 15) ; "The barber must keep odd lunch hours."
					)
				else
					(HighPrint 300 16) ; "There are signs over each of the buildings informing you of their purpose."
				)
			)
			((Said 'search/man,meisterson,goon,otto')
				(HighPrint 300 17) ; "Searching a law enforcer is a bad idea."
			)
			(else
				(switch (event type:)
					(evSAID
						(cond
							((Said 'open/door')
								(cond
									((& (gEgo onControl: 1) $2000)
										(if (< gTimeOfDay 4)
											(HighPrint 300 18) ; "The door appears to be locked, and breaking into the Sheriff's office might evoke the wrath of Otto Von Goon."
										else
											(HighPrint 300 19) ; "You'd better not. The Goon would probably try to strangle you with his yo-yo if he thought you were going into the Sheriff's office without permission."
										)
									)
									((& (gEgo onControl: 1) $1000)
										(HighPrint 300 20) ; "There's a sign on the door of the barber's shop, informing whoever reads it that the barber is out to lunch. The door is locked."
										(if (> gTimeOfDay 4)
											(HighPrint 300 15) ; "The barber must keep odd lunch hours."
										)
									)
									((& (gEgo onControl: 1) $0400)
										(if (>= gTimeOfDay 6)
											(HighPrint 300 21) ; "The door is locked."
										else
											(HighPrint 300 22) ; "Turn around."
										)
									)
									(else
										(event claimed: 0)
									)
								)
							)
							((Said 'close,hasp,bar/gate')
								(if (local2 cel:)
									(HighPrint 300 23) ; "That's the Sheriff's job."
								else
									(HighPrint 300 24) ; "The gate is already closed."
								)
							)
							((Said 'open/gate')
								(if (local2 cel:)
									(HighPrint 300 25) ; "The town gate is standing wide open, as it does every day."
								else
									(HighPrint 300 26) ; "The sturdy town gate is completely locked and barred, as it is every evening."
								)
							)
							((Said 'unlock,unbar/gate')
								(if (local2 cel:)
									(HighPrint 300 25) ; "The town gate is standing wide open, as it does every day."
								else
									(HighPrint 300 27) ; "Only the Sheriff can unlock the gate."
								)
							)
							((Said 'look>')
								(cond
									(
										(Said
											'[<at,around][/!*,street,hamlet,building]'
										)
										(if gNight
											(HighPrint 300 28) ; "Spielburg remains colorful, even at night."
										else
											(localproc_0)
										)
									)
									((Said '/barbershop,shop[<barber]')
										(if (> (gEgo x:) 125)
											(HighPrint 300 29) ; "The Barber Shop appears to be closed. There's a note hanging from the doorknob."
										else
											(HighPrint 300 7) ; "You can't see it."
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
)

(instance entranceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SolvePuzzle 717 1)
				(gEgo setMotion: MoveTo 187 187 self)
			)
			(1
				((= local3 (View new:))
					view: 300
					loop: 8
					cel: 0
					posn: 187 154
					setPri: 15
					ignoreActors:
					init:
				)
				(= cycles 10)
			)
			(2
				(local3 setCel: 1 posn: 188 154)
				(= cycles 10)
			)
			(3
				(local3 dispose:)
				(localproc_0)
				(gEgo setMotion: MoveTo 187 167 self)
			)
			(4
				(HighPrint 300 30) ; "The man with the pipe greets you."
				(HighPrint 300 31) ; "Welcome to our town. You are lucky to have made it down from the mountains before the snow blocked the pass again. It's gotten pretty dangerous outside of town, I understand."
				(HighPrint 300 32) ; "Many monsters have been trapped around here with the late snow. Between them and the brigands, we certainly could use a Hero around here."
				(HighPrint 300 33) ; "I am Sheriff Schultz Meistersson. This is Otto Von Goon, my assistant. What do you call yourself?"
				(HandsOn)
				(GetInput @global401 50 {What's your name?})
				(if (== (StrLen @global401) 0)
					(Format @global401 300 34) ; "Unknown Hero"
				)
				(HighPrint 300 35 @global401) ; "Good luck in your quest, %s."
			)
		)
	)
)

(instance sheriff of Act
	(properties
		view 300
		loop 3
	)

	(method (init)
		(self illegalBits: 0)
		((= local6 (Prop new:))
			view: 300
			loop: 5
			cel: 0
			posn: 159 102
			setPri: 9
			init:
			ignoreActors:
			setCycle: Fwd
			cycleSpeed: 1
			stopUpd:
		)
		((= local7 (Prop new:))
			view: 300
			loop: 7
			cel: 0
			posn: 156 99
			setPri: 9
			init:
			ignoreActors:
			cycleSpeed: 1
			stopUpd:
		)
		((= local5 (View new:))
			view: 300
			loop: 6
			cel: 0
			posn: 152 128
			init:
			ignoreActors:
			stopUpd:
		)
		((= local4 (Prop new:))
			view: 606
			loop: 1
			posn: 194 76
			init:
			cycleSpeed: 1
		)
		((View new:) view: 606 posn: 195 118 loop: 0 cel: 0 init: addToPic:)
		(if (== gHowFast 0)
			(local5 addToPic:)
			(local4 addToPic:)
			(local6 addToPic:)
			(local7 addToPic:)
		else
			(local4 setScript: YoYoScript)
			(self setScript: sheriffScript)
		)
		(gMouseHandler add: self)
		(super init:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'look/deputy,otto,goon,assistant')
					(MouseClaimed onGoon event 3)
				)
				(HighPrint 300 36) ; "There's more than a hint of Ogre about this strange and bulky character. He seems cheerful, though."
			)
			((or (Said 'look/meisterson,man') (MouseClaimed onSheriff event 3))
				(HighPrint 300 37) ; "Schultz appears to be an affable old coot, content to smoke his pipe. There's a hardness behind his eyes, however, that gives you reason to believe that he's no pushover."
			)
			((or (Said 'look/yo,yo') (MouseClaimed onYoyo event 3))
				(HighPrint 300 38) ; "It goes up and down...up and down...up and down...up and down....."
			)
			((or (Said 'look/pipe') (MouseClaimed onPipe event 3))
				(HighPrint 300 39) ; "The Sheriff's pipe is a truly impressive hand-carved ivory pipe."
			)
			(else
				(switch (event type:)
					(evSAID
						(cond
							((Said 'talk/meisterson,man')
								(if (gEgo inRect: 100 100 242 171)
									(HighPrint 300 40) ; "The Sheriff informs you that he's much too busy for idle chit-chat."
								else
									(NotClose)
								)
							)
							((Said 'talk/goon,otto,deputy,assistant')
								(if (gEgo inRect: 100 100 242 171)
									(HighPrint 300 41) ; "Otto only expresses himself physically."
								else
									(NotClose)
								)
							)
							(
								(and
									(Said 'ask>')
									(gEgo inRect: 100 100 242 171)
								)
								(= local10 1)
								(cond
									((Said '/hamlet')
										(= local10 0)
										(HighPrint 300 42) ; "Just walk around and find out for yourself."
									)
									((Said '/hero,adventure,adventuring')
										(HighPrint 300 43) ; "You'll need to talk to the Baron about that. Or go ask Wolfgang down at the Guild Hall, which is just down the street."
										(HighPrint 300 44) ; "So maybe you're going to be a hero? Well, we could surely use one around here, what with all the brigands."
									)
									((Said '/bandit,robbery')
										(HighPrint 300 45) ; "There's a whole band of brigands hiding out somewhere in the mountains around us. They robbed a merchant just last week. Got a fair amount of treasure, I hear."
									)
									((Said '/name')
										(HighPrint 300 46) ; "I am Sheriff Schultz Meistersson, and this is Otto Von Goon, my assistant."
									)
									((Said '/meisterson')
										(HighPrint 300 47) ; "The Sheriff replies, "Why, that's me!""
									)
									((Said '/abdulla')
										(HighPrint 300 48) ; "The one who was robbed? He's staying at the Inn, I believe."
									)
									((Said '/hotel')
										(HighPrint 300 49) ; "Go talk to the Innkeeper. He will help you there."
									)
									((Said '/hill')
										(HighPrint 300 50) ; "You should know. You came down from there."
									)
									((Said '/danger')
										(HighPrint 300 51) ; "My friend," the Sheriff says, "this world's filled with dangers. Sometimes I think it might be better to choose your danger, rather than sitting around, waiting for it, as I seem to do."
										(HighPrint 300 52) ; "But enough of this philosophical rambling. I am content enough to be Sheriff of Spielburg."
									)
									((Said '/prisoner')
										(HighPrint 300 53) ; "It's simple. When somone breaks the law, and we catch them, we hold them prisoner."
									)
									((Said '/loot')
										(HighPrint 300 54) ; "Obtaining treasure involves putting yourself in danger. If you're brave, foolish, or lucky, you might get some treasure."
									)
									((Said '/monster')
										(HighPrint 300 55) ; "The monsters come down from the mountains every winter, but they're usually gone by now. The Baron just doesn't have enough men to handle them."
										(HighPrint 300 56) ; "Wolfgang is the one to talk to about monsters. He's had a lot of experience with them."
									)
									((Said '/baron,castle')
										(HighPrint 300 57) ; "Baron Stefan keeps mostly to himself at his castle north of here. We haven't seen him here in town for years."
									)
									((Said '/abenteuer,master')
										(HighPrint 300 58) ; "Wolfgang, down at the Guild hall, is the one to talk to about monsters. He's had a lot of experience with them."
									)
									((Said '/goon,otto,deputy,assistant,help')
										(HighPrint 300 59) ; "Otto is a big help to me," the Sheriff tells you. "He's very smart for a Goon. His prisoners only suffer a few broken bones when he grabs them."
										(HighPrint 300 60) ; "It took a bit of doing to teach him to bring prisoners back alive, but he hardly ever forgets, now."
									)
									((Said '/labor,(hall[<club,about])')
										(HighPrint 300 61) ; "The Guild Hall is at the Southwest corner of town. If you're looking for work, that's a good place to go."
									)
									(
										(Said
											'/magic,zara,spell,potion,scroll,wand,(shop<magic)'
										)
										(HighPrint 300 62) ; "Just next to the Inn is a small Magic Shop. The owner, Zara, will let you in if you have some abilities in that area. She's a strange one, all right!"
									)
									((Said '/*')
										(= local10 0)
										(HighPrint 300 63) ; "The Sheriff says, "You think I'm going to tell you everything I know about everything? Go look around and find things out for yourself.""
									)
								)
								(if local10
									(SolvePuzzle 718 1)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance sheriffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local5 hide: stopUpd:)
				(local6 hide: stopUpd:)
				(local7 hide: stopUpd:)
				(sheriff
					posn: 152 128
					startUpd:
					cycleSpeed: 2
					show:
					setCycle: End self
				)
			)
			(1
				(sheriff setCycle: Beg self)
			)
			(2
				(sheriff hide: stopUpd:)
				(local5 show: stopUpd:)
				(local7 show: startUpd: setCycle: End)
				(local6 show: startUpd:)
				(= cycles (Random 30 70))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance YoYoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== (mod local8 5) 0)
						(self changeState: 2)
					)
					((== (mod local8 8) 0)
						(self changeState: 4)
					)
					(else
						(++ local8)
						(local4 loop: 1 cel: 0 setCycle: End)
						(= cycles 20)
					)
				)
			)
			(1
				(self changeState: 0)
			)
			(2
				(++ local8)
				(local4 loop: 2 cel: 0 setCycle: End)
				(= cycles 30)
			)
			(3
				(self changeState: 0)
			)
			(4
				(= local8 1)
				(local4 loop: 3 cel: 0 setCycle: End self)
			)
			(5
				(= cycles 30)
			)
			(6
				(self changeState: 0)
			)
		)
	)
)

(instance onYoyo of RFeature
	(properties
		nsTop 92
		nsLeft 200
		nsBottom 111
		nsRight 204
	)
)

(instance onGoon of RFeature
	(properties
		nsTop 71
		nsLeft 185
		nsBottom 116
		nsRight 199
	)
)

(instance onBarberPole of RFeature
	(properties
		nsTop 83
		nsLeft 277
		nsBottom 119
		nsRight 286
	)
)

(instance onBarberNote of RFeature
	(properties
		nsTop 98
		nsLeft 266
		nsBottom 105
		nsRight 275
	)
)

(instance onSheriff of RFeature
	(properties
		nsTop 92
		nsLeft 142
		nsBottom 127
		nsRight 154
	)
)

(instance onPipe of RFeature
	(properties
		nsTop 97
		nsLeft 155
		nsBottom 109
		nsRight 161
	)
)

(instance onJailSign of RFeature
	(properties
		nsTop 57
		nsLeft 149
		nsBottom 68
		nsRight 198
	)
)

(instance onScissors of RFeature
	(properties
		nsTop 48
		nsLeft 239
		nsBottom 59
		nsRight 278
	)
)

(instance onInnSign of RFeature
	(properties
		nsTop 49
		nsLeft 39
		nsBottom 69
		nsRight 65
	)
)

(instance egoWakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Beg self)
			)
			(1
				(NormalEgo)
				(HighPrint 300 64) ; "However, this was not a good place to sleep. You're stiff and sore all over and your wallet feels very light."
				(= [gInvNum 1] 0) ; silver
				(= [gInvNum 2] 0) ; gold
				(HandsOn)
				(= cycles 2)
			)
			(2
				(HighPrint 300 65) ; "As safe as our streets are, you still should not sleep on them. It is a good way to get robbed."
			)
		)
	)
)

