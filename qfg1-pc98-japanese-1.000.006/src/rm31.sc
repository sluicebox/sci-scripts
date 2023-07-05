;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm31 0
)

(local
	local0
	local1
	local2
	[local3 250]
	local253
	local254
	local255
	local256
	local257
	local258
	local259
	local260
	local261
	local262
	local263
	local264 = 1
	local265
	local266
	local267
	[local268 5] = [1 2 4 8 16]
	[local273 4] = [{Open} {Fetch} {Flame Dart} {Trigger}]
	[local277 4] = [{\83I\81[\83v\83\93} {\83t\83F\83b\83`} {\83t\83\8c\81[\83\80\81E\83_\81[\83g} {\83g\83\8a\83K\81[}]
	local281
	[local282 8]
)

(procedure (localproc_0)
	(fenrus cycleSpeed: 0 setLoop: 6 setCel: -1 setCycle: Fwd)
)

(procedure (localproc_1)
	(fenrus cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0)
)

(procedure (localproc_2)
	(= global312 1)
	(gEgo setCel: 2)
	(rm31 setScript: 0)
)

(procedure (localproc_3 param1)
	(= local2 (+ param1 5))
	(Format @local3 31 0 &rest) ; "%s"
	(wizard setScript: 0)
	(clr)
	(wizard setScript: wizPrint)
)

(procedure (localproc_4 param1)
	(= local2 (+ param1 5))
	(Format @local3 31 0 &rest) ; "%s"
	(fenrus setScript: 0)
	(clr)
	(fenrus setScript: ratPrint)
)

(procedure (localproc_5)
	(Format @local3 31 0 &rest) ; "%s"
	(gEgo setScript: 0)
	(clr)
	(gEgo setScript: egoPrint)
)

(procedure (localproc_6)
	(= local254 1)
	(localproc_5 31 1)
)

(procedure (localproc_7)
	(= local254 4)
	(fenrus setLoop: 6 setCel: 0)
	(localproc_5 31 2)
)

(procedure (localproc_8)
	(= local254 0)
	(localproc_5 31 3)
)

(procedure (localproc_9)
	(= local254 0)
	(localproc_5 31 4)
)

(procedure (localproc_10)
	(= local254 2)
	(localproc_5 31 5)
)

(procedure (localproc_11)
	(= local254 1)
	(if local255
		(localproc_5 31 6)
	else
		(localproc_5 31 7)
	)
)

(procedure (localproc_12)
	(= local254 4)
	(localproc_5 31 8)
)

(procedure (localproc_13)
	(= local254 3)
	(localproc_5 31 9)
)

(procedure (localproc_14)
	(= local254 2)
	(localproc_5 31 10)
)

(procedure (localproc_15)
	(= local254 2)
	(localproc_5 31 11)
)

(class KeepTalkingScript of Script
	(properties)

	(method (doit)
		(if (and (not global310) (not global311))
			(self cue:)
		)
		(super doit:)
	)
)

(instance rm31 of Rm
	(properties
		picture 31
		style 4
	)

	(method (dispose)
		(SetFlag 21)
		(super dispose:)
	)

	(method (init)
		(HandsOff)
		(gMouseHandler add: self)
		(gKeyHandler add: self)
		(LoadMany rsVIEW 31 199 530)
		(SL enable:)
		(super init:)
		(NormalEgo)
		(gEgo init:)
		(= [local282 0] rexJoke)
		(= [local282 1] torchJoke)
		(= [local282 2] ottoJoke)
		(= [local282 3] commaJoke)
		(= [local282 4] dingeJoke)
		(= [local282 5] noJoke)
		(= [local282 6] flyJoke)
		(= [local282 7] broomJoke)
		(= local258 (Random 50 100))
		(= local259 100)
		(= local260 (Random 1 7))
		(gAddToPics add: table shelf eachElementDo: #init doit:)
		(if (== gPrevRoomNum 32) ; wizGame
			(door1 posn: 144 119)
			(door2 posn: 177 119)
		)
		(door1 ignoreActors: init: setPri: 1 stopUpd:)
		(door2 ignoreActors: init: setPri: 1 stopUpd:)
		(wizBody init: setPri: 5 stopUpd:)
		(teacup init: setPri: 7 stopUpd:)
		(egoChair init: setPri: 5 ignoreActors: stopUpd:)
		(fenrus init: setPri: 9 ignoreActors:)
		(poof init: setPri: 14 ignoreActors:)
		(wizard init: setPri: 15 ignoreActors: illegalBits: 0 stopUpd:)
		(wizDrinking init: setPri: 14 ignoreActors: illegalBits: 0 stopUpd:)
		(if (== gPrevRoomNum 32) ; wizGame
			(gEgo
				view: 31
				setLoop: 4
				setCel: 0
				illegalBits: 0
				posn: 186 121
				stopUpd:
			)
			(self setScript: entryDelay 0 gameOver)
		else
			(gEgo illegalBits: 0 setPri: 8 posn: 200 208)
			(self setScript: entryDelay 0 intoTheTower)
		)
	)

	(method (doit)
		(cond
			((and global312 (> local258 1))
				(-- local258)
			)
			((== local258 1)
				(= local258 (Random 150 250))
				(wizDrinking setScript: drinkTea)
			)
		)
		(cond
			((> local259 1)
				(-- local259)
			)
			((== local259 1)
				(= local259 (Random 200 300))
				(if
					(==
						(rm31 script:)
						(wizDrinking script:)
						(fenrus script:)
						(wizard script:)
						(gEgo script:)
						0
					)
					(if (== local260 7)
						(= local260 0)
					else
						(++ local260)
					)
					(self setScript: [local282 local260])
				)
			)
		)
		(if local0
			(= local0 0)
			(self setScript: teleportOut)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((or global310 global311)
						(event claimed: 1)
					)
					((MouseClaimed wizBody event 3)
						(localproc_6)
					)
					((MouseClaimed onRat event 3)
						(localproc_7)
					)
					((MouseClaimed onLWindow event 3)
						(localproc_8)
					)
					(
						(and
							(MouseClaimed onRWindow event 3)
							(not (MouseClaimed onCheese event 3))
						)
						(localproc_9)
					)
					(
						(and
							(MouseClaimed onTable event 3)
							(not (MouseClaimed teacup event 3))
						)
						(localproc_10)
					)
					((and (MouseClaimed teacup event 3) (not local256))
						(localproc_11)
					)
					((MouseClaimed onCheese event 3)
						(localproc_12)
					)
					((MouseClaimed gEgo event 3)
						(localproc_13)
					)
					((MouseClaimed onCeiling event 3)
						(localproc_14)
					)
					((MouseClaimed onStairs event 3)
						(localproc_15)
					)
				)
			)
			(evKEYBOARD
				(cond
					((== KEY_RETURN (event message:))
						(clr)
						(if global310
							(wizPrint changeState: 2)
						)
						(if global311
							(ratPrint changeState: 2)
						)
					)
					((or global310 global311)
						(event claimed: 1)
					)
				)
			)
			(evSAID
				(cond
					(global313
						(cond
							((Said 'yes,please')
								(if (== (++ local262) 4)
									(localproc_2)
									(= local1 2)
									(= local0 1)
								else
									(= global314 1)
									((rm31 script:) cue:)
								)
							)
							((Said 'no')
								((rm31 script:) cue:)
							)
							((Said 'chuckle')
								(HighPrint 31 12) ; "You're strange! Erasmus hasn't told the punchline yet."
							)
							(else
								(event claimed: 1)
								(HighPrint 31 13) ; "Just answer the question: Yes or No?"
							)
						)
					)
					((Said 'chuckle')
						(switch (Random 0 5)
							(0
								(HighPrint 31 14) ; "YUK-YUK-YUK-GUFFAW!"
							)
							(1
								(HighPrint 31 15) ; "A-HYUK, A-HYUK, A-HYUK. GAWRSH!"
							)
							(2
								(HighPrint 31 16) ; "Tee-Hee-Hee!"
							)
							(3
								(HighPrint 31 17) ; "HO-HO-HO-HEE-HEE-HEE HA-HA-HA!"
							)
							(4
								(HighPrint 31 18) ; "(Snicker!) (Chuckle!) (Titter!)"
							)
							(5
								(HighPrint 31 19) ; "This is a serious game, Rosella!"
							)
						)
					)
					((and (not gNight) (Said 'japaneserestorsleep>')))
					((or (Said 'nap,nap[/!*]') (Said 'go[<to]/nap,nap'))
						(= local1 6)
						(= local0 1)
					)
					((Said 'attack,hit,cut,kill,throw')
						(= local1 3)
						(SetFlag 154)
						(= local0 1)
					)
					((Said 'cast')
						(= local1 4)
						(SetFlag 154)
						(= local0 1)
					)
					(
						(or
							(Said 'stand,stand,done,done,go,done')
							(Said 'get,get<up,out')
						)
						(= local1 5)
						(= local0 1)
					)
					((Said 'look,look>')
						(cond
							((Said '/wizard,erasmus')
								(localproc_6)
							)
							((Said '/fenrus,familiar')
								(localproc_7)
							)
							((Said '/window')
								(localproc_8)
								(localproc_9)
							)
							((Said '/table,desk')
								(localproc_10)
							)
							((Said '/tea,cup,teacup')
								(localproc_11)
							)
							((Said '/cheese')
								(localproc_12)
							)
							((Said '/chair')
								(= local254 2)
								(localproc_5 31 20)
							)
							((or (Said '<up') (Said '/ceiling'))
								(localproc_14)
							)
							(
								(or
									(Said '<down')
									(Said '/floor,ladder,staircase')
								)
								(localproc_15)
							)
						)
					)
					((Said 'play/game,maze')
						(if (>= [gEgoStats 12] 20) ; magic
							(self setScript: goGame)
						else
							(localproc_3 4 31 21)
						)
					)
					((Said 'ask>')
						(if local256
							(localproc_5 31 22)
							(event claimed: 1)
						else
							(= local263 1)
							(cond
								(
									(or
										(Said '//open,open,open')
										(Said '//spell<open,open,open')
									)
									(self setScript: openTalk)
								)
								(
									(or
										(Said '//fetch,fetch')
										(Said '//spell<fetch,fetch')
									)
									(self setScript: fetchTalk)
								)
								(
									(or
										(Said '//trigger')
										(Said '//spell<trigger')
									)
									(self setScript: triggerTalk)
								)
								((or (Said '//dazzle') (Said '//spell<dazzle'))
									(self setScript: dazzleTalk)
								)
								((Said '//trap')
									(self setScript: trapTalk)
								)
								((Said '//erana')
									(self setScript: eranaTalk)
								)
								(
									(or
										(Said '//protection,peace,hamlet')
										(Said '//spell<protection,peace,erana')
									)
									(self setScript: peaceTalk)
								)
								((Said '//zara')
									(self setScript: zaraTalk)
								)
								((Said '//baba')
									(self setScript: babaTalk)
								)
								((Said '//curse,curse')
									(self setScript: curseTalk)
								)
								((Said '//countercurse')
									(self setScript: counterCurseTalk)
								)
								((Said '//fenrus,familiar,fenrus')
									(self setScript: fenrusTalk)
								)
								((Said '//enry,enry,ermit,ermit')
									(self setScript: hermitTalk)
								)
								((Said '//initiation,institute')
									(self setScript: initiationTalk)
								)
								((Said '//mirror')
									(self setScript: mirrorTalk)
								)
								((Said '//wizard,user,caster,mage,mage')
									(self setScript: wizardTalk)
								)
								((Said '//nincompoop')
									(self setScript: poopTalk)
								)
								((Said '//necromancer')
									(self setScript: deadTalk)
								)
								((Said '//magic,technocery')
									(self setScript: magicTalk)
								)
								((Said '//game,maze')
									(self setScript: gameTalk)
								)
								((Said '//warlock')
									(localproc_3 5 31 23)
								)
								((Said '//spell,scroll')
									(localproc_3 7 31 24)
								)
								((Said '//bandit')
									(localproc_3 9 31 25)
								)
								((Said '//erasmus')
									(localproc_3 4 31 26)
								)
								(else
									(event claimed: 1)
									(= local263 0)
									(if (== (++ local261) 6)
										(= local1 1)
										(= local0 1)
									else
										(localproc_3 4 31 27)
									)
								)
							)
							(if (and local263 (event claimed:))
								(SolvePuzzle 659 1)
							)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance wizPrint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global310 1)
				(if (< (wizDrinking cel:) 4)
					(wizard setCycle: Fwd)
				)
				(cond
					((> (gEgo cel:) 1)
						(gEgo setCycle: CT 1 -1 self)
					)
					((< (gEgo cel:) 1)
						(gEgo setCycle: CT 1 1 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(if (!= local2 0)
					(Print
						@local3
						#at
						5
						5
						#width
						305
						#mode
						1
						#title
						{ Erasmus%j\b4\d7\bd\d1\bd}
						#dispose
						#time
						local2
					)
					(= seconds local2)
				else
					(Print @local3 #at 5 5 #width 305 #mode 1)
					(self cue:)
				)
			)
			(2
				(wizard setCycle: 0 setCel: 0 setScript: 0)
				(= global310 0)
			)
		)
	)
)

(instance ratPrint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global311 1)
				(fenrus setLoop: 5 setCycle: Fwd)
				(if (< (gEgo cel:) 4)
					(gEgo setCycle: CT 4 1 self)
				else
					(self cue:)
				)
			)
			(1
				(if (!= local2 0)
					(Print
						@local3
						#at
						5
						5
						#width
						305
						#mode
						1
						#title
						{ Fenrus%j\cc\aa\dd\d7\bd}
						#dispose
						#time
						local2
					)
					(= seconds local2)
				else
					(Print @local3 #at 5 5 #width 305 #mode 1)
					(self cue:)
				)
			)
			(2
				(fenrus setCycle: 0 setLoop: 5 setCel: 0 setScript: 0)
				(= global311 0)
			)
		)
	)
)

(instance egoPrint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local254
					(0
						(if (> (gEgo cel:) 0)
							(gEgo setCycle: CT 0 -1 self)
						else
							(self cue:)
						)
					)
					(1
						(if (> (gEgo cel:) 1)
							(gEgo setCycle: CT 1 -1 self)
						else
							(gEgo setCel: 1)
							(= cycles 1)
						)
					)
					(2
						(cond
							((< (gEgo cel:) 2)
								(gEgo setCycle: CT 2 1 self)
							)
							((> (gEgo cel:) 2)
								(gEgo setCycle: CT 2 -1 self)
							)
							(else
								(self cue:)
							)
						)
					)
					(3
						(if (< (gEgo cel:) 3)
							(gEgo setCycle: CT 3 1 self)
						else
							(gEgo setCel: 3)
							(= cycles 1)
						)
					)
					(4
						(if (< (gEgo cel:) 4)
							(gEgo setCycle: CT 4 1 self)
						else
							(fenrus setLoop: 6)
							(= cycles 2)
						)
					)
				)
			)
			(1
				(Print @local3 #at -1 15)
				(if (== (fenrus loop:) 6)
					(fenrus setLoop: 5)
				)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance drinkTea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local256 1)
				(wizard hide:)
				(teacup hide:)
				(self cue:)
			)
			(1
				(wizDrinking setCycle: End self)
			)
			(2
				(= cycles 8)
			)
			(3
				(wizDrinking setCycle: Beg self)
			)
			(4
				(= local256 0)
				(wizard show:)
				(teacup show:)
				(wizDrinking setCel: 0 setScript: 0)
			)
		)
	)
)

(instance teleportOut of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if global313
					(= global313 0)
				)
				(= local258 0)
				(User canInput: 0)
				(switch local1
					(1
						(localproc_3 4 31 28)
					)
					(2
						(localproc_3 8 31 29)
					)
					(3
						(localproc_3 6 31 30)
					)
					(4
						(localproc_3 4 31 31)
					)
					(6
						(localproc_3 4 31 31)
					)
					(else
						(localproc_3 4 31 32)
					)
				)
			)
			(1
				(= global310 1)
				(wizard hide:)
				(wizDrinking setLoop: 3 cel: 0 setCycle: End self)
			)
			(2
				(Magic
					ignoreActors:
					setPri: (+ (gEgo priority:) 1)
					posn: (egoChair x:) (egoChair y:)
					init:
					setCycle: CT 6 1 self
				)
			)
			(3
				(gEgo hide:)
				(egoChair setLoop: 0 setCel: 3)
				(Magic setCycle: End self)
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

(instance table of PV
	(properties
		y 149
		x 152
		view 31
		cel 1
		priority 6
	)
)

(instance shelf of PV
	(properties
		y 123
		x 201
		view 31
		cel 8
		priority 7
	)
)

(instance door1 of Act
	(properties
		y 119
		x 153
		view 31
		illegalBits 0
		xStep 1
	)
)

(instance door2 of Act
	(properties
		y 119
		x 168
		view 31
		illegalBits 0
		xStep 1
	)
)

(instance egoChair of View
	(properties
		y 151
		x 183
		view 31
		cel 3
	)
)

(instance teacup of View
	(properties
		y 123
		x 147
		view 31
		cel 5
	)
)

(instance wizBody of View
	(properties
		y 148
		x 131
		view 31
		cel 6
	)
)

(instance wizard of Act
	(properties
		y 122
		x 129
		view 31
		loop 2
		cycleSpeed 1
	)
)

(instance wizDrinking of Act
	(properties
		y 128
		x 136
		view 31
		loop 1
		cycleSpeed 1
	)
)

(instance fenrus of Prop
	(properties
		y 113
		x 206
		view 199
		loop 4
	)
)

(instance poof of Prop
	(properties
		y 108
		x 204
		view 199
		loop 3
		cel 5
		cycleSpeed 1
	)
)

(instance Magic of Prop
	(properties
		view 530
		cycleSpeed 2
	)
)

(instance onCheese of RFeature
	(properties
		nsTop 101
		nsLeft 192
		nsBottom 108
		nsRight 197
	)
)

(instance onRat of RFeature
	(properties
		nsTop 91
		nsLeft 198
		nsBottom 114
		nsRight 210
	)
)

(instance onLWindow of RFeature
	(properties
		nsTop 88
		nsLeft 119
		nsBottom 100
		nsRight 131
	)
)

(instance onRWindow of RFeature
	(properties
		nsTop 90
		nsLeft 187
		nsBottom 111
		nsRight 197
	)
)

(instance onStairs of RFeature
	(properties
		nsTop 156
		nsLeft 161
		nsBottom 166
		nsRight 197
	)
)

(instance onTable of RFeature
	(properties
		nsTop 118
		nsLeft 138
		nsBottom 149
		nsRight 168
	)
)

(instance onCeiling of RFeature
	(properties
		nsLeft 97
		nsBottom 90
		nsRight 224
	)
)

(instance entryDelay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(client setScript: register)
			)
		)
	)
)

(instance cheese of View
	(properties
		y 122
		x 161
		view 31
		cel 4
	)
)

(instance intoTheTower of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(cheese init: setPri: 7 ignoreActors: stopUpd:)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if (and local267 (not global310) (not local265))
			(self cue:)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) evSAID) local265)
				(= seconds 0)
				(cond
					((Said 'yes,please')
						(= local264 0)
						(self cue:)
					)
					((Said 'no')
						(self cue:)
					)
					(else
						(event claimed: 1)
						(localproc_3 4 31 33)
					)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 [temp1 66])
		(switch (= state newState)
			(0
				(gEgo
					illegalBits: 0
					setPri: 8
					posn: 200 208
					setMotion: MoveTo 175 183 self
				)
			)
			(1
				(wizard setCycle: Fwd)
				(= cycles 4)
			)
			(2
				(Print ; "Come in and sit down."
					31
					34
					#at
					5
					40
					#width
					80
					#mode
					1
					#title
					{ Erasmus %j\b4\d7\bd\d1\bd}
					#dispose
					#time
					3
				)
				(gEgo setMotion: MoveTo 155 163 self)
			)
			(3
				(NormalEgo)
				(gEgo illegalBits: 0 setMotion: MoveTo 155 158 self)
			)
			(4
				(wizard setCel: 0 setCycle: 0)
				(gEgo setMotion: MoveTo 174 152 self)
			)
			(5
				(egoChair setCel: 7)
				(gEgo
					view: 31
					setLoop: 4
					setCel: 2
					illegalBits: 0
					posn: 186 121
					stopUpd:
				)
				(= cycles 5)
			)
			(6
				(wizard setCel: -1 setCycle: Fwd)
				(Print ; "Fenrus, our guest has arrived."
					31
					35
					#at
					5
					40
					#width
					80
					#mode
					1
					#title
					{ Erasmus %j\b4\d7\bd\d1\bd}
					#dispose
					#time
					4
				)
				(= seconds 4)
			)
			(7
				(wizard setCel: 0 setCycle: 0 stopUpd:)
				(gEgo setCel: 2)
				(poof setCycle: Beg self)
			)
			(8
				(poof setCycle: End self)
			)
			(9
				(fenrus setCycle: End)
				(= cycles 10)
			)
			(10
				(Print ; "Cheese, please!"
					31
					36
					#at
					219
					85
					#width
					90
					#mode
					1
					#title
					{ Fenrus %j\cc\aa\dd\d7\bd}
					#dispose
					#time
					3
				)
				(gEgo setCycle: End)
				(= seconds 2)
			)
			(11
				(poof
					cycleSpeed: 0
					cel: 0
					posn: 197 102
					setPri: 14
					setCycle: End self
				)
			)
			(12
				(poof cel: 0 posn: 161 115 setCycle: End)
				(= cycles 10)
			)
			(13
				(cheese posn: (+ (cheese x:) 7) (- (cheese y:) 3))
				(++ local253)
				(= cycles 1)
			)
			(14
				(if (< local253 5)
					(self changeState: 13)
				else
					(cheese dispose:)
					(fenrus setLoop: 5 setCel: 0)
					(self cue:)
				)
			)
			(15
				(fenrus setCel: 1)
				(Print ; "Ahhhhhh!"
					31
					37
					#at
					225
					85
					#width
					90
					#mode
					1
					#title
					{ Fenrus %j\cc\aa\dd\d7\bd}
					#dispose
					#time
					3
				)
				(gEgo setCycle: CT 3 -1)
				(= seconds 3)
			)
			(16
				(fenrus cycleSpeed: 1 setCel: 0)
				(= cycles 2)
			)
			(17
				(if (>= [gEgoStats 12] 20) ; magic
					(= cycles 1)
				else
					(User canInput: 1)
					(gEgo setCel: 2)
					(client setScript: 0)
				)
			)
			(18
				(HandsOff)
				(= local267 1)
				(= global312 0)
				(= local264 0)
				(if (not (IsFlag 353))
					(SetFlag 353)
					(localproc_3 8 31 38)
				else
					(= cycles 1)
				)
			)
			(19
				(while (& global281 [local268 register])
					(++ register)
				)
				(cond
					(local266
						(SetFlag 266)
						(localproc_3 9 31 39)
					)
					((& global280 [local268 register])
						(localproc_3
							5
							(Format ; "Have you learned the %s spell yet?%"
								@temp1
								31
								40
								[local273 register]
								[local277 register]
							)
						)
					)
					((< register 4)
						(|= global280 [local268 register])
						(localproc_3
							7
							(Format ; "Do you know how to cast the %s spell?%"
								@temp1
								31
								41
								[local273 register]
								[local277 register]
							)
						)
					)
					((IsFlag 266)
						(localproc_3 7 31 42)
					)
					(else
						(= local266 1)
						(-- state)
						(localproc_3 7 31 43)
					)
				)
			)
			(20
				(= local264 (= local265 1))
				(HandsOn)
				(User canControl: 0)
				(= seconds 14)
			)
			(21
				(HandsOff)
				(= local265 0)
				(cond
					(local264
						(switch register
							(4
								(gEgo setCel: 2)
								(User canInput: 1)
								(client setScript: 0)
								(localproc_3 8 31 44)
							)
							(3
								(localproc_3 8 31 45)
							)
							(else
								(localproc_3 8 31 46)
							)
						)
					)
					((>= register 4)
						(client setScript: goGame)
					)
					(else
						(|= global281 [local268 register])
						(++ register)
						(self changeState: 19)
					)
				)
			)
			(22
				(gEgo setCel: 2)
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance gameOver of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoChair setCel: 7)
				(gEgo
					view: 31
					setLoop: 4
					setCel: 0
					illegalBits: 0
					posn: 186 121
					stopUpd:
				)
				(fenrus setLoop: 5 cel: 1)
				(= cycles 5)
			)
			(1
				(poof
					cycleSpeed: 0
					cel: 0
					posn: 160 102
					setPri: 14
					setCycle: End self
				)
			)
			(2
				(door1 setLoop: 0 setCel: 0 setMotion: MoveTo 153 119 startUpd:)
				(door2
					setLoop: 0
					setCel: 0
					setMotion: MoveTo 168 119 self
					startUpd:
				)
			)
			(3
				(door2 stopUpd:)
				(door1 stopUpd:)
				(gEgo setCel: 2)
				(= cycles 5)
			)
			(4
				(wizard setCel: -1 setCycle: Fwd)
				(gEgo setCel: 1)
				(Print ; "I so enjoy playing the Mage's Maze."
					31
					47
					#at
					5
					40
					#width
					80
					#mode
					1
					#title
					{ Erasmus %j\b4\d7\bd\d1\bd}
					#dispose
					#time
					5
				)
				(= seconds 5)
			)
			(5
				(gEgo setCel: 2)
				(wizard setCycle: Beg)
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance openTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 7 31 48)
			)
			(1
				(localproc_3 7 31 49)
			)
			(2
				(localproc_4 5 31 50)
			)
			(3
				(localproc_3 4 31 51)
			)
			(4
				(localproc_4 4 31 52)
			)
			(5
				(= global311 1)
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 8)
			)
			(6
				(localproc_2)
				(= global311 0)
				(localproc_1)
			)
		)
	)
)

(instance fetchTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 7 31 53)
			)
			(1
				(localproc_3 5 31 54)
			)
			(2
				(localproc_4 4 31 55)
			)
			(3
				(localproc_3 6 31 56)
			)
			(4
				(localproc_4 5 31 57)
			)
			(5
				(localproc_2)
			)
		)
	)
)

(instance triggerTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 9 31 58)
			)
			(1
				(localproc_3 9 31 59)
			)
			(2
				(localproc_3 6 31 60)
			)
			(3
				(localproc_3 7 31 61)
			)
			(4
				(localproc_3 7 31 62)
			)
			(5
				(localproc_2)
			)
		)
	)
)

(instance dazzleTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 5 31 63)
			)
			(1
				(localproc_3 6 31 64)
			)
			(2
				(localproc_3 10 31 65)
			)
			(3
				(localproc_2)
			)
		)
	)
)

(instance trapTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 8 31 66)
			)
			(1
				(localproc_3 9 31 67)
			)
			(2
				(localproc_4 7 31 68)
			)
			(3
				(= global311 1)
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 12)
			)
			(4
				(= global311 0)
				(localproc_1)
				(gEgo setCel: 2)
				(localproc_3 5 31 69)
			)
			(5
				(localproc_2)
			)
		)
	)
)

(instance goGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(poof
					cycleSpeed: 0
					cel: 0
					posn: 160 102
					setPri: 14
					setCycle: End self
				)
			)
			(1
				(gEgo setCel: 0)
				(door1 setLoop: 0 setCel: 0 setMotion: MoveTo 143 119 startUpd:)
				(door2
					setLoop: 0
					setCel: 0
					setMotion: MoveTo 178 119 self
					startUpd:
				)
			)
			(2
				(gCurRoom newRoom: 32) ; wizGame
			)
		)
	)
)

(instance eranaTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 5 31 70)
			)
			(1
				(localproc_3 9 31 71)
			)
			(2
				(localproc_3 9 31 72)
			)
			(3
				(localproc_4 8 31 73)
			)
			(4
				(= global311 1)
				(localproc_0)
				(= cycles 6)
			)
			(5
				(= global311 0)
				(localproc_1)
				(localproc_3 10 31 74)
			)
			(6
				(= global312 1)
				(client setScript: 0)
			)
		)
	)
)

(instance peaceTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 9 31 75)
			)
			(1
				(localproc_3 9 31 76)
			)
			(2
				(localproc_3 5 31 77)
			)
			(3
				(localproc_4 4 31 78)
			)
			(4
				(= global311 1)
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 8)
			)
			(5
				(localproc_2)
				(= global311 0)
				(localproc_1)
			)
		)
	)
)

(instance zaraTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 9 31 79)
			)
			(1
				(localproc_3 6 31 80)
			)
			(2
				(localproc_4 8 31 81)
			)
			(3
				(localproc_4 5 31 82)
			)
			(4
				(= global311 1)
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 8)
			)
			(5
				(localproc_2)
				(= global311 0)
				(localproc_1)
			)
		)
	)
)

(instance babaTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 9 31 83)
			)
			(1
				(localproc_3 6 31 84)
			)
			(2
				(localproc_4 4 31 85)
			)
			(3
				(localproc_3 7 31 86)
			)
			(4
				(localproc_4 5 31 87)
			)
			(5
				(= global311 1)
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 8)
			)
			(6
				(localproc_2)
				(= global311 0)
				(localproc_1)
			)
		)
	)
)

(instance curseTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 7 31 88)
			)
			(1
				(localproc_3 10 31 89)
			)
			(2
				(localproc_3 7 31 90)
			)
			(3
				(localproc_2)
			)
		)
	)
)

(instance counterCurseTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 10 31 91)
			)
			(1
				(localproc_3 8 31 92)
			)
			(2
				(localproc_5 31 93)
			)
			(3
				(localproc_5 31 94)
			)
			(4
				(localproc_5 31 95)
			)
			(5
				(localproc_5 31 96)
			)
			(6
				(localproc_3 11 31 97)
			)
			(7
				(localproc_4 8 31 98)
			)
			(8
				(localproc_2)
			)
		)
	)
)

(instance fenrusTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_4 9 31 99)
			)
			(1
				(localproc_3 6 31 100)
			)
			(2
				(localproc_2)
			)
		)
	)
)

(instance hermitTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 7 31 101)
			)
			(1
				(localproc_4 6 31 102)
			)
			(2
				(localproc_3 8 31 103)
			)
			(3
				(localproc_3 5 31 104)
			)
			(4
				(localproc_4 5 31 105)
			)
			(5
				(localproc_2)
			)
		)
	)
)

(instance initiationTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 7 31 106)
			)
			(1
				(localproc_2)
			)
		)
	)
)

(instance mirrorTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 10 31 107)
			)
			(1
				(localproc_4 5 31 108)
			)
			(2
				(localproc_3 5 31 109)
			)
			(3
				(localproc_4 6 31 110)
			)
			(4
				(= global311 1)
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 12)
			)
			(5
				(= global311 0)
				(localproc_1)
				(gEgo setCel: 2)
				(localproc_3 11 31 111)
			)
			(6
				(localproc_3 8 31 112)
			)
			(7
				(localproc_4 8 31 113)
			)
			(8
				(localproc_3 4 31 114)
			)
			(9
				(localproc_3 8 31 115)
			)
			(10
				(localproc_2)
			)
		)
	)
)

(instance wizardTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 7 31 116)
			)
			(1
				(localproc_3 10 31 117)
			)
			(2
				(localproc_3 5 31 118)
			)
			(3
				(localproc_3 7 31 119)
			)
			(4
				(localproc_4 5 31 120)
			)
			(5
				(localproc_3 5 31 121)
			)
			(6
				(localproc_4 6 31 122)
			)
			(7
				(= global311 1)
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 12)
			)
			(8
				(= global311 0)
				(localproc_1)
				(gEgo setCel: 2)
				(localproc_2)
			)
		)
	)
)

(instance poopTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 5 31 123)
			)
			(1
				(localproc_4 5 31 124)
			)
			(2
				(= global311 1)
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 8)
			)
			(3
				(localproc_2)
				(= global311 0)
				(localproc_1)
			)
		)
	)
)

(instance deadTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_4 7 31 125)
			)
			(1
				(localproc_3 5 31 126)
			)
			(2
				(localproc_3 6 31 127)
			)
			(3
				(localproc_4 5 31 128)
			)
			(4
				(localproc_3 7 31 129)
			)
			(5
				(localproc_4 4 31 130)
			)
			(6
				(localproc_4 4 31 131)
			)
			(7
				(= global311 1)
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 8)
			)
			(8
				(localproc_2)
				(= global311 0)
				(localproc_1)
			)
		)
	)
)

(instance magicTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 6 31 132)
			)
			(1
				(localproc_4 8 31 133)
			)
			(2
				(localproc_3 3 31 134)
			)
			(3
				(localproc_3 6 31 135)
			)
			(4
				(localproc_4 5 31 136)
			)
			(5
				(localproc_3 9 31 137)
			)
			(6
				(localproc_4 7 31 138)
			)
			(7
				(localproc_3 6 31 139)
			)
			(8
				(localproc_4 3 31 140)
			)
			(9
				(localproc_3 4 31 141)
			)
			(10
				(localproc_4 4 31 142)
			)
			(11
				(= global311 1)
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 8)
			)
			(12
				(= global311 0)
				(localproc_1)
				(localproc_2)
			)
		)
	)
)

(instance gameTalk of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(localproc_3 11 31 143)
			)
			(1
				(localproc_4 5 31 144)
			)
			(2
				(localproc_3 5 31 145)
			)
			(3
				(localproc_3 9 31 146)
			)
			(4
				(localproc_3 9 31 147)
			)
			(5
				(localproc_2)
			)
		)
	)
)

(instance rexJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(localproc_3 11 31 148)
			)
			(1
				(if global314
					(localproc_3 6 31 149)
					(= global313 0)
					(localproc_2)
				else
					(self cue:)
				)
				(= global314 0)
			)
			(2
				(localproc_3 5 31 150)
				(= cycles 5)
			)
			(3
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 20)
			)
			(4
				(localproc_2)
				(= global313 0)
				(localproc_1)
			)
		)
	)
)

(instance torchJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(localproc_3 8 31 151)
			)
			(1
				(localproc_3 4 31 152)
				(= cycles 5)
			)
			(2
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 20)
			)
			(3
				(localproc_2)
				(= global313 0)
				(localproc_1)
			)
		)
	)
)

(instance ottoJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(localproc_3 8 31 153)
			)
			(1
				(if global314
					(localproc_3 6 31 154)
					(= global313 0)
					(localproc_2)
				else
					(self cue:)
				)
				(= global314 0)
			)
			(2
				(localproc_3 5 31 155)
				(= cycles 5)
			)
			(3
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 20)
			)
			(4
				(localproc_2)
				(= global313 0)
				(localproc_1)
			)
		)
	)
)

(instance commaJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(localproc_3 6 31 156)
			)
			(1
				(if global314
					(localproc_3 3 31 157)
					(= global313 0)
					(localproc_2)
				else
					(self cue:)
				)
				(= global314 0)
			)
			(2
				(localproc_3 5 31 158)
				(= cycles 5)
			)
			(3
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 20)
			)
			(4
				(localproc_2)
				(= global313 0)
				(localproc_1)
			)
		)
	)
)

(instance dingeJoke of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(= local281 1)
				(localproc_3 6 31 159)
			)
			(1
				(= local281 0)
				(if global314
					(localproc_3 4 31 160)
					(= global313 0)
					(localproc_2)
				)
				(= global314 0)
			)
			(2
				(User canInput: 0)
				(localproc_3 4 31 161)
			)
			(3
				(localproc_4 6 31 162)
			)
			(4
				(gEgo setCel: 3)
				(localproc_0)
				(= cycles 12)
			)
			(5
				(User canInput: 1)
				(localproc_2)
				(= global313 0)
				(localproc_1)
			)
		)
	)
)

(instance noJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(localproc_3 6 31 163)
			)
			(1
				(if global314
					(localproc_3 8 31 164)
					(= global313 0)
					(localproc_2)
				else
					(self cue:)
				)
				(= global314 0)
			)
			(2
				(localproc_3 4 31 165)
				(= global313 0)
				(localproc_2)
			)
		)
	)
)

(instance flyJoke of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(= local281 1)
				(localproc_3 8 31 166)
			)
			(1
				(= local281 0)
				(if global314
					(localproc_3 4 31 167)
					(= global313 0)
					(localproc_2)
				)
				(= global314 0)
			)
			(2
				(User canInput: 0)
				(localproc_3 4 31 168)
			)
			(3
				(localproc_4 4 31 169)
			)
			(4
				(localproc_0)
				(gEgo setCel: 3)
				(localproc_3 4 31 170)
			)
			(5
				(User canInput: 1)
				(localproc_1)
				(localproc_2)
				(= global313 0)
			)
		)
	)
)

(instance broomJoke of KeepTalkingScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(= local281 1)
				(localproc_3 4 31 171)
			)
			(1
				(= local281 0)
				(if global314
					(localproc_3 4 31 172)
					(= global313 0)
					(localproc_2)
				)
				(= global314 0)
			)
			(2
				(User canInput: 0)
				(localproc_3 4 31 173)
			)
			(3
				(localproc_4 4 31 174)
			)
			(4
				(gEgo setCel: 3)
				(= cycles 5)
			)
			(5
				(Print 31 175 #at 164 85) ; "(Gag!)"
				(= global313 0)
				(User canInput: 1)
				(localproc_2)
			)
		)
	)
)

