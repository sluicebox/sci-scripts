;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use Gaza)
(use eRoom)
(use Interface)
(use Motion)
(use User)
(use Actor)

(public
	Rm44 0
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
)

(procedure (localproc_0)
	(if (or global169 (not (IsFlag 115)))
		(Print 44 0) ; "The water looks and smells most inviting. I am surprised your mule has not drunk from it yet."
	else
		(Print 44 1) ; "It is a naturally formed pool, fed by a small stream flowing down a wadi to the east."
	)
)

(instance rock1Reflection of Prop
	(properties
		y 169
		x 140
		view 144
		cycleSpeed 3
	)
)

(instance rock2Reflection of Prop
	(properties
		y 116
		x 263
		view 144
		loop 1
		cycleSpeed 3
	)
)

(instance Rm44 of eRoom
	(properties
		picture 44
	)

	(method (init)
		(self
			style:
				(switch global103
					(0 100)
					(1 15)
					(2 17)
				)
		)
		(Load rsVIEW 41)
		(Load rsVIEW 42)
		(Load rsVIEW 80)
		(if (IsFlag 20)
			(Load rsVIEW 424)
		)
		(Load rsSCRIPT 175)
		(Load rsSCRIPT 179)
		(Load rsSCRIPT 180)
		(Load rsSCRIPT 178)
		(Load rsSCRIPT 185)
		(Load rsSCRIPT 105)
		(super init:)
		(self setRegions: 107) ; Gaza
		(proc0_13 65)
		(gAddToPics doit:)
		(rock1Reflection setPri: 0 init: ignoreActors: 1 setCycle: Fwd)
		(rock2Reflection setPri: 0 init: ignoreActors: 1 setCycle: Fwd)
		(gEgo init:)
		(switch gPrevRoomNum
			(39
				(self enterRoom: 70 -5 70 60)
				(if (IsFlag 20)
					(self muleEnterRoom: 40 -5 40 50)
				)
			)
			(45
				(if (and (not (IsFlag 115)) (< global189 9))
					(self enterRoom: 180 20 130 42)
					(if (IsFlag 20)
						(self muleEnterRoom: 145 30 100 45 1)
					)
				else
					(self enterRoom: 320 39 285 39)
					(if (IsFlag 20)
						(self muleEnterRoom: 320 30 280 30)
					)
				)
			)
			(else
				(self enterRoom: -10 80 50 80)
				(if (IsFlag 20)
					(self muleEnterRoom: -5 70 45 70)
				)
			)
		)
		(if
			(or
				(and (== global189 0) (not (IsFlag 115)))
				(== global189 5)
				(== global189 7)
			)
			(if global124
				(= local0 4)
			)
			((ScriptID 130 0) ; Jabir
				view: 392
				illegalBits: 0
				posn: 174 80
				setLoop: 0
				init:
				cycleSpeed: 1
				setCycle: End
			)
			((ScriptID 130 1) ; jabirHead
				ignoreActors: 1
				posn: 174 80
				setLoop: 9
				cel: 0
				setCycle: End
			)
			((ScriptID 130 2) brTop: 110 brLeft: 160 brBottom: 170 brRight: 290) ; jabirWindow
		else
			(= local0 3)
		)
		(if (IsFlag 20)
			(if (and (not (IsFlag 115)) (< global189 9))
				(gMuleObj illegalBits: 0)
			else
				(gMuleObj illegalBits: $bfff)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (IsFlag 121)
			(ClearFlag 121)
			(gEgo setScript: (ScriptID 175 1)) ; poisoned
		)
		(if (IsFlag 123)
			(ClearFlag 123)
			((ScriptID 130 0) setScript: (ScriptID 180 0)) ; Jabir, killKing
		)
		(cond
			((> local1 1)
				(-- local1)
			)
			((== local1 1)
				(= local1 0)
				(= local9 1)
			)
			(
				(and
					(< local0 3)
					local9
					(not ((ScriptID 130 0) script:)) ; Jabir
					(not (gEgo script:))
					(not gModelessDialog)
				)
				(= local1 300)
				(++ local2)
				((ScriptID 130 0) setScript: (ScriptID 105 0)) ; Jabir, goAhead
			)
		)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(if
				(and
					global169
					(not local4)
					(not local7)
					(>= local2 3)
					(>= (gEgo distanceTo: (ScriptID 130 0)) 110) ; Jabir
					(< (gEgo x:) 120)
					(or (== (gEgo loop:) 1) (== (gEgo loop:) 3))
					(not ((ScriptID 130 0) script:)) ; Jabir
				)
				(= local7 1)
				(gEgo setMotion: 0)
				(= local0 3)
				(User canControl: 0)
				((ScriptID 130 0) setScript: (ScriptID 105 1)) ; Jabir, pullKnife
			)
			(cond
				((and global169 (== local0 4))
					(= global189 8)
					(= local0 3)
					(SetFlag 126)
					(SetFlag 115)
					((ScriptID 130 0) setScript: (ScriptID 114 0)) ; Jabir, run
				)
				((and global169 (< local0 1))
					(= local0 1)
					((ScriptID 130 0) setScript: (ScriptID 178 0)) ; Jabir, hereItIs
					(= local1 400)
					(if (and (not (IsFlag 115)) (< global189 9))
						(HandsOff)
						(gEgo setScript: (ScriptID 178 1)) ; egoWalk
					)
				)
				((and (not (IsFlag 90)) (IsFlag 20))
					(SetFlag 90)
					(gMuleObj setScript: (ScriptID 178 2)) ; IAintDrinkinTHAT
				)
				((> (gEgo x:) 310)
					(if (IsFlag 20)
						(gMuleObj illegalBits: $8000)
					)
					(if global169
						(= global189 9)
						(SetFlag 115)
					)
					(self leaveRoom: 45 320 (gEgo y:))
				)
				((< (gEgo x:) 10)
					(if (IsFlag 20)
						(gMuleObj illegalBits: $8000)
					)
					(if global169
						(= global189 9)
						(SetFlag 115)
					)
					(self leaveRoom: 42 -10 (gEgo y:))
				)
				((and (< (gEgo y:) 20) (== (gEgo loop:) 3))
					(if (IsFlag 20)
						(gMuleObj illegalBits: $8000)
					)
					(if global169
						(= global189 9)
						(SetFlag 115)
					)
					(self leaveRoom: 39 (gEgo x:) -5)
				)
				(
					(and
						local5
						(== (gEgo onControl: 1) 2)
						(not local4)
						(not (gEgo script:))
					)
					(= local4 1)
					(if global124
						(= global125 2)
						(= local8 1)
					else
						(gEgo setScript: (ScriptID 185 0)) ; walkIn
					)
				)
				((and (not global124) local8)
					(= local8 0)
					(gEgo setScript: (ScriptID 185 0)) ; walkIn
				)
				((and local5 local4 (== (gEgo onControl: 1) 4))
					(= local4 0)
					(if (IsFlag 120)
						((ScriptID 179 0) ; drinkWet
							setScript: (ScriptID 185 1) (ScriptID 179 0) ; stepOut, drinkWet
						)
					else
						(gEgo setScript: (ScriptID 185 1)) ; stepOut
					)
				)
				((and (== (gEgo onControl: 1) 1) (not local5))
					(= local5 1)
				)
				((and (!= (gEgo onControl: 1) 1) local5)
					(= local5 0)
				)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(and
					global169
					(or
						(Said 'ask,tell,get,give/hamid/drink')
						(Said 'drink<first<to<hamid<ask,tell,get')
						(Said 'force,make/drink<hamid')
						(Said 'after/you')
						(Said 'after/hamid<you')
						(Said '<you/first')
						(Said 'drink<hamid<have')
					)
				)
				(Talk 44 2) ; "Worry not about me, habib. But please, you need water. I beg you to have a drink."
			)
			((or (Said '(go<dive),dive,bathe') (Said 'get/avebury'))
				(Print 44 3) ; "This is neither the time nor place."
			)
			((or (Said 'drink[/water]') (Said 'get/water'))
				(cond
					(local4
						(gEgo setScript: (ScriptID 179 0)) ; drinkWet
					)
					((and (< (gEgo y:) 79) (> (gEgo x:) 160))
						(NotClose) ; "Perhaps you should move closer."
					)
					((and (< (gEgo y:) (+ global175 2)) (== global177 44))
						(Print 44 4) ; "You certainly could use a drink. And the closest water is that pool."
					)
					(else
						(gEgo setScript: (ScriptID 175 0)) ; drinkDry
					)
				)
			)
			((Said 'get/body,camel,skeleton,bone,skull')
				(Print 44 5) ; "Nonsense. You can barely carry what you have in this heat."
			)
			((Said 'get,eat,pick/plant,bush')
				(Print 44 6) ; "Nay, I do not advise it. They are unknown and could be dangerous."
			)
			((Said 'look<below/body,camel,skeleton,bone,skull')
				(Print 44 7) ; "There is nothing but sand."
			)
			((Said 'talk/hamid')
				(if global169
					(Talk 44 8) ; "You sound parched. Wet your throat and ease your burning thirst. Please, drink your fill."
				else
					(event claimed: 0)
				)
			)
			(
				(and
					global169
					(or
						(Said 'look[<at,around][/!*][/!*]')
						(Said 'look/room[/!*]')
						(Said 'look<around')
					)
				)
				(Talk 44 9) ; "As you see, there is water in this wadi. Drink your fill."
			)
			((and global169 (or (Said 'talk,ask[/hamid]>') (Said 'tell[/me]>')))
				(cond
					(
						(or
							(Said '/water,spring,pool,spring,lake,wadi,oasis')
							(Said '//water,spring,pool,spring,lake,wadi,oasis')
						)
						(Talk 44 10) ; "It is a perfectly good pool. Drink your fill."
					)
					((or (Said '/ass') (Said '//ass'))
						(if (IsFlag 20)
							(Talk 44 11) ; "Your mule is a stupid animal. It does not even have the sense to drink when there is water."
						else
							(Talk 44 12) ; "you have no mule, habib, and neither do I."
						)
					)
					(
						(or
							(Said '/body,camel,skeleton,bone,skull')
							(Said '//body,camel,skeleton,bone,skull')
						)
						(Talk 44 13) ; "Eh? It is nothing. A camel I once owned, that is all."
					)
					(
						(or
							(Said '/reflection,ripple')
							(Said '//reflection,ripple')
						)
						(Talk 44 14) ; "See how beautifully the pool reflects all around it. Surely you will wait no longer to drink from it."
					)
					(else
						(Talk 44 15) ; "In this heat, you must waste no breath upon idle chatter."
						(event claimed: 1)
					)
				)
			)
			(
				(or
					(Said 'ask[/merlin][/advice]')
					(Said 'ask/advice[<merlin][/!*]')
					(Said 'talk/merlin[/!*]')
				)
				(if global169
					(Print 44 16) ; "Jabir is very eager for you to drink, yet insists you drink first. What do your own instincts tell you?"
				else
					(if (IsFlag 20)
						(Print 44 17) ; "Perhaps your mule is merely too stupefied to drink. Perhaps the camel died of old age or injury."
					else
						(Print 44 18) ; "Perhaps the camel died of old age or injury."
					)
					(if (IsFlag 117)
						(Print 44 19) ; "You have a choice between this naturally formed pool and the other pool nearby. Your own instincts must guide you."
					else
						(Print 44 20) ; "You need water, but you must rely upon your own instincts to make a decision."
					)
				)
			)
			((Said 'smell/water')
				(localproc_0)
			)
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((and global169 (Said 'draw/blade'))
				(if local4
					(Print 44 21) ; "If you wish to use your sword, Arthur, stand on dry land."
				)
				(if (and (not local7) (not local4))
					(SetFlag 115)
					((ScriptID 130 0) setScript: (ScriptID 114 0)) ; Jabir, run
					(= global189 9)
					(= local0 3)
				)
				(event claimed: 0)
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
						)
						(Print 44 22) ; "There is a natural pool of water, surrounded by cliffs and flowing down through a ravine. Some plants grow here."
						(Print 44 23) ; "There is also a camel's skeleton."
					)
					(
						(or
							(Said '/mesa,cliff,desert,terrain')
							(Said '//mesa,cliff,desert,terrain')
						)
						(Print 44 24) ; "Cliffs hide this wadi quite well, and the water flows down from a deep cleft in the ground."
					)
					(
						(or
							(Said '/water,spring,pool,spring,lake,wadi,oasis')
							(Said '//water,spring,pool,spring,lake,wadi,oasis')
						)
						(localproc_0)
					)
					(
						(or
							(Said '/plant,bush')
							(Said '//plant,bush')
							(OnButton event 176 104 192 114)
							(OnButton event 207 75 241 88)
							(OnButton event 251 66 265 84)
							(OnButton event 266 73 293 84)
						)
						(Print 44 25) ; "They are strange plants. I cannot identify them. Nor do I like the look of them. They have an odd colour."
					)
					(
						(or
							(Said '/reflection,ripple')
							(Said '//reflection,ripple')
							(MouseClaimed rock1Reflection event)
							(MouseClaimed rock2Reflection event)
						)
						(Print 44 26) ; "The reflections are almost entrancing."
					)
					(
						(and
							(IsFlag 20)
							(or
								(Said '/ass')
								(Said '//ass')
								(MouseClaimed gMuleObj event)
							)
						)
						(Print 44 27) ; "Aye, 'tis odd that your mule shows no desire for this water when she is clearly quite thirsty."
					)
					(
						(or
							(Said '/boulder')
							(Said '//boulder')
							(OnButton event 3 71 47 189)
							(OnButton event 47 96 66 189)
							(OnButton event 66 158 80 189)
							(OnButton event 127 132 151 146)
							(OnButton event 172 78 211 94)
							(OnButton event 173 96 199 110)
							(OnButton event 222 24 310 74)
							(OnButton event 142 177 184 189)
							(OnButton event 184 161 198 189)
							(OnButton event 199 139 241 189)
							(OnButton event 242 124 255 189)
							(OnButton event 255 119 268 189)
							(OnButton event 268 112 294 181)
							(OnButton event 294 107 304 189)
							(OnButton event 306 93 310 189)
							(OnButton event 86 74 100 79)
						)
						(proc107_2)
					)
					((or (Said '/body') (Said '//body'))
						(if (!= global177 gCurRoomNum)
							(SetScore 291 1 1)
							(Print 44 28) ; "The skeleton could be nothing else save a camel. It must have died here some time ago."
						else
							(Print 44 29) ; "There are fleas and lice, drying blood and a ripe smell. There is nothing of any worth."
						)
					)
					(
						(or
							(Said '/camel,skeleton,bone,skull')
							(Said '//camel,skeleton,bone,skull')
							(OnButton event 122 29 167 74)
							(OnButton event 167 18 193 48)
						)
						(SetScore 291 1 1)
						(Print 44 28) ; "The skeleton could be nothing else save a camel. It must have died here some time ago."
					)
				)
			)
		)
	)
)

