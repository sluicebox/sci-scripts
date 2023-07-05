;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 550)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use Talker)
(use TargActor)
(use Full)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm550 0
)

(local
	lastChance
	tombDoorOpen
	responseTimer
	noticedDoor
	annoyed
	myLastSeconds
	aSecondPassed
	oldRegister
)

(procedure (FaceEgo)
	(TurnHead 4)
	(adAvis view: 555 setLoop: 2 setCel: 2)
)

(procedure (FaceDoor)
	(TurnHead 0)
	(adAvis view: 555 setLoop: 0 setCel: -1 cel: 8)
)

(procedure (TurnHead where &tmp whichLoop)
	(if (= whichLoop where)
		(adAvisHead
			view: 555
			setLoop: whichLoop
			tLoop: whichLoop
			setPri: (+ (adAvis priority:) 4)
			setCycle: 0
			cel: 0
			show:
		)
	else
		(adAvisHead hide:)
	)
)

(instance rm550 of Rm
	(properties
		picture 550
		style 16
	)

	(method (init)
		(LoadMany rsVIEW 550 555 495 552 556 4 0)
		(LoadMany rsSOUND 550 551 12 15)
		(= gDay 29)
		(FixTime 21 0)
		(= global61 1)
		(NormalEgo)
		(super init:)
		(HandsOff)
		(adAvis init:)
		(adAvisHead init: setPri: (+ (adAvis priority:) 2))
		(FaceEgo)
		(door init: stopUpd:)
		(gEgo view: 4 posn: 72 185 init:)
		(InitFeatures turret entrance stoneWall)
		(InitAddToPics moon)
		(gCSound number: 550 loop: -1 playBed:)
		(self setScript: cartoon1)
	)

	(method (doit &tmp temp0 [temp1 21])
		(if (!= myLastSeconds (= temp0 (GetTime 1))) ; SysTime12
			(= myLastSeconds temp0)
			(= aSecondPassed 1)
			(if (> responseTimer 1)
				(-- responseTimer)
			)
		)
		(cond
			(script
				(script doit:)
			)
			((== responseTimer 1)
				(= responseTimer 0)
				(cond
					((not noticedDoor)
						(self setScript: noNoticeDoor)
						(= noticedDoor 1)
					)
					((not lastChance)
						(= lastChance 1)
						(self setScript: adAvisAngry)
					)
					(else
						(self setScript: adAvisAngry)
					)
				)
			)
		)
		(= aSecondPassed 0)
	)

	(method (handleEvent event &tmp [temp0 21])
		(super handleEvent: event)
		(if (or script (event claimed:))
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'use/mirror')
						(if (gEgo has: 46) ; Mirror
							(self setScript: useTheMirror)
						else
							(HighPrint 550 0) ; "Very clever! Oh, but that you possessed one."
						)
					)
					((Said 'cast/open,open,detect')
						(event claimed: 0)
					)
					((Said 'attack,cast,throw/flame,dart,dagger,boulder,dazzle')
						(HighPrint 550 1) ; "You wouldn't think of harming such a friend."
					)
					(
						(or
							(Said
								'search,look,look[<at,around][/room,area][/!*]'
							)
							(Said 'look,look/city,ruin,remain,grave')
						)
						(HighPrint 550 2) ; "Against the granite cliffs the remains of an ancient city are slowly being entombed by the sands."
					)
					(
						(or
							(Said 'look,look/sand,ground,boulder')
							(Said 'look,look<down')
						)
						(HighPrint 550 3) ; "The sand and rocks at your feet were once part of the cliffs above you."
					)
					(
						(or
							(Said 'look,look/sky,star,constellation')
							(Said 'look,look<up')
						)
						(HighPrint 550 4) ; "Above you in the clear desert sky you see the luminous full moon, framed by uncountable stars and constellations."
					)
				)
			)
		)
	)
)

(instance adAvis of Prop
	(properties
		x 21
		y 155
		noun '/ad,man,wizard'
		description {Ad Avis}
		lookStr {He seems like such a nice man.  You would really like to be able to help him.}
		view 555
		signal 16384
	)
)

(instance adAvisHead of Talker
	(properties
		x 21
		y 155
		z 39
		description {Ad Avis}
		view 555
		loop 4
		signal 16384
		illegalBits 0
		tLoop 4
		title {Ad Avis:}
		color 13
		back 0
	)

	(method (handleEvent event)
		(cond
			((Said 'ask,tell//mirror')
				(Say adAvisHead askAboutMirror 550 5) ; "Don't bother me with silly quest... Mirror? Do you have a mirror? USE it, you fool!"
				(gCurRoom setScript: askAboutMirror)
			)
			((Said 'ask,tell//door,star,constellation')
				(if noticedDoor
					(Say adAvisHead 550 6) ; "Silence, fool! I am pondering the significance of that at this very instant."
				else
					(= responseTimer 0)
					(Say adAvisHead 550 7) ; "What about it? The door is clearly there, emblazoned with stars. Wait, they are constellations! There is the scorpion, below is the dragon. Perhaps you are not totally worthless after all. We need but wait for the moon to shine upon the door."
					(++ noticedDoor)
					(= responseTimer 40)
				)
			)
			((Said 'ask,tell//*')
				(switch (++ annoyed)
					(1
						(Say adAvisHead 550 8) ; "Questions! Do you have nothing better to do than waste my time? Let me think, and I'd advise you to do the same!"
					)
					(2
						(Say adAvisHead 550 9) ; "Enough. You do not want to make me angry!"
					)
					(3
						(Say adAvisHead 550 10) ; "I grow impatient with your nonsense. Either find a way to make the moon obey you, or you will face my wrath!"
					)
					(4
						(Say adAvisHead 550 11) ; "You would try the patience of a dervish! Do something!"
					)
					(5
						(gCurRoom setScript: egoToSaurus)
					)
				)
			)
			((super handleEvent: event) 1)
		)
	)
)

(instance ballOfFlame of Actor
	(properties
		z 30
		view 555
		loop 7
	)
)

(instance reflection of Actor
	(properties
		x 104
		y 47
		view 550
		loop 6
		priority 15
		signal 26640
		illegalBits 0
	)
)

(instance door of TargActor
	(properties
		x 159
		y 119
		description {the doorway to the ancient city}
		yStep 7
		view 550
		cel 2
		priority 1
		signal 22544
		illegalBits 0
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (< y 119)
				(HighPrint 550 12) ; "After One Thousand Years and a Year, the door to the ancient city is unsealed."
			else
				(HighPrint 550 13) ; "The door to the Forbidden City is sealed, as it has been for centuries."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (openMe)
		(HighPrint 550 14) ; "The door is sealed by magic stronger than any you may ever command."
		(return 0)
	)

	(method (detectMe)
		(HighPrint 550 15) ; "There is a strong aura of magic emanating from the door ahead of you. Ad Avis seems to be surrounded by magic, and for some reason, so do you."
		(return 1)
	)
)

(instance cartoon1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 0 setMotion: MoveTo 72 185 init:)
				(adAvis setScript: castOpen self 1)
			)
			(1
				(Say adAvisHead 550 16) ; "You there, try walking through the door now!"
				(gEgo setScript: baseToDoor self)
			)
			(2
				(= seconds 2)
			)
			(3
				(Say adAvisHead self 550 17) ; "No, no, fool. Pass through it! Oh, get out of the way."
			)
			(4
				(HighPrint 550 18) ; "You have no idea how or why you got here, but it is nice to be able to help such a nice man."
				(gEgo setScript: doorToBase)
			)
			(5
				(TurnHead 6)
				(Say adAvisHead self 550 19) ; "I cannot be mistaken. My translation of the prophecy must be correct. It must be you. Of all the stupid Heroes in the world, I had to be cursed with you!"
			)
			(6
				(adAvis setScript: castOpen self 2)
			)
			(7
				(TurnHead 4)
				(= cycles 1)
			)
			(8
				(TurnHead 6)
				(Say adAvisHead self 550 20) ; "What is wrong? How does it go?"
			)
			(9
				(Say adAvisHead self 550 21 550 22 550 23 550 24) ; ""For one thousand years and a year, Iblis will be bound..." I know that it has been one thousand and one years to this very day, so that MUST be correct."
			)
			(10
				(TurnHead 4)
				(Say adAvisHead self 550 25) ; "When the moonlight shines between the Dragon's jaws... And is caught and held there by the Scorpion's claws."
			)
			(11
				(TurnHead 6)
				(= cycles 1)
			)
			(12
				(TurnHead 5)
				(Say adAvisHead self 550 26) ; "The Moon! It is not due to rise between the two constellations until tomorrow! How can I be wrong!?"
			)
			(13
				(TurnHead 4)
				(Say adAvisHead 550 27) ; "I WILL NOT BE DENIED!!!"
				(= cycles 1)
			)
			(14
				(adAvis setScript: castOpen self 2)
			)
			(15
				(Say adAvisHead self 550 28 550 29) ; "I cannot be wrong. It did not say a thousand and one years and a day. No!"
			)
			(16
				(DontTalk 0)
				(= responseTimer 25)
				(self dispose:)
			)
		)
	)
)

(instance slideDoor of Script
	(properties)

	(method (init)
		(super init: &rest)
		(self doit:)
		(doorSound number: 551 loop: 1 init: play:)
	)

	(method (doit)
		(super doit: &rest)
		(if (not (and (>= (door x:) 180) (>= (door y:) 168)))
			(door posn: (+ (door x:) 3) (+ (door y:) 7))
		else
			(self dispose:)
		)
	)
)

(instance castOpen of Script
	(properties)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: turnToDoor self)
			)
			(1
				(adAvis setLoop: 3 setCel: 0 setCycle: Full 1 self)
			)
			(2
				(xSound number: 12 loop: 1 init: play:)
				(door setLoop: register setCycle: Full)
				(adAvis setLoop: 5 setCel: 0 setCycle: Full 2 self)
			)
			(3
				(door setCel: 255)
				(self setScript: turnToEgo self)
			)
			(4
				(door stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance baseToDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					ignoreControl: -1
					view: 0
					setLoop: -1
					setCycle: SyncWalk
					setMotion: MoveTo 72 173 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 79 130 self)
			)
			(2
				(gEgo setMotion: MoveTo 165 133 self)
			)
			(3
				(gEgo setMotion: MoveTo 165 129 self)
			)
			(4
				(if tombDoorOpen
					(self dispose:)
				else
					(gEgo setLoop: setMotion: MoveTo 163 126 self)
				)
			)
			(5
				(gEgo setMotion: MoveTo 165 129 self)
			)
			(6
				(gEgo setLoop: setMotion: MoveTo 163 126 self)
			)
			(7
				(gEgo setMotion: MoveTo 165 129 self)
			)
			(8
				(gEgo setLoop: -1)
				(self dispose:)
			)
		)
	)
)

(instance doorToBase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					ignoreControl: -1
					view: 0
					setLoop: -1
					setCycle: SyncWalk
					setMotion: MoveTo 79 131 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 75 167 self)
			)
			(2
				(gCurRoom cue:)
				(gEgo setMotion: MoveTo 227 184 self)
			)
			(3
				(gEgo setLoop: -1 setMotion: MoveTo 225 181 self)
			)
			(4
				(gEgo setCycle: StopWalk 4)
				(= cycles 1)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance egoToSaurus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(FaceEgo)
				(TurnHead 6)
				(adAvis view: 555 setLoop: 2 cel: 1)
				(Say adAvisHead self 550 30) ; "So be it! "By the Powers of all Darkness. By the Power of My Name Shall your soul be mirrored outward, and your body be the same!""
			)
			(1
				(TurnHead 4)
				(adAvis setCel: -1 cel: 0 setCycle: End self)
			)
			(2
				(gEgo view: 556 cel: 0 cycleSpeed: 2 setCycle: CT 2 1)
				(tSound number: 15 loop: 1 init: play:)
				(ballOfFlame
					ignoreActors:
					ignoreControl: -1
					setLoop: 7
					setPri: (- (gEgo priority:) 1)
					setStep: 20 20
					setCycle: Fwd
					posn: (adAvis x:) (adAvis y:)
					setMotion: MoveTo (gEgo x:) (gEgo y:) self
					init:
				)
			)
			(3
				(ballOfFlame dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(EgoDead ; "Oooo... I hate it when this happens."
					0
					550
					31
					#icon
					(gEgo view:)
					(gEgo loop:)
					(gEgo cel:)
				)
				(self dispose:)
			)
		)
	)
)

(instance useTheMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HighPrint 550 32) ; "You whip the mirror out of your pocket, and carefully direct the reflected moonlight between the constellations."
				(gEgo
					view: 552
					setLoop: 0
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(turnToDoor start: 2)
				(adAvis setScript: turnToDoor self 1)
			)
			(2
				(reflection init: setMotion: MoveTo 144 96 self)
			)
			(3
				(door setLoop: 3 setCel: 0)
				(reflection setMotion: MoveTo 152 104 self)
			)
			(4
				(door setCel: 1)
				(reflection setMotion: MoveTo 161 112 self)
			)
			(5
				(door setCel: 2)
				(= cycles 5)
			)
			(6
				(reflection hide:)
				(door setLoop: 5 setCycle: Full 5 self)
				(gEgo setCycle: Beg)
			)
			(7
				(reflection
					posn: 159 99
					setLoop: 4
					setCel: 0
					show:
					setCycle: End self
				)
			)
			(8
				(reflection dispose:)
				(door setCel: 2 moveSpeed: 3 setPri: setScript: slideDoor self)
			)
			(9
				(door dispose:)
				(adAvis setScript: turnToEgo self)
				(SolvePuzzle 632 5)
			)
			(10
				(adAvis setLoop: 2 setCel: 1)
				(TurnHead 6)
				(Say adAvisHead self 550 33) ; "At last! Now how does the rest of the prophecy go? "And at last the Hero 'He who Waits Behind' shall see, While Iblis rises by the Dark One and the light shall flee. By the name of Suleiman, so shall this be!""
			)
			(11
				(adAvis setLoop: 2 setCel: 2)
				(TurnHead 4)
				(Say adAvisHead self 550 34) ; "Now you know all you need to know. Go in there and bring me the statue of Iblis!"
			)
			(12
				(= tombDoorOpen 1)
				(NormalEgo)
				(HandsOff)
				(gEgo setScript: baseToDoor self)
				(turnToDoor start: 2)
				(adAvis setScript: turnToDoor self 1)
				(= responseTimer 0)
			)
			(13 0)
			(14
				(gCurRoom newRoom: 580)
				(= global61 0)
				(self dispose:)
			)
		)
	)
)

(instance turnToEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(adAvis
					view: 555
					posn: 21 155
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(FaceEgo)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance turnToDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(FaceDoor)
				(adAvis setLoop: 0 setCel: 8 setCycle: Beg self)
			)
			(1
				(adAvis view: 495 posn: 32 158 setLoop: 1 setCel: 0)
				(self dispose:)
			)
			(2
				(FaceDoor)
				(adAvis setLoop: 0 setCel: 255 setCycle: CT 1 -1 self)
			)
			(3
				(self start: 0)
				(self dispose:)
			)
		)
	)
)

(instance noNoticeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontTalk 1)
				(Say adAvisHead self 550 35) ; "Bah! What use are you? Be silent!"
			)
			(1
				(= seconds 3)
			)
			(2
				(HighPrint 550 36) ; "You find that you have no desire to speak."
				(= cycles 1)
			)
			(3
				(adAvis setScript: turnToDoor self)
			)
			(4
				(Say adAvisHead self 550 37) ; "Passing through the door... what is it about that door? Door with stars, constellations! The scorpion and the dragon are on the door! It must be when the moon shines upon the door that you may pass though it."
			)
			(5
				(Say adAvisHead self 550 38) ; "Let me see, where is the moon now? The moon is to the southeast. But the door is facing north! The moonlight will not pass over us enough to cast light upon the door. Why is this happening to me? After all these years of planning, how can so many things go wrong?"
			)
			(6
				(adAvis setScript: turnToEgo self)
			)
			(7
				(Say adAvisHead self 550 39) ; "Well, Hero from the Northland, are you so powerful a magician that you can move the moon from its orbit and force it to shine on the door? Or are you so strong that you can bend light? What can you say or do that will let you pass the door?"
			)
			(8
				(HighPrint 550 40) ; "You find you can speak and move your arms again, but you can't seem to move your legs."
				(DontTalk 0)
				(= responseTimer 40)
				(self dispose:)
			)
		)
	)
)

(instance adAvisAngry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontTalk 1)
				(if lastChance
					(Say adAvisHead self 550 41) ; "Bah! You have no way of getting through that door. And if your usefulness has ended...."
				else
					(Say adAvisHead self 550 42) ; "What is it about you that will let you pass the door? There must be something. The prophecy cannot be wrong."
				)
			)
			(1
				(DontTalk 0)
				(if lastChance
					(gCurRoom setScript: egoToSaurus)
				)
				(self dispose:)
			)
		)
	)
)

(instance askAboutMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(if (gEgo has: 46) ; Mirror
					(self setScript: useTheMirror self)
				else
					(self dispose:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance turret of Feature
	(properties
		x 264
		y 131
		noun '/minaret'
		nsTop 111
		nsLeft 242
		nsBottom 152
		nsRight 287
		description {the fallen tower}
		lookStr {This fallen tower once stood guard over the ancient city.}
	)
)

(instance moon of PicView
	(properties
		x 30
		y 30
		noun '/moon'
		description {the pale moon}
		lookStr {The pale moon provides the only illumination for this eerie tableau.}
		view 552
		loop 1
	)
)

(instance xSound of Sound
	(properties
		vol 50
		priority 5
	)
)

(instance tSound of Sound
	(properties
		vol 80
		priority 5
	)
)

(instance doorSound of Sound
	(properties
		priority 5
	)
)

(instance stoneWall of Feature
	(properties
		x 205
		y 52
		noun '/wall,cliff'
		nsLeft 93
		nsBottom 104
		nsRight 318
		description {the remains of the ancient city}
		lookStr {The ancient city, long before it was sealed, bustled with intelligence and magic under these granite cliffs.}
	)
)

(instance entrance of Feature
	(properties
		x 146
		y 77
		noun '/entrance,door'
		nsTop 34
		nsLeft 100
		nsBottom 120
		nsRight 193
		description {the entrance to the Forbidden City}
		lookStr {Jutting from the ground like the prow of an ancient shipwreck is the entrance to the Forbidden City.}
	)
)

