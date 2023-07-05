;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 122)
(include sci.sh)
(use Main)
(use Interface)
(use User)
(use System)

(public
	Rm0Saids 0
)

(instance Rm0Saids of Script
	(properties)

	(method (handleEvent event)
		(cond
			((Said 'consult,look,read,get,study,look,open/doctrina')
				(Print 122 0 #icon 532 0 0) ; "It is a book of knowledge which should be in your possession already. It looks like this and it is vital that you have it."
			)
			(
				(or
					(Said 'say,talk,recite,read/message/rose')
					(Said 'ask[/merlin]/message<of<rose')
				)
				(Print 122 1) ; "The Message of the Rose is written in your liber ex doctrina."
			)
			((Said 'look>')
				(cond
					(global140
						(cond
							((not (gEgo has: global140))
								(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
							)
							((Said '/blade,excaliber')
								(Print 122 2) ; "You received your sword, Excaliber, from the Lady in the Lake. By Her Blessings, may it serve you well."
							)
							((Said '/shield')
								(Print 122 3) ; "Upon this shield is the Red Dragon, in token of your surname, Pendragon, which comes from the Welsh words meaning "supreme war chief"."
							)
							(else
								(global141 showSelf:)
							)
						)
						(event claimed: 1)
					)
					((Said '/gawain,lancelot,galahad')
						(Print 122 4) ; "Clearly he is not here."
					)
					((Said '/book')
						(Print 122 5) ; "The Liber ex Doctrina looks like this. I sincerely hope you have it with you."
					)
					((Said '/boots')
						(Print 122 6) ; "You have worn these sturdy leather boots on many journeys. They will last quite a while yet."
					)
					((Said '/armor')
						(if (IsFlag 3)
							(Print 122 7) ; "It's nice armor, isn't it?"
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said 'look/merlin')
						(Print 122 8) ; "I am only with you in spirit, but that should be enough."
					)
					((Said '/pack,pack,clothes,blanket')
						(if (> gCurRoomNum 34) ; Voyage
							(Print 122 9) ; "The pack washed overboard in the storm, remember?"
						else
							(Print 122 10) ; "That is on the mule, wherever she is."
						)
					)
					(else
						(event claimed: 1)
						(Print 122 11) ; "I see nothing that is significant to your mission."
						(proc0_19 (User inputLineAddr:) {No response})
					)
				)
			)
			(
				(or
					(Said 'kill,stab/self,yourself,me,me')
					(Said 'commit/suicide')
					(Said 'cut/wrist,throat')
					(Said 'fall,eat,(stab<on)/blade,excaliber,blade')
					(Said 'kill,get/life')
				)
				(Print 122 12) ; "That would solve nothing."
			)
			((Said 'kill,attack,annihilate,hit,hit/>')
				(cond
					((Said '/charger,ass')
						(Print 122 13) ; "What an abysmally foolish idea."
					)
					((Said '[/!*]')
						(Print 122 14) ; "Unnecessary violence is a stain upon the soul."
					)
					((not (IsFlag 3))
						(event claimed: 1)
						(Print 122 15) ; "You had better don sword and armour first."
					)
					(else
						(event claimed: 1)
						(Print 122 16) ; "Deeds of mindless violence will make you unworthy of the Grail."
					)
				)
			)
			(
				(or
					(Said 'talk/merlin')
					(Said 'ask/advice')
					(Said 'ask[/merlin]/advice')
				)
				(switch (Random 0 2)
					(0
						(Print 122 17) ; "I have nothing special to tell you now."
					)
					(1
						(Print 122 18) ; "I have no special knowledge to help you here."
					)
					(2
						(Print 122 19) ; "I am unable to help more at this time."
					)
				)
			)
			((and (Said 'ask/*/*>') (not (Said '/merlin>')))
				(event claimed: 1)
				(Print 122 20) ; "That would avail you nothing."
			)
			((Said 'ask,(are<where)[/merlin]>')
				(cond
					((Said '//gawain,lancelot,galahad')
						(Print 122 21) ; "At the moment, I know no more than you of his fate."
					)
					((Said '//grail')
						(Print 122 22) ; "I would gladly tell you more if I had the knowledge."
					)
					((Said '//doctrina')
						(Print 122 0 #icon 532 0 0) ; "It is a book of knowledge which should be in your possession already. It looks like this and it is vital that you have it."
					)
					(else
						(event claimed: 1)
						(Print 122 23) ; "I can tell you nothing relevant at the moment."
					)
				)
			)
			((Said 'get[<!*]/*>')
				(cond
					((Said '/grail')
						(Print 122 24) ; "Aye, that is the purpose of your mission."
					)
					((and global141 (== (global141 owner:) gEgo))
						(Print 122 25) ; "It is in your possession."
						(event claimed: 1)
					)
					(global141
						(Print 122 26) ; "I do not see how you can, unless you know something I do not."
						(event claimed: 1)
					)
					(else
						(Print 122 27) ; "Obtain only what you need. Your burdens are already great."
						(event claimed: 1)
					)
				)
			)
			((Said 'sell,bargain/*')
				(if (and global140 (gEgo has: global140))
					(Print 122 28) ; "This is no time for the vulgar pursuit of money."
				else
					(Print 122 29) ; "How can you part with something you do not possess?"
				)
			)
			((Said 'buy/*')
				(Print 122 30) ; "That is not for sale."
			)
			((Said 'search>')
				(if (Said '/!*')
					(Print 122 31) ; "Search what?"
				else
					(event claimed: 1)
					(Print 122 32) ; "There is nothing of interest."
				)
			)
		)
		(DisposeScript 122)
	)
)

