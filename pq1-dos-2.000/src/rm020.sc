;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use station)
(use eRS)
(use Conversation)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm020 0
)

(local
	local0 = -1
	local1 = -1
	local2
	local3
)

(instance rm020 of PQRoom
	(properties
		noun 4
		picture 20
	)

	(method (init)
		(self
			setRegions: 134 ; station
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 141 103 131 112 202 112 177 144 203 124 249 124 249 103
					yourself:
				)
		)
		(= local0 (- (* (Random 0 3) 2) 1))
		(super init:)
		(door init:)
		(morgan init:)
		(CORNERPLANT init:)
		(DESKWHEELS init:)
		(twoChairs init:)
		(booksF init:)
		(cabinetDoorsF init:)
		(cabinetF init:)
		(computerF init:)
		(diploma_1 init:)
		(diploma_2 init:)
		(diploma_3 init:)
		(diploma_4 init:)
		(diploma_5 init:)
		(diploma_6 init:)
		(diploma_7 init:)
		(goldPlaque init:)
		(hatrackF init:)
		(knickKnacksF init:)
		(knickKnacksF init:)
		(letterBlotter init:)
		(ltDeskF init:)
		(ltlampF init:)
		(phoneF init:)
		(shelfPlantF init:)
		(vaseF init:)
		(windowF init:)
		(if (== global211 89)
			(marie init:)
			(cop init:)
			(coat init:)
		)
		(gEgo init: posn: 235 86)
		(self setScript: enterScript)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo -1 2)
				(gEgo setMotion: MoveTo 230 107 self)
			)
			(1
				(door startUpd: setCycle: Beg self)
			)
			(2
				(sfx number: 914 play:)
				(gEgo setMotion: MoveTo 218 112 self)
			)
			(3
				(door stopUpd:)
				(cond
					((and (== global211 52) (== global206 1))
						(morgan setScript: firstVisit)
					)
					((== global211 78)
						(morgan setScript: secondVisit)
					)
					((== global211 80)
						(morgan setScript: thirdVisit)
					)
					((== global211 89)
						(morgan setScript: fourthVisit)
					)
					((== global211 91)
						(morgan setScript: fifthVisit)
					)
					(else
						(bugEgo start: 1)
						(morgan setScript: bugEgo)
						(HandsOn)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc134_3 self)
			)
			(1
				(NormalEgo -1 3)
				(gEgo posn: 230 107)
				(door startUpd: setCycle: End self)
				(sfx number: 913 play:)
			)
			(2
				(gEgo setMotion: MoveTo 235 86 self)
			)
			(3
				(gCurRoom newRoom: 18)
			)
		)
	)
)

(instance getCoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (- (coat x:) 16) (+ (coat y:) 33) self
				)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(coat startUpd: dispose:)
				(gEgo
					view: 174
					loop: 0
					cel: 0
					posn: (- (coat x:) 6) (+ (coat y:) 33)
					setCycle: End self
				)
			)
			(3
				(gEgo
					view: 174
					loop: 1
					cel: 0
					posn: (- (coat x:) 18) (+ (coat y:) 31)
					setCycle: End self
				)
				(= global206 177)
				(gEgo get: 15) ; Hair_Dye
			)
			(4
				(NormalEgo -1 0)
				(gEgo
					posn: (- (coat x:) 16) (+ (coat y:) 33)
					setHeading: 225 self
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance bugEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(= local2 bugEgo)
				(morganGestures doit:)
			)
			(2
				(-= state 3)
				(gMessager
					say:
						27
						0
						(cond
							((and (IsFlag 84) (== global211 54)) 18)
							((and (== global211 52) (!= global206 1)) 24)
							((<= 53 global211 78) 3)
							((<= 79 global211 80) 7)
							((<= 81 global211 89) 11)
							((<= 90 global211 91) 12)
							((<= 91 global211 91) 16)
							((<= 92 global211) 15)
							(else 18)
						)
						0
						self
				)
			)
		)
	)
)

(instance firstVisit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global211 53)
				(gEgo setHeading: 225 self)
			)
			(1
				(gMessager say: 26 2 2 1 self) ; "Hello, Lt. Morgan."
			)
			(2
				(morgan setCycle: CT 4 1 self)
			)
			(3
				(gEgo setMotion: MoveTo 165 115 self)
			)
			(4
				(gEgo
					view: 171
					loop: 0
					cel: 0
					posn: 172 113
					setCycle: CT 3 1 self
				)
			)
			(5
				(gMessager say: 26 2 2 2 self) ; "Hello, Sonny. Welcome to the department."
			)
			(6
				(gEgo setCycle: Beg self)
				(morgan setCycle: Beg self)
			)
			(7)
			(8
				(NormalEgo -1 2)
				(gEgo posn: 165 115 setMotion: MoveTo 218 112 self)
			)
			(9
				(gEgo setHeading: 225 self)
			)
			(10
				(= local2 morganConv)
				(morganConv
					add: morganGestures
					add: 20 26 2 2 3 ; "Thank you, sir. I'm happy to be here."
					add: morganGestures
					add: 20 26 2 2 4 ; "Glad to hear it. Well, let's get you started. Your new partner, Detective Laura Watts, is waiting for you in the Narcotics office. She'll get you settled in. I'll call you in later for further briefing."
					add: morganGestures
					add: 20 26 2 2 5 ; "Yes, sir."
					add: morganGestures
					init: self
				)
			)
			(11
				(= next bugEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance secondVisit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global211 79)
				(gEgo setHeading: 225 self)
			)
			(1
				(= local2 morganConv)
				(morganConv
					add: morganGestures
					add: 20 26 2 5 1 ; "You wanted to see me, Lt. Morgan?"
					add: morganGestures
					add: 20 26 2 5 2 ; "Yes. I need you to review some evidence from the Hoffman case, Bonds. Check out the black notebook for clues about this man and his activities, and run an ID check on the gun. There's something very strange about this case. Think you can clarify the picture, Sonny?"
					add: morganGestures
					add: 20 26 2 5 3 ; "I'll do my best, sir."
					add: morganGestures
					add: 20 26 2 5 4 ; "Well, have at it, detective."
					add: morganGestures
					add: 20 26 2 5 5 ; "Hey! He called you "detective!""
					add: morganGestures
					add: 20 26 2 5 6 ; "Yes, SIR!"
					add: morganGestures
					init: self
				)
			)
			(2
				(= next bugEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance thirdVisit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global211 81)
				(gEgo setHeading: 225 self)
			)
			(1
				(= local2 morganConv)
				(morganConv
					add: morganGestures
					add: 20 26 2 8 1 ; "Yes, sir? You asked to see me?"
					add: morganGestures
					add: 20 26 2 8 2 ; "Oh, hello, Sonny. Yes, I wanted to talk to you about Marie Wilkans. You possibly know her as "Sweet Cheeks" Marie."
					add: morganGestures
					add: 20 26 2 8 3 ; "Yes, sir, I know the young lady."
					add: morganGestures
					add: 20 26 2 8 4 ; "She evidently knows you, too, and thinks rather highly of you. Anyway, she's been arrested for soliciting. We'd like you to approach her with a "deal"."
					add: morganGestures
					add: 20 26 2 8 5 ; "We're going to be starting an undercover operation at the Hotel Delphoria. We want to infiltrate the narcotics ring by way of the illegal gambling that goes on there. We know Marie Wilkans has connections at the Delphoria."
					add: morganGestures
					add: 20 26 2 8 6 ; "We think Marie Wilkans can get us in there. In return, we'll do our best to get the charges dropped. I need you to go to the jail and discuss this with her, Bonds. Give her a minimum of information. We don't want her endangered, but we think she can help us. Any questions?"
					add: morganGestures
					add: 20 26 2 8 7 ; "No, sir."
					add: morganGestures
					add: 20 26 2 8 8 ; "Okay then. From what I hear, she'll probably cooperate with you, Sonny. Rumor has it she's stuck on you."
					add: morganGestures
					add: 20 26 2 8 9 ; "I, er, I guess I'd better get going, sir."
					add: morganGestures
					add: 20 26 2 8 10 ; "Good idea, Sonny."
					add: morganGestures
					add: 20 26 2 8 11 ; "You're not sure, but you think Lt. Morgan is suppressing a smile."
					add: morganGestures
					init: self
				)
			)
			(2
				(= next bugEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fourthVisit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global211 90)
				(gEgo setHeading: 225 self)
			)
			(1
				(= local2 morganConv)
				(morganConv
					add: morganGestures
					add: 20 26 2 9 1 ; "Hello, Lt. Morgan."
					add: morganGestures
					add: 20 26 2 9 2 ; "Ah, there you are, Bonds. We were just getting ready to discuss plans for the Delphoria operation. I believe everybody has been introduced, so let's get started."
					add: morganGestures
					add: 20 26 2 9 3 ; "Bonds, you'll go to the hotel in disguise, using the name of Jimmy Lee "Whitey" Banksten. Marie Wilkans will have already been there for several hours, socializing in the hotel bar. When you reach the hotel, you will rent a room, then go directly to the bar."
					add: morganGestures
					add: 20 26 2 9 4 ; "Once there, you'll socialize with the bartender. You should buy a drink or two, but I don't have to tell you to keep a clear head. Marie will introduce you to the bartender, Alexandra Parker, whom we suspect of facilitating the illegal gambling. If all goes well, you'll get yourself invited to a "private" poker game."
					add: morganGestures
					add: 20 26 2 9 5 ; "Once you've infiltrated the game, discover what you can about the narcotics ring, and the identity of the "Death Angel." Be sure to report back to me with any important findings. Think you're up to it, "Whitey"?"
					add: morganGestures
					add: 20 26 2 9 6 ; "Just one question, sir. Why is my nickname supposed to be "Whitey"?"
					init: self
				)
			)
			(2
				(morganConv
					add: lauraGestures
					add: morganGestures
					add: 20 26 2 9 7 ; "Hah! I thought you'd never ask, Sonny. Here you go, a bottle of extra-strength peroxide compound for bleaching your hair. Get it, "Whitey?""
					add: morganGestures
					add: 20 26 2 9 8 ; "I'm afraid so. What's the rest of my costume like?"
					add: lauraGestures
					add: morganGestures
					add: 20 26 2 9 9 ; "Oh, it's this white "high-roller" suit hanging on the coat rack over here. Pretty tacky, actually."
					add: lauraGestures
					add: morganGestures
					add: 20 26 2 9 10 ; "Oh, joy."
					add: morganGestures
					add: 20 26 2 9 11 ; "You'll look perfectly tacky, I'm sure, Bonds. Any questions, Miss Wilkans?"
					add: morganGestures
					init: self
				)
			)
			(3
				(morganConv
					add: marieGestures
					add: lauraGestures
					add: 20 26 2 9 12 ; "No, sir...Yes. Yes, I do have a question. Alex Parker is my friend, Lt. Morgan. I don't want to throw her to the wolves. What's going to happen to her after this operation?"
					add: morganGestures
					add: 20 26 2 9 13 ; "It's kind of you to think of your friend, Miss Wilkans, but you'd do better to look out for yourself. Actually, all we suspect Alex Parker of is facilitating an illegal gambling operation. That's not a tremendously serious charge. If she cooperates with us, things will probably go easier for her."
					add: morganGestures
					add: marieGestures
					add: 20 26 2 9 14 ; "But...will she go to jail?"
					add: morganGestures
					add: 20 26 2 9 15 ; "I honestly don't know, Miss Wilkans. That's the best answer I can give you at this time. Are you reconsidering your offer to help us?"
					add: morganGestures
					add: marieGestures
					add: 20 26 2 9 16 ; "I...no, Lt. Morgan. I'll do it. Just promise me you'll do your best by Alex."
					add: morganGestures
					add: 20 26 2 9 17 ; "I'll do what I can, Miss Wilkans. Why don't you head over to the hotel now? It's getting late."
					add: morganGestures
					init: self
				)
			)
			(4
				(morganConv add: marieLeaves1 add: 20 26 2 9 18 init: self) ; "Alright. I'll see you there, Sonny."
			)
			(5
				(morganConv
					add: marieLeaves2
					add: morganGestures
					add: 20 26 2 9 19 ; "I'm going back to the Narc room. I've got a lot of work to do. Sonny, just put the peroxide in your hair and leave it there for a few minutes. It's pretty strong, so don't leave it there too long. Otherwise we'll be calling you "Baldy" instead of "Whitey.""
					init: self
				)
			)
			(6
				(morganConv add: lauraLeaves add: morganGestures init: self)
			)
			(7
				(morganConv
					add: getCoat
					add: 20 26 2 9 20 ; "You'd better get started, Sonny. Go to the locker room and get changed. Don't forget to bleach your hair. Come back here for a quick final briefing before you leave for the hotel."
					add: morganGestures
					add: 20 26 2 9 21 ; "Yes, sir. Oh, Lt. Morgan? The dead body in Cotton Cove was Jason Taselli."
					add: morganGestures
					add: 20 26 2 9 22 ; "Well...I can't say I'll cry over him, but that means there's somebody worse out there. Go on, Sonny, maybe we'll catch him in the Delphoria operation. Goodbye."
					add: morganGestures
					init: self
				)
			)
			(8
				(= next bugEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fifthVisit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global211 92)
				(gEgo setHeading: 225 self)
			)
			(1
				(= local2 morganConv)
				(morganConv
					add: morganGestures
					add: 20 26 2 13 1 ; "Hello, Lt. Morgan. What do you think? Am I convincing?"
					add: morganGestures
					add: 20 26 2 13 2 ; "Very. Your own mother would have to look twice. How do you feel?"
					add: morganGestures
					add: 20 26 2 13 3 ; "Pretty good, sir. I'm ready."
					add: morganGestures
					add: 20 26 2 13 4 ; "You have to be ready, Sonny, and wide awake. You know you'll have to go in without a weapon or a wire. If those men were to catch on you were a cop, they'd kill you in a heartbeat. Understand?"
					add: morganGestures
					add: 20 26 2 13 5 ; "Yes, sir, I do."
					add: morganGestures
					init: self
				)
			)
			(2
				(morganConv
					add: dooleyEnters
					add: 20 26 2 13 6 ; "Lt. Morgan?"
					add: morganGestures
					add: 20 26 2 13 7 ; "Yes, Sergeant, what can I do for you?"
					add: morganGestures
					add: 20 26 2 13 8 ; "I'm afraid I have some terrible news. Officer Jack Cobb's daughter Kathy died in the hospital about an hour ago. Apparently she never woke up."
					add: morganGestures
					add: 20 26 2 13 9 ; "My God...thank you, Sgt. Dooley. I appreciate your letting me know. You've spoken to Jack, yes?"
					add: morganGestures
					add: 20 26 2 13 10 ; "Yes, sir."
					init: self
				)
			)
			(3
				(morganConv
					add: dooleyLeaves
					add: morganGestures
					add: 20 26 2 13 11 ; "Sonny, I think the importance of this operation is obvious to you. These men are killing innocent kids. They have to be stopped. Remember to keep a level head, though. Rage will only get you killed. These people--if you can call them that--are not to be trifled with. Be sure to check in with me after you've made contact with them."
					add: morganGestures
					add: 20 26 2 13 12 ; "Yes, sir. I'm going to get them. You can be sure of that."
					add: morganGestures
					add: 20 26 2 13 13 ; "Good. Head on over to the hotel, Sonny. Don't let this distract you."
					add: morganGestures
					init: self
				)
			)
			(4
				(= next bugEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lauraGestures of Code
	(properties)

	(method (doit)
		(switch (= local1 (mod (+ local1 1) 2))
			(0
				(cop setHeading: 90 local2)
			)
			(1
				(cop setMotion: MoveTo 193 102 local2)
			)
			(2
				(cop setHeading: 90 local2)
			)
			(3
				(cop setHeading: 180 local2)
			)
		)
	)
)

(instance morganGestures of Code
	(properties)

	(method (doit)
		(switch (= local0 (mod (+ local0 1) 9))
			(0
				(morgan
					view: 175
					loop: 9
					cel: 0
					posn: 129 131
					setPri: 8
					setCycle: End local2
				)
			)
			(1
				(morgan
					view: 175
					loop: 1
					cel: 0
					posn: 115 128
					setPri: 8
					setCycle: End local2
				)
			)
			(2
				(morgan
					view: 175
					loop: 1
					cel: (morgan lastCel:)
					posn: 115 128
					setPri: 8
					setCycle: Beg local2
				)
			)
			(3
				(morgan
					view: 175
					loop: 4
					cel: 0
					posn: 130 128
					setPri: 8
					setCycle: End local2
				)
			)
			(4
				(morgan
					view: 175
					loop: 4
					cel: (morgan lastCel:)
					posn: 130 128
					setPri: 8
					setCycle: Beg local2
				)
			)
			(5
				(morgan
					view: 175
					loop: 7
					cel: 0
					posn: 131 128
					setPri: 8
					setCycle: End local2
				)
			)
			(6
				(morgan
					view: 175
					loop: 7
					cel: (morgan lastCel:)
					posn: 131 128
					setPri: 8
					setCycle: Beg local2
				)
			)
			(7
				(morgan
					view: 175
					loop: 8
					cel: 0
					posn: 129 129
					setPri: 8
					setCycle: End local2
				)
			)
			(8
				(morgan
					view: 175
					loop: 8
					cel: (morgan lastCel:)
					posn: 129 129
					setPri: 8
					setCycle: Beg local2
				)
			)
		)
	)
)

(instance marieGestures of Code
	(properties)

	(method (doit)
		(switch local3
			(0
				(++ local3)
				(marie
					view: 173
					loop: 0
					cel: 0
					posn: 201 157
					setPri: 10
					setCycle: End local2
				)
			)
			(1
				(++ local3)
				(marie
					view: 173
					loop: 0
					cel: (marie lastCel:)
					posn: 201 157
					setPri: 10
					setCycle: Beg local2
				)
			)
			(2
				(marie
					view: 173
					loop: 2
					cel: 0
					posn: 199 155
					setPri: 10
					setCycle: End local2
				)
			)
		)
	)
)

(instance marieLeaves1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(marie
					view: 173
					loop: 1
					cel: 0
					posn: 199 149
					setCycle: End self
				)
			)
			(1
				(proc134_4 marie 268 3 202 150 10)
				(marie setMotion: MoveTo 204 114 self)
			)
			(2
				(gEgo setMotion: MoveTo 232 107 self)
			)
			(3
				(gEgo setHeading: 45 self)
			)
			(4
				(proc134_3 self)
			)
			(5
				(door startUpd: setCycle: End self)
			)
			(6
				(NormalEgo -1 1)
				(marie setPri: -1 setMotion: MoveTo 217 109 self)
			)
			(7
				(marie setHeading: 90 self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance marieLeaves2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(marie setMotion: DPath 230 96 231 87 210 87 203 87 self)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(door stopUpd:)
				(marie dispose:)
				(self dispose:)
			)
		)
	)
)

(instance lauraLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cop setPri: 10 setMotion: MoveTo 204 114 self)
			)
			(1
				(gEgo setMotion: MoveTo 232 107 self)
			)
			(2
				(gEgo setHeading: 45 self)
			)
			(3
				(proc134_3 self)
			)
			(4
				(door startUpd: setCycle: End self)
			)
			(5
				(NormalEgo -1 1)
				(cop
					setPri: -1
					setMotion: DPath 217 109 230 96 231 87 210 87 203 87 self
				)
			)
			(6
				(door setCycle: Beg self)
			)
			(7
				(door stopUpd:)
				(cop dispose:)
				(self dispose:)
			)
		)
	)
)

(instance dooleyEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cop init: setMotion: MoveTo 234 89 self)
			)
			(1
				(cop setHeading: 180 self)
			)
			(2
				(= local0 -1)
				(= local2 self)
				(morganGestures doit:)
			)
			(3
				(= local2 morganConv)
				(door startUpd: setCycle: End self)
			)
			(4
				(gEgo setHeading: 90 self)
			)
			(5
				(cop setMotion: MoveTo 234 98 self)
			)
			(6
				(cop setHeading: 225 self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance dooleyLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 morganConv)
				(cop setMotion: MoveTo 234 89 self)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(gEgo setHeading: 225 self)
			)
			(3
				(cop setMotion: MoveTo 204 89 self)
			)
			(4
				(door stopUpd:)
				(cop dispose:)
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 246
		y 47
		noun 3
		approachX 230
		approachY 107
		view 154
		priority 7
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 setCel: (self lastCel:) stopUpd:) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: exitScript)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance coat of Prop
	(properties
		x 202
		y 72
		view 154
		loop 1
		priority 6
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance morgan of Actor
	(properties
		x 129
		y 128
		noun 26
		view 175
		priority 8
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (>= global211 78)
			(self loop: 9 cel: 0 posn: 129 131)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager
					say:
						27
						0
						(cond
							((and (IsFlag 84) (== global211 54)) 18)
							((< global211 52) 23)
							((and (== global211 52) (!= global206 1)) 24)
							((<= 53 global211 78) 3)
							((<= 79 global211 80) 7)
							((<= 81 global211 89) 11)
							((and (>= global211 90) (!= global206 2)) 16)
							((>= global211 92) 15)
							(else 18)
						)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance marie of Actor
	(properties
		x 201
		y 157
		noun 2
		view 173
		priority 10
		signal 16400
	)

	(method (init)
		(super init: &rest)
	)
)

(instance cop of Actor
	(properties
		x 173
		y 115
		heading 135
		noun 28
		view 12
		loop 4
	)

	(method (init)
		(switch global211
			(89
				(self view: 12 loop: 4 heading: 135 posn: 173 115)
			)
			(else
				(self view: 132 posn: 204 89 loop: 0 setPri: 1)
			)
		)
		(super init: &rest)
		(proc134_4 self)
	)
)

(instance morganConv of Conversation
	(properties)
)

(instance CORNERPLANT of Feature
	(properties
		x 73
		y 135
		noun 16
		nsTop 120
		nsLeft 60
		nsBottom 150
		nsRight 86
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance DESKWHEELS of Feature
	(properties
		x 148
		y 145
		noun 25
		nsTop 144
		nsLeft 134
		nsBottom 146
		nsRight 163
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance twoChairs of Feature
	(properties
		x 216
		y 129
		noun 24
		nsTop 109
		nsLeft 188
		nsBottom 149
		nsRight 245
		sightAngle 40
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance booksF of Feature
	(properties
		noun 10
		sightAngle 40
		onMeCheck 4096
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x ((gUser curEvent:) x:))
				(= y ((gUser curEvent:) y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance cabinetDoorsF of Feature
	(properties
		noun 9
		sightAngle 40
		onMeCheck 2048
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance cabinetF of Feature
	(properties
		noun 8
		sightAngle 40
		onMeCheck 16384
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance computerF of Feature
	(properties
		noun 12
		sightAngle 40
		onMeCheck 8192
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance hatrackF of Feature
	(properties
		noun 6
		sightAngle 40
		onMeCheck 1024
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance knickKnacksF of Feature
	(properties
		noun 11
		sightAngle 40
		onMeCheck 2
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance ltChairF of Feature ; UNUSED
	(properties
		noun 17
		sightAngle 40
		onMeCheck 64
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance ltDeskF of Feature
	(properties
		noun 18
		sightAngle 40
		onMeCheck 32
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance ltlampF of Feature
	(properties
		noun 20
		sightAngle 40
		onMeCheck 16
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance phoneF of Feature
	(properties
		noun 29
		sightAngle 40
		onMeCheck 8
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance shelfPlantF of Feature
	(properties
		noun 13
		sightAngle 40
		onMeCheck 512
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance vaseF of Feature
	(properties
		noun 14
		sightAngle 40
		onMeCheck 256
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance goldPlaque of Feature
	(properties
		x 74
		y 106
		noun 32
		nsTop 103
		nsLeft 72
		nsBottom 109
		nsRight 77
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance diploma_1 of Feature
	(properties
		x 128
		y 57
		noun 7
		nsTop 53
		nsLeft 126
		nsBottom 61
		nsRight 131
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance diploma_2 of Feature
	(properties
		x 129
		y 70
		noun 22
		nsTop 66
		nsLeft 126
		nsBottom 75
		nsRight 133
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance diploma_3 of Feature
	(properties
		x 71
		y 81
		noun 30
		nsTop 79
		nsLeft 69
		nsBottom 84
		nsRight 74
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance diploma_4 of Feature
	(properties
		x 73
		y 93
		noun 31
		nsTop 89
		nsLeft 69
		nsBottom 97
		nsRight 77
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance diploma_5 of Feature
	(properties
		x 61
		y 87
		noun 33
		nsTop 83
		nsLeft 59
		nsBottom 92
		nsRight 63
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance diploma_6 of Feature
	(properties
		x 61
		y 100
		noun 34
		nsTop 97
		nsLeft 59
		nsBottom 103
		nsRight 63
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance diploma_7 of Feature
	(properties
		x 62
		y 111
		noun 35
		nsTop 106
		nsLeft 59
		nsBottom 117
		nsRight 66
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance letterBlotter of Feature
	(properties
		x 154
		y 112
		noun 36
		nsTop 106
		nsLeft 143
		nsBottom 119
		nsRight 166
		sightAngle 40
		onMeCheck 1024
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance windowF of Feature
	(properties
		noun 23
		sightAngle 40
		onMeCheck 4
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= x (event x:))
				(= y (event y:))
				(super handleEvent: event &rest)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

