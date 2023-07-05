;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use n117)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Rm14 0
)

(local
	local0
)

(instance blackWindow of SysWindow
	(properties
		color 12
		back 0
		title {The Black Knight}
		brTop 10
		brLeft 150
		brBottom 120
		brRight 270
	)
)

(instance blackKnight of Act
	(properties
		y 109
		x 282
		view 300
	)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= local0 1))
				(return)
			)
			((Said 'joust')
				(DoJoust changeState: 10)
			)
			((Said 'escape')
				(Talk 14 0) ; "There is no escape, unless I allow you to pass. But the price of safe passage is high indeed."
			)
			((Said 'greet')
				(Talk 14 1) ; "Waste no time with empty words of politeness."
			)
			((Said 'get/shield,charger,crest,crest')
				(Print 14 2) ; "That is not within your power."
			)
			((Said 'get/lance,weapon')
				(Print 14 3) ; "You cannot joust with a sword. If you accept the joust, he must perforce provide you with a jousting lance."
			)
			((Said 'get/spear')
				(Print 14 4) ; "By this, I assume you mean a jousting lance."
			)
			((or (Said 'talk/merlin') (Said 'ask/merlin/(knight<black),joust'))
				(Print 14 5) ; "Were I with you in person, I could overcome this spell, but this is your mission and you alone must make the choices and seek the path to the Grail."
			)
			((or (Said 'pay') (Said 'give,count/coin,copper,dirham,dinar'))
				(if (not (DoPurse))
					0
				else
					(Talk 14 6) ; "I have no use for money."
					(proc0_18)
				)
			)
			((Said 'give/moneybag')
				(Talk 14 6) ; "I have no use for money."
			)
			((Said 'give/rose,sleeve,lodestone,charger')
				(Talk 14 7) ; "I have no use for it."
			)
			((Said 'fuck,fuck')
				(Talk 14 8) ; "For that insult, I shall take special pleasure in slaying you."
			)
			((Said 'talk[/knight,man]')
				(Talk 14 9) ; "I will give you my ultimatum soon enough."
			)
			((or (Said 'ask[/knight,man]/*>') (Said 'are<where/*>'))
				(cond
					((or (Said '/grail') (Said '//grail'))
						(Talk 14 10) ; "Not even I know where the Grail is hidden."
					)
					((or (Said '/gawain') (Said '//gawain'))
						(Talk 14 11) ; "He is my prisoner."
					)
					((or (Said '/lancelot') (Said '//lancelot'))
						(Talk 14 12) ; "I know nothing about this knight."
					)
					((or (Said '/blackbird') (Said '//blackbird'))
						(Talk 14 13) ; "My crow warned you. You should have heeded the warning."
					)
					((or (Said '/name') (Said '//name'))
						(Talk 14 14) ; "I am the Black Knight, fool."
					)
					((or (Said '/joust') (Said '//joust'))
						(Talk 14 15) ; "I have no equal in jousting. You shall surely die."
					)
					(else
						(event claimed: 1)
						(Print 14 16) ; "The black knight does not respond."
					)
				)
			)
			((Said 'kiss')
				(Talk 14 17) ; "You disgust me."
			)
		)
	)
)

(instance blackLance of Act
	(properties
		y 80
		x 285
		view 300
		loop 1
	)
)

(instance egoLance of Act
	(properties
		y 117
		x 47
		view 18
		loop 1
	)
)

(instance Rm14 of Rm
	(properties
		picture 14
	)

	(method (init)
		(super init:)
		(if (== gPrevRoomNum 110) ; theJoust
			(= global116 1)
		)
		(self setRegions: 102) ; forestPerilous
		(= local0 (if (IsFlag 28) 0 else 1))
		(gTObj tWindow: blackWindow actor: 0 init:)
		(switch gPrevRoomNum
			(15
				(gEgo posn: 310 110 loop: 1 setMotion: MoveTo 290 110)
				(if (IsFlag 20)
					(gMuleObj posn: 310 120 loop: 1 setMotion: MoveTo 290 120)
				)
			)
			(110 ; theJoust
				(gEgo view: 9 loop: 0 posn: 150 120)
			)
			(else
				(gEgo posn: 10 120 loop: 0)
				(if (IsFlag 20)
					(gMuleObj posn: 10 130 loop: 0 setMotion: MoveTo 40 130)
				)
			)
		)
		(gEgo init:)
		(if (== local0 1)
			(Load rsVIEW 300)
			(Load rsVIEW 307)
			(gCurRoom setScript: DoJoust)
		)
		(proc0_13 32)
		(gAddToPics doit:)
		(if (== gPrevRoomNum 110) ; theJoust
			(RedrawCast)
			(Print 14 18) ; "Praise all the powers that be! You are victorious, my king."
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((< (gEgo x:) 10)
				(gCurRoom newRoom: 13)
			)
			((> (gEgo x:) 310)
				(gCurRoom newRoom: 15)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (& (event modifiers:) emSHIFT)
					(cond
						(
							(and
								(gCast contains: blackKnight)
								(MouseClaimed blackKnight event)
							)
							(Print 14 19) ; "This is no natural foe. Nothing can be seen inside his dark, bat-winged helm and his voice is like an echo from the grave."
						)
						((OnButton event 25 94 284 117)
							(Print 14 20) ; "The Black Knight has caused a hedge to grow into a natural jousting lane divider."
						)
						((OnButton event 118 40 173 85)
							(Print 14 21) ; "'Tis a tree."
						)
						(
							(or
								(OnButton event 258 49 272 54)
								(OnButton event 266 54 273 74)
								(OnButton event 197 57 252 75)
								(OnButton event 196 54 207 63)
								(OnButton event 295 58 310 79)
								(OnButton event 69 40 105 76)
								(OnButton event 105 72 120 73)
								(OnButton event 133 53 144 72)
								(OnButton event 246 129 310 183)
							)
							(Print 14 22) ; "'Tis a rock."
						)
						(
							(or
								(OnButton event 25 7 292 21)
								(OnButton event 8 20 311 79)
							)
							(Print 14 21) ; "'Tis a tree."
						)
						(
							(or
								(OnButton event 219 148 250 173)
								(OnButton event 187 46 219 172)
								(OnButton event 156 156 187 182)
								(OnButton event 127 166 156 182)
							)
							(Print 14 23) ; "'Tis a bush."
						)
					)
				)
			)
			(evSAID
				(cond
					((== local0 2) 0)
					(
						(and
							(== local0 0)
							(or
								(Said '/knight[<black]')
								(Said '//knight[<black]')
							)
						)
						(Print 14 24) ; "The Black Knight is gone."
					)
					(
						(or
							(Said 'talk/merlin')
							(Said 'ask/advice')
							(Said 'ask[/merlin]/advice')
						)
						(cond
							((and (== local0 0) (not (> global200 2)))
								(Print 14 25) ; "Hurry on, Arthur! Gawaine must be close by!"
							)
							((== local0 0)
								(Print 14 26) ; "What advice can I give a fool?"
							)
							(else
								(Print 14 27) ; "You must joust the Black Knight if you would save Gawaine."
							)
						)
					)
					(
						(or
							(== (event type:) evMOUSEBUTTON)
							(Said 'look,(are<where)>')
							(Said 'ask[/merlin]/*>')
						)
						(cond
							(
								(or
									(Said 'look[<around][/room,forest]')
									(Said '//room,forest')
								)
								(cond
									((== local0 1)
										(Print 14 28) ; "Your foe awaits you at the other end of this jousting hedge."
									)
									((IsFlag 27)
										(Print 14 29) ; "The Black Knight's body has vanished, as is to be expected with such a supernatural being."
									)
									(else
										(Print 14 30) ; "Only the jousting hedge remains as proof that the Black Knight was ever here."
									)
								)
							)
							(
								(or
									(Said '/knight,man,body')
									(Said '//knight,man,body')
								)
								(if (== local0 1)
									(Print 14 19) ; "This is no natural foe. Nothing can be seen inside his dark, bat-winged helm and his voice is like an echo from the grave."
								else
									(Print 14 31) ; "You have seen the last of him."
								)
							)
							(
								(or
									(Said
										'/shield,design,badge,seal,brand[/knight]'
									)
									(Said '//shield,design,badge,seal,brand')
								)
								(if (== local0 1)
									(Print 14 32) ; "He bears no special device."
								else
									(Print 14 33) ; "I see nothing here but forest and hedge."
								)
							)
							(
								(or
									(Said '/crest,crest,head')
									(Said '//crest,crest,head')
								)
								(if (== local0 1)
									(Print 14 34) ; "His helmet is adorned with two bat-like wings."
								else
									(Print 14 33) ; "I see nothing here but forest and hedge."
								)
							)
							((Said '<below/divider,bush,bush,wall')
								(Print 14 35) ; "There is nothing to be seen there."
							)
							(
								(or
									(Said '<above/divider,bush,bush,wall')
									(Said '/side<other')
								)
								(if (== local0 1)
									(Print 14 36) ; "The jousting lane on the other side is exactly the same. The Black Knight has not taken any unfair advantage."
								else
									(Print 14 37) ; "It is the same as this side."
								)
							)
							(
								(or
									(Said '/divider,bush,bush,wall')
									(Said '//divider,bush,bush,wall')
								)
								(Print 14 20) ; "The Black Knight has caused a hedge to grow into a natural jousting lane divider."
							)
						)
					)
					((Said 'joust')
						(Print 14 38) ; "It takes two to joust."
					)
					((Said 'escape')
						(if (IsFlag 34)
							(Print 14 39) ; "You will pass unmolested, thanks to your cowardice. I do not know how you can bear the shame of it."
						else
							(Print 14 40) ; "The Black Knight is vanquished. There is no need to escape."
						)
					)
					((Said 'get/shield,charger,crest,crest')
						(Print 14 41) ; "The Black Knight is gone and left nothing behind."
					)
					((Said 'get/lance,weapon,spear')
						(Print 14 42) ; "You will not find one here."
					)
					((Said 'help/gawain')
						(cond
							((== local0 1)
								(Print 14 43) ; "That you can only do if you defeat the Black Knight."
							)
							((not (IsFlag 35))
								(Print 14 44) ; "You have a chance now to save Gawaine. Do not delay!"
							)
							(else
								(Print 14 45) ; "You have done all you could. His fate is no longer in your hands, but that of Camelot is. Seek the Grail."
							)
						)
					)
					((Said 'kill,attack,attack,cut')
						(cond
							((== local0 1)
								(Talk 14 46) ; "You can try, King Arthur, as others have died trying."
							)
							((IsFlag 27)
								(Print 14 47) ; "You have already won your victory."
							)
							(else
								(Print 14 48) ; "Too late for a show of bravado now. The evil deed is done."
							)
						)
					)
					((and (!= local0 0) (Said 'draw/blade'))
						(Print 14 49) ; "Your sword is of no use here. The Black Knight has set the terms of combat as a joust."
						(= global125 2)
					)
				)
			)
		)
	)
)

(instance DoJoust of Script
	(properties)

	(method (init)
		(HandsOff)
		(super init:)
		(blackKnight init:)
		(blackLance init:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 35 120 self)
			)
			(1
				(gRmMusic number: 34 loop: -1 play:)
				(gGame setCursor: gNormalCursor (HaveMouse))
				(gTObj talkCue: self)
				(Talk 14 50) ; "Hold, King Arthur. Do not seek to move. Not even Merlin can free you from my power in this place."
			)
			(2
				(= local0 2)
				(HandsOff)
				(gTObj talkCue: self)
				(Talk 14 51 14 52 14 53) ; "Here are your choices."
			)
			(3
				(gTObj talkCue: self)
				(Talk 14 54 14 55) ; "But if you joust with me, you will surely die. Therefore I give you one other choice: I will let you pass untouched.....but I will take Gawaine's life in exchange."
			)
			(4
				(gGame setCursor: gNormalCursor (HaveMouse))
				(User canInput: 1)
				(= seconds 15)
			)
			(5
				(Talk 14 56) ; "Will you joust with me? Answer aye or nay."
				(self changeState: 4)
			)
			(6
				(HandsOff)
				(= local0 1)
				(= cycles (= seconds 0))
				(gTObj talkCue: self)
				(Talk 14 57) ; "You are a weakling and a coward. Gawaine's life is mine and you are free to go."
			)
			(7
				(blackLance dispose:)
				(blackKnight view: 307 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(8
				(blackKnight
					setLoop: 1
					setCel: 0
					posn: (+ (blackKnight x:) 7) (blackKnight y:)
					setCycle: Fwd
					setMotion: MoveTo 330 (blackKnight y:) self
				)
			)
			(9
				(SetFlag 28)
				(SetFlag 34)
				(= global200 4)
				(= local0 0)
				(blackKnight dispose:)
				(SetScore 0 2 -50)
				(HandsOn)
			)
			(10
				(= local0 1)
				(= seconds 0)
				(egoLance init:)
				(= cycles 8)
			)
			(11
				(gEgo setLoop: 0 setMotion: MoveTo 40 120 self)
			)
			(12
				(egoLance dispose:)
				(gEgo view: 18 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(13
				(blackLance cycleSpeed: 2 setCycle: End)
				(= seconds 3)
			)
			(14
				(HandsOff)
				(gCurRoom newRoom: 110) ; theJoust
			)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(User canInput:)
					(not (User controls:))
					(or
						(== (event type:) $0040) ; direction
						(and (== (event type:) evMOUSEBUTTON) (== (event modifiers:) $0000))
					)
				)
				(event claimed: 1)
				(if global132
					(proc0_18)
				)
				(if (>= 4 state 2)
					(Talk 14 58) ; "Will you joust with me? Answer aye or nay. You have no other choices."
				else
					(Print 14 59) ; "You are held fast by the power of the Black Knight."
				)
			)
			((or (event claimed:) (!= (event type:) evSAID) (not (>= 4 state 2)))
				(return)
			)
			((or (Said 'yes,accept,joust') (Said '/me/will,accept'))
				(Talk 14 60) ; "You are a worthy opponent. Take up your lance and let the joust begin!"
				(HandsOff)
				(SetScore 0 2 5)
				(self changeState: 10)
			)
			((or (Said 'no,refuse') (Said '/me/(will<not)'))
				(self changeState: 6)
			)
			(else
				(event claimed: 1)
				(Talk 14 58) ; "Will you joust with me? Answer aye or nay. You have no other choices."
			)
		)
	)
)

