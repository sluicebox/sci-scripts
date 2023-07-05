;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 158)
(include sci.sh)
(use Main)
(use Bazaar)
(use Interface)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	mo 0
	proc158_1 1
)

(local
	local0
	local1
	local2
)

(procedure (proc158_1)
	(Face gEgo mo)
	(gTObj tWindow: moWindow actor: mo tLoop: 4 cSpeed: 3 postLoop: -1)
	(if (== (gMuleObj script:) happyMule)
		(gTObj postLoop: 5)
	)
)

(procedure (localproc_0)
	(proc158_1)
	(Talk &rest)
)

(instance moWindow of SysWindow
	(properties
		back 12
		title {Mohammed}
		brTop 10
		brLeft 70
		brBottom 95
		brRight 200
	)
)

(instance mo of Act
	(properties
		y 140
		x 230
		view 347
		loop 4
		xStep 4
	)

	(method (init)
		(super init:)
		(if (== global202 2)
			(mo setLoop: 5 cycleSpeed: 2 setCycle: Fwd)
			(gMuleObj setScript: happyMule)
		)
	)

	(method (delete)
		(super delete:)
		(DisposeScript 158)
	)

	(method (dispose)
		(gMuleObj setScript: 0)
		(super dispose:)
	)

	(method (handleEvent event)
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
			(
				(or
					(Said 'look/mohammed,merchant,guard,man')
					(Said 'ask/merlin/mohammed,merchant,(guard[<!*]),man')
					(MouseClaimed self event)
				)
				(Print 158 0) ; "A most formidable looking man, but with an honest face. I would say he was previously a soldier who has gone into business selling what he knows best."
			)
			(
				(or
					(Said 'look/dagger,scimitar,blade')
					(Said 'ask/merlin/dagger,scimitar,blade')
				)
				(Print 158 1) ; "He wears an extremely good scimitar and dagger and from the looks of him, he knows how to use them."
			)
			(
				(and
					(or (mo script:) (< (gEgo x:) 120))
					(Said 'ask,talk,give,buy[/mohammed,merchant,guard,man]')
				)
				(if (mo script:)
					(Print 158 2) ; "Mohammed is busy closing his shop."
				else
					(Print 158 3) ; "Perhaps you should move closer"
				)
			)
			((Said 'knock[/door]')
				(if (gEgo inRect: 203 132 266 154)
					(localproc_0 158 4) ; "There is no-one inside my shop. I have closed up."
				else
					(NotClose) ; "Perhaps you should move closer."
				)
			)
			((Said 'open/door')
				(if (gEgo inRect: 203 132 266 154)
					(Print 158 5) ; "I would not annoy Mohammed by trying that when his shop is clearly closed."
				else
					(NotClose) ; "Perhaps you should move closer."
				)
			)
			((Said 'talk[/mohammed,merchant,guard,man]')
				(cond
					((== global202 1)
						(switch local0
							(0
								(localproc_0 158 6 158 7) ; "Thought I would wait and see how you fared, warrior. I take it things do not go well. I am sorry to see it. If I were not about to leave on a long journey, I would take you in as my guest."
							)
							(else
								(localproc_0 158 8) ; "I am sure you value your mule too highly to part with her. I certainly would."
							)
						)
					)
					((== global202 2)
						(switch local0
							(0
								(localproc_0 158 9 158 10) ; "Your mule is safe, habib. I thought I had best remain and guard her against other thieves. They are a plague in Jerusalem."
							)
							(else
								(localproc_0 158 11) ; "That truly is a very good mule. You undoubtedly value her very highly. If that were my mule, I would never sell her."
							)
						)
					)
					((== global202 0)
						(switch local0
							(0
								(localproc_0 158 12 158 13) ; "You are wise not to waste your time chasing after him, habib. The thieves of Jerusalem are as slippery as eels."
							)
							(else
								(localproc_0 158 14) ; "I will ask Allah to aid you."
							)
						)
					)
					(else
						(Print 158 15) ; "I fear you waited too long, Arthur. He is gone."
					)
				)
				(++ local0)
			)
			((and (!= global202 3) (Said 'give/ass'))
				(localproc_0 158 16) ; "You would give me this excellent mule?! Habibi, you are either a holy man or a mad man. Still, you have my undying gratitude."
				(= local2 1)
				(SetScore 0 1 -10)
				(mo setScript: getMule)
			)
			((Said 'sell,bargain>')
				(cond
					((Said '/ass')
						(if (or (IsFlag 20) (== global202 2))
							(= local2 0)
							(SetScore 0 1 10)
							(mo setScript: getMule)
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/excaliber')
						(localproc_0 158 17) ; "You would not last long in Jerusalem without a sword. I could not consider buying your only weapon, magnificent though it is."
					)
					((Said '/shield')
						(localproc_0 158 18) ; "I have many shields to sell and yours, though well made, has been through much travel and battle. Besides, you may well need it."
					)
					((Said '/armor')
						(localproc_0 158 19) ; "It is good armor, made after the fashion of the Romans, I see. But I am in the business of selling, not buying."
					)
				)
			)
			((Said 'buy/>')
				(if (Said '/weapon,blade,shield,armor')
					(localproc_0 158 20) ; "You look well equipped, habib, and I have closed up shop to go on a journey."
				else
					(event claimed: 1)
					(localproc_0 158 21) ; "I sell only weapons and armor."
				)
			)
			((and (== global202 2) (Said '*/ass>'))
				(cond
					((Said 'look')
						(Print 158 22) ; "The mule looks very happy with Mohammed."
					)
					((Said 'get,get,guide')
						(localproc_0 158 23) ; "She is yours, warrior. I am simply guarding her for you."
					)
				)
			)
			((Said 'ask[/mohammed,merchant,guard,man]/*>')
				(cond
					((Said '//grail')
						(localproc_0 158 24) ; "I do not know of such things. I am only a simple soldier turned merchant."
					)
					((Said '//galahad')
						(localproc_0 158 25) ; "There was another like you, but that was a some time ago. I do not know what became of him."
					)
					((Said '//ass')
						(localproc_0 158 26) ; "She is a fine mule. I can see she has good bloodlines."
					)
					((Said '//con')
						(localproc_0 158 27) ; "That mongrel? He waits outside the gate and tries to trick people into paying him to enter! He is not very good at his fraud and most people are too smart to pay him."
					)
					((Said '//weapon,blade,business,goods,dagger,ax,club')
						(localproc_0 158 28) ; "I sell weapons of all kinds - swords, daggers, bows, maces, axes, spears and many other weapons. But I regret I have locked up as I must depart very soon to join a caravan."
					)
					((Said '//armor,food')
						(localproc_0 158 29) ; "I deal with weapons only."
					)
					((Said '//journey,caravan')
						(localproc_0 158 30) ; "I travel with a caravan to Cairo."
					)
					((Said '//cairo')
						(localproc_0 158 31) ; "It is in Egypt."
					)
					((Said '//mari,girl,mari')
						(localproc_0 158 32) ; "The wench lives above me, but I would avoid her company, if I were you."
					)
					((Said '//bandit')
						(localproc_0 158 33) ; "I am sorry for your loss. That thief has done much mischief in the bazaar."
					)
					((Said '//jerusalem')
						(localproc_0 158 34) ; "It is a city of great interest, if one is careful enough."
					)
					((Said '//arma')
						(localproc_0 158 35) ; "Eh? You jest. You know that means weapons."
					)
					((and (Said 'ask//*>') (not (proc152_2 event)))
						(event claimed: 1)
						(localproc_0 158 36) ; "I am not the wisest of men, habib, so I say as little as possible to hide my ignorance."
					)
				)
			)
			((Said 'draw/blade')
				(localproc_0 158 37) ; "Not wise, habib. There are mercenary guards all over this city, eager to cut into pieces any foreigner foolish enough to cause trouble. I know. I have done it."
				(= global125 2)
			)
		)
	)
)

(instance getMule of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== global202 2)
					(gMuleObj
						setLoop: 1
						setCycle: Walk
						cycleSpeed: 0
						setScript: 0
					)
					(mo setLoop: 4 cel: 0 setCycle: 0)
				)
				(gEgo ignoreActors:)
				(cond
					((and (== global202 2) (gEgo inRect: 185 135 225 145))
						(gEgo setMotion: MoveTo 185 147 self)
					)
					((< (gEgo y:) 147)
						(gEgo setMotion: MoveTo (gEgo x:) 147 self)
					)
					(else
						(= cycles 2)
					)
				)
			)
			(1
				(if (!= global202 2)
					(gMuleObj ignoreActors: setMotion: MoveTo 235 180)
				)
				(if local2
					(gEgo setMotion: MoveTo 260 147 self)
				else
					(gEgo setMotion: MoveTo 260 145 self)
				)
			)
			(2
				(gEgo loop: 1)
				(if (!= global202 2)
					(gMuleObj setMotion: MoveTo 230 145 self)
				else
					(= cycles 1)
				)
			)
			(3
				(gMuleObj
					view: 348
					setCycle: Walk
					setMotion: MoveTo 225 145 self
				)
			)
			(4
				(if local2
					(self changeState: 14)
				else
					(= cycles 1)
				)
			)
			(5
				(gTObj talkCue: self)
				(localproc_0 158 38) ; "Habibi, if you would truly part with this excellent mule, I will gladly give you all the money I have upon me. It is a goodly sum, but this fine mule is worth every coin."
			)
			(6
				(gTObj talkCue: self)
				(localproc_0 158 39) ; "In this purse you will find two dinars, that which is our gold coin. There are also dirhams, and these are silver, and some fals. A fals is a copper coin."
			)
			(7
				(mo setLoop: 6 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(8
				(= cycles 1)
			)
			(9
				(gEgo loop: 1)
				(RedrawCast)
				(gEgo get: 3) ; purse
				(SetFlag 133)
				(SetMenu 1281 112 1)
				(= global122 2)
				(= global121 4)
				(= global120 18)
				(gEgo
					view: 70
					setLoop: 0
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(10
				(mo setLoop: 4 cycleSpeed: 0 setCycle: 0)
				(gEgo setCycle: Beg self)
			)
			(11
				(gTObj talkCue: self)
				(localproc_0 158 40) ; "Since I see you do not understand, here is the way of it--4 fals are worth 1 dirham. 4 dirham are worth 1 dinar."
			)
			(12
				(gEgo
					view: 0
					setLoop: -1
					loop: 1
					cycleSpeed: 0
					setCycle: Walk
				)
				(gTObj talkCue: self)
				(localproc_0 158 41) ; "And now I must go and meet the caravan that awaits me. May Allah grant you good fortune."
			)
			(13
				(self changeState: 15)
			)
			(14
				(HandsOff)
				(gTObj talkCue: self)
				(localproc_0 158 42) ; "I must hurry now to meet my caravan. May Allah guide you."
				(= global190 3000)
			)
			(15
				(mo
					view: 347
					setLoop: 1
					setCycle: Walk
					cycleSpeed: 0
					setStep: 4 2
					setMotion: MoveTo -20 150
				)
				(gMuleObj
					setScript: 0
					setCycle: Walk
					setStep: 4 2
					cycleSpeed: 0
					setMotion: MoveTo -20 155 self
				)
			)
			(16
				(= global202 3)
				(ClearFlag 20)
				(gEgo ignoreActors: 0)
				(HandsOn)
				(gMuleObj dispose: delete:)
				(mo dispose: delete:)
			)
		)
	)
)

(instance happyMule of Script
	(properties)

	(method (init)
		(super init:)
		(gMuleObj
			view: 348
			setLoop: 0
			posn: 235 143
			cycleSpeed: 6
			setCycle: Fwd
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((and gModelessDialog (== (gTObj actor:) mo))
				(gMuleObj setCycle: 0)
			)
			(
				(and
					(== (gTObj actor:) mo)
					(== (gTObj tCount:) 0)
					(== (gMuleObj cycler:) 0)
				)
				(gMuleObj setCycle: Fwd)
			)
		)
	)
)

