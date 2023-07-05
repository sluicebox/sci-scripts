;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 455)
(include sci.sh)
(use Main)
(use rm71)
(use Interface)
(use FileSelector)
(use Game)
(use System)

(public
	rm455 0
)

(instance rm455 of Rm
	(properties
		picture 455
	)

	(method (init)
		(super init:)
		(self setRegions: 71 setLocales: 70 setScript: RoomScript) ; rm71
		(Notify 71 1 104 72)
		(Notify 71 2 133 60)
		(Notify 71 3 104 69)
		(Notify 71 4 135 55)
		(Notify 71 5 133 82)
		(Notify 71 6 138 91)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event &tmp temp0 [temp1 600] [temp601 40] [temp641 40])
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said '(go<out),date,date/woman,woman,entertainer')
					(Said 'get/anyword/building')
					(Said 'ask/anyword/date,date')
					(Said 'ask,get,get/date,date')
					(Said 'make/enjoy,love,date,date')
					(Said 'let<make/enjoy,love,date,date')
					(Said 'anyword/make/enjoy,love')
					(Said
						'go/area,penthouse,drop,drop,comedian,club,date,date,exit,walk,bar,show,show,dance,dance'
					)
				)
				(cond
					((not (InRoom 10))
						(PrintL 455 0) ; "Hello, beautiful, my name is Larry; Larry Laffer. Why don't you and I get together some time very soon?"
						(PrintP 455 1) ; ""Hello yourself, Mr. `Pretend-To- Be-A-Swinging-Single!' I never date married men when there are so many single guys just waiting their turn!"%"
						(React 4)
					)
					((not gEgoIsHunk)
						(PrintL 455 2) ; "Patti, you know I'm divorced now. What do you say we get together for a little nightcap after your last set?"
						(PrintP 455 3) ; ""I'm sorry, Larry, but you must improve your poor physical condition. I could never go out with a man with such a pot belly!"%"
						(React 4)
					)
					((TestFlag 8)
						(PrintL 455 4) ; "Patti, look at my new body! I'm a hunk!! Now, can we go out?"
						(PrintP 455 5) ; ""Phew! Don't you ever take a shower? I could never go out with a man with such B.O."%"
						(React 4)
					)
					((TestFlag 10)
						(PrintL 455 4) ; "Patti, look at my new body! I'm a hunk!! Now, can we go out?"
						(PrintP 455 6) ; ""Phew! Don't you ever use soap? I could never go out with a man with such B.O."%"
						(React 4)
					)
					((TestFlag 62)
						(PrintL 455 4) ; "Patti, look at my new body! I'm a hunk!! Now, can we go out?"
						(PrintP 455 7) ; ""Phew! Don't you ever use deodorant? I could never go out with a man with such B.O."%"
						(React 4)
					)
					((not (InRoom 11))
						(PrintL 455 8) ; "Patti, please! Let's try it. You and me. Together. Alone at last! What do you say?"
						(PrintP 455 9) ; ""I'd say `YES,' Larry, but where I come from a gentleman customarily gives a gift to his lady on their first date? I could never go out with a man who didn't care enough to give me presents."%"
					)
					(else
						(self changeState: 1)
					)
				)
			)
			((or (Said '/marriage') (Said 'marry/'))
				(Print 455 10) ; "A little fast, aren't you, Larry? Why, you hardly know her!"
			)
			((Said 'fuck,fuck')
				(PrintP 455 11) ; ""Why, Larry! Shame on you!"%"
				(React 4 4)
			)
			((Said '/neck')
				(Print 455 12) ; "She IS beautiful, isn't she?"
			)
			((Said '/penthouse,area')
				(PrintP 455 13) ; ""Yes, Larry, I DO live in the penthouse here."%"
			)
			((Said 'caress')
				(PrintP 455 14) ; ""I might enjoy that later..."%"
				(React 2 5)
			)
			((Said 'embrace,embrace,embrace')
				(PrintP 455 15) ; ""You've never experienced that until you've had me..."%"
				(React 2 5)
			)
			((Said '/music,gamble')
				(PrintL 455 16) ; "What talented fingers you have, Patti."
				(PrintP 455 17) ; ""All the better to play with, Larry!"%"
				(React 2 5)
			)
			((Said 'shit,shit')
				(PrintP 455 18) ; ""This is no time to get discouraged, Larry..."%"
				(React 4 4)
			)
			((Said 'talk,talk')
				(switch (Random 1 3)
					(1
						(PrintP 455 19) ; ""You know, Larry, I always say it's not the men in your life that count -- it's the life in your men!"%"
					)
					(2
						(PrintP 455 20) ; ""Larry, I believe in the old saying: a good man is hard to find... but a hard man is good to find!"%"
					)
					(else
						(PrintP 455 21) ; ""Larry, you won't get much out of life if you don't `go for it.'"%"
					)
				)
			)
			((Said 'show,show/ball')
				(PrintL 455 22) ; "Bet you've never seen one like this before!"
				(PrintP 455 23) ; ""See what, Larry?"%"
				(React 2 20)
			)
			((Said 'make/joke')
				(Print 455 24) ; "You make a lame joke."
				(Print 455 25 #at -1 144) ; "(You succeed.)"
				(PrintP 455 26) ; ""Hey, Larry! This is what I think of that joke!"%"
				(React 7 22)
			)
			((Said 'enjoy,love/you,woman,woman,entertainer')
				(PrintL 455 27) ; "Baby, I thinks I loves ya!"
				(PrintP 455 28) ; ""I'm sure you would!"%"
				(React 5 44)
			)
			((Said '/pass,backstage')
				(PrintL 455 29) ; "Patti, do you have any idea how a guy like me could get into that showroom across the casino?"
				(PrintP 455 30) ; ""I don't know, Larry. They gave me a free pass."%"
			)
			((Said 'get,gamble/music,buy,order')
				(PrintL 455 31) ; "Patti, do you take requests?"
				(PrintP 455 32) ; ""Certainly, Larry, but not when you are staring into my eyes like this. You make me want to play this song (and this song only!)"%"
			)
			(
				(or
					(Said 'stop/look,look')
					(Said 'look,look<stop')
					(Said 'look,look/bar,area')
					(Said 'done,exit,exit,done,exit,walk,go')
					(Said
						'exit,rise,(rise,nightstand<up),(get,get<off,up)/barstool'
					)
				)
				(self changeState: 2)
			)
			((Said 'look,look>')
				(cond
					((Said '/calf')
						(PrintP 455 33) ; ""Oh, Larry!" smiles Patti. "I love it when you look at me like that!"%"
						(React 3 22)
					)
					((Said '/bracelet')
						(Print 455 34) ; "Her pearly white wrist passes through an expensive golden bracelet."
					)
					((Said '/ear')
						(Print 455 35) ; "Tasteful imported Italian earrings grace her delicate tasteful ears."
					)
					((Said '/boob')
						(Print 455 36) ; ""My, what I'd love to do with those!" you whisper to yourself."
						(PrintP 455 37) ; ""Oh, Larry!" smiles Patti overhearing you. "You're so subtle!"%"
						(React 6 12)
					)
					((Said '/keyboard')
						(Print 455 38) ; "Patti's grand piano stretches across the bar like a wino with a 6-dollar gallon of wine!"
					)
					((Said '[/keyboard,woman,woman,entertainer]')
						(Print 455 39) ; "Before you sits the latest girl of your dreams the world-famous piano bar entertainer, Passionate Patti."
						(PrintP 455 40) ; ""Hello," she says with a smile.%"
						(React 2 33)
					)
				)
			)
			((Said 'give,throw,drop,show,show,drop,drop>')
				(= temp0 (gInventory saidMe:))
				(event claimed: 0)
				(cond
					((Said '[/!*]')
						(Print 455 41) ; "What did you want to give her?"
					)
					((not temp0)
						(Print 455 42) ; "Where did you get that?"
					)
					((not (temp0 ownedBy: gEgo))
						(DontHave) ; "You don't have it."
					)
					((TestFlag 8)
						(PrintP 455 43) ; ""Phew! Don't you ever take a shower? I could never go out with a man with such B.O."%"
						(React 4)
					)
					((TestFlag 10)
						(PrintP 455 44) ; ""Phew! Don't you ever use soap? I could never go out with a man with such B.O."%"
						(React 4)
					)
					((== temp0 (gInventory at: 1)) ; Credit_Card
						(PrintL 455 45) ; "Do you take plastic?"
						(PrintP 455 46) ; ""Honey, I'm not interested in credit, (except the way they announce my act!). If you want to give me a tip, put it in the tip glass right here on the piano. And be sure I don't hear any clinking sounds!"%"
						(React 4)
					)
					((== temp0 (gInventory at: 4)) ; Native_Grass
						(if (== (temp0 view:) 23)
							(PrintL 455 47) ; "Patti, this grass skirt would look perfect on you."
							(PrintP 455 48) ; ""If it's not imported, Larry, there's no way you're going to get me to wear it!"%"
						else
							(PrintL 455 49) ; "Patti, would you care for some of my grass?"
							(PrintP 455 50) ; ""Not me, Larry. I don't do drugs!"%"
						)
						(React 4)
					)
					((== temp0 (gInventory at: 5)) ; Soap-On-A-Rope
						(PrintL 455 51) ; "Patti, how about this bar of soap? Would you like to have it? It's yours."
						(PrintP 455 52) ; ""Gosh, Larry, you really have a way with women, don't you?"%"
						(React 4)
					)
					((== temp0 (gInventory at: 6)) ; A_Twenty_Dollar_Bill
						(PrintL (Format @temp1 455 53 gDollars gDollars)) ; ""What do you say, baby? Would %d dollars make you interested in me?"%"
						(PrintP 455 54) ; ""How dare you!"%"
						(React 4)
					)
					((== temp0 (gInventory at: 7)) ; Land_Deed
						(PrintL 455 55) ; "Take my land. Please!"
						(PrintP 455 56) ; ""What are you? Henny Youngman?"%"
						(React 4)
					)
					((== temp0 (gInventory at: 8)) ; Beach_Towel
						(PrintL 455 57) ; "Would you like to rub this all over your naked body?"
						(PrintP 455 58) ; ""No, Larry, but I do enjoy being rubbed!"%"
						(React 4)
					)
					((== temp0 (gInventory at: 9)) ; Spa_Keycard
						(PrintL 455 59) ; "Would you like to work out over at Fat City? You could take my keycard."
						(PrintP 455 60) ; ""Hardly. I can get into Fat City whenever I wish. You see, I `know' the clerk there!"%"
						(React 2)
					)
					((== temp0 (gInventory at: 10)) ; Divorce_Decree
						(PrintL 455 61) ; "Patti, look! I did it! My divorce is finalized. Here, take it. Frame this thing and mount it here on your piano!"
						(if (not (gEgo has: 9)) ; Spa_Keycard
							(Print 455 62) ; "As you hand your hard-earned divorce decree to Patti, something flutters to the floor."
							(gEgo get: 9) ; Spa_Keycard
							(SetFlag 70)
							(Print 455 63) ; "Well, well," you say, "look at this. Somehow Suzi Cheatem's Fat City Membership Card got mixed in with these papers. I suppose I could always return it to her."
						)
						(gGame changeScore: 100)
						(PutInRoom 10)
						(PrintP 455 64) ; ""Congratulations, Larry. Did I mention earlier how much I love single men? Suddenly, you've become a lot more interesting to me. We should get together some time."%"
						(React 2)
					)
					((== temp0 (gInventory at: 11)) ; some_Orchids
						(cond
							((and (== gCurTimer 1) (== gRgTimer 0))
								(PrintL 455 65) ; "Patti, here. Take these wilted, old flowers."
								(PrintP 455 66) ; ""No way, Larry. Although I have a soft spot in my heart for orchids, I could never accept these tired old things. Is that all you think of me? Dead flowers, indeed!"%"
								(React 4)
							)
							((not (InRoom 10))
								(PrintL 455 67) ; "Patti, please accept these flowers and let's get together tonight when you get off work."
								(PrintP 455 68) ; ""No, Larry, not now. Although I have a soft spot in my heart for orchids and I am growing more fond of you every moment we're together, I could never date a married man!"%"
								(React 4)
							)
							((not (== (temp0 view:) 26))
								(PrintL 455 69) ; "Patti, although their beauty pales besides yours, I'd like you to accept these orchids as a humble token of my interest in you."
								(PrintP 455 70) ; ""Oh, Larry. Your flowers are very pretty, but what woman would want to go out with a man who is unable to `lei' her?"%"
								(React 4)
							)
							(else
								(PrintL 455 71) ; "Patti, please wear my lei... tonight... for me... alone!"
								(PrintP 455 72) ; ""Oh, Larry, thank you! You're such a charmer! I'm ready. What do you want to do?"%"
								(gGame changeScore: 100)
								(PutInRoom 11)
								(React 2)
							)
						)
					)
					(else
						(PrintL
							(Format ; ""Patti, look at this `%s?'"%"
								@temp1
								455
								73
								(StrSplitInTwo @temp601 @temp641 (temp0 name:))
								@temp641
							)
						)
						(PrintP 455 74) ; ""Why, Larry. How droll."%"
					)
				)
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(PrintP 455 75) ; ""Oh, well; what the hell. It's getting late, I'm ready to quit for the night, and you're looking better all the time. Sure, let's go!!"%"
				(gGame changeScore: 100)
				(= gEgoState 1)
				(++ state)
				(React 2 99)
				(= cycles 33)
			)
			(2
				(PrintL 455 76) ; "I'm leaving now, Patti"
				(PrintP 455 77) ; ""See you later, Larry!"%"
				(React 2 55)
				(= cycles 33)
			)
			(3
				(gCurRoom newRoom: 450)
			)
		)
	)
)

