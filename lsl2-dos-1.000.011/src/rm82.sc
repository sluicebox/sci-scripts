;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm82 0
)

(local
	bottleInHand
	bagInBottle
	bagBurning
	causedEruption
	safeX
	safeY
	aDoor
	aSteam1
	aSteam2
	aSteam3
	aBottle
)

(instance theSound of Sound
	(properties
		number 6
	)
)

(instance rm82 of Rm
	(properties
		picture 82
	)

	(method (init)
		(Load rsVIEW 715)
		(Load rsVIEW 184)
		(Load rsVIEW 103)
		(Load rsSOUND 1)
		(Load rsSOUND 6)
		(super init:)
		(theSound init:)
		((= aSteam3 (Prop new:))
			view: 715
			loop: 3
			posn: 142 125
			setCycle: Fwd
			isExtra: 1
			init:
		)
		((= aSteam2 (Prop new:))
			view: 715
			loop: 2
			posn: 102 114
			setCycle: Fwd
			isExtra: 1
			init:
		)
		((= aSteam1 (Prop new:))
			view: 715
			loop: 1
			posn: 24 111
			setCycle: Fwd
			isExtra: 1
			init:
		)
		((= aDoor (Prop new:))
			view: 715
			setLoop: 0
			posn: 75 147
			setPri: 11
			stopUpd:
			init:
		)
		(if gDebugging
			(gEgo get: 27 get: 21 get: 19) ; Airsick_Bag, Hair_Rejuvenator, Matches
		)
		(if (gEgo has: 21) ; Hair_Rejuvenator
			((= aBottle (Act new:))
				view: 184
				ignoreActors:
				illegalBits: 0
				setLoop: 4
				setCycle: Walk
				setStep: 3 9
				posn: 111 1111
				init:
				setScript: bottleScript
			)
		)
		(gEgo posn: 164 224 setPri: 15 init:)
		(self setScript: rm82Script)
	)
)

(instance rm82Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== state 16)
			(ShakeScreen 1 (Random 1 3))
		)
		(cond
			((and (& (gEgo onControl:) $0008) (== gCurrentStatus 0))
				(gEgo setPri: 1)
				(self changeState: 4)
			)
			((and (& (gEgo onControl:) $0004) (== gCurrentStatus 0))
				(self changeState: 19)
			)
			((and gDebugging (== gCurrentStatus 0))
				(= safeX (gEgo x:))
				(= safeY (gEgo y:))
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/canyon,hole,boulder')
				(Print 82 0) ; "As best you can tell from this angle, the crevice ends several hundred feet below you."
				(Print 82 1 #at -1 152) ; "(Better save your game before walking closer!)"
			)
			(if (Said '/glacier')
				(Print 82 2) ; "It's not ice. It's a column of steam rising into the tropical sky."
			)
			(if (Said '/door,elevator,box,button,control,burn')
				(if causedEruption
					(Print 82 3) ; "The explosion has forced the door open."
				else
					(Print 82 4) ; "It's controlled from within and there is no way for you to get them to open it!"
				)
			)
			(if (Said '/carpet')
				(Print 82 5) ; "There is a major fissure very close to that elevator shaft."
			)
			(if (Said '/cloud')
				(Print 82 6) ; "There's a 0% chance of rain in Sierra's adventure games."
			)
			(if (Said '[/airport,cigarette,hill,hill]')
				(Print 82 7) ; "You have reached the summit of Nontoonyt volcano. An elevator incongruously awaits you. Steam rises from a volcanic crevice. The ground feels highly unstable."
				(Print 82 8 #at -1 152) ; "(Fondly, you remember Los Angeles!)"
			)
		)
		(if (Said 'apply/ash,beach')
			(Print 82 9) ; "That won't help you now."
		)
		(if (Said 'apply,make/bomb')
			(Print 82 10) ; "Good idea. The question is how."
		)
		(if (Said 'pull,bang,apply,open/door,elevator,button')
			(Print 82 11) ; "This elevator is controlled from within!"
		)
		(if (Said 'board,climb,apply,board/canyon,hole')
			(Print 82 12) ; "Just walk closer."
		)
		(if (and (gEgo has: 21) (Said 'shit,drain/rejuvenator')) ; Hair_Rejuvenator
			(Print 82 13) ; "You open the bottle of hair rejuvenator and pour it onto the ground by your feet."
			(Print 82 14 #at -1 152) ; "(What a waste!)"
			(gEgo put: 21 -1) ; Hair_Rejuvenator
		)
		(if (Said 'drop,apply,throw/rejuvenator,bottle')
			(cond
				((not (gEgo has: 21)) ; Hair_Rejuvenator
					(DontHave) ; "You don't have it."
				)
				((and (!= gCurrentStatus 0) (!= gCurrentStatus 13))
					(NotNow) ; "Not now!"
				)
				((not (& (gEgo onControl:) $2000))
					(Print 82 15) ; "This area is not conducive to bombing. Try again somewhere else."
				)
				(else
					(Ok) ; "Ok."
					(self changeState: 13)
				)
			)
		)
		(if (Said 'stick,drop,pull,drop/rejuvenator,bottle/bag')
			(cond
				((and (not (gEgo has: 21)) (not (gEgo has: 27))) ; Hair_Rejuvenator, Airsick_Bag
					(DontHave) ; "You don't have it."
				)
				((and (!= gCurrentStatus 0) (!= gCurrentStatus 13))
					(NotNow) ; "Not now!"
				)
				(bagInBottle
					(Print 82 16) ; "You can't. The bag is securely stuffed into the neck of the bottle of hair rejuvenator."
				)
				(else
					(Print 82 17) ; "You slide the bottle of hair rejuvenator into your airsick bag."
					(Print 82 18) ; "Realizing this will accomplish nothing, you remove it again."
				)
			)
		)
		(if (Said 'stick,pull,drop,drop/bag/rejuvenator,bottle')
			(cond
				((not (gEgo has: 21)) ; Hair_Rejuvenator
					(DontHave) ; "You don't have it."
				)
				((and (!= gCurrentStatus 0) (!= gCurrentStatus 13))
					(NotNow) ; "Not now!"
				)
				((not (& (gEgo onControl:) $2000))
					(Print 82 15) ; "This area is not conducive to bombing. Try again somewhere else."
				)
				(bagInBottle
					(ItIs) ; "It is."
				)
				(else
					(Ok) ; "Ok."
					(self changeState: 8)
				)
			)
		)
		(if
			(or
				(Said 'drop,drop/match/bottle')
				(Said 'apply,burn/match')
				(Said 'burn,burn/bottle,rejuvenator')
			)
			(cond
				((not (gEgo has: 19)) ; Matches
					(Print 82 19) ; "You have no matches with which to light anything!"
				)
				((not (gEgo has: 21)) ; Hair_Rejuvenator
					(Print 82 20) ; "Do you have that?"
				)
				((and (!= gCurrentStatus 0) (!= gCurrentStatus 13))
					(NotNow) ; "Not now!"
				)
				((!= bagInBottle 1)
					(self changeState: 22)
				)
				(else
					(Ok) ; "Ok."
					(self changeState: 10)
				)
			)
		)
		(if (Said 'burn,burn/bag')
			(cond
				((not (gEgo has: 27)) ; Airsick_Bag
					(DontHave) ; "You don't have it."
				)
				((not (gEgo has: 19)) ; Matches
					(Print 82 19) ; "You have no matches with which to light anything!"
				)
				((and (!= gCurrentStatus 0) (!= gCurrentStatus 13))
					(NotNow) ; "Not now!"
				)
				((!= bagInBottle 1)
					(Print 82 21) ; "You strike a match and watch the airsick bag go up in flames. Whee!"
					(gEgo put: 19 -1) ; Matches
					(gEgo put: 27 -1) ; Airsick_Bag
				)
				((not (& (gEgo onControl:) $2000))
					(Print 82 15) ; "This area is not conducive to bombing. Try again somewhere else."
				)
				(else
					(Ok) ; "Ok."
					(self changeState: 10)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(HandsOff)
				(gEgo
					illegalBits: 0
					setLoop: 3
					setMotion: MoveTo 164 180 self
				)
			)
			(2
				(gEgo setPri: 13 setMotion: MoveTo 164 188 self)
			)
			(3
				(NormalEgo 3)
				(gEgo observeControl: 16384)
			)
			(4
				(HandsOff)
				(Print 82 22 #at -1 20 #dispose) ; "Oh, shhhhhhhh..."
				(= gCurrentStatus 12)
				(theSound number: 1 play:)
				(gEgo
					view: 103
					illegalBits: 0
					ignoreActors:
					posn: (gEgo x:) (- (gEgo y:) 15)
					cel: 0
					setStep: 1 15
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 200) self
				)
			)
			(5
				(cls)
				(= gCurrentStatus 1000)
				(Print 82 23) ; "You rapidly explore the interior of a volcanic crevice before discovering the pool of molten lava at its bottom."
				(= gCurrentStatus 1001)
				(if (== gDebugging 1)
					(NormalEgo)
					(gEgo observeControl: 16384 posn: safeX safeY)
				)
			)
			(6
				(if bottleInHand
					(ItIs) ; "It is."
				else
					(bottleScript changeState: 1)
				)
			)
			(7
				(Print 82 24 #at -1 20 #draw) ; "You extract the bottle of hair rejuvenator from your pocket and remove the cap. Now what?"
				(User canInput: 1)
				(if (not (gEgo has: 27)) ; Airsick_Bag
					(HandsOff)
					(Print 82 25) ; "But, now you realize: there's something you've forgotten!"
					(Print 82 26 #at -1 152) ; "(But, what?!)"
					(= gCurrentStatus 1001)
				)
			)
			(8
				(if (!= bottleInHand 1)
					(-- state)
					(bottleScript changeState: 1)
				else
					(gEgo view: 184 setLoop: 1 cel: 0 setCycle: End self)
				)
			)
			(9
				(gGame changeScore: 5)
				(Print 82 27 #at -1 20 #draw) ; "You insert the airsick bag into the neck of the bottle of hair rejuvenator."
				(if (not (gEgo has: 19)) ; Matches
					(HandsOff)
					(Print 82 25) ; "But, now you realize: there's something you've forgotten!"
					(Print 82 26 #at -1 152) ; "(But, what?!)"
					(= gCurrentStatus 1001)
				else
					(= bagInBottle 1)
					(User canInput: 1)
				)
			)
			(10
				(if (!= bottleInHand 1)
					(-- state)
					(bottleScript changeState: 1)
				else
					(HandsOff)
					(gEgo view: 184 setLoop: 2 cel: 0 setCycle: End self)
					(gEgo put: 19 -1) ; Matches
					(gEgo put: 27 -1) ; Airsick_Bag
				)
			)
			(11
				(aBottle
					setPri: (+ (gEgo priority:) 1)
					posn: (+ (gEgo x:) 7) (- (gEgo y:) 19)
					setLoop: 3
					setCycle: Fwd
				)
				(gGame changeScore: 5)
				(Print 82 28 #at -1 20 #draw) ; "You are now holding a bottle full of highly flammable liquid, with a burning wick made from an airsick bag."
				(Print 82 29 #at -1 152) ; "Yes, really!"
				(= bagBurning 1)
				(User canInput: 1)
				(= seconds 5)
			)
			(12
				(HandsOff)
				(= gCurrentStatus 14)
				(gCurRoom newRoom: 152)
			)
			(13
				(if (!= bottleInHand 1)
					(-- state)
					(bottleScript changeState: 1)
				else
					(if bagBurning
						(aBottle setLoop: 5)
						(Print 82 30 #at -1 20) ; "You dispatch your Larrytov cocktail on its merry mission with a hearty grunt!"
					else
						(Print 82 31 #at -1 20) ; "You toss the bottle of hair rejuvenator into the deep crevice."
					)
					(gEgo
						setMotion: 0
						view: 184
						setLoop: 2
						setCel: 255
						put: 21 -1 ; Hair_Rejuvenator
					)
					(aBottle
						posn: (+ (gEgo x:) 7) (- (gEgo y:) 19)
						setPri: 0
						setMotion: MoveTo 162 124 self
					)
					(= bagInBottle 0)
					(= bottleInHand 0)
				)
			)
			(14
				(if (not bagBurning)
					(= state 22)
				)
				(= bagBurning 0)
				(aBottle setMotion: MoveTo 162 422 self)
			)
			(15
				(NormalEgo 0)
				(aBottle dispose:)
				(gGame changeScore: 10)
				(= seconds 3)
			)
			(16
				(theSound number: 6 play:)
				(Print 82 32 #draw) ; "You feel a deep rumbling as your homemade bomb explodes, weakening an old lava tube deep within the earth. This could be extremely dangerous!"
				(= causedEruption 1)
				(aDoor setCycle: End self)
			)
			(17
				(aDoor stopUpd:)
				(= seconds 2)
			)
			(18
				(Print 82 33 #draw) ; "The force of the explosion has also caused the elevator door to open!"
			)
			(19
				(HandsOff)
				(= gCurrentStatus 22)
				(gEgo setLoop: 2 setPri: 10)
				(= seconds 3)
			)
			(20
				(Print 82 34 #at -1 20) ; "As you start to push the "Close Door" button, you notice there is no "Close Door" button inside this elevator."
				(Print 82 35 #at -1 20) ; "Say! There are no buttons at all inside this elevator."
				(Print 82 36 #at -1 20) ; "In fact, there's not even a floor!"
				(Print 82 22 #at -1 20 #dispose) ; "Oh, shhhhhhhh..."
				(theSound number: 1 play:)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setStep: 1 15
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 200) self
				)
			)
			(21
				(cls)
				(gCurRoom newRoom: 83)
			)
			(22
				(= gCurrentStatus 15)
				(HandsOff)
				(Print 82 37) ; "Bad idea."
				(Print 82 38) ; "You open the bottle of hair rejuvenator, light one of your matches, then drop it inside."
				(Print 82 39) ; "You wonder to yourself, "Is that a disk drive I hear?""
				(gCurRoom newRoom: 152)
			)
			(23
				(Print 82 40) ; "It finally reaches bottom and breaks harmlessly on the jagged rocks, making quite a mess but accomplishing nothing."
				(Print 82 41) ; "You just threw away the only hope you had of saving this island from the evil Doctor!"
				(= gCurrentStatus 1001)
			)
		)
	)
)

(instance bottleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= gCurrentStatus 13)
				(HandsOff)
				(gEgo setMotion: MoveTo 147 128 self)
			)
			(2
				(gEgo view: 184 setLoop: 0 cel: 0 setCycle: End self)
			)
			(3
				(= bottleInHand 1)
				(rm82Script cue:)
			)
		)
	)
)

