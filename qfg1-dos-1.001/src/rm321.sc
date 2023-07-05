;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 321)
(include sci.sh)
(use Main)
(use LoadMany)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)

(public
	rm321 0
	vase 1
	miscMusic 2
	sneakMusic 3
	portrait 4
	sheriff 5
	otto 6
	bottomDoor 7
	leftDoor 8
	rightDoor 9
	musicBox 10
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
)

(procedure (localproc_0)
	(if local3
		(LowPrint &rest)
	else
		(HighPrint &rest)
	)
)

(procedure (localproc_1)
	(SetFlag 144)
	(gEgo get: 1 3) ; silver
	(localproc_0 321 0) ; "In the desk drawers, you find an assortment of mostly worthless objects, but you find three silvers, which you take."
	(SolvePuzzle 631 1 2)
)

(instance otto of Act
	(properties)
)

(instance sheriff of Act
	(properties)
)

(instance vase of Act
	(properties)
)

(instance leftDoor of Prop
	(properties)
)

(instance rightDoor of Prop
	(properties)
)

(instance bottomDoor of Prop
	(properties)
)

(instance safeDoor of View
	(properties)
)

(instance portrait of View
	(properties)
)

(instance candelabra of View
	(properties)
)

(instance chair of View
	(properties)
)

(instance musicBox of View
	(properties)
)

(instance rm321 of Rm
	(properties
		picture 321
		style 3
	)

	(method (dispose)
		(ClearFlag 193)
		(SetFlag 95)
		(= global325 (SoundFX 26))
		(super dispose:)
	)

	(method (init)
		(LoadMany rsSCRIPT 969 288 289 290)
		(LoadMany rsTEXT 288 289 290)
		(LoadMany rsVIEW 321 602 601 525 507 503)
		(LoadMany rsSOUND 8 13 (SoundFX 52) (SoundFX 14) (SoundFX 15) (SoundFX 35))
		(super init:)
		(SolvePuzzle 630 5 2)
		(gMouseHandler add: self)
		(self
			setFeatures:
				onDesk
				onCandles
				onVase
				onMusicBox
				onFireplace
				onPaintingDown
				onPaintingUp
				onSafe
				onPlant
				onLeftDoor
				onRightDoor
				onBottomDoor
				onChair
				onCouch
				onStuffedChair
				onTable
		)
		(self setLocales: 801)
		(SL enable:)
		(sneakMusic init:)
		(miscMusic init:)
		(= global325 (SoundFX 52))
		(if (IsFlag 184)
			(= local6 1)
		)
		(if (IsFlag 183)
			(= local5 1)
		)
		(if (IsFlag 179)
			(= local4 1)
		)
		(NormalEgo)
		(gEgo
			posn: 163 188
			illegalBits: -30720
			init:
			setMotion: MoveTo 163 169
		)
		(leftDoor
			view: 321
			loop: 1
			cel: 0
			posn: 129 55
			ignoreActors:
			init:
			stopUpd:
		)
		(rightDoor
			view: 321
			loop: 2
			cel: 0
			posn: 153 55
			ignoreActors:
			init:
			stopUpd:
		)
		(bottomDoor
			view: 321
			loop: 3
			cel: 0
			posn: 109 119
			ignoreActors:
			init:
			stopUpd:
		)
		(otto
			view: 602
			illegalBits: 0
			ignoreActors:
			init:
			setCycle: Walk
			stopUpd:
		)
		(sheriff
			view: 601
			illegalBits: 0
			ignoreActors:
			init:
			setCycle: Walk
			stopUpd:
		)
		(safeDoor
			view: 321
			loop: 0
			cel: (if (IsFlag 184) 1 else 0)
			posn: 271 106
			init:
			stopUpd:
		)
		(if (not (IsFlag 179))
			(vase
				view: 321
				loop: 5
				cel: 0
				illegalBits: 0
				ignoreActors:
				posn:
					(if (IsFlag 180) 247 else 262)
					(if (IsFlag 180) 136 else 119)
				setPri: 10
				init:
				stopUpd:
			)
		)
		(portrait
			view: 321
			loop: 4
			cel: 0
			posn: 277 (if (not (IsFlag 183)) 121 else 109)
			init:
			stopUpd:
		)
		(if (not (IsFlag 181))
			(candelabra
				view: 321
				loop: 4
				cel: 1
				posn: 172 88
				setPri: 9
				init:
				stopUpd:
			)
		)
		(chair view: 321 loop: 4 cel: 2 posn: 290 161 init: stopUpd: addToPic:)
		(if (not (IsFlag 182))
			(musicBox
				view: 321
				loop: 4
				cel: 3
				posn: 138 145
				setPri: 12
				init:
				stopUpd:
			)
		)
		(sneakMusic play:)
		(self setScript: (ScriptID 288 3)) ; rm321Script
	)

	(method (doit)
		(if (and (== (gEgo edgeHit:) 3) (not (IsFlag 193)))
			(= global110 gDay)
			(gCurRoom newRoom: 320)
		)
		(cond
			(
				(and
					(> (gEgo x:) 35)
					(< (gEgo y:) 92)
					(== (gEgo loop:) 0)
					(not local3)
					(not (IsFlag 196))
				)
				(= local3 1)
				(gEgo setScript: (ScriptID 288 1)) ; upScript
			)
			(
				(and
					local3
					(< (gEgo x:) 87)
					(< (gEgo y:) 62)
					(== (gEgo loop:) 1)
					(not (IsFlag 196))
				)
				(= local3 0)
				(gEgo setScript: (ScriptID 288 2)) ; downScript
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'search,open,(look<in)/desk,drawer')
						(cond
							((IsFlag 144)
								(localproc_0 321 1) ; "You've looked in there already."
							)
							((gEgo inRect: 167 127 196 132)
								(localproc_1)
							)
							(else
								(NotClose)
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '[<at,around][/!*,room,house]')
								(cond
									((IsFlag 95)
										(localproc_0 321 2) ; "The room is dark and still."
									)
									(
										(or
											(not (IsFlag 181))
											(not (IsFlag 179))
											(not (IsFlag 182))
										)
										(localproc_0 321 3) ; "You see items which may be interesting and probably valuable."
										(if (not (IsFlag 181))
											(localproc_0 321 4) ; "The candelabra looks like it is made of gold."
										)
										(if (not (IsFlag 179))
											(localproc_0 321 5) ; "The vase on the mantle might be worth taking."
										)
										(if (not (IsFlag 182))
											(localproc_0 321 6) ; "There is also an odd little box on the table."
										)
									)
									(else
										(localproc_0 321 2) ; "The room is dark and still."
									)
								)
							)
							((Said '[<up][/ceiling]')
								(localproc_0 321 7) ; "How anyone manages to dust a CEILING is beyond you."
							)
							((Said '[<down][/floor,carpet]')
								(localproc_0 321 8) ; "The floor is covered with expensive wall-to-wall carpeting not common in this time period."
							)
							((Said '/wall')
								(localproc_0 321 9) ; "The walls look like they've been recently painted."
							)
							((Said '/desk')
								(localproc_0 321 10) ; "Looks like solid oak."
							)
							((Said '/plant')
								(HighPrint 321 11) ; "Somebody has a green thumb."
							)
							((Said '/dust')
								(localproc_0 321 12) ; "There isn't any."
							)
							((Said '/fire,chimney,ember,chandelier')
								(localproc_0 321 13) ; "The glowing embers from the fire cast a dim light in the room."
							)
							((Said '/table')
								(if (IsFlag 182)
									(localproc_0 321 14) ; "There once was a music box on the table, but you took it."
								else
									(HighPrint 321 15) ; "There is an ornately carved box sitting atop the oak table."
								)
							)
							((Said '/mantle')
								(localproc_0 321 16) ; "The mantle is a single heavy timber."
								(if (not local4)
									(localproc_0 321 17) ; "A vase sits on the mantle."
								)
							)
							((Said '/painting,portrait')
								(if local5
									(localproc_0 321 18) ; "Over the safe is a charming portrait of the Sheriff and his wife."
								else
									(localproc_0 321 19) ; "Over the mantle is a charming portrait of the Sheriff and his wife."
								)
							)
							((Said '/vase,bottle')
								(cond
									((gEgo has: 14) ; vase
										(event claimed: 0)
									)
									((IsFlag 179)
										(HighPrint 321 20) ; "You took it. Remember?"
									)
									((< (gEgo distanceTo: vase) 50)
										(localproc_0 321 21) ; "The vase is carved from alabaster and could be worth some money, although it would take up a lot of space in your pack."
									)
									(else
										(localproc_0 321 22) ; "Get closer for a good look."
									)
								)
							)
							((Said '/box')
								(cond
									((gEgo has: 16) ; music box
										(event claimed: 0)
									)
									((IsFlag 182)
										(HighPrint 321 20) ; "You took it. Remember?"
									)
									((< (gEgo distanceTo: musicBox) 50)
										(localproc_0 321 23) ; "It is a small, beautifully decorated metal box with a hinged lid."
									)
									(else
										(localproc_0 321 22) ; "Get closer for a good look."
									)
								)
							)
							((Said '/candle,candelabra,(stick<candle)')
								(cond
									((gEgo has: 15) ; candelabra
										(event claimed: 0)
									)
									((IsFlag 181)
										(HighPrint 321 20) ; "You took it. Remember?"
									)
									((< (gEgo distanceTo: candelabra) 70)
										(localproc_0 321 24) ; "The candelabra looks like it is made of solid gold."
									)
									(else
										(localproc_0 321 22) ; "Get closer for a good look."
									)
								)
							)
							((Said '/alm,silver')
								(localproc_0 321 25) ; "Most silvers look alike, and they are all the same weight."
							)
							((Said '/safe')
								(cond
									((not local5)
										(localproc_0 321 26) ; "Safe? You don't see a safe."
									)
									((not local6)
										(localproc_0 321 27) ; "It looks very sturdy, indeed."
									)
									((> (gEgo distanceTo: safeDoor) 50)
										(localproc_0 321 28) ; "Get closer if you want to look into the safe."
									)
									((IsFlag 145)
										(localproc_0 321 29) ; "There is an empty coin bag in the safe."
									)
									(else
										(localproc_0 321 30) ; "You see a bag of coins."
									)
								)
							)
						)
					)
					((Said 'move,lift,straighten/painting,portrait')
						(cond
							(local5
								(localproc_0 321 31) ; "You have already done that."
							)
							((> (gEgo distanceTo: portrait) 45)
								(NotClose)
							)
							((not local4)
								(vase setScript: (ScriptID 288 0)) ; vaseScript
							)
							(else
								(SetFlag 183)
								(= local5 1)
								(SolvePuzzle 632 1 2)
								(self setScript: (ScriptID 288 4)) ; raisePainting
							)
						)
					)
					((Said 'lower,replace/painting,portrait')
						(cond
							(local6
								(localproc_0 321 32) ; "You'd better shut the safe, first."
							)
							((not local5)
								(localproc_0 321 33) ; "There is no need to do that."
							)
							((> (gEgo distanceTo: portrait) 50)
								(NotClose)
							)
							(else
								(= local5 0)
								(self setScript: (ScriptID 288 5)) ; lowerPainting
							)
						)
					)
					(
						(or
							(Said 'move/vase')
							(Said 'get,get/vase/mantle')
							(Said 'place,put/vase/floor')
						)
						(cond
							((gEgo has: 14) ; vase
								(localproc_0 321 34) ; "It's already in your pack."
							)
							((IsFlag 179)
								(HighPrint 321 20) ; "You took it. Remember?"
							)
							((> (gEgo distanceTo: vase) 40)
								(NotClose)
							)
							(local4
								(AlreadyDone)
							)
							(else
								(vase posn: 247 136)
								(SetFlag 180)
								(= local4 1)
								(localproc_0 321 35) ; "You take the vase carefully from the mantle and place it gently on the floor."
							)
						)
					)
					(
						(or
							(Said 'replace/vase')
							(Said 'place,put,move/vase/mantle')
						)
						(cond
							((gEgo has: 14) ; vase
								(localproc_0 321 34) ; "It's already in your pack."
							)
							((IsFlag 179)
								(HighPrint 321 20) ; "You took it. Remember?"
							)
							((> (gEgo distanceTo: vase) 40)
								(NotClose)
							)
							((not local4)
								(localproc_0 321 36) ; "The vase is on the mantle."
							)
							(else
								(vase posn: 262 119)
								(= local4 0)
								(ClearFlag 180)
								(localproc_0 321 37) ; "You place the vase back on the mantle."
							)
						)
					)
					((Said 'get>')
						(cond
							((Said '/vase,bottle')
								(cond
									((IsFlag 179)
										(AlreadyDone)
									)
									((> (gEgo distanceTo: vase) 35)
										(NotClose)
									)
									(else
										(SetFlag 179)
										(gEgo get: 14) ; vase
										(= local4 1)
										(vase posn: 0 1000 stopUpd:)
										(localproc_0 321 38) ; "You place the vase carefully in your pack beneath your cape."
										(SolvePuzzle 635 1 2)
									)
								)
							)
							((Said '/candle,candelabra,(stick<candle)')
								(cond
									((IsFlag 181)
										(AlreadyDone)
									)
									((> (gEgo distanceTo: candelabra) 55)
										(NotClose)
									)
									(else
										(SetFlag 181)
										(gEgo get: 15) ; candelabra
										(candelabra posn: 0 1000 stopUpd:)
										(localproc_0 321 39) ; "You place the candelabra carefully in your pack beneath your cape."
										(SolvePuzzle 636 1 2)
									)
								)
							)
							((Said '/box')
								(cond
									((IsFlag 182)
										(AlreadyDone)
									)
									((> (gEgo distanceTo: musicBox) 35)
										(NotClose)
									)
									(else
										(SetFlag 182)
										(gEgo get: 16) ; music box
										(musicBox posn: 0 1000 stopUpd:)
										(if (IsFlag 194)
											(miscMusic stop:)
											(localproc_0 321 40) ; "You quickly close the box and toss it into your pack."
											(ClearFlag 194)
										else
											(localproc_0 321 41) ; "You quickly toss the box into your pack."
										)
										(SolvePuzzle 637 1 2)
									)
								)
							)
							((Said '/plant')
								(if (gEgo inRect: 0 0 40 108)
									(HighPrint 321 42) ; "Even though it's a 50-year-old Sego palm, it's too big to fit in your pack."
								else
									(NotClose)
								)
							)
							((Said '/alm,silver,loot,bag')
								(cond
									((gEgo inRect: 167 127 196 132)
										(if (IsFlag 144)
											(AlreadyDone)
										else
											(localproc_1)
										)
									)
									((IsFlag 145)
										(AlreadyDone)
									)
									((not local5)
										(localproc_0 321 43) ; "Nothing like that is visible to you."
									)
									((not local6)
										(localproc_0 321 44) ; "There might be something like that inside the wall safe."
									)
									((> (gEgo distanceTo: safeDoor) 50)
										(NotClose)
									)
									(else
										(SetFlag 145)
										(gEgo get: 1 50) ; silver
										(localproc_0 321 45) ; "You take the fifty silvers, and put the empty bag back in the safe."
										(SolvePuzzle 634 1 2)
									)
								)
							)
						)
					)
					((Said 'open/safe')
						(cond
							(local6
								(localproc_0 321 46) ; "The safe is already open."
							)
							((not local5)
								(localproc_0 321 26) ; "Safe? You don't see a safe."
							)
							((> (gEgo distanceTo: safeDoor) 50)
								(NotClose)
							)
							(else
								(localproc_0 321 47) ; "The safe is securely locked."
							)
						)
					)
					((Said 'unlock,lockpick/safe,hasp')
						(cond
							((not local5)
								(localproc_0 321 48) ; "Where?"
							)
							((> (gEgo distanceTo: safeDoor) 50)
								(NotClose)
							)
							(local6
								(localproc_0 321 49) ; "What for? It's open!"
							)
							((== local1 2)
								(gEgo setScript: (ScriptID 289 0)) ; bustedScript
							)
							((TrySkill 9 0 (- global189 20)) ; pick locks
								(miscMusic number: (SoundFX 35) loop: 1 play:)
								(HighPrint 321 50) ; "Ah, got it!"
								(++ local1)
								(safeDoor setCel: 1)
								(SetFlag 184)
								(= local6 1)
								(SolvePuzzle 633 1 2)
							)
							(else
								(HighPrint 321 51) ; "Cracking safes looked a lot easier in the instruction book."
							)
						)
					)
					((Said 'close/safe')
						(cond
							((not local5)
								(localproc_0 321 26) ; "Safe? You don't see a safe."
							)
							((not local6)
								(localproc_0 321 52) ; "It's not open."
							)
							((> (gEgo distanceTo: safeDoor) 50)
								(NotClose)
							)
							(else
								(= local6 0)
								(safeDoor setCel: 0)
							)
						)
					)
					((Said 'open/door')
						(cond
							((== (gEgo onControl: 1) 16384)
								(leftDoor setScript: (ScriptID 290 1)) ; leftScript
							)
							((== (gEgo onControl: 1) 8192)
								(rightDoor setScript: (ScriptID 290 2)) ; rightScript
							)
							((== (gEgo onControl: 1) 4096)
								(bottomDoor setScript: (ScriptID 290 0)) ; bottomScript
							)
							(else
								(NotClose)
							)
						)
					)
					((Said 'lift,open/box,lid')
						(cond
							((gEgo has: 16) ; music box
								(localproc_0 321 53) ; "The little box is safely tucked away in your pack. You can open it up later."
							)
							((IsFlag 182)
								(HighPrint 321 20) ; "You took it. Remember?"
							)
							((> (gEgo distanceTo: musicBox) 35)
								(NotClose)
							)
							((IsFlag 195)
								(localproc_0 321 54) ; "Oh, no! You won't do THAT again!"
							)
							(else
								(gEgo setScript: (ScriptID 289 1)) ; faceTheMusicScript
							)
						)
					)
					((Said 'close,lower/box,lid')
						(cond
							((gEgo has: 16) ; music box
								(localproc_0 321 55) ; "The little box is safely tucked away in your pack. It is already closed."
							)
							((IsFlag 182)
								(HighPrint 321 20) ; "You took it. Remember?"
							)
							((> (gEgo distanceTo: musicBox) 35)
								(NotClose)
							)
							((IsFlag 194)
								(miscMusic stop:)
								(localproc_0 321 56) ; "You quickly shut the lid on the music box!"
								(ClearFlag 194)
								(musicBox setCel: 3)
							)
							(else
								(localproc_0 321 57) ; "It's already closed."
							)
						)
					)
					((Said 'listen[/!*,door,snore]')
						(cond
							((== (gEgo onControl: 1) 16384)
								(localproc_0 321 58) ; "There is some fairly loud snoring going on in this room. You hear: "Brckawwwww...zup-zup-zup-zup-zzzzz.""
							)
							((== (gEgo onControl: 1) 8192)
								(localproc_0 321 59) ; "Very faintly, you hear snoring: "Prrrrrt...prrrrrt...prrrrrt.""
							)
							((== (gEgo onControl: 1) 4096)
								(localproc_0 321 60) ; "Someone (or someTHING) is snoring up a storm. You hear: "Nkaawww..rspft...honk... buh-buh-buh-buh-buh-buh-phweep."
							)
							(else
								(localproc_0 321 61) ; "Faintly, you hear: "Nkaawww...prrrrrt... honk...zup-zup-zup-buh-buh-buh-phweep."
							)
						)
					)
					((Said 'odor>')
						(cond
							((Said '/sauerkraut,bratwurst,food')
								(localproc_0 321 62) ; "If you were a person who liked that sort of food, you'd love this smell!"
							)
							((Said '/smoke,birch,fire')
								(localproc_0 321 63) ; "It would be more pleasant if it wasn't mixed with the odor of sauerkraut."
							)
							((Said '/odor')
								(localproc_0 321 64) ; "What a mixture!"
							)
						)
					)
				)
			)
		)
	)
)

(instance sneakMusic of Sound
	(properties
		number 8
		loop -1
	)
)

(instance miscMusic of Sound
	(properties
		number 13
		priority 1
	)
)

(instance onDesk of RFeature
	(properties
		nsTop 89
		nsLeft 160
		nsBottom 124
		nsRight 193
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onDesk event 3)
				(localproc_0 321 10) ; "Looks like solid oak."
			)
		)
	)
)

(instance onCandles of RFeature
	(properties
		nsTop 75
		nsLeft 166
		nsBottom 88
		nsRight 179
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onCandles event 3)
				(cond
					((gEgo has: 15) ; candelabra
						(event claimed: 0)
					)
					((IsFlag 181)
						(event claimed: 0)
					)
					((< (gEgo distanceTo: candelabra) 70)
						(localproc_0 321 24) ; "The candelabra looks like it is made of solid gold."
					)
					(else
						(localproc_0 321 22) ; "Get closer for a good look."
					)
				)
			)
		)
	)
)

(instance onVase of RFeature
	(properties
		nsTop 107
		nsLeft 258
		nsBottom 119
		nsRight 267
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onVase event 3)
				(cond
					((gEgo has: 14) ; vase
						(event claimed: 0)
					)
					((IsFlag 179)
						(event claimed: 0)
					)
					((< (gEgo distanceTo: vase) 50)
						(localproc_0 321 21) ; "The vase is carved from alabaster and could be worth some money, although it would take up a lot of space in your pack."
					)
					(else
						(localproc_0 321 22) ; "Get closer for a good look."
					)
				)
			)
		)
	)
)

(instance onMusicBox of RFeature
	(properties
		nsTop 139
		nsLeft 134
		nsBottom 145
		nsRight 141
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onMusicBox event 3)
				(cond
					((gEgo has: 16) ; music box
						(event claimed: 0)
					)
					((IsFlag 182)
						(event claimed: 0)
					)
					((< (gEgo distanceTo: musicBox) 50)
						(localproc_0 321 23) ; "It is a small, beautifully decorated metal box with a hinged lid."
					)
					(else
						(localproc_0 321 22) ; "Get closer for a good look."
					)
				)
			)
		)
	)
)

(instance onFireplace of RFeature
	(properties
		nsTop 119
		nsLeft 254
		nsBottom 155
		nsRight 279
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onFireplace event 3)
				(localproc_0 321 13) ; "The glowing embers from the fire cast a dim light in the room."
			)
		)
	)
)

(instance onPaintingDown of RFeature
	(properties
		nsTop 91
		nsLeft 267
		nsBottom 120
		nsRight 287
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onPaintingDown event 3)
				(if local5
					(event claimed: 0)
				else
					(localproc_0 321 19) ; "Over the mantle is a charming portrait of the Sheriff and his wife."
				)
			)
		)
	)
)

(instance onPaintingUp of RFeature
	(properties
		nsTop 77
		nsLeft 262
		nsBottom 108
		nsRight 287
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onPaintingUp event 3)
				(if local5
					(localproc_0 321 18) ; "Over the safe is a charming portrait of the Sheriff and his wife."
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance onSafe of RFeature
	(properties
		nsTop 106
		nsLeft 270
		nsBottom 117
		nsRight 281
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onSafe event 3)
				(cond
					((not local5)
						(event claimed: 0)
					)
					((not local6)
						(localproc_0 321 27) ; "It looks very sturdy, indeed."
					)
					((> (gEgo distanceTo: safeDoor) 50)
						(localproc_0 321 28) ; "Get closer if you want to look into the safe."
					)
					((IsFlag 145)
						(localproc_0 321 29) ; "There is an empty coin bag in the safe."
					)
					(else
						(localproc_0 321 30) ; "You see a bag of coins."
					)
				)
			)
		)
	)
)

(instance onPlant of RFeature
	(properties
		nsTop 32
		nsBottom 83
		nsRight 10
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onPlant event 3)
				(HighPrint 321 65) ; "It's a potted plant."
			)
		)
	)
)

(instance onLeftDoor of RFeature
	(properties
		nsTop 6
		nsLeft 105
		nsBottom 54
		nsRight 130
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onLeftDoor event 3)
				(localproc_0 321 58) ; "There is some fairly loud snoring going on in this room. You hear: "Brckawwwww...zup-zup-zup-zup-zzzzz.""
			)
		)
	)
)

(instance onRightDoor of RFeature
	(properties
		nsTop 6
		nsLeft 150
		nsBottom 54
		nsRight 175
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onRightDoor event 3)
				(localproc_0 321 59) ; "Very faintly, you hear snoring: "Prrrrrt...prrrrrt...prrrrrt.""
			)
		)
	)
)

(instance onBottomDoor of RFeature
	(properties
		nsTop 69
		nsLeft 108
		nsBottom 118
		nsRight 142
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onBottomDoor event 3)
				(localproc_0 321 61) ; "Faintly, you hear: "Nkaawww...prrrrrt... honk...zup-zup-zup-buh-buh-buh-phweep."
			)
		)
	)
)

(instance onChair of RFeature
	(properties
		nsTop 133
		nsLeft 285
		nsBottom 160
		nsRight 297
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onChair event 3)
				(HighPrint 321 66) ; "An uncomfortable looking chair."
			)
		)
	)
)

(instance onCouch of RFeature
	(properties
		nsTop 131
		nsLeft 96
		nsBottom 160
		nsRight 122
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onCouch event 3)
				(HighPrint 321 67) ; "An overstuffed couch."
			)
		)
	)
)

(instance onTable of RFeature
	(properties
		nsTop 138
		nsLeft 125
		nsBottom 152
		nsRight 151
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onMusicBox event 3)
				(cond
					((gEgo has: 16) ; music box
						(HighPrint 321 68) ; "A solid looking table."
					)
					((IsFlag 182)
						(HighPrint 321 68) ; "A solid looking table."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((MouseClaimed onTable event 3)
				(HighPrint 321 68) ; "A solid looking table."
			)
		)
	)
)

(instance onStuffedChair of RFeature
	(properties
		nsTop 98
		nsLeft 210
		nsBottom 124
		nsRight 236
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onStuffedChair event 3)
				(HighPrint 321 69) ; "An overstuffed chair."
			)
		)
	)
)

