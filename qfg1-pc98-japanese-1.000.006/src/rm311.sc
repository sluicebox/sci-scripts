;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 311)
(include sci.sh)
(use Main)
(use Door)
(use FileSelector)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm311 0
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
	local11
)

(procedure (localproc_0)
	(HighPrint 311 0) ; "Get closer for a good look."
)

(procedure (localproc_1 &tmp temp0 [temp1 200])
	(= temp0 local10)
	(if (not (IsFlag 127))
		(++ temp0)
	)
	(if (gEgo inRect: 190 115 250 124)
		(if (< local10 0)
			(HighPrint 311 1) ; "The remaining pages are blank, awaiting further tales of adventure."
			(= local10 0)
			(return)
		)
		(SolvePuzzle 723 4)
		(switch temp0
			(0
				(Format @temp1 311 2 @global401 @global594) ; "The writing on this page looks very recent. It says "I, %s, have come to Spielburg to become a Hero."%"
				(HighPrint @temp1)
			)
			(1
				(Format ; "The %s entry was made several years ago. It says: "Baronet Barnard von Spielburg killed a Troll near the Flying Falls on this 23 day of Octember".%"
					@temp1
					311
					3
					(if (IsFlag 127) {previous} else {last})
					(if (IsFlag 127)
						{\91O\89\f1\82\cc\8bL\98^}
					else
						{\8d\c5\8c\e3\82\c9\8f\91\82\a9\82\ea\82\bd\8bL\98^}
					)
				)
				(HighPrint @temp1)
			)
			(else
				(HighPrint 311 4) ; "The other pages record the exploits of the great adventurers of Spielburg's past. The names Wolfgang Abenteuer and Baron Stefan von Spielburg appear most often."
				(= local10 2)
			)
		)
	else
		(localproc_0)
	)
)

(procedure (localproc_2)
	(if (not (gEgo inRect: 190 115 250 124))
		(localproc_0)
	)
	(gEgo inRect: 190 115 250 124)
)

(procedure (localproc_3)
	(if (gEgo inRect: 100 110 167 126)
		(SolvePuzzle 726 6)
		(gCurRoom newRoom: 318)
	else
		(localproc_0)
	)
)

(procedure (localproc_4)
	(HighPrint 311 5) ; "It looks like this old Guild Master doesn't do too much adventuring any more. Still, he looks like he was plenty tough in his day, and he probably has many a tale to tell."
)

(procedure (localproc_5)
	(HighPrint 311 6) ; "The fire blazing cheerily in the fireplace helps warm the Guild Master's old bones."
)

(procedure (localproc_6)
	(HighPrint 311 7) ; "The plaque under the Moose says: "Courtesy of Sierra Online Prop Dept.""
)

(procedure (localproc_7)
	(HighPrint 311 8) ; "You never saw a purple Saurus before you came to Spielburg, but it looks like a really stupid monster. The plaque reads: "Saurus slain by Hans Halfwitten"."
)

(procedure (localproc_8)
	(HighPrint 311 9) ; "It looks like it must have been a particularly nasty Troll. You wouldn't want to meet him in a dark forest. The plaque reads: "Troll slain by Wolfgang Abenteuer"."
)

(procedure (localproc_9)
	(HighPrint 311 10) ; "This crossbreed of eagle and lion could have torn a man apart when it was alive. The plaque reads: "Gryphon slain by Wolfgang Abenteuer"."
)

(procedure (localproc_10)
	(HighPrint 311 11) ; "Even in death, this monster remains awesome. The plaque reads: "Dragon slain by Baron Stefan von Spielburg"."
)

(procedure (localproc_11)
	(HighPrint 311 12) ; "The head is like a panther's, but with a strong human-like quality. It is still rather frightening. The plaque reads: "Cheetaur slain by Wolfgang Abenteuer"."
)

(procedure (localproc_12)
	(HighPrint 311 13) ; "This is certainly a weird one! You've never seen anything quite like it. The plaque reads: "Antwerp slain by Two Guys From Andromeda"."
)

(procedure (localproc_13)
	(HighPrint 311 14) ; "This Adventurer's Guild Hall reminds you of the one in your home town. The traditional Moose head and other stuffed monsters (Saurus, Troll, Gryphon, Dragon, Cheetaur, and the terrible Antwerp) adorn the walls."
	(HighPrint 311 15) ; "You see the registration book on the desk and the bulletin board full of job listings. The man seated by the fire must be the Guild Master. He is snoring."
)

(instance rm311 of Rm
	(properties
		picture 311
		style 2
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 91)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW (LangSwitch 311 317))
		(Load rsVIEW 312)
		(super init: &rest)
		(gMouseHandler add: self)
		(self
			setFeatures:
				onDragon
				onCheetaur
				onTroll
				onGryphon
				onAntwerp
				onSaurus
				onMoose
				onGuildMaster
				onFireplace
				onLog
				onQuestBoard
		)
		(self setLocales: 801)
		(SL enable:)
		(master init:)
		(NormalEgo)
		(gEgo loop: 1 posn: 276 148 init:)
		(if (== gPrevRoomNum 318)
			(gEgo posn: 133 118)
		)
		((= local0 (Prop new:))
			view: 311
			loop: 1
			posn: 11 160
			init:
			setCycle: Fwd
			cycleSpeed: 1
			startUpd:
		)
		((= local1 (Door new:))
			view: 311
			loop: 0
			posn: 315 158
			doorControl: 16384
			entranceTo: 310
			init:
			ignoreActors:
			setPri: 11
		)
		((View new:)
			view: (LangSwitch 311 317)
			loop: 2
			cel: 0
			posn: 135 73
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 311
			loop: 2
			cel: 1
			posn: 209 92
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 311
			loop: 2
			cel: 2
			posn: 194 87
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 311
			loop: 2
			cel: 3
			posn: 244 67
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 311
			loop: 2
			cel: 4
			posn: 25 81
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 311
			loop: 2
			cel: 5
			posn: 204 66
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 311
			loop: 2
			cel: 6
			posn: 110 66
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 311
			loop: 2
			cel: 7
			posn: 163 70
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 311
			loop: 2
			cel: 8
			posn: 74 69
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 311
			loop: 2
			cel: 9
			posn: 302 83
			init:
			stopUpd:
			addToPic:
		)
		(if (not (IsFlag 91))
			(localproc_13)
		)
	)

	(method (handleEvent event &tmp [temp0 3])
		(switch (event type:)
			(evSAID
				(cond
					((Said 'get,get')
						(HighPrint 311 16) ; "There is nothing here that you need, and the Guild Master may be more aware than he seems."
					)
					((or (Said 'turn/page') (Said 'page<preceding'))
						(++ local10)
						(localproc_1)
					)
					((Said '/page<next')
						(-- local10)
						(localproc_1)
					)
					((Said '/page<first')
						(= local10 2)
						(localproc_1)
					)
					((Said '/page<last')
						(= local10 0)
						(localproc_1)
					)
					(
						(or
							(Said 'look,look<in/desk,drawer')
							(Said 'open,open,open/desk,drawer')
						)
						(if (localproc_2)
							(HighPrint 311 17) ; "The desk drawers are empty."
						)
					)
					((Said 'close,close/desk')
						(HighPrint 311 18) ; "There is no way to close the desk."
					)
					((Said 'look,look,read>')
						(cond
							(
								(Said
									'/registration,register,register,log,book,page'
								)
								(localproc_1)
							)
							((Said '/desk,(top<desk)')
								(if (localproc_2)
									(HighPrint 311 19) ; "On the desk are an old but ornate leather-bound book and a quill pen in the ink bottle."
								)
							)
							((Said '/feather,pen,ink,bottle')
								(HighPrint 311 20) ; "You see an ordinary pen and ink."
							)
							((Said '/message,quest,(board[<bulletin,quest])')
								(localproc_3)
							)
							((Said '[<at,around][/!*,room,building,hall,club]')
								(localproc_13)
							)
							((Said '/moose,(head<moose)')
								(localproc_6)
							)
							((Said '/saurus,(head<saurus)')
								(localproc_7)
							)
							((Said '/troll,(head<troll)')
								(localproc_8)
							)
							((Said '/griffin,(head<griffin)')
								(localproc_9)
							)
							((Said '/dragon,(head<dragon)')
								(localproc_10)
							)
							((Said '/cheetaur,(head<cheetaur)')
								(localproc_11)
							)
							((Said '/antwerp,(head<antwerp)')
								(localproc_12)
							)
							((Said '/monster,trophy,head')
								(HighPrint 311 21) ; "On the walls hang dusty, moth-eaten monster heads. You recognize the purple Saurus, the Troll, the Gryphon, and the Dragon."
								(HighPrint 311 22) ; "You figure that the black head must belong to the Cheetaur, and you have no idea what the four-eyed creature might be. You are also not quite sure why the Moose head is considered traditional, but every Guild Hall seems to have one."
							)
							((Said '/desk')
								(HighPrint 311 23) ; "The desk holds a pen, an inkwell, and the Adventurer's Guild Registration and Log Book."
							)
							(
								(Said
									'/abenteuer,master,man,adventurer,guildmaster'
								)
								(localproc_4)
							)
							((Said '/fire,chimney')
								(localproc_5)
							)
						)
					)
					(
						(or
							(Said
								'sign,sign,register,register[/name,book,register,register,log]'
							)
							(Said
								'write,enter/name,quest[/book,register,register,log]'
							)
						)
						(cond
							((IsFlag 127)
								(HighPrint 311 24) ; "But you've already done that!"
							)
							((gEgo inRect: 190 115 250 124)
								(HighPrint 311 25) ; "You sign your name into the Adventurer's Log Book with a flourish."
								(SolvePuzzle 724 1)
								(SetFlag 127)
							)
							(else
								(NotClose)
							)
						)
					)
				)
			)
		)
	)
)

(instance master of Prop
	(properties
		view 312
	)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(self
			posn: 76 137
			setPri: 12
			ignoreActors:
			startUpd:
			setScript: masterScript
		)
		((= local2 (View new:))
			view: 312
			loop: 0
			cel: 0
			posn: 82 153
			init:
			stopUpd:
		)
		((= local3 (Prop new:))
			view: 312
			loop: 3
			cel: 0
			posn: 72 130
			init:
			cycleSpeed: 1
			setPri: 12
			stopUpd:
			hide:
		)
	)

	(method (doit)
		(cond
			((> local9 1)
				(-- local9)
			)
			((== local9 1)
				(= local9 0)
				(if local7
					(= local8 1)
				)
			)
		)
		(if (== (master loop:) 2)
			(cond
				((< (gEgo x:) 100)
					(if (== (master cel:) 1)
						(master cel: 0)
					)
				)
				((== (master cel:) 0)
					(master cel: 1)
				)
			)
		)
		(super doit:)
	)
)

(instance masterScript of Script
	(properties)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					(
						(Said
							'awaken[<up]/adventurer,master,abenteuer,man,guildmaster'
						)
						(if local7
							(HighPrint 311 26) ; "He already is."
						else
							(self changeState: 7)
						)
					)
					((Said 'talk,talk/adventurer,master,abenteuer,man')
						(if (gEgo inRect: 0 132 106 195)
							(= local9 100)
							(if local7
								(HighPrint 311 27) ; "Oh, my young friend! What shall we talk about? I have so many stories. Just ask me about something."
							else
								(self changeState: 7)
							)
						else
							(NotClose)
						)
					)
					((Said 'ask>')
						(if (gEgo inRect: 0 132 106 195)
							(= local9 100)
							(cond
								(local7
									(= local11 1)
									(cond
										((Said '//curse,curse')
											(HighPrint 311 28) ; "Ja. What with the baron losing his son and daughter, all the monsters, Baba Yaga, and now the brigands, it has been one thing after another."
										)
										((Said '//baron')
											(HighPrint 311 29) ; "Baron von Spielburg was once a brave protector of our valley. We used to adventure together when we were younger."
											(HighPrint 311 30) ; "No brigand or monster would dare show his face here if the Baron had not angered Baba Yaga. Now it is said that he goes nowhere and sees no one."
										)
										((Said '//barnard,barnard,boy')
											(HighPrint 311 31) ; "He was a hero and worthy of the name Barnard von Spielburg. He rode off to hunt one morning five years ago, and his horse returned with large and deep claw marks. No sign of the Baronet's body was ever found."
										)
										((Said '//elsa,daughter,girl')
											(HighPrint 311 32) ; "Elsa was a beautiful eight-year-old child with blonde hair and sky-blue eyes. She was the Baron's pride and joy."
											(HighPrint 311 33) ; "Ten years ago she was carried off by something which came over the wall and flew off with her. The search for her lasted many years, but at last everyone gave up."
											(HighPrint 311 34) ; "Everyone, that is, except for the Baron's Jester, Yorick."
										)
										((Said '//jester,yorick')
											(HighPrint 311 35) ; "Yorick was a funny little man, but brave. He swore he would spend his life searching for the Baron's Elsa."
										)
										((Said '//baba')
											(HighPrint 311 36) ; "She is the center of our problems, I think. Baba Yaga is a powerful Ogress. Baron von Spielburg tried to force her to leave this valley, but she cursed him."
											(HighPrint 311 37) ; "Now the Baron has lost everything but his land, and I don't know how long he will keep that. What our valley needs is a Hero."
										)
										(
											(Said
												'//adventure,adventurer,adventuring'
											)
											(HighPrint 311 38) ; "Did I ever tell you about the days when Schultz and I rid this valley of Antwerps? Ja, we were real adventurers then, and this was a true Guild Hall. Now we are just old men, and this is just a place to tell old stories."
										)
										((Said '//meisterson')
											(HighPrint 311 39) ; ""Schultz and I have been friends for a long time. He too has been a real adventurer. Now, he is just the Sheriff of the town." \81u\83V\83\85\83\8b\83c\82\c6\82\ed\82\b5\82\cd\81A\92\b7\94N\82\cc\97F\92B\82\be\81B\94\de\82\e0\96{\93\96\82\cc\96`\8c\af\89\c6\82\be\82\c1\82\bd\82\f1\82\be\81B\8d\a1\82\cd\81A\94\de\82\cd\82\b1\82\cc\92\ac\82\cc\95\db\88\c0\8a\af\82\c9\82\b7\82\ac\82\c8\82\a2\82\aa\82\cb\81B\81v"
										)
										((Said '//thief,(club<thief)')
											(HighPrint 311 40) ; "Even a thief can be a hero sometimes, as long as uses his skills only for good purposes. But most thieves are far from being heroes."
										)
										((Said '//hall,club')
											(HighPrint 311 41) ; "This is, of course, where an adventurer can find out where there is a need for someone brave and courageous. There are jobs on the bulletin board over there."
											(HighPrint 311 42) ; "It is also a good place to talk about adventures on a cold afternoon. We used to play cards here once a week, as well, but there are too few adventurers in Spielburg anymore."
											(HighPrint 311 43) ; "They all died at the hands of monsters or brigands, or they just became too old."
										)
										(
											(Said
												'//board,bulletin,notice,job,labor,labor'
											)
											(HighPrint 311 41) ; "This is, of course, where an adventurer can find out where there is a need for someone brave and courageous. There are jobs on the bulletin board over there."
										)
										((Said '//monster,head')
											(HighPrint 311 44) ; "You can see some of the types of monsters that live around here if you look at our walls."
										)
										((Said '//bandit')
											(HighPrint 311 45) ; "There is a reward for anyone who can stop the brigands by capturing or killing their leaders. The information is on the bulletin board."
										)
										((Said '//saurus')
											(HighPrint 311 46) ; "Oh, those are nothing. Anyone can kill a Saurus."
										)
										((Said '//troll')
											(HighPrint 311 47) ; "It's been a while since Schultz and I killed the one on the wall. It is fortunate that few Trolls remain; they're deadly."
										)
										((Said '//cheetaur')
											(HighPrint 311 48) ; "Watch out for Cheetaurs. I bear the scars of my last fight with one to this day."
										)
										((Said '//griffin')
											(HighPrint 311 49) ; "I remember the day I killed one. It was the biggest one I had ever seen. It put up a tough fight, but I was tougher. You can see the result on the wall."
										)
										((Said '//dragon')
											(HighPrint 311 50) ; "One day, years ago, a pair of dragons tried to take over our valley. We adventurers rode out to meet them."
											(HighPrint 311 51) ; "I can still see Stefan von Spielburg charging forward on his black horse. He slew the one whose head adorns the wall above our fireplace. The other one flew off."
											(HighPrint 311 52) ; "People say that they can sometimes see that other dragon flying high overhead, but it has never dared attack us again."
										)
										((Said '//antwerp')
											(HighPrint 311 53) ; "One year, this valley was overrun by those odd and terrible monsters. Schultz and I fought long and hard to eliminate them completely. We might have failed even so, had it not been for those two peculiar tourists who came to our aid."
										)
										((Said '//moose')
											(HighPrint 311 54) ; "That was the most vicious moose I ever ran into. Nearly bit my nose off!"
										)
										((Said '//tourist')
											(HighPrint 311 55) ; "They certainly were strange."
										)
										((Said '//andromeda')
											(HighPrint 311 56) ; "That's where the tourists said they came from. Must be some place up North -- I sure never heard of it."
										)
										((Said '//halfwitten')
											(HighPrint 311 57) ; "Not much of an adventurer, but he did kill one Saurus before he made the mistake of tangling with an Ogre."
										)
										((Said '//ogre')
											(HighPrint 311 58) ; "Ogres are a lot like Goons, but even meaner. Not as bright, though."
										)
										((Said '//goon,otto,bouncer')
											(HighPrint 311 59) ; "A Goon is a lot like an Ogre, not as tough, but a little smarter. We have two Goons in town, Otto and Crusher."
										)
										((Said '//abenteuer,master,name')
											(HighPrint 311 60) ; "I am Wolfgang Abenteuer, Guild Master of this hall."
										)
										((Said '//hero,fame')
											(HighPrint 311 61) ; "A real hero is someone who did not start out strong or powerful, but who uses his courage, brains, and skills to become the best he can be."
										)
										(
											(or
												(Said
													'//ring,ring,warlock,spell,leader'
												)
												(Said
													'//component[<spell,about]'
												)
											)
											(HighPrint 311 62) ; "I'm sorry. I only know what's written on the poster."
										)
										((Said '//castle')
											(HighPrint 311 63) ; "The castle is just north of the Healer's house."
										)
										((Said '//heal,house')
											(HighPrint 311 64) ; "The Healer's house is just north of the crossroads outside of town."
										)
										((Said '//*')
											(= local11 0)
											(HighPrint 311 65) ; "You know, that reminds me very little of the time old Schultz and I......."
											(HighPrint 311 66) ; "Wait a minute. It'll come to me."
											(= local8 1)
										)
									)
									(if local11
										(SolvePuzzle 725 1)
									)
								)
								((Said '//*')
									(masterScript changeState: 7)
								)
							)
						else
							(NotClose)
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7 0)
				(= local4 5)
				(master loop: 1 cel: 0 cycleSpeed: 0)
				(= cycles 3)
			)
			(1
				(master cel: 1)
				(= cycles 3)
			)
			(2
				(master cel: 2)
				(= cycles 3)
			)
			(3
				(master cel: 3)
				(= cycles 3)
			)
			(4
				(master cel: 1)
				(= cycles 1)
			)
			(5
				(master cel: 0)
				(-- local4)
				(= cycles 1)
			)
			(6
				(if (> local4 0)
					(self changeState: 4)
				else
					(self changeState: 0)
				)
			)
			(7
				(HighPrint 311 67) ; "ZZZZZZZZZZZZZZZZ."
				(master
					loop: 2
					cel: (if (> (gEgo x:) 100) 1 else 0)
					posn: 80 134
				)
				(local2 cel: 1)
				(local3 show:)
				(= cycles 5)
			)
			(8
				(if local6
					(HighPrint 297 (Random 21 25))
				else
					(= local6 1)
					(HighPrint 311 68) ; "Ach! I was so busy I didn't notice you come in. Welcome, welcome! It is so seldom that we have new adventurers here. Most people think this valley is cursed!"
				)
				(= local9 100)
				(= local5 (Random 1 4))
				(= local7 1)
				(= cycles 2)
			)
			(9
				(local3 setCycle: End self)
			)
			(10
				(local3 setCycle: Beg self)
			)
			(11
				(if (> local5 0)
					(-- local5)
					(self changeState: 9)
				else
					(= cycles (Random 30 60))
				)
			)
			(12
				(= local5 (Random 1 4))
				(if local8
					(self cue:)
				else
					(self changeState: 9)
				)
			)
			(13
				(= local8 0)
				(= local7 0)
				(= local9 0)
				(master loop: 4 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(14
				(self changeState: 0)
			)
		)
	)
)

(instance onDragon of RFeature
	(properties
		nsTop 55
		nsBottom 80
		nsRight 50
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onDragon event 3)
				(localproc_10)
			)
		)
	)
)

(instance onCheetaur of RFeature
	(properties
		nsTop 55
		nsLeft 65
		nsBottom 70
		nsRight 80
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onCheetaur event 3)
				(localproc_11)
			)
		)
	)
)

(instance onTroll of RFeature
	(properties
		nsTop 40
		nsLeft 98
		nsBottom 65
		nsRight 122
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onTroll event 3)
				(localproc_8)
			)
		)
	)
)

(instance onGryphon of RFeature
	(properties
		nsTop 40
		nsLeft 145
		nsBottom 68
		nsRight 180
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onGryphon event 3)
				(localproc_9)
			)
		)
	)
)

(instance onAntwerp of RFeature
	(properties
		nsTop 40
		nsLeft 192
		nsBottom 65
		nsRight 215
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onAntwerp event 3)
				(localproc_12)
			)
		)
	)
)

(instance onSaurus of RFeature
	(properties
		nsTop 54
		nsLeft 221
		nsBottom 67
		nsRight 245
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onSaurus event 3)
				(localproc_7)
			)
		)
	)
)

(instance onMoose of RFeature
	(properties
		nsTop 57
		nsLeft 279
		nsBottom 85
		nsRight 314
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onMoose event 3)
				(localproc_6)
			)
		)
	)
)

(instance onGuildMaster of RFeature
	(properties
		nsTop 124
		nsLeft 62
		nsBottom 150
		nsRight 80
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onGuildMaster event 3)
				(localproc_4)
			)
		)
	)
)

(instance onFireplace of RFeature
	(properties
		nsTop 119
		nsLeft 1
		nsBottom 155
		nsRight 28
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onFireplace event 3)
				(localproc_5)
			)
		)
	)
)

(instance onLog of RFeature
	(properties
		nsTop 81
		nsLeft 197
		nsBottom 94
		nsRight 219
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onLog event 3)
				(localproc_1)
			)
		)
	)
)

(instance onQuestBoard of RFeature
	(properties
		nsTop 73
		nsLeft 106
		nsBottom 92
		nsRight 162
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onQuestBoard event 3)
				(localproc_3)
			)
		)
	)
)

