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
	wizard 1
	egoChair 2
	poof 3
	fenrus 4
	proc31_5 5
	proc31_6 6
	proc31_7 7
	proc31_8 8
	door1 9
	door2 10
)

(local
	local0
	local1
	local2
	[local3 251]
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
)

(procedure (proc31_8)
	(= global312 1)
	(gEgo setCel: 2)
	(rm31 setScript: 0)
)

(procedure (proc31_5 param1)
	(= local2 (+ param1 5))
	(Format @local3 31 0 &rest) ; "%s"
	(wizard setScript: 0)
	(clr)
	(wizard setScript: wizPrint)
)

(procedure (proc31_6 param1)
	(= local2 (+ param1 5))
	(Format @local3 31 0 &rest) ; "%s"
	(fenrus setScript: 0)
	(clr)
	(fenrus setScript: ratPrint)
)

(procedure (proc31_7)
	(Format @local3 31 0 &rest) ; "%s"
	(gEgo setScript: 0)
	(clr)
	(gEgo setScript: egoPrint)
)

(procedure (localproc_0)
	(= local254 1)
	(proc31_7 31 1)
)

(procedure (localproc_1)
	(= local254 4)
	(fenrus setLoop: 6 setCel: 0)
	(proc31_7 31 2)
)

(procedure (localproc_2)
	(= local254 0)
	(proc31_7 31 3)
)

(procedure (localproc_3)
	(= local254 0)
	(proc31_7 31 4)
)

(procedure (localproc_4)
	(= local254 2)
	(proc31_7 31 5)
)

(procedure (localproc_5)
	(= local254 1)
	(if local255
		(proc31_7 31 6)
	else
		(proc31_7 31 7)
	)
)

(procedure (localproc_6)
	(= local254 4)
	(proc31_7 31 8)
)

(procedure (localproc_7)
	(= local254 3)
	(proc31_7 31 9)
)

(procedure (localproc_8)
	(= local254 2)
	(proc31_7 31 10)
)

(procedure (localproc_9)
	(= local254 2)
	(proc31_7 31 11)
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
		(LoadMany rsSCRIPT 131 132 133 134 135)
		(LoadMany rsTEXT 131 132 133 134 135)
		(LoadMany rsVIEW 31 199 530)
		(SL enable:)
		(super init:)
		(NormalEgo)
		(gEgo init:)
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
			(self setScript: entryDelay 0 (ScriptID 131 1)) ; gameOver
		else
			(gEgo illegalBits: 0 setPri: 8 posn: 200 208)
			(self setScript: entryDelay 0 (ScriptID 131 0)) ; intoTheTower
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
					(self setScript: (ScriptID 135 local260))
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
						(localproc_0)
					)
					((MouseClaimed onRat event 3)
						(localproc_1)
					)
					((MouseClaimed onLWindow event 3)
						(localproc_2)
					)
					(
						(and
							(MouseClaimed onRWindow event 3)
							(not (MouseClaimed onCheese event 3))
						)
						(localproc_3)
					)
					(
						(and
							(MouseClaimed onTable event 3)
							(not (MouseClaimed teacup event 3))
						)
						(localproc_4)
					)
					((and (MouseClaimed teacup event 3) (not local256))
						(localproc_5)
					)
					((MouseClaimed onCheese event 3)
						(localproc_6)
					)
					((MouseClaimed gEgo event 3)
						(localproc_7)
					)
					((MouseClaimed onCeiling event 3)
						(localproc_8)
					)
					((MouseClaimed onStairs event 3)
						(localproc_9)
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
									(proc31_8)
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
					((or (Said 'nap[/!*]') (Said 'go[<to]/nap'))
						(= local1 6)
						(= local0 1)
					)
					((Said 'fight,hit,cut,kill,throw')
						(= local1 3)
						(SetFlag 154)
						(= local0 1)
					)
					((Said 'cast')
						(= local1 4)
						(SetFlag 154)
						(= local0 1)
					)
					((or (Said 'stand,done,go,done') (Said 'get<up,out'))
						(= local1 5)
						(= local0 1)
					)
					((Said 'look>')
						(cond
							((Said '/wizard,erasmus')
								(localproc_0)
							)
							((Said '/fenrus,familiar')
								(localproc_1)
							)
							((Said '/window')
								(localproc_2)
								(localproc_3)
							)
							((Said '/table,desk')
								(localproc_4)
							)
							((Said '/tea,cup,teacup')
								(localproc_5)
							)
							((Said '/cheese')
								(localproc_6)
							)
							((Said '/chair')
								(= local254 2)
								(proc31_7 31 20)
							)
							((or (Said '<up') (Said '/ceiling'))
								(localproc_8)
							)
							(
								(or
									(Said '<down')
									(Said '/floor,ladder,staircase')
								)
								(localproc_9)
							)
						)
					)
					((Said 'play/game,maze')
						(if (>= [gEgoStats 12] 20) ; magic
							(self setScript: (ScriptID 132 5)) ; goGame
						else
							(proc31_5 4 31 21)
						)
					)
					((Said 'ask>')
						(if local256
							(proc31_7 31 22)
							(event claimed: 1)
						else
							(= local263 1)
							(cond
								((or (Said '//open') (Said '//spell<open'))
									(self setScript: (ScriptID 132 0)) ; openTalk
								)
								((or (Said '//fetch') (Said '//spell<fetch'))
									(self setScript: (ScriptID 132 1)) ; fetchTalk
								)
								(
									(or
										(Said '//trigger')
										(Said '//spell<trigger')
									)
									(self setScript: (ScriptID 132 2)) ; triggerTalk
								)
								((or (Said '//dazzle') (Said '//spell<dazzle'))
									(self setScript: (ScriptID 132 3)) ; dazzleTalk
								)
								((Said '//trap')
									(self setScript: (ScriptID 132 4)) ; trapTalk
								)
								((Said '//erana')
									(self setScript: (ScriptID 133 0)) ; eranaTalk
								)
								(
									(or
										(Said '//protection,peace,hamlet')
										(Said '//spell<protection,peace,erana')
									)
									(self setScript: (ScriptID 133 1)) ; peaceTalk
								)
								((Said '//zara')
									(self setScript: (ScriptID 133 2)) ; zaraTalk
								)
								((Said '//baba')
									(self setScript: (ScriptID 133 3)) ; babaTalk
								)
								((Said '//curse')
									(self setScript: (ScriptID 133 4)) ; curseTalk
								)
								((Said '//countercurse')
									(self setScript: (ScriptID 133 5)) ; counterCurseTalk
								)
								((Said '//fenrus,familiar,fenrus')
									(self setScript: (ScriptID 133 6)) ; fenrusTalk
								)
								((Said '//enry,enry,ermit,ermit')
									(self setScript: (ScriptID 133 7)) ; hermitTalk
								)
								((Said '//initiate,institute')
									(self setScript: (ScriptID 133 8)) ; initiationTalk
								)
								((Said '//mirror')
									(self setScript: (ScriptID 134 0)) ; mirrorTalk
								)
								((Said '//wizard,user,caster,mage,mage')
									(self setScript: (ScriptID 134 1)) ; wizardTalk
								)
								((Said '//nincompoop')
									(self setScript: (ScriptID 134 2)) ; poopTalk
								)
								((Said '//necromancer')
									(self setScript: (ScriptID 134 3)) ; deadTalk
								)
								((Said '//magic,technocery')
									(self setScript: (ScriptID 134 4)) ; magicTalk
								)
								((Said '//game,maze')
									(self setScript: (ScriptID 134 5)) ; gameTalk
								)
								((Said '//warlock')
									(proc31_5 5 31 23)
								)
								((Said '//spell,scroll')
									(proc31_5 7 31 24)
								)
								((Said '//bandit')
									(proc31_5 9 31 25)
								)
								((Said '//erasmus')
									(proc31_5 4 31 26)
								)
								(else
									(event claimed: 1)
									(= local263 0)
									(if (== (++ local261) 6)
										(= local1 1)
										(= local0 1)
									else
										(proc31_5 4 31 27)
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
						3
						25
						#width
						82
						#mode
						1
						#title
						{ Erasmus }
						#dispose
						#time
						local2
					)
					(= seconds local2)
				else
					(Print @local3 #at 3 25 #width 82 #mode 1)
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
						225
						85
						#width
						90
						#mode
						1
						#title
						{ Fenrus }
						#dispose
						#time
						local2
					)
					(= seconds local2)
				else
					(Print @local3 #at 225 85 #width 90 #mode 1)
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

(instance teleportOut of Script
	(properties)

	(method (doit)
		(if (and (not global310) (not global311))
			(self cue:)
		)
		(super doit:)
	)

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
						(proc31_5 4 31 28)
					)
					(2
						(proc31_5 8 31 29)
					)
					(3
						(proc31_5 6 31 30)
					)
					(4
						(proc31_5 4 31 31)
					)
					(6
						(proc31_5 4 31 31)
					)
					(else
						(proc31_5 4 31 32)
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

