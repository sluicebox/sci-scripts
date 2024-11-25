;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use LoadMany)
(use Actor)
(use System)

(public
	rm380 0
)

(instance rm380 of LLRoom
	(properties
		picture 415
		style 9
	)

	(method (init &tmp i)
		(LoadMany rsVIEW 1415 1416)
		(super init:)
		(SetFFRoom 385)
		(gCurRoom setScript: sCartoon)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 4)
			)
			(1
				(Say Desmond 380 0 #dispose #caller self) ; "Well, Patti, I'm glad to see you made it back safely. I told you there was nothing to worry about!"
			)
			(2
				(= ticks 30)
			)
			(3
				(Say You 380 1 #dispose #caller self) ; "You were right, Inspector Desmond. But for a while there, I was really stumped!"
			)
			(4
				(= ticks 30)
			)
			(5
				(Say Desmond 380 2 #dispose #caller self) ; "Oh, you did fine! Now let's go over what you discovered through your investigations."
			)
			(6
				(= ticks 30)
			)
			(7
				(Say Desmond 380 3 #dispose #caller self) ; "Let's begin with Baltimore and des Rever Records. What happened?"
			)
			(8
				(= ticks 30)
			)
			(9
				(cond
					((IsFlag 118)
						(Say You 380 4 #dispose #caller self) ; "It was easy. I got past that guard in the Shill Building Lobby just by showing him the DataMan\05 into which I had inserted Reverse Biaz's cartridge."
					)
					((IsFlag 119)
						(Say You 380 5 #dispose #caller self) ; "It was easy. I got past that guard in the Shill Building Lobby just by showing him Reverse Biaz's fax."
					)
					((IsFlag 48) ; fDirectorySol
						(Say You 380 6 #dispose #caller self) ; "It was easy. I got past that guard in the Shill Building Lobby just by finding Reverse Biaz's office in the building directory."
					)
					(else
						(Say You 380 7 #dispose #caller self) ; "I had real trouble there, Inspector. I never could figure out any way to get past that guard in the Shill Building Lobby."
					)
				)
			)
			(10
				(= ticks 60)
			)
			(11
				(if (or (IsFlag 118) (IsFlag 119) (IsFlag 48)) ; fDirectorySol
					(Say Desmond 380 8 #dispose #caller self) ; "Good work, Patti. But what happened after you were upstairs? Did you learn anything about des Rever or Biaz?"
				else
					(= state 24)
					(Say Desmond 380 9 #dispose #caller self) ; "Oh, no. That's too bad. I thought Reverse Biaz was a major player. He might have been the key to breaking this case."
				)
			)
			(12
				(= ticks 120)
			)
			(13
				(if (gEgo has: 5) ; Michelle_Milken_s_Resume
					(Say You 380 10 #dispose #caller self) ; "While upstairs in des Rever's outer office, I found a gold record which I think might contain some valuable evidence. Here, take it!"
					(gEgo put: 5) ; Michelle_Milken_s_Resume
				else
					(Say You 380 11 #dispose #caller self) ; "I couldn't find anything interesting in des Rever's outer office."
				)
			)
			(14
				(= ticks 60)
			)
			(15
				(if (IsFlag 122)
					(Say You 380 12 #dispose #caller self) ; "I discovered the gold record could actually be played on a stereo system there. It sounded fine."
				else
					(= cycles 2)
				)
			)
			(16
				(if (IsFlag 123)
					(Say You 380 13 #dispose #caller self) ; "But when I played the gold record in reverse at 33-1/3, I heard a strange message. It should be proof positive of the vicious things they've been doing!"
				else
					(= cycles 2)
				)
			)
			(17
				(= ticks 60)
			)
			(18
				(Say Desmond 380 14 #dispose #caller self) ; "Good going, Patti. Did you make the recording session I booked for you?"
			)
			(19
				(if (IsFlag 126)
					(Say You 380 15 #dispose #caller self) ; "Actually, the studio session went pretty well, Boss. After a couple of tries, I started really cookin'!"
				else
					(Say You 380 16 #dispose #caller self) ; "I'm sorry, but I just couldn't, Inspector."
				)
			)
			(20
				(= ticks 60)
			)
			(21
				(cond
					((IsFlag 127)
						(Say You 380 17 #dispose #caller self) ; "You'll love this, Boss! I just used an old technique with which I'm quite familiar! I grabbed some champagne from my limo and got Reverse drunk! So drunk, in fact, he gave me this cassette tape to impress me."
						(gEgo put: 6) ; Hard_Disk_Cafe_Napkin
					)
					((IsFlag 128)
						(Say You 380 18 #dispose #caller self) ; "Gosh, Boss. I just used an old technique with which I'm quite familiar! Here's the tape I, uh, `talked' him out of!"
						(gEgo put: 6) ; Hard_Disk_Cafe_Napkin
					)
					((IsFlag 129)
						(Say You 380 19 #dispose #caller self) ; "Here's the tape I, uh, `talked' him out of!"
						(gEgo put: 6) ; Hard_Disk_Cafe_Napkin
					)
					(else
						(= state 24)
						(Say Desmond 380 20 #dispose #caller self) ; "Too bad, Patti. I wish you could have found something there."
					)
				)
			)
			(22
				(= ticks 60)
			)
			(23
				(Say Desmond 380 21 #dispose #caller self) ; "You really have a way with men, Patti!" he laughs. "Our agents could have never `obtained' evidence like you did."
			)
			(24
				(= ticks 120)
			)
			(25
				(Say Desmond 380 22 #dispose #caller self) ; "So, did you discover anything at K-RAP radio?"
			)
			(26
				(if (IsFlag 150)
					(Say You 380 23 #dispose #caller self) ; "Well, I sneaked into John Krapper's office just as the receptionist came back from her break."
				else
					(Say You 380 24 #dispose #caller self) ; "Sorry, Boss, but I couldn't even get past the K-RAP lobby! They really had tight security!"
				)
			)
			(27
				(= ticks 30)
			)
			(28
				(if (IsFlag 150)
					(Say Desmond 380 25 #dispose #caller self) ; "Nice job of sleuthing, Patti!"
				else
					(= state 38)
					(Say Desmond 380 26 #dispose #caller self) ; "It's too bad you didn't get further into the K-RAP building, Patti. I think P. C. Hammer might well be crucial to this problem."
				)
			)
			(29
				(= ticks 60)
			)
			(30
				(Say You 380 27 #dispose #caller self) ; "I searched John Krapper's desk and discovered a folder filled with what looked like incriminating evidence to me!"
			)
			(31
				(Say You 380 28 #dispose #caller self) ; "I assumed he'd miss the folder if I stole it, so I used his photocopier to make copies of it. Here they are!"
				(gEgo put: 11) ; DayTrotter
			)
			(32
				(Say Desmond 380 29 #dispose #caller self) ; "Way to go, Patti. Nice work."
			)
			(33
				(= ticks 60)
			)
			(34
				(Say You 380 30 #dispose #caller self) ; "And, besides that, I overheard what `2 Live 2 Screw' thought were private conversations. They didn't realize they were meeting in a room with an open microphone!"
			)
			(35
				(Say You 380 31 #dispose #caller self) ; "Although I nearly got trapped by P. C. Hammer, I recorded `2 Live 2 Screw' on a reel-to-reel tape."
			)
			(36
				(if (IsFlag 156)
					(Say Desmond 380 32 #dispose #caller self) ; "Great! Patti, you have proven yourself the right woman for the job!"
					(gEgo put: 12) ; Money
				else
					(Say Desmond 380 33 #dispose #caller self) ; "Good, Patti. May I have the tape?"
				)
			)
			(37
				(if (not (IsFlag 156))
					(Say You 380 34 #dispose #caller self) ; "Uh, well, Inspector, I must confess: I left it on the tape recorder in the K-RAP control room. I'm sorry."
				else
					(= cycles 2)
				)
			)
			(38
				(if (not (IsFlag 156))
					(Say Desmond 380 35 #dispose #caller self) ; "Oh, that's all right, Patti. Mistakes happen; even to super-spies!"
				else
					(= cycles 2)
				)
			)
			(39
				(= ticks 30)
			)
			(40
				(if
					(and
						(not (IsFlag 150))
						(not (or (IsFlag 118) (IsFlag 119) (IsFlag 48))) ; fDirectorySol
					)
					(Say Desmond 380 36 #dispose #caller self) ; "Patti, I don't know if this is an appropriate time, but I must tell you: I find myself strongly attracted to you."
				else
					(Say Desmond 380 37 #dispose #caller self) ; "Patti, you've done a wonderful job! I'm so proud of you!"
					(++ state)
				)
			)
			(41
				(Say Desmond 380 38 #dispose #caller self) ; "You have such wonderful big, uh, er, eyes! Even though you weren't much help as a spy, I hoped you might feel something for me, too. So, here's a little favor."
			)
			(42
				(= ticks 30)
			)
			(43
				(if (IsFlag 100)
					(= state 46)
					(= cycles 2)
				else
					(Say Desmond 380 39 #dispose #caller self) ; "I have a small souvenir for you, Patti--a little something for you to remember your experiences as an F.B.I. agent."
				)
			)
			(44
				(Say Desmond 380 40 #dispose #caller self) ; "I want you to have Commander Twit's exploding bra--and every time you wear it, think of me!"
				(gEgo get: 13) ; Credit_Cards
			)
			(45
				(Say You 380 41 #dispose #caller self) ; "Oh, great! I'll wear it to my next heavy metal gig."
			)
			(46
				(Say Desmond 380 42 #dispose #caller self) ; "He laughs, "And that may be sooner than you think, Patti!""
			)
			(47
				(Say Desmond 380 43 #dispose #caller self) ; "In anticipation of your success, I made all the necessary arrangements for your White House..."
			)
			(48
				(DrawPic 1 100)
				(gTheMusic2 stop:)
				(Display ; "Suddenly, a westbound flight heads South!"
					380
					44
					dsALIGN
					alCENTER
					dsCOLOR
					gColVLRed
					dsFONT
					gNiceFont
					dsWIDTH
					318
					dsCOORD
					1
					82
				)
				(= cycles 2)
			)
			(49
				(gCurRoom newRoom: 385)
			)
		)
	)
)

(instance You of Talker
	(properties
		x 140
		y 180
		nsTop 76
		nsLeft 168
		view 1416
		loop 3
	)

	(method (init)
		(= mouth pattiMouth)
		(super init: &rest)
	)
)

(instance pattiMouth of Prop
	(properties
		nsLeft 1
		view 1416
		cycleSpeed 5
	)
)

(instance Desmond of Talker
	(properties
		x 1
		y 180
		nsTop 73
		nsLeft 120
		view 1415
		loop 3
		talkWidth 180
	)

	(method (init)
		(= mouth desmondMouth)
		(super init: &rest)
	)
)

(instance desmondMouth of Prop
	(properties
		view 1415
		cycleSpeed 5
	)
)

