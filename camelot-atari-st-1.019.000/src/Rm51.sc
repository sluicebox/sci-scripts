;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use n117)
(use eRoom)
(use Interface)
(use Follow)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	Rm51 0
	mercenary 1
	whiteThug 2
	blueThug 3
	magentaThug 4
)

(synonyms
	(thug arab)
	(man gatekeeper saracen guard mercenary)
	(coin bribe dinar dirham copper)
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
	(cond
		((and (IsFlag 79) (< local3 25))
			(gEgo setMotion: MoveTo 220 170)
			(Talk 51 0) ; "A fool and his money are soon parted. Heh, heh, heh!"
		)
		((<= 1 local3 3)
			(Talk 51 1) ; "This is not enough. All my men must be paid as well."
			(return)
		)
		((<= 4 local3 24)
			(SetScore 292 1 1)
			(gTObj noWidth: 1)
			(Talk 51 2) ; "You may pass, infidel."
			(mercenary setScript: standAside)
		)
		((>= local3 25)
			(gTObj noWidth: 1)
			(Talk 51 3) ; "A rich man!!"
			(if (IsFlag 96)
				(mercenary setScript: pauseBeforeKill)
			else
				(mercenary setScript: pauseBeforeGangup)
			)
		)
	)
)

(instance thugWindow of SysWindow
	(properties
		color 15
		back 5
		title {Mercenary}
		brLeft 50
		brBottom 100
		brRight 250
	)
)

(instance magentaThug of Act
	(properties
		y 144
		x 196
		view 344
		loop 2
		illegalBits 0
	)
)

(instance blueThug of Act
	(properties
		y 146
		x 291
		view 344
		loop 2
		cel 2
		illegalBits 0
	)
)

(instance whiteThug of Act
	(properties
		y 143
		x 233
		view 344
		loop 2
		cel 1
		illegalBits 0
	)
)

(instance mercenary of Act
	(properties
		y 156
		x 266
		view 344
		illegalBits 0
	)

	(method (doit)
		(cond
			((and (== (gEgo onControl: 1) 4096) global124 (not script))
				(= global124 0)
				(Talk 51 4) ; "Now we shall see how well an infidel dies."
				(if (IsFlag 96)
					(self setScript: pauseBeforeKill)
				else
					(= local5 3)
					(self setScript: gangUp)
				)
			)
			(
				(and
					(== (gEgo onControl: 1) 4096)
					(not (and (< gPrevRoomNum 52) (> (gEgo x:) 170)))
					(not local2)
					(not local2)
					(not local1)
				)
				(= local2 1)
				(gEgo setMotion: 0)
				(if local0
					(gMuleObj setMotion: Follow gEgo 500)
				)
				(Talk 51 5) ; "Leaving, heathen? Good. We do not like infidels."
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'draw/blade')
				(if (not (== (gEgo onControl: 1) 4096))
					(= global125 2)
					(Talk 51 6) ; "Come closer, coward! Our swords thirst for your blood!"
				else
					(= global154 0)
					(= global153 0)
					(= global155 1)
					(HandsOff)
				)
			)
			((Said 'greet')
				(Talk 51 7) ; "We do not want your greetings, dog."
			)
			((Said 'move,remove[/man,thug]')
				(if (and (< gPrevRoomNum 52) (> (gEgo x:) 170))
					(Talk 51 8) ; "You want me to move, heathen dog? Give me money and I will consider it."
				else
					(Talk 51 9) ; "I am not in your way now, but by Allah I will GET in your way if you provoke me."
				)
			)
			((Said 'press,kill,attack,hit,cut,annihilate[/man,thug]')
				(if (== (gEgo onControl: 1) 4096)
					(Talk 51 4) ; "Now we shall see how well an infidel dies."
					(mercenary setScript: pauseBeforeKill)
				else
					(Talk 51 10) ; "Hah! Come closer and try that, dog."
				)
			)
			((Said 'ask[/man,thug][/*]')
				(Talk 51 11) ; "I do not answer questions, infidel. Move along."
			)
			((Said 'get/coin,moneybag')
				(if (IsFlag 79)
					(Talk 51 12) ; "You get nothing back from me, unbeliever. Be on your way."
				else
					(event claimed: 0)
				)
			)
			((Said 'get')
				(Talk 51 13) ; "You will get nothing but trouble if you bother me, heathen dog."
			)
			((Said 'sell/lodestone,ass')
				(Talk 51 14) ; "We do not buy, we take."
			)
			((Said 'give,bargain/lodestone')
				(if (gEgo has: 2) ; lodestone
					(if (IsFlag 96)
						(Talk 51 15) ; "What is this? Some kind of filthy heathen talisman? Keep it away from me, by Allah."
					else
						(NotClose) ; "Perhaps you should move closer."
					)
				else
					(Print 51 16) ; "How can you offer that which you do not have?"
				)
			)
			((Said 'give,bargain/ass')
				(if local0
					(Talk 51 17) ; "I do not want your wretched mule."
				else
					(Talk 51 18) ; "Do you fool with me, unbeliever? I am not amused."
				)
			)
			((Said 'give/moneybag')
				(if (< (gEgo distanceTo: mercenary) 40)
					(if (or global122 global121 global120)
						(gTObj noWidth: 1)
						(Talk 51 3) ; "A rich man!!"
						(if (IsFlag 96)
							(mercenary setScript: pauseBeforeKill)
						else
							(mercenary setScript: pauseBeforeGangup)
						)
					else
						(Talk 51 19) ; "This is empty, dog! Give me money or be gone!"
					)
				else
					(NotClose) ; "Perhaps you should move closer."
				)
			)
			((Said 'give,pay[/man,thug,coin][/man,thug,coin]')
				(cond
					((not (DoPurse))
						(if (IsFlag 79)
							(Talk 51 20) ; "Do you mock us, infidel? We are not amused."
						else
							(Talk 51 21) ; "You had better pay in coin, infidel, or you will pay in blood."
						)
						(return)
					)
					((== (gEgo onControl: 1) 4096)
						(+= local3 global132)
						(mercenary setScript: payTheMan)
					)
					(else
						(Talk 51 22) ; "If you want to pass, you will come here and pay me."
						(proc0_18)
						(return)
					)
				)
				(= global132 0)
			)
			((Said 'talk[/man,thug]')
				(if (and (< gPrevRoomNum 52) (> (gEgo x:) 170))
					(if (IsFlag 79)
						(Talk 51 23) ; "I do not waste speech with heathens. Move along, unless you wish to give us more money, heh heh."
					else
						(Talk 51 24 51 25) ; "The Zion Gate is closed. You cannot enter here. You must go to the Jaffa Gate."
					)
				else
					(Talk 51 26) ; "I do not waste speech with infidels. I would as soon talk to a cur in the street."
				)
			)
		)
	)
)

(instance Rm51 of eRoom
	(properties
		picture 51
		style 0
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 969)
	)

	(method (init)
		(Load rsVIEW 344)
		(Load rsVIEW 388)
		(Load rsVIEW 387)
		(Load rsVIEW 386)
		(Load rsSCRIPT 969)
		(Load rsSOUND 82)
		(super init:)
		(gEgo view: 0 init:)
		(mercenary init:)
		(magentaThug init: stopUpd:)
		(blueThug init: stopUpd:)
		(whiteThug init: stopUpd:)
		(self setRegions: 123) ; wallRegion
		(if (IsFlag 20)
			(= local0 1)
		)
		(gTObj tWindow: thugWindow actor: mercenary tLoop: 0 cSpeed: 2)
		(switch gPrevRoomNum
			(52
				(self enterRoom: -10 140 30 140)
				(if local0
					(gMuleObj loop: 0)
					(self muleEnterRoom: -15 130 25 130)
				)
			)
			(else
				(self enterRoom: 225 235 225 185)
				(if local0
					(gMuleObj loop: 3)
					(self muleEnterRoom: 195 235 195 186)
				)
			)
		)
		(proc0_13 81)
		(gAddToPics doit:)
	)

	(method (doit)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				(
					(and
						(< gPrevRoomNum 50)
						local0
						(> (gMuleObj y:) 170)
						(not local6)
					)
					(= local6 1)
					(gMuleObj setScript: getHerOut)
				)
				(
					(and
						(or
							(IsFlag 79)
							(not (and (< gPrevRoomNum 52) (> (gEgo x:) 170)))
						)
						(or
							(gEgo inRect: 190 140 300 150)
							(gEgo inRect: 250 140 300 164)
						)
						(not (gEgo script:))
						(not (mercenary script:))
					)
					(gEgo
						posn: (- (gEgo x:) 5) (+ (gEgo y:) 3)
						setMotion: 0
					)
					(if (< local5 3)
						(++ local5)
						(Talk 51 27) ; "Be on your way, infidel, before we tire of your ugly face."
					else
						(Talk 51 4) ; "Now we shall see how well an infidel dies."
						(gEgo view: 6)
						(mercenary setScript: gangUp)
					)
				)
				(
					(and
						(not (mercenary script:))
						(or
							(and
								(IsFlag 96)
								(< (gEgo distanceTo: (ScriptID 51 3)) 25) ; blueThug
							)
							(and
								(IsFlag 96)
								(or
									(< (gEgo distanceTo: (ScriptID 51 2)) 15) ; whiteThug
									(< (gEgo distanceTo: (ScriptID 51 4)) 15) ; magentaThug
								)
							)
							(and
								(IsFlag 96)
								(< (gEgo y:) 155)
								(or (<= (gEgo x:) 215) (>= (gEgo x:) 236))
							)
						)
					)
					(if (== local5 3)
						(Talk 51 28) ; "You were warned, infidel!"
						(mercenary setScript: pauseBeforeKill)
					else
						(++ local5)
						(mercenary setScript: (ScriptID 137 0)) ; firstWarning
					)
				)
			)
			(cond
				((and (IsFlag 106) (not local1))
					(= local1 1)
					(Talk 51 29) ; "By Allah! Look, men, our infidel returns as bedraggled as an old sow that has been rolling in dust and muck."
				)
				((and (< (gEgo y:) 186) (IsFlag 80))
					(ClearFlag 80)
					(= local1 1)
					(Talk 51 30) ; "Hah! They must raise some clumsy fools where you come from."
				)
				((and (IsFlag 79) (not local1))
					(= local1 1)
					(Talk 51 31) ; "Fool of a heathen. Can you not even find the right gate?"
				)
				((and (not local1) (< (gEgo y:) 183) (!= gPrevRoomNum 52))
					(= local1 1)
					(gEgo setMotion: 0)
					(if global124
						(Talk 51 32) ; "Sheathe your sword, infidel, or we will chop you to pieces."
					else
						(Talk 51 33) ; "Be warned, infidel! Keep your sword sheathed or we will chop you to pieces."
					)
					(mercenary setScript: gangUp)
				)
				((< (gEgo x:) 20)
					(self leaveRoom: 52 0 (gEgo y:))
					(if (and local2 local0)
						(gMuleObj setMotion: Follow gEgo 50)
					)
				)
				((> (gEgo y:) 185)
					(self leaveRoom: 49 (gEgo x:) 235)
					(if (and local2 local0)
						(gMuleObj setMotion: Follow gEgo 50)
					)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'open/door,gate')
				(if (IsFlag 96)
					(switch local5
						(3
							(Talk 51 28) ; "You were warned, infidel!"
							(mercenary setScript: pauseBeforeKill)
						)
						(2
							(Talk 51 34) ; "The Zion Gate is closed. Move along, infidel, and I mean NOW!"
							(++ local5)
						)
						(else
							(++ local5)
							(Talk 51 35) ; "The Zion gate is closed. You should consider yourself fortunate if we allow you to leave with your skin intact."
						)
					)
				else
					(Talk 51 34) ; "The Zion Gate is closed. Move along, infidel, and I mean NOW!"
				)
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
			(
				(or
					(Said 'look<down')
					(and
						(or
							(OnButton event 6 150 148 189)
							(OnButton event 255 164 319 189)
						)
						(not (OnButton event 6 145 60 182))
						(not (OnButton event 80 144 153 182))
					)
				)
				(Print 51 36) ; "It is a long way to the bottom of the hill!"
			)
			((Said 'look<in,through/hole,opening,archiere')
				(Print 51 37) ; "The wall is too thick and the opening too narrow to see anything inside."
			)
			(
				(or
					(Said 'spit,damn,blow,fuck,cocksuck')
					(Said 'eat/shit,me')
					(Said 'insult,curse/man,thug')
				)
				(Print 51 38) ; "Why would you insult an armed group of men? Are you feeling exceptionally suicidal today?"
			)
			((Said 'move,remove,press/man,thug')
				(if (IsFlag 79)
					(Talk 51 39) ; "We have moved as far as we will move. Do not push your luck, dog of an infidel."
				else
					(Talk 51 8) ; "You want me to move, heathen dog? Give me money and I will consider it."
				)
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'are<where>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '/city,jerusalem')
							(Said '//city,jerusalem')
						)
						(Print 51 40) ; "There is a dangerous looking Mercenary guard and his thugs guarding a small, closed gate. They outnumber you, Arthur, and they are well armed."
					)
					(
						(or
							(Said '/thug')
							(Said '//thug')
							(MouseClaimed blueThug event)
							(MouseClaimed magentaThug event)
							(MouseClaimed whiteThug event)
						)
						(Print 51 41) ; "These thugs have the look of violence about them."
					)
					(
						(or
							(Said '/man')
							(Said '//man')
							(MouseClaimed mercenary event)
						)
						(cond
							((IsFlag 96)
								(Print 51 42) ; "The mercenary's evil eyes are filled with a savage bloodlust. He enjoys killing as much as he enjoys taking money"
							)
							((IsFlag 79)
								(Print 51 43) ; "Now that he has been paid, the mercenary eyes you with contempt."
							)
							(else
								(Print 51 44) ; "The large Mercenary in the pale blue robe is obviously the leader of this little band of thugs."
							)
						)
					)
					(
						(or
							(Said '/weapon,arm,scimitar,blade[<thug,man]')
							(Said '//weapon,arm,(blade<thug,man)')
						)
						(Print 51 45) ; "These men carry scimitars, a most lethal Arab weapon."
					)
					((or (Said '/turban,hat') (Said '//turban,hat'))
						(Print 51 46) ; "Do not be fooled by the look of cloth. They could well have a helmet beneath the turban."
					)
					((or (Said '/clothes,clothes') (Said '//clothes,clothes'))
						(Print 51 47) ; "Their robes may look strange to us, but they are perfectly suited to this climate."
					)
					((or (Said '/coin,fee,coin') (Said '//coin,fee,coin'))
						(cond
							((== gPrevRoomNum 52)
								(if (or global122 global121 global120)
									(Print 51 48) ; "You may have to pay them again.  Let us hope not."
								else
									(Print 51 49) ; "Let us hope that they will not wish payment to let you leave Jerusalem."
								)
							)
							((IsFlag 79)
								(Print 51 50) ; "You were very wise to avoid a fight with four heavily armed and dangerous men."
							)
							((or global122 global121 global120)
								(Print 51 51) ; "You are a lone foreigner against four dangerous mercenaries. Your life is worth far more than a few coins."
							)
							(else
								(Print 51 52) ; "I do hope you can talk your way out of this, Arthur, but I fear the only language they speak is that of money."
							)
						)
					)
					(
						(or
							(OnButton event 27 46 44 62)
							(OnButton event 124 43 140 61)
							(Said '/disc,circle,bump')
							(Said '//disc,circle,bump')
						)
						(Print 51 53) ; "The discs seem to be a part of the walls, but I cannot say what their purpose may be."
					)
					(
						(or
							(OnButton event 80 44 89 75)
							(Said '/archiere,hole,opening')
							(Said '//archiere,hole,opening')
						)
						(Print 51 54) ; "It is an archiere, from which arrows can be fired in time of war."
					)
					(
						(or
							(Said '/handle')
							(Said '//handle')
							(OnButton event 281 100 302 119)
						)
						(Print 51 55) ; "The door handles are made of iron."
					)
					(
						(or
							(Said '/door,gate<jaffa,other')
							(Said '//door,gate<jaffa,other')
						)
						(Print 51 56) ; "You cannot see it from here. It is in the western wall."
					)
					(
						(or
							(Said '/door,gate[<zion]')
							(Said '//door,gate[<zion]')
							(Said '<about/door,gate[<zion]')
							(OnButton event 250 64 310 144)
						)
						(Print 51 57) ; "If I read my maps of Jerusalem correctly, this is called the Zion Gate and is a minor gate in the south wall."
					)
					(
						(or
							(Said '/arch')
							(Said '//arch')
							(OnButton event 186 7 310 144)
						)
						(Print 51 58) ; "The arch is part of the structure of the Gate."
					)
					(
						(or
							(OnButton event 6 145 60 182)
							(OnButton event 80 144 153 182)
						)
						(Print 51 59) ; "These spiny plants are Aloe Vera."
					)
					((OnButton event 6 6 216 127)
						(Print 51 60) ; "The walls of Jerusalem are made of huge blocks of a buff-colored stone."
					)
					((OnButton event 11 122 201 142)
						(Print 51 61) ; "Aye, they are rocks. There is a lot of rock in this country."
					)
				)
			)
		)
	)
)

(instance standAside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local5 0)
				(= local3 0)
				(magentaThug
					view: 388
					setCycle: Walk
					startUpd:
					setMotion: MoveTo 196 144
				)
				(whiteThug
					view: 387
					setCycle: Walk
					startUpd:
					setMotion: MoveTo 233 143 self
				)
				(gEgo
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 221 156
				)
			)
			(1
				(HandsOn)
				(ClearFlag 96)
				(magentaThug view: 344 loop: 2 cel: 0 stopUpd:)
				(whiteThug view: 344 loop: 2 cel: 1 stopUpd:)
				(gEgo ignoreActors: 0)
				(gTObj endTalk:)
				(SetFlag 79)
				(SetFlag 109)
				(client setScript: 0)
			)
		)
	)
)

(instance gangUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(IsFlag 79)
						(not (and (< gPrevRoomNum 52) (> (gEgo x:) 170)))
					)
					(gTObj endTalk:)
				)
				(HandsOff)
				(magentaThug
					view: 388
					setCycle: Walk
					startUpd:
					setMotion: MoveTo 163 159
				)
				(whiteThug
					view: 387
					setCycle: Walk
					startUpd:
					setMotion: MoveTo 189 151
				)
				(blueThug
					view: 386
					ignoreActors: 1
					setCycle: Walk
					startUpd:
					setMotion: MoveTo 293 161
				)
				(gEgo setMotion: MoveTo 220 170)
				(= cycles 16)
			)
			(1
				(gTObj endTalk:)
				(if
					(or
						(IsFlag 79)
						(not (and (< gPrevRoomNum 52) (> (gEgo x:) 170)))
					)
					(Print 51 62 #dispose #time 3) ; "Arthur, are you mad?!"
				)
				(magentaThug view: 344 loop: 4 cel: 0 stopUpd:)
				(whiteThug view: 344 loop: 3 cel: 0 stopUpd:)
				(blueThug view: 344 loop: 6 cel: 0 stopUpd:)
				(cond
					(global124
						(= global125 2)
					)
					((< local5 3)
						(HandsOn)
					)
				)
				(SetFlag 96)
				(if
					(or
						(IsFlag 79)
						(not (and (< gPrevRoomNum 52) (> (gEgo x:) 170)))
					)
					(= seconds 3)
				else
					(= cycles 5)
				)
			)
			(2
				(if
					(or
						(IsFlag 79)
						(not (and (< gPrevRoomNum 52) (> (gEgo x:) 170)))
					)
					(client setScript: (ScriptID 136 0)) ; killEgo
				else
					(client setScript: 0)
				)
			)
		)
	)
)

(instance getHerOut of Script
	(properties)

	(method (doit)
		(if (and (IsFlag 79) (< (gEgo x:) 25))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMuleObj
					illegalBits: 0
					setMotion: MoveTo (gMuleObj x:) 166 self
				)
			)
			(1
				(gMuleObj setMotion: MoveTo 160 155 self)
			)
			(2
				(HandsOn)
				(gMuleObj setMotion: MoveTo 47 138 self)
			)
			(3
				(gMuleObj setMotion: MoveTo 48 138 self)
			)
			(4
				(gMuleObj illegalBits: -32768 setCycle: 0 stopUpd:)
			)
			(5
				(gCurRoom leaveRoom: 52 -10 (gEgo y:))
			)
		)
	)
)

(instance payTheMan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7 (gEgo cycler:))
				(gEgo cycler: 0)
				(HandsOff)
				(gEgo
					view: 0
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 258 164 self
				)
			)
			(1
				(if (not (gEgo mover:))
					(self cue:)
				)
			)
			(2
				(gEgo setLoop: 3)
				(= cycles 3)
			)
			(3
				(gEgo view: 70 setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(= cycles 5)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo view: 0 setLoop: -1 ignoreActors: 0 cycler: local7)
				(gTObj talkCue: self)
				(localproc_0)
			)
			(7
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance pauseBeforeKill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
			)
			(1
				(client setScript: (ScriptID 136 0)) ; killEgo
			)
		)
	)
)

(instance pauseBeforeGangup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
			)
			(1
				(client setScript: gangUp)
			)
		)
	)
)

