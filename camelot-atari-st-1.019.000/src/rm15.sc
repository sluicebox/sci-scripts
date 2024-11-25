;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
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
	rm15 0
)

(synonyms
	(binding binding)
	(gawain prisoner guard knight friend man)
)

(local
	local0
	local1
	[local2 3] = [12 16 24]
	[local5 12] = [244 47 260 166 69 125 98 163 8 7 312 65]
	[local17 16] = [267 76 311 103 82 160 243 182 7 99 43 135 155 72 229 109]
	[local33 24] = [10 156 101 183 264 136 309 184 281 98 311 129 207 59 229 104 179 143 207 153 193 121 208 142]
)

(procedure (localproc_0)
	(if (== global200 0)
		(gawaine setScript: gawTalk)
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1 temp2)
	(= temp2 0)
	(if (not (and (== (param2 type:) 1) (& (param2 modifiers:) $0003)))
		(return 0)
	)
	(for ((= temp0 0)) (< temp0 [local2 param1]) ((+= temp0 4))
		(if
			(= temp2
				(switch param1
					(0
						(OnButton
							param2
							[local5 temp0]
							[local5 (+ temp0 1)]
							[local5 (+ temp0 2)]
							[local5 (+ temp0 3)]
						)
					)
					(1
						(OnButton
							param2
							[local17 temp0]
							[local17 (+ temp0 1)]
							[local17 (+ temp0 2)]
							[local17 (+ temp0 3)]
						)
					)
					(2
						(OnButton
							param2
							[local33 temp0]
							[local33 (+ temp0 1)]
							[local33 (+ temp0 2)]
							[local33 (+ temp0 3)]
						)
					)
				)
			)
			(param2 claimed: 1)
			(return 1)
		)
	)
	(return 0)
)

(instance gawaine of Act
	(properties
		y 118
		x 103
		view 310
		illegalBits 0
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
				(and
					(<= global200 1)
					(or (Said 'ask[/gawain]>') (Said 'are<where/>'))
				)
				(cond
					((or (== global200 3) (== global200 4) (IsFlag 34))
						(Print 15 0) ; "Dead men tell no tales."
						(event claimed: 1)
					)
					((or (Said '/grail') (Said '//grail'))
						(localproc_0)
						(SetScore 249 1 1)
						(Talk 15 1) ; "Though I....did not reach the Tor....I believe it is in the possession.....of the Mad Monk of Glastonbury."
					)
					((or (Said '/galahad,lancelot') (Said '//galahad,lancelot'))
						(localproc_0)
						(Talk 15 2) ; "Alas....I have not seen or heard of him since I left Camelot."
					)
					((or (Said '/doug,glastenbury') (Said '//doug,glastenbury'))
						(localproc_0)
						(SetScore 249 1 1)
						(Talk 15 3) ; "Though I....did not reach the Tor....I believe the Grail is held.....by the Mad Monk of Glastonbury."
					)
					(
						(or
							(Said '/gawain,(gawain<black)')
							(Said '//self,gawain,(gawain<black)')
						)
						(localproc_0)
						(Talk 15 4) ; "Ah...my story is not a happy one. To be defeated....by the Black Knight....I cannot bear to speak of it yet."
					)
					(else
						(event claimed: 1)
						(Talk 15 5) ; "Please, M'lord. You must continue on with your quest."
					)
				)
			)
		)
	)
)

(instance gawWindow of SysWindow
	(properties
		color 15
		back 2
		title {Gawaine}
		brLeft 20
		brBottom 80
		brRight 159
	)
)

(instance rm15 of Rm
	(properties
		picture 15
	)

	(method (init)
		(if (!= global200 2)
			(Load rsVIEW 310)
			(Load rsSOUND 6)
			(Load rsSOUND 206)
		)
		(super init:)
		(self setRegions: 102) ; forestPerilous
		(SetFlag 31)
		(gTObj tWindow: gawWindow init:)
		(if (!= global200 2)
			(gawaine init: stopUpd:)
		)
		(if (and (== global200 0) (not (IsFlag 27)))
			(= global200 3)
			(SetScore 330 2 -50)
		)
		(switch global200
			(0
				(gawaine loop: 0 cel: 0)
			)
			(3
				(gawaine loop: 0 cel: 0)
			)
			(4
				(gawaine loop: 6 cel: 4)
			)
		)
		(if (== global116 1)
			(Load rsVIEW 13)
			(Load rsVIEW 401)
		)
		(gEgo init:)
		(switch gPrevRoomNum
			(16
				(gEgo posn: 310 130 loop: 1 setMotion: MoveTo 290 130 self)
				(if (IsFlag 20)
					(gMuleObj posn: 310 140 loop: 1 setMotion: MoveTo 290 140)
				)
			)
			(else
				(gEgo posn: 10 150 loop: 0 setMotion: MoveTo 30 150 self)
				(if (IsFlag 20)
					(gMuleObj posn: 10 160 loop: 0 setMotion: MoveTo 30 160)
				)
			)
		)
		(proc0_13 32)
		(gAddToPics doit:)
		(if (== global200 0)
			(gCurRoom setScript: Entrance)
		)
	)

	(method (newRoom newRoomNumber)
		(if (< global200 2)
			(SetScore 330 2 -50)
		)
		(if (gCast contains: gawaine)
			(if (== global200 0)
				(= global200 3)
			else
				(= global200 4)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((> (gEgo x:) 310)
				(gCurRoom newRoom: 16)
			)
			((< (gEgo x:) 10)
				(gCurRoom newRoom: 14)
			)
		)
		(cond
			((and (!= (gEgo priority:) 5) (& (gEgo onControl: 1) $4000))
				(gEgo setPri: 5)
			)
			(
				(and
					(== (gEgo priority:) 5)
					(not (& (gEgo onControl: 1) $4000))
				)
				(gEgo setPri: -1)
			)
		)
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
					(Said 'talk/merlin')
					(Said 'ask/advice')
					(Said 'ask[/merlin]/advice')
				)
				(cond
					((== global200 2)
						(Print 15 6) ; "Now that you have saved Gawaine, concentrate once more upon your search."
					)
					((< global200 2)
						(Print 15 7) ; "Gawaine is close to death and urgently needs help."
					)
					(else
						(Print 15 8) ; "You let Gawaine die. I have nothing to give you at this moment but contempt."
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
							((== global200 2)
								(Print 15 9) ; "This place should look familiar. It was here that you freed Gawaine and sent him back to Camelot."
							)
							((== global200 1)
								(Print 15 10) ; "Gawaine's injuries are serious. Only the physicians of Camelot may be able to save him."
							)
							((< global200 3)
								(Print 15 11) ; "In spite of his injuries, Gawaine has been left shackled to a massive tree. The Black Knight shows little mercy."
							)
							(else
								(Print 15 12) ; "Naught but the proof of your shame awaits you here. The massive tree before you marks the place where Gawaine's bones shall lie."
							)
						)
					)
					((Said '/gawain<black')
						(Print 15 13) ; "He is not here."
					)
					((Said '//gawain<black')
						(if (> global200 2)
							(Print 15 14) ; "The Black Knight still rules supreme in this forest, thanks to your cowardice."
						else
							(Print 15 15) ; "You have vanquished him, to your great glory."
						)
					)
					(
						(or
							(OnButton event 87 74 94 78)
							(OnButton event 110 80 115 84)
							(Said '/chain,binding')
							(Said '//chain,binding')
						)
						(if (or (== global200 0) (== global200 3))
							(Print 15 16) ; "The shackles are made of metal, sunk too deeply into the tree to pull them free, but the metal itself is not thick."
						else
							(Print 15 17) ; "The remains of the shackles shall serve as a reminder of suffering ended."
						)
					)
					((Said '//gawain')
						(cond
							((== global200 2)
								(Print 15 18) ; "He is safe. Worry not."
							)
							((> global200 2)
								(Print 15 19) ; "I am so filled with contempt that you allowed your great friend and noble knight to die, that I can offer you no words of wisdom or comfort."
							)
							(else
								(Print 15 20) ; "The most important thing to do is see that Gawaine reaches Camelot as quickly as possible. But you must continue to search for the Grail."
							)
						)
					)
					(
						(or
							(and (!= global200 2) (MouseClaimed gawaine event))
							(Said '/gawain,body')
							(Said '//body')
						)
						(switch global200
							(2
								(Print 15 21) ; "Gawaine is gone."
							)
							(0
								(Print 15 22) ; "Gawaine is still alive, barely. Hanging from the shackles must pain him cruelly."
							)
							(1
								(Print 15 23) ; "Gawaine is very ill and weak. He must go back to Camelot and be tended by a healer at once, or he will die here, but he will never make it back on foot."
							)
							(else
								(if (not (IsFlag 27))
									(Print 15 24) ; "The Black Knight has taken his life. Aye, well you should tremble at the sight. This crime lies heavily upon your own soul and will never be cleansed, no matter how you seek to right it."
								else
									(Print 15 25) ; "Alas, Gawaine, the noble Gawaine is dead.  Perhaps he died of his injuries, but I fear it was your indifference that struck the final blow."
								)
							)
						)
					)
					((or (Said '/gash') (Said '//gash'))
						(cond
							((== global200 2)
								(Print 15 26) ; "He has returned to Camelot for healing."
							)
							((< global200 3)
								(Print 15 27) ; "Though he is cut and bleeding, I fear his most serious injuries may not be as obvious to the eye."
							)
							(else
								(Print 15 28) ; "Does it matter how he died, be it of injuries or grief that his own king betrayed him? He is dead."
							)
						)
					)
					((or (Said '/tree') (Said '//tree'))
						(Print 15 29) ; "It is a huge tree."
					)
					(
						(and
							(== global116 0)
							(== global115 0)
							(or (Said '/charger') (Said '//charger'))
						)
						(Print 15 30) ; "Your horse has disappeared. It must have went back to Camelot."
					)
					(
						(or
							(OnButton event 76 70 144 121)
							(OnButton event 8 7 130 69)
						)
						(Print 15 29) ; "It is a huge tree."
					)
					((localproc_1 2 event)
						(Print 15 31) ; "'Tis a rock."
					)
					((localproc_1 1 event)
						(Print 15 32) ; "'Tis a bush."
					)
					((localproc_1 0 event)
						(Print 15 33) ; "'Tis a tree."
					)
				)
			)
			((and (< global200 3) (Said 'fuck,shit,asshole,piss'))
				(Talk 15 34) ; "I cannot believe such filth... from the lips of my own king!"
			)
			((Said 'smell')
				(cond
					((== global200 2)
						(event claimed: 0)
					)
					((== global200 0)
						(Print 15 35) ; "The smell of blood, sweat and illness is nearly overwhelming."
					)
					((< global200 3)
						(Talk 15 36) ; "I fear... I am not... my usual fragrant self."
					)
					(else
						(Print 15 37) ; "The odor of human death is not a pleasant one."
					)
				)
			)
			((Said 'listen')
				(cond
					((== global200 2)
						(event claimed: 0)
					)
					((< global200 3)
						(Print 15 38) ; "I am disturbed by the labored quality of Gawaine's breathing. He must reach Camelot as quickly as possible."
					)
					(else
						(Print 15 39) ; "The pall of solemn death enshrouds this place."
					)
				)
			)
			((Said 'greet')
				(if (< global200 3)
					(Print 15 40) ; "Sir Gawaine needs more than trivialities."
				else
					(event claimed: 0)
				)
			)
			((Said 'get/charger')
				(if (and (== global116 2) (== global115 15))
					(Print 15 41) ; "He is nearby."
				else
					(event claimed: 0)
				)
			)
			((Said 'get/help')
				(cond
					((== global200 2)
						(Print 15 26) ; "He has returned to Camelot for healing."
					)
					((< global200 3)
						(Print 15 42) ; "You are the only one who can help him. If he does not reach Camelot quickly, he will die."
					)
					(else
						(Print 15 43) ; "It is too late for that. Gawaine is dead."
					)
				)
			)
			(
				(or
					(Said 'pay')
					(Said 'give,count/coin,copper,dirham,dinar')
					(Said 'give/moneybag,bag')
				)
				(if (not (DoPurse))
					(return)
				else
					(proc0_18)
				)
				(cond
					((== global200 0)
						(Print 15 44) ; "Concern yourself with such things after you have freed Gawaine from his suffering."
					)
					((== global200 2)
						(event claimed: 0)
					)
					((> global200 2)
						(Print 15 45) ; "All the money in the world will not restore Sir Gawaine to life."
					)
					(else
						(Talk 15 46) ; "Nay, m'lord. I will not take....your money....for you may yet need it."
					)
				)
			)
			((Said 'give/rose,lodestone,sleeve,key')
				(cond
					((== global200 2)
						(event claimed: 0)
					)
					((< global200 3)
						(Print 15 47) ; "Gawaine needs no gift so greatly as he needs the gift of healing, which you cannot give him, I fear."
					)
					(else
						(Print 15 48) ; "It is of no use to a dead man."
					)
				)
			)
			((Said 'use/rose,lodestone,sleeve,key')
				(if (== global200 2)
					(event claimed: 0)
				else
					(Print 15 49) ; "It can do nothing for Gawaine."
				)
			)
			(
				(or
					(Said 'burn,hide,hide,bury/gawain,body,body,relic')
					(Said 'make,make,pile/barrow,headstone')
					(Said 'dig,make/barrow,hole')
				)
				(cond
					((== global200 2)
						(event claimed: 0)
					)
					((< global200 3)
						(Print 15 50) ; "What morbid thoughts."
					)
					(else
						(Print 15 51) ; "It cannot wash the stain of Gawaine's death from your soul. He will be enfolded into the body of mother earth and this ancient tree shall be his monument."
					)
				)
			)
			((Said 'ask,beg,have,get/absolution')
				(if (>= global200 3)
					(Print 15 52) ; "For what you have allowed to happen, there can be no forgiveness."
				else
					(Print 15 53) ; "You have no need of forgiveness. Your virtue, at the moment, is intact."
				)
			)
			((Said 'give/ass,pack,water,food,clothes,blanket')
				(cond
					((not (IsFlag 20))
						(Print 15 54) ; "You do not have your mule."
					)
					((== global200 2)
						(event claimed: 0)
					)
					(else
						(Print 15 48) ; "It is of no use to a dead man."
					)
				)
			)
			((Said 'bandage,fix,clean,bind/gawain,gash')
				(cond
					((== global200 0)
						(Print 15 55) ; "Nothing can help him until he is free of the shackles."
					)
					((== global200 2)
						(Print 15 26) ; "He has returned to Camelot for healing."
					)
					((< global200 2)
						(Print 15 56) ; "Only the healers of Camelot can save him, if he can reach them in time. He will never make it back on foot."
					)
					((or (== global200 3) (== global200 4) (IsFlag 34))
						(Print 15 43) ; "It is too late for that. Gawaine is dead."
					)
					(else
						(Print 15 57) ; "Have no fear. Gawaine will be tended well in Camelot."
					)
				)
			)
			(
				(or
					(Said 'cut,cut,annihilate,twist/binding,chain,metal')
					(Said 'use/blade,excaliber')
					(Said 'cut<deliver,loose,down/gawain')
				)
				(cond
					((IsFlag 35)
						(Print 15 58) ; "My, your memory is short. You have already shattered the shackles."
					)
					((== global200 4)
						(Print 15 59) ; "Nothing you do now can restore Sir Gawaine to life."
					)
					(
						(or
							(and
								(== global116 2)
								(not (& (gEgo onControl: 1) $0004))
								(not (& (gEgo onControl: 1) $0002))
							)
							(and
								(== global116 1)
								(not (& (gEgo onControl: 1) $0004))
								(not (& (gEgo onControl: 1) $0002))
							)
						)
						(NotClose) ; "Perhaps you should move closer."
					)
					(else
						(gCurRoom setScript: cutShackles)
					)
				)
			)
			((Said '*/binding,chain>')
				(cond
					((>= global200 3)
						(event claimed: 1)
						(Print 15 59) ; "Nothing you do now can restore Sir Gawaine to life."
					)
					((!= global200 0)
						(event claimed: 1)
						(Print 15 60) ; "You have dealt with the shackles."
					)
					((Said 'unlock')
						(Print 15 61) ; "These shackles do not unlock."
					)
					((Said 'open,undo')
						(Print 15 62) ; "I am sure you will find a way."
					)
					((Said 'get,remove,pull,twist,appropriate')
						(Print 15 63) ; "The shackles are securely anchored. Can you think of nothing better to try."
					)
				)
			)
			((Said 'dismount,(get<off)[/charger]')
				(if (!= global116 1)
					(event claimed: 0)
				else
					(gEgo setScript: moveHorse)
				)
			)
			((Said 'draw/blade')
				(cond
					((== global200 2)
						(event claimed: 0)
					)
					((or (== global200 3) (== global200 4) (IsFlag 34))
						(Print 15 64) ; "Not all the sword brandishing in the world will return Gawaine to life. Be still."
					)
					((IsFlag 35)
						(Print 15 65) ; "There is no danger for the moment. Best to put up your sword lest it make Gawaine uneasy."
					)
					((== global200 0)
						(Print 15 66) ; "There is no danger for the moment. Or did you have some other purpose in drawing your sword?"
					)
					((== global116 1)
						(Print 15 67) ; "This is one place where it would be best to use your sword on foot."
					)
					(else
						(Print 15 68) ; "There is no danger here. Be more specific about what non-violent use you portend."
					)
				)
				(= global125 2)
			)
			((Said 'talk[/gawain]')
				(cond
					((== global200 2)
						(event claimed: 0)
					)
					((> (gEgo distanceTo: gawaine) 50)
						(NotClose) ; "Perhaps you should move closer."
					)
					((== global200 0)
						(localproc_0)
						(Talk 15 69) ; "Help me, Arthur. The pain....is terrible."
					)
					((== global200 1)
						(if (> (gEgo distanceTo: gawaine) 30)
							(NotClose) ; "Perhaps you should move closer."
						else
							(Talk 15 70 15 71) ; "Beware....the Mad Monk....of Glastonbury."
						)
					)
					(else
						(Print 15 72) ; "Sir Gawaine shall never speak again."
					)
				)
			)
			((Said 'help,save,(pick<up)/gawain')
				(cond
					((== global200 0)
						(Print 15 73) ; "Consider how you might best do that."
					)
					((== global200 2)
						(event claimed: 0)
					)
					((== global200 1)
						(Print 15 74) ; "Aye, Gawaine must be helped. If he does not reach Camelot soon, he will die of his injuries."
					)
					(else
						(Print 15 75) ; "He is beyond help."
					)
				)
			)
			(
				(or
					(Said 'give/charger[/gawain]')
					(Said 'get,get,drop,mount,carry,lift/gawain/charger')
					(Said 'get,replace,send/gawain/camelot,home')
				)
				(cond
					((== global200 0)
						(Print 15 73) ; "Consider how you might best do that."
					)
					((== global116 1)
						(Print 15 76) ; "First, you must dismount."
					)
					((== global200 2)
						(event claimed: 0)
					)
					((== global200 1)
						(if (& (gEgo onControl: 1) $0004)
							(gCurRoom setScript: helpGawaineOnHorse)
						else
							(NotClose) ; "Perhaps you should move closer."
						)
					)
					(else
						(Print 15 75) ; "He is beyond help."
					)
				)
			)
			((Said '/gawain[<!*]>')
				(cond
					((== global200 2)
						(Print 15 26) ; "He has returned to Camelot for healing."
						(event claimed: 1)
					)
					((Said 'fuck')
						(if (< global200 3)
							(Talk 15 77) ; "Uh... surely you have mistaken me... for someone else."
						else
							(Print 15 78) ; "Do not add necrophilia to your list of sins."
						)
					)
					((Said 'kill,cut,hit,hit')
						(if (< global200 3)
							(Print 15 79) ; "Have you gone completely mad!?!"
						else
							(Print 15 80) ; "He is already dead. Your shame is great enough without adding evil thoughts to it."
						)
					)
					((Said 'kiss')
						(if (< global200 3)
							(Print 15 81) ; "That is hardly what he needs."
						else
							(Print 15 82) ; "Though it is a common practice to kiss farewell to the dead, it is hardly right for you to do so when you have caused his death."
						)
					)
					((Said 'hug')
						(if (< global200 3)
							(Print 15 83) ; "That would cause him even more pain than he is already suffering."
						else
							(Print 15 84) ; "Your sorrow is meaningless. It will not bring him back from the dead."
						)
					)
					((Said 'get')
						(cond
							((== global200 0)
								(Print 15 85) ; "Aye, he is indeed in need of help. He will not live hanging from those shackles much longer."
							)
							((== global200 1)
								(Print 15 86) ; "You have freed him, but he will not live long if left here."
							)
							(else
								(Print 15 87) ; "Nothing you can do now can wash the sin of Gawaine's death from your soul."
							)
						)
					)
					((Said 'pray')
						(if (>= global200 3)
							(Print 15 88) ; "It may ease your conscience, but will change nothing."
						else
							(Print 15 89) ; "Let us hope your god heeds your silent prayers."
						)
					)
					((Said 'walk,carry,assist')
						(cond
							((== global200 0)
								(Print 15 90) ; "He will go nowhere until free of the shackles."
							)
							((== global200 1)
								(Print 15 91) ; "It makes no sense to bear the burden yourself when you have a powerful horse nearby."
							)
							(else
								(Print 15 92) ; "Though bearing Gawaine's body is a burden you well deserve, your mission must not be abandoned. This tree will mark the place where his bones lie."
							)
						)
					)
					((Said 'deliver,deliver,deliver,unfasten')
						(cond
							((or (== global200 3) (== global200 4) (IsFlag 34))
								(Print 15 93) ; "What does it matter? Gawaine is dead."
							)
							((IsFlag 35)
								(Print 15 94) ; "Though Gawaine is free of the shackles, his ordeal is far from over. His life depends on your actions, King Arthur."
							)
							(else
								(Print 15 95) ; "Aye, it would be best to get him free of the shackles as quickly as possible. Seek the most direct method."
							)
						)
					)
					((Said 'drop,carry,adjust,lay/gawain/ass<(on,above)')
						(cond
							((not (IsFlag 20))
								(Print 15 54) ; "You do not have your mule."
							)
							((== global200 2)
								(event claimed: 0)
							)
							(else
								(Print 15 96) ; "Better to leave Gawaine's body beneath a tree than slung like baggage on a mule."
							)
						)
					)
				)
			)
		)
	)
)

(instance Entrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(localproc_0)
				(Talk 15 97) ; "King....Arthur....I knew....you would come."
				(client setScript: 0)
			)
		)
	)
)

(instance moveHorse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 (gEgo illegalBits:))
				(gEgo illegalBits: 0)
				(cond
					((> (gEgo x:) 165)
						(gEgo setMotion: MoveTo 165 150 self)
					)
					((not (& (gEgo onControl: 1) $0002))
						(gEgo setMotion: MoveTo 120 155 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(gEgo illegalBits: local1)
				(= global116 4)
				(client setScript: 0)
			)
		)
	)
)

(instance gawTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gawaine loop: 0 cel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(1
				(if gModelessDialog
					(= cycles 10)
				else
					(= cycles 1)
				)
			)
			(2
				(gawaine cycleSpeed: 0 setCycle: Beg self)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

(instance cutShackles of Script
	(properties)

	(method (init)
		(super init:)
		(self changeState: 1)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 3) (== global116 2))
			(HandsOff)
			(gEgo illegalBits: 0)
			(self changeState: 4)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors: 1)
				(cond
					((== global116 1)
						(self changeState: 3)
					)
					(
						(gEgo
							inRect:
								(- (gHorseObj x:) 35)
								(gHorseObj y:)
								(+ (gHorseObj x:) 40)
								200
						)
						(self changeState: 4)
					)
					((gEgo inRect: 78 100 136 125)
						(self cue:)
					)
					(else
						(gEgo setMotion: MoveTo 120 128 self)
					)
				)
			)
			(2
				(self changeState: 5)
			)
			(3
				(gEgo setScript: moveHorse)
			)
			(4
				(if (> (gEgo x:) (gHorseObj x:))
					(gEgo
						setMotion:
							MoveTo
							(+ (gHorseObj x:) 40)
							(gEgo y:)
							self
					)
				else
					(gEgo
						setMotion:
							MoveTo
							(- (gHorseObj x:) 34)
							(gEgo y:)
							self
					)
				)
			)
			(5
				(gEgo setPri: 9 setMotion: MoveTo 126 117 self)
			)
			(6
				(gEgo setLoop: 1)
				(= cycles 6)
			)
			(7
				(gEgo view: 5 cel: 0 setCycle: End self)
			)
			(8
				(gawaine hide:)
				(gEgo
					view: 310
					setLoop: 1
					cel: 0
					posn: 103 118
					setPri: 9
					cycleSpeed: 2
					setCycle: CT 2 1 self
				)
			)
			(9
				(gEgo setCycle: End self)
				(gSFX number: (proc0_20 6) loop: 1 play:)
			)
			(10
				(gEgo
					view: 3
					setLoop: -1
					loop: 1
					cel: 0
					posn: 126 117
					setCycle: Walk
					setMotion: MoveTo 125 123
				)
				(gawaine
					view: 310
					posn: 103 118
					setLoop: (if (== global200 3) 6 else 7)
					setCel: 0
					cycleSpeed: 2
					setCycle: End
					show:
				)
				(if (== global200 3)
					(gawaine setMotion: MoveTo (- (gawaine x:) 6) (gawaine y:))
				)
				(= cycles 22)
			)
			(11
				(Print 15 98) ; "You have shattered the shackles."
				(gEgo
					loop: 1
					cycleSpeed: 0
					illegalBits: $8000
					ignoreActors: 0
					setAvoider: 0
					setPri: -1
				)
				(if (== global200 3)
					(gawaine ignoreActors: 0 setMotion: 0 stopUpd:)
					(= global200 4)
				else
					(= global200 1)
				)
				(SetFlag 35)
				(HandsOn)
			)
		)
	)
)

(instance helpGawaineOnHorse of Script
	(properties)

	(method (init)
		(super init:)
		(self changeState: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 111 118 self
				)
			)
			(2
				(gEgo
					view: 310
					loop: 2
					posn: 103 118
					setCel: 0
					setCycle: End self
				)
				(gawaine dispose:)
			)
			(3
				(gEgo setCycle: Walk)
				(if (> (gEgo x:) (gHorseObj x:))
					(gEgo
						setLoop: 8
						setMotion:
							MoveTo
							(+ (gHorseObj x:) 40)
							(+ (gHorseObj y:) 5)
							self
					)
					(= local0 2)
				else
					(gEgo
						setLoop: 3
						setMotion:
							MoveTo
							(- (gHorseObj x:) 40)
							(+ (gHorseObj y:) 5)
							self
					)
					(= local0 1)
				)
			)
			(4
				(gEgo
					setMotion: MoveTo (gHorseObj x:) (+ (gHorseObj y:) 3) self
				)
			)
			(5
				(gawaine
					init:
					setLoop: 4
					setCel: 0
					ignoreActors:
					illegalBits: 0
					posn: (+ (gHorseObj x:) 9) (gHorseObj y:)
					setPri: 10
					setCycle: End self
				)
				(gHorseObj dispose:)
				(gEgo
					view: 3
					loop: 3
					cel: 0
					ignoreActors: 1
					illegalBits: $8000
					posn: (+ (gEgo x:) 1) (gEgo y:)
				)
			)
			(6
				(gTObj talkCue: self)
				(Talk 15 99) ; "May...god be with you, Arthur. Tarry not with me. Go at once....to the Tor. Find...the Grail, I beg you."
			)
			(7
				(gawaine
					setLoop: 5
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo (- (gawaine x:) 20) 140 self
				)
			)
			(8
				(gawaine setMotion: MoveTo -20 140 self)
				(gEgo setLoop: -1 loop: 1)
			)
			(9
				(Print 15 100) ; "He is right. Your horse will carry him safely back to Camelot. Even if you must go on foot, you must continue your search without delay, but be assured that this noble sacrifice brings blessings upon you."
				(SetScore 0 2 50)
				(HandsOn)
				(gEgo view: 3 ignoreActors: 0)
				(gawaine dispose:)
				(= global200 2)
				(= global116 0)
			)
		)
	)
)

