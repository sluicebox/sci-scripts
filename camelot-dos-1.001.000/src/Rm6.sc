;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use n117)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm6 0
)

(synonyms
	(rose blossom)
	(bush plant rosebush)
	(guenevere guenevere)
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(if (== (gwenActions state:) 2)
		(gTObj preLoop: 0 postLoop: 1)
		(gwenActions state: 1)
	)
	(gwenHead setScript: gwenTalking)
	(gTObj actor: gwen tLoop: 1)
	(Talk &rest)
)

(instance gwenHead of Prop
	(properties
		y 500
		x 500
		view 331
		loop 5
		cel 2
	)

	(method (doit)
		(super doit:)
		(if (== (gwen loop:) 1)
			(self posn: (- (gwen x:) 3) (gwen y:) 39)
		else
			(self posn: 500 500)
		)
		(if (and gModelessDialog (not cycler))
			(= loop
				(if
					(or
						(gEgo inRect: -30 162 152 220)
						(gEgo inRect: -30 148 102 220)
					)
					6
				else
					7
				)
			)
			(self setCycle: Fwd)
		)
		(if (and (not gModelessDialog) script (== (script state:) 1) local4)
			(script cue:)
		)
	)
)

(instance gwenTalking of Script
	(properties)

	(method (doit)
		(super doit:)
		(if gModelessDialog
			(= local4 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 0)
				(if
					(or
						(gEgo inRect: -30 162 152 220)
						(gEgo inRect: -30 148 102 220)
					)
					(gwenHead loop: 5 cel: 2 setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(1
				(gwenHead
					loop: (if (== (gwenHead loop:) 5) 6 else 7)
					setCycle: Fwd
				)
			)
			(2
				(= local4 0)
				(if (== (gwenHead loop:) 6)
					(gwenHead loop: 5 cel: 0 setCycle: End self)
				else
					(gwenHead setCycle: 0)
					(gwenHead cel: 0)
					(self dispose:)
				)
			)
			(3
				(gwenHead loop: 7 cel: 0 setCycle: 0)
			)
		)
	)
)

(instance gwen of Act
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
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
			((or (Said 'talk,greet[/guenevere,woman]') (Said 'greet'))
				(switch local2
					(0
						(localproc_0 6 0 6 1) ; "I pray to all the powers that be that you will return safely, that the Grail will be yours, as surely it must be."
					)
					(1
						(localproc_0 6 2) ; "Your fate will be always in my mind during the long and lonely hours."
					)
					(2
						(localproc_0 6 3 6 4) ; "I will add prayers for your return to those I have already made everyday for Sir Launcelot."
					)
					(else
						(localproc_0 6 5) ; "There is no more I can bear to say. Dally no more with me, my lord. Fare thee well."
					)
				)
				(++ local2)
			)
			((Said 'give/lodestone')
				(if (gEgo has: 2) ; lodestone
					(localproc_0 6 6) ; "A lodestone? I have no need of it, but you surely might. I insist you keep it."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'give/rose')
				(if (gEgo has: 4) ; rose | apple | green_apple
					(localproc_0 6 7) ; "But it is I who give it to you. I have whispered secrets to it and nourished it with my tears. It is imbued with the power of my love."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'climb,crawl')
				(localproc_0 6 8) ; "Indeed not, husband. That would be most undignified."
			)
			((Said '/you<love<me')
				(localproc_0 6 9) ; "I will cherish those words always."
			)
			((Said 'love<you<do/me')
				(localproc_0 6 10) ; "I have for you all the loving devotion a wife could have for a husband."
			)
			((or (Said '/girl') (Said '//girl'))
				(localproc_0 6 11) ; "Girl? I am Gwenhyver -- your queen, your woman, your wife. I am no girl."
			)
			((or (Said 'hello') (Said '/hello'))
				(localproc_0 6 12) ; "Is this some sort of odd Moorish word?"
			)
			((Said '/bye')
				(localproc_0 6 13) ; "Goodbye, my love. May you fulfill your destiny."
			)
			((Said 'rob/*')
				(localproc_0 6 14) ; "There is no need to steal that which is already yours."
			)
			((or (Said 'get/message') (Said 'ask[/guenevere]/message'))
				(localproc_0 6 15) ; "It is written in the Liber ex Doctrina."
			)
			((or (Said 'ask[/guenevere]/>') (Said 'are<where/*>'))
				(cond
					((Said '//bush')
						(localproc_0 6 16) ; "Alas, my husband, all but one of my roses has withered and fallen. My garden is dying, even as our kingdom slowly dies."
					)
					((Said '//wall')
						(localproc_0 6 17) ; "We are completely private within these walls. You need not worry about the window behind us. Within is only a sewing room and empty at present."
					)
					((Said '//window')
						(localproc_0 6 18) ; "There is nothing inside save the ladies' sewing room, of no interest to a warrior."
					)
					((Said '//fountain,lake')
						(localproc_0 6 19) ; "My fountain is as parched and dry as the lakes and rivers of our poor kingdom."
					)
					((Said '//bench')
						(localproc_0 6 20) ; "It is a stone bench and not very comfortable."
					)
					((Said '//tree')
						(localproc_0 6 21) ; "You planted that tree for me when Camelot was first built. I pray it will survive."
					)
					((Said '//rose')
						(cond
							((gEgo has: 4) ; rose | apple | green_apple
								(localproc_0 6 22) ; "Wear it next to your heart. In time of need, it will guide you through danger if you recite the Message of the Rose."
							)
							((IsFlag 12)
								(Print 6 23) ; "You have taken the only rose."
							)
							(else
								(localproc_0 6 24) ; "It is the last and most beautiful of my red roses. It would please me if you took it as a token of my love."
							)
						)
					)
					((Said '//gawain,galahad,grail')
						(localproc_0 6 25) ; "If I knew the least thing, I would gladly tell you."
					)
					((or (Said '/lancelot') (Said '//lancelot'))
						(SetScore 237 1 2)
						(localproc_0 6 26 6 27 6 28) ; "Ah...uhmmm....we are just good friends."
					)
					((Said '//doctrina')
						(localproc_0 6 29) ; "It is your Book of Lore, full of many things you need to know, including the Message of the Rose."
					)
					(else
						(event claimed: 1)
						(localproc_0 6 30) ; "I would gladly speak more, but I beg you to delay not another moment in beginning your mission."
					)
				)
			)
			((Said '/guenevere,woman>')
				(cond
					((Said 'look>') 0)
					((!= (gwenActions state:) 1)
						(event claimed: 1)
						(Print 6 31) ; "Move closer to her."
					)
					((Said 'kiss')
						(cond
							((not (gEgo inRect: 78 132 156 170))
								(Print 6 32) ; "Her lips do not reach that far."
							)
							((<= local0 2)
								(++ local0)
								(gwenActions changeState: 3)
							)
							(else
								(localproc_0 6 33) ; "Nay, Arthur. You must go now, before the sin of lust makes you unworthy to find the Grail!"
							)
						)
					)
					((Said 'hug')
						(cond
							((not (gEgo inRect: 78 132 156 170))
								(Print 6 34) ; "Get a little closer."
							)
							((<= local1 2)
								(++ local1)
								(gwenActions changeState: 9)
							)
							(else
								(localproc_0 6 35) ; "As nice as this is, Arthur, it does not further your mission."
							)
						)
					)
					((Said 'kill,cut')
						(localproc_0 6 36) ; "Violence in the soul will place the Grail forever beyond your reach."
					)
					((Said 'hit')
						(localproc_0 6 37) ; "Jealousy is a poison to the heart and does not become your noble character."
					)
					((Said 'fuck')
						(localproc_0 6 38) ; "Really, husband. There will be time enough for that if....I mean, when you return."
					)
					((Said 'help')
						(localproc_0 6 39) ; "Truly, if you wish to help me and your kingdom, you will search for the Grail at once!"
					)
					((Said 'poke,caress,feel')
						(localproc_0 6 40) ; "Such delights must wait until you have returned with the Grail."
					)
					((Said 'insult')
						(Print 6 41) ; "You have no good reason to insult the woman you love and your queen."
					)
					(else
						(event claimed: 1)
						(Print 6 42) ; "Gwenhyver looks puzzled. I know I am."
					)
				)
			)
		)
	)
)

(instance rose of View
	(properties)

	(method (handleEvent event)
		(if (MouseClaimed rose event)
			(Print 6 43) ; "There is only one rose left in her garden, but I have no doubt she would be glad for you to have it."
		)
	)
)

(instance gwenWindow of SysWindow
	(properties
		top 20
		left 80
		color 15
		back 2
		title {Gwenhyver}
		brTop 10
		brLeft 70
		brBottom 95
		brRight 200
	)
)

(instance bushBlock of Blk ; UNUSED
	(properties
		top 171
		left 97
		bottom 179
		right 127
	)
)

(instance roomBlock1 of Blk
	(properties
		top 190
		left -5
		bottom 231
		right 61
	)
)

(instance roomBlock2 of Blk
	(properties
		top 210
		left 60
		bottom 230
		right 226
	)
)

(instance roomBlock3 of Blk
	(properties
		top 190
		left 225
		bottom 230
		right 325
	)
)

(instance Rm6 of Rm
	(properties
		picture 6
	)

	(method (init)
		(super init:)
		(= global112 4)
		(if (not (IsFlag 12))
			(rose
				view: 331
				loop: 4
				cel: 0
				posn: 114 162
				ignoreActors:
				setPri: 13
				init:
				stopUpd:
			)
		)
		(gEgo
			view: (if (IsFlag 3) 0 else 2)
			loop: 1
			posn: 307 150
			observeBlocks: roomBlock1 roomBlock2 roomBlock3
			setMotion: MoveTo 290 150
			init:
		)
		(if (= local3 (<= (++ global117) 3))
			(gwen
				view: 331
				loop: 0
				cel: 8
				illegalBits: 0
				ignoreActors:
				posn: 104 144
				setPri: 10
				setScript: gwenActions
				init:
			)
			(gwenActions state: 2)
			(gwenHead init:)
			(gTObj tWindow: gwenWindow actor: gwen tLoop: 1 cSpeed: 4 init:)
			(gRmMusic number: 20 loop: -1 play:)
		)
		(proc0_13 258)
		(gAddToPics doit:)
		(SetFlag 1)
	)

	(method (newRoom newRoomNumber)
		(gRmMusic fade:)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(if (> (gEgo x:) 308)
			(gCurRoom newRoom: 1)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
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
			((Said 'why')
				(Print 6 44) ; "Why what? Why do we live? Why do we die? If you wish to ask me about something specific, fine. Otherwise, save the sweeping philosophical questions for another time."
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
							(Said '/sky,cloud,sun')
							(Said '<up')
							(Said '//sky,sun,cloud')
							(OnButton event 126 7 310 48)
						)
						(Print 6 45) ; "Aye, the sky is overhead as usual."
					)
					((Said '//curse')
						(Print 6 46) ; "Your land is cursed and only the Grail can heal it."
					)
					(
						(or
							(Said 'look<down')
							(Said '/dirt,dirt')
							(Said '//dirt,dirt')
						)
						(Print 6 47) ; "The ground is made of soil, as most ground is."
					)
					((or (Said '/berries') (Said '//berries'))
						(Print 6 48) ; "There are no berries, only dying leaves."
					)
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '/bower')
							(Said '/bower')
						)
						(if local3
							(Print 6 49) ; "Gwenhyver awaits you in her bower. The blight on Camelot has not spared this place, once the most beautiful garden in the land."
						else
							(Print 6 50) ; "Without the queen here, this dying bower is a sad and empty place."
						)
					)
					(
						(or
							(Said '/spinster,(woman<court)')
							(Said '//spinster,(woman<court)')
						)
						(Print 6 51) ; "They are such gossips. And none are pure in heart as your queen."
					)
					(
						(or
							(MouseClaimed gwen event)
							(Said '/guenevere,woman')
							(Said '//guenevere')
							(and (Said '//woman>') (not (Said '//*<ice,lake>')))
						)
						(event claimed: 1)
						(if local3
							(Print 6 52) ; "If there is any news of Launcelot, Gwenhyver is bound to know it."
						else
							(switch (Random 0 4)
								(0
									(Print 6 53) ; "But she's gone."
								)
								(1
									(Print 6 54) ; "She is no longer here. Perhaps she went to the Chapel to pray for your success."
								)
								(else
									(Print 6 55) ; "She's not here."
								)
							)
						)
					)
					(
						(or
							(Said '/bush')
							(Said '//bush')
							(OnButton event 129 84 290 121)
							(OnButton event 19 127 79 148)
							(OnButton event 105 153 124 173)
							(OnButton event 104 109 136 134)
							(OnButton event 270 16 292 125)
							(OnButton event 248 47 260 94)
						)
						(Print 6 56) ; "The bushes are dying from the curse upon Camelot."
					)
					((or (Said '/rose') (Said '//rose'))
						(cond
							((gEgo has: 4) ; rose | apple | green_apple
								(event claimed: 0)
							)
							((IsFlag 12)
								(Print 6 23) ; "You have taken the only rose."
							)
							(else
								(Print 6 43) ; "There is only one rose left in her garden, but I have no doubt she would be glad for you to have it."
							)
						)
					)
					((Said '//message<rose')
						(Print 6 15) ; "It is written in the Liber ex Doctrina."
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 6 57) ; "The walls, not surprisingly, are made of grey stone."
					)
					(
						(or
							(Said '/tower,camelot,castle')
							(Said '//tower,camelot,castle')
						)
						(Print 6 58) ; "This tower houses ladies of the court, unmarried girls and spinster women, mainly."
					)
					(
						(or
							(Said '/window')
							(Said '//window')
							(OnButton event 65 64 84 96)
						)
						(Print 6 59) ; "You cannot actually see in from here, but I believe it is the ladies' sewing room inside. Hardly of interest to you."
					)
					(
						(or
							(Said '/fountain,lake')
							(Said '//fountain,lake')
							(OnButton event 202 123 222 143)
						)
						(Print 6 60) ; "The fountain has run dry, like most of Camelot's water."
					)
					((or (Said '/water') (Said '//water'))
						(Print 6 61) ; "There is none. The Queen's fountain has dried up, like so many of Camelot's lakes and rivers. It is one more reminder of the curse which you alone can undo by finding the Grail."
					)
					(
						(or
							(Said '/bench')
							(Said '//bench')
							(OnButton event 79 131 114 142)
						)
						(Print 6 62) ; "It is a plain stone bench."
					)
					(
						(or
							(Said '/tree')
							(Said '//tree')
							(OnButton event 0 0 208 41)
						)
						(Print 6 63) ; "They are dying from the curse upon Camelot."
					)
					(
						(or
							(Said '/mountain')
							(Said '//mountain')
							(OnButton event 124 47 310 64)
						)
						(Print 6 64) ; "You often hunt those hills, even as far as the distant Mendip Hills. But this is no time to be daydreaming."
					)
					((or (Said '/lancelot') (Said '//lancelot'))
						(if local3
							(Print 6 52) ; "If there is any news of Launcelot, Gwenhyver is bound to know it."
						else
							(event claimed: 0)
						)
					)
				)
			)
			((and local3 (Said 'give/coin,dinar,dirham,copper,moneybag'))
				(if (not (DoPurse))
					0
				else
					(proc0_18)
					(localproc_0 6 65) ; "I have all the wealth I need and desire no more earthly goods, only the salvation of our land."
				)
			)
			((Said 'climb/bench')
				(Print 6 66) ; "You have better things to do than peek into the ladies' sewing room."
			)
			((or (Said 'climb') (Said 'crawl/window'))
				(Print 6 67) ; "This is not the time for scrambling about like a boy."
			)
			((Said 'cut/tree')
				(Print 6 68) ; "Wanton violence taints the soul."
			)
			((Said 'sat')
				(Print 6 69) ; "Though you may desire to sit in the sun, your mission is too urgent to wait."
			)
			((Said 'get/leaf')
				(Print 6 70) ; "None of these leaves has any particular value."
			)
			((Said 'get,pick/rose')
				(cond
					((IsFlag 12)
						(Print 6 71) ; "The only rose has already been picked."
					)
					(
						(or
							(gEgo inRect: 100 180 125 189)
							(gEgo inRect: 39 146 100 175)
							(gEgo inRect: 100 125 172 175)
							(>= (gEgo y:) 175)
						)
						(SetScore 0 0 1)
						(gEgo setScript: pickRose)
					)
					(else
						(NotClose) ; "Perhaps you should move closer."
					)
				)
			)
			((Said 'drop,exit/rose')
				(cond
					((not (gEgo has: 4)) ; rose | apple | green_apple
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					((not local3)
						(Print 6 72) ; "You don't need to."
					)
					(else
						(Talk 6 73) ; "You would be a poor husband indeed to be so careless."
					)
				)
			)
			((Said 'get,drink/water')
				(Print 6 61) ; "There is none. The Queen's fountain has dried up, like so many of Camelot's lakes and rivers. It is one more reminder of the curse which you alone can undo by finding the Grail."
			)
			((Said 'get,pick/berries')
				(Print 6 48) ; "There are no berries, only dying leaves."
			)
			((Said 'wear/rose,rose')
				(if (gEgo has: 4) ; rose | apple | green_apple
					(Print 6 74) ; "She was being poetic, Arthur. She meant only to carry it with you."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'draw/blade')
				(cond
					((not (IsFlag 3))
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					(local3
						(= global125 2)
						(switch (Random 0 1)
							(0
								(localproc_0 6 75) ; "There is nothing quite as exciting as a man with a long sword."
							)
							(1
								(localproc_0 6 76) ; "Fond as I am of your sword, Arthur, I would rather that you save it for a better use."
							)
							(2
								(localproc_0 6 77) ; "Your sword is unequalled in all of Christendom. But for my peace of mind, I prefer to see it sheathed."
							)
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance gwenActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (gwenActions state:) 2) (< (gEgo x:) 260))
			(gwenActions changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gwen setLoop: 0 setCel: 0 setCycle: CT 4 1 cycleSpeed: 1)
			)
			(2
				(gwen setLoop: 0 setCel: 4 setCycle: CT 0 -1 cycleSpeed: 1)
			)
			(3
				(gTObj endTalk:)
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors:)
				(if (gEgo inRect: 100 140 140 150)
					(self cue:)
				else
					(gEgo setMotion: MoveTo 124 144 self)
				)
			)
			(4
				(gEgo setMotion: MoveTo 119 144 self)
			)
			(5
				(gEgo hide:)
				(gwen
					setLoop: (if (IsFlag 3) 3 else 2)
					cel: 0
					setCycle: End self
				)
			)
			(6
				(= seconds 3)
			)
			(7
				(gwen setCycle: Beg self)
			)
			(8
				(HandsOn)
				(gEgo
					show:
					setLoop: -1
					setCel: -1
					loop: 1
					illegalBits: -4096
					ignoreActors: 0
				)
				(gwen setLoop: 1 setCel: 0)
				(gwenActions state: 1)
			)
			(9
				(gTObj endTalk:)
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors:)
				(if (gEgo inRect: 100 140 140 150)
					(self cue:)
				else
					(gEgo setMotion: MoveTo 124 144 self)
				)
			)
			(10
				(gEgo setMotion: MoveTo 119 144 self)
			)
			(11
				(gEgo hide:)
				(gwen
					setLoop: (if (IsFlag 3) 3 else 2)
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(12
				(= seconds 3)
			)
			(13
				(gwen setCycle: Beg self)
			)
			(14
				(HandsOn)
				(gEgo
					show:
					setLoop: -1
					setCel: -1
					loop: 1
					illegalBits: -4096
					ignoreActors: 0
				)
				(gwen setLoop: 1 setCel: 0)
				(gwenActions state: 1)
			)
		)
	)
)

(instance pickRose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(cond
					((gEgo inRect: 100 180 125 189)
						(self changeState: 3)
					)
					((gEgo inRect: 39 146 100 175)
						(gEgo setMotion: MoveTo 84 168 self)
					)
					((gEgo inRect: 100 125 172 175)
						(gEgo setMotion: MoveTo 141 168 self)
					)
					((>= (gEgo y:) 184)
						(self changeState: 2)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x:) 184 self)
			)
			(2
				(gEgo setMotion: MoveTo 105 183 self)
			)
			(3
				(gEgo loop: 3)
				(rose dispose:)
				(= seconds 2)
			)
			(4
				(if local3
					(localproc_0 6 22) ; "Wear it next to your heart. In time of need, it will guide you through danger if you recite the Message of the Rose."
				)
				(gEgo get: 4 illegalBits: -32768) ; rose | apple | green_apple
				(SetFlag 12)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

